package org.yu.service;

import org.springframework.stereotype.Service;
import org.yu.dao.SHTDao;
import org.yu.entity.UserEntity;
import org.yu.serviceIml.LoginService;
import org.yu.utils.MD5Encrypt;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
@Service(value = "loginServiceIml")
public class LoginServiceIml implements LoginService {

    @Resource(name = "shtDao")
    private SHTDao shtDao;
    @Resource(name = "md5Encrypt")
    private MD5Encrypt md5Encrypt;

    public boolean login(String inputEamil, String inputPWD, HttpSession session) {

        UserEntity userEntity = null;
        userEntity = shtDao.selectUserByEmail(inputEamil);
        try {
            if (userEntity != null && md5Encrypt.checkpassword(inputPWD, userEntity.getPwd())) {
                session.setAttribute("user", userEntity);
                return true;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }
}
