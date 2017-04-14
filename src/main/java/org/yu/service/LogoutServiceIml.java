package org.yu.service;

import org.springframework.stereotype.Service;
import org.yu.serviceIml.LogoutService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
@Service(value = "logoutServiceIml")
public class LogoutServiceIml implements LogoutService {

    public void quitAutoLogin(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies)
        {
            if("loginEmail".equals(cookie.getName()))
            {
                cookie.setValue("");
            }else if("loginPWD".equals(cookie.getName()))
            {
                cookie.setValue("");
            }
        }
        request.getSession().removeAttribute("user");
    }
}
