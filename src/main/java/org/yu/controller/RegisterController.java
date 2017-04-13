package org.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.yu.entity.UserEntity;
import org.yu.serviceIml.RegisterService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: $date$
 */
@Controller
public class RegisterController {

    @Resource(name="registerServiceIml")
    private RegisterService registerService;

    @RequestMapping("/register.action")
    public ModelAndView register(UserEntity register_user, @RequestParam(value="validatePwd")String validatePwd, @RequestParam(value = "validateCode")String inputCode, HttpSession session){
        /**
         *   @Description:
         *   @Author:俞竞雄
         *   @Param:[register_user] 绑定用户送过来的email和密码
         *   @Param:[validatePwd]    用户填写的重复密码
         *   @Param:[inputCode]      用户填写的验证码
         *   @Param:[session]        用户的session对象
         *   @return:org.springframework.web.servlet.ModelAndView
         *   @Date:2017-04-13
        */

        ModelAndView modelAndView = new ModelAndView();
        String viewName = "";

        //判断密码合法性
        if(!registerService.validatePwd(register_user.getPwd()))
        {
            modelAndView.addObject("validateCodeResult","");
            modelAndView.addObject("emailReult","");
            modelAndView.addObject("pwdValidateResult","");
            modelAndView.addObject("pwdResult","密码过短");
            modelAndView.addObject("nameResult","");
            viewName = "/user/register";
        }
        //判断名字输入的合法性
        else if(register_user.getName().equals(""))
        {
            modelAndView.addObject("validateCodeResult","");
            modelAndView.addObject("emailReult","");
            modelAndView.addObject("pwdValidateResult","");
            modelAndView.addObject("pwdResult","");
            modelAndView.addObject("nameResult","请输入名字");
            viewName = "/user/register";
        }
        //两次密码输入是否一致
        else if(!registerService.validateTwicePwd(register_user.getPwd(), validatePwd))
        {
            modelAndView.addObject("validateCodeResult","");
            modelAndView.addObject("emailReult","");
            modelAndView.addObject("pwdValidateResult","两次密码输入不同");
            modelAndView.addObject("pwdResult","");
            modelAndView.addObject("nameResult","");
            viewName = "/user/register";
        }
        //验证码是否正确
        else if(!registerService.validateCode((String) session.getAttribute("validateCode"), inputCode))
        {
            modelAndView.addObject("validateCodeResult","请输入正确的验证码");
            modelAndView.addObject("emailReult","");
            modelAndView.addObject("pwdValidateResult","");
            modelAndView.addObject("pwdResult","");
            modelAndView.addObject("nameResult","");
            viewName = "/user/register";
        }
        //email是否被占用
        else if(registerService.validateEmail(register_user))
        {
            modelAndView.addObject("validateCodeResult","");
            modelAndView.addObject("emailReult","该email已经注册");
            modelAndView.addObject("pwdValidateResult","");
            modelAndView.addObject("pwdResult","");
            modelAndView.addObject("nameResult","");
            viewName = "/user/register";
        }
        //验证全部通过，将user的信息放到数据库中
        else
        {
            registerService.insertUser(register_user);
            viewName = "/index";
        }

        //将register_user对象放到request中来回显数据
        modelAndView.addObject("registerUser",register_user);
        modelAndView.setViewName(viewName);

        return modelAndView;

    }
}
