package org.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.yu.service.LogoutServiceIml;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
@Controller
public class LogoutController {

    @Resource(name = "logoutServiceIml")
    private LogoutServiceIml logoutServiceIml;

    @RequestMapping("/logout.action")
    public ModelAndView logout(HttpServletRequest request) {
        /**
         *   @Description:  账号登出操作
         *   @Author:俞竞雄
         *   @Param:[request]
         *   @return:org.springframework.web.servlet.ModelAndView
         *   @Date:2017-03-17
        */

        ModelAndView modelAndView = new ModelAndView();

        //清除Cookie和session
        logoutServiceIml.quitAutoLogin(request);

        modelAndView.setViewName("redirect:/indexController.action?ceta=0");

        return modelAndView;
    }
}
