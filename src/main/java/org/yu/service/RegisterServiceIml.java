package org.yu.service;

import org.springframework.stereotype.Service;
import org.yu.dao.SHTDao;
import org.yu.entity.UserEntity;
import org.yu.serviceIml.RegisterService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
@Service(value = "registerServiceIml")
public class RegisterServiceIml implements RegisterService {

    @Resource(name="shtDao")
    private SHTDao shtDao;

    public boolean validateCode(String sessionCode, String inputCode) {
        if(sessionCode.equals(inputCode))
        {
            return true;
        }else
        {
            return false;
        }
    }

    public boolean validatePwd(String pwd) {

        if(pwd == null)
        {
            return false;
        }else if(pwd.length() < 6){
            return false;
        }

        return true;
    }

    public boolean validateTwicePwd(String pwd, String validatePwd) {

        if(pwd.equals(validatePwd))
        {
            return true;
        }

        return false;
    }

    public boolean validateEmail(UserEntity user) {

        if(shtDao.selectUserByEmail(user.getEmail()) != null)
        {
            return true;
        }

        return false;
    }

    public void insertUser(UserEntity user) {

        shtDao.insertUser(user);

    }

    public void setAutoLogin(UserEntity user, HttpSession session) {

        session.setAttribute("user", user);
    }
}
