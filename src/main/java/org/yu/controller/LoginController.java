package org.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.yu.service.LoginServiceIml;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
@Controller
public class LoginController {

    @Resource(name = "loginServiceIml")
    private LoginServiceIml loginServiceIml;

    @RequestMapping("/login.action")
    public ModelAndView login(@RequestParam(value = "inputEmail")String inputEamil, @RequestParam(value = "inputPassword")String inputPWD, @RequestParam(value = "validateCode")String validateCode, HttpSession session) {
        /**
         *   @Description: 登录的判断功能
         *   @Author:俞竞雄
         *   @Param:[inputEamil]     用户输入的email
         *   @Param:[inputPWD]        用户输入的密码
         *   @Param:[validateCode]   用户输入的验证码
         *   @Param:[session]         用户的session对象
         *   @return:org.springframework.web.servlet.ModelAndView
         *   @Date:2017-04-13
        */

        ModelAndView modelAndView = new ModelAndView();
        //显示页面
        String viewName = "";

        //验证用户输入的验证码是否正确
        if(!session.getAttribute("validateCode").equals(validateCode))
        {
            modelAndView.addObject("validateCodeResult", "验证码错误");
            modelAndView.addObject("loginReult", "");
            viewName = "/user/login";
        }
        //验证用户输入的email和密码是否正确
        else if(!loginServiceIml.login(inputEamil, inputPWD, session))
        {
            modelAndView.addObject("validateCodeResult", "");
            modelAndView.addObject("loginReult", "E-mail或密码错误");
            viewName = "/user/login";
        }
        //验证通过
        else
        {
            modelAndView.addObject("validateCodeResult", "");
            modelAndView.addObject("loginReult", "");
            viewName = "/index";
        }

        modelAndView.setViewName(viewName);

        return modelAndView;
    }

}
