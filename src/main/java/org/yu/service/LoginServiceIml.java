package org.yu.service;

import org.springframework.stereotype.Service;
import org.yu.dao.SHTDao;
import org.yu.entity.UserEntity;
import org.yu.serviceIml.LoginService;
import org.yu.utils.MD5Encrypt;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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

    public boolean checkAutoLogin(String inputEamil, String inputPWD, HttpSession session) {

        UserEntity userEntity = null;
        userEntity = shtDao.selectUserByEmail(inputEamil);

        if (userEntity != null && inputPWD.equals(userEntity.getPwd())) {
            session.setAttribute("user", userEntity);
            return true;
        }

        return false;
    }

    public void setAutoLogin(String inputEamil, String inputPWD, HttpServletResponse response) {

        Cookie cookie = new Cookie("loginEmail", inputEamil);
        cookie.setPath("/");
        cookie.setMaxAge(30*24*60*60);
        response.addCookie(cookie);

        String encryptPWD = null;
        try{
            encryptPWD = md5Encrypt.encoderByMd5(inputPWD);
        }catch (Exception e){
            e.printStackTrace();
        }
        Cookie cookie1 = new Cookie("loginPWD", encryptPWD);
        cookie1.setPath("/");
        cookie1.setMaxAge(30*24*60*60);
        response.addCookie(cookie1);
    }

    public Integer selectMessageCount(HttpSession session) {

        Integer messCount = shtDao.selectMessageCount((UserEntity) session.getAttribute("user"));

        return messCount;
    }


}
