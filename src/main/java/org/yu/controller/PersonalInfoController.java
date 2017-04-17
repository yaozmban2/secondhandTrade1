package org.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.yu.entity.UserEntity;
import org.yu.service.ChangePersonalInfoServicceIml;
import org.yu.service.LogoutServiceIml;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
@Controller
public class PersonalInfoController {

    @Resource(name = "changePersonalInfoServicceIml")
    private ChangePersonalInfoServicceIml changePersonalInfoServicceIml;

    @Resource(name = "logoutServiceIml")
    private LogoutServiceIml logoutServiceIml;

    @RequestMapping("/changePersonalPWD.action")
    public ModelAndView changePersonalPWD(UserEntity inputUser, @RequestParam(value = "validatePWD")String validatePWD, @RequestParam(value = "newPWD")String newPWD, HttpServletRequest request, HttpServletResponse response){

        ModelAndView modelAndView = new ModelAndView();

        if(changePersonalInfoServicceIml.changePersonalPWD(inputUser, modelAndView, validatePWD, newPWD, request))
        {
            modelAndView.addObject("changePresonalPWDScucess", "密码修改成功，请重新登录！");
            logoutServiceIml.quitAutoLogin(request, response);
            modelAndView.setViewName("/user/login");
        }else {
            modelAndView.addObject("flag", "personalMSSG");
            modelAndView.setViewName("/user/personal");
        }

        modelAndView.addObject("isPWDpage", "PWDpage");

        return modelAndView;

    }

    @RequestMapping("/changePersonalInfo.action")
    public ModelAndView changePersonalInfo(UserEntity inputUser,HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        if(changePersonalInfoServicceIml.changePersonalInfo(inputUser, request.getSession()))
        {
            modelAndView.addObject("checkChangePersonalInfo", "修改用户信息成功！");
        }

        modelAndView.addObject("flag", "personalMSSG");

        modelAndView.setViewName("/user/personal");

        return modelAndView;
    }

    @RequestMapping("/uploadAvatar.action")
    public ModelAndView uploadAvatar(HttpServletRequest request, @RequestParam(value = "file") MultipartFile itemPic) {
        ModelAndView modelAndView = new ModelAndView();

        if(changePersonalInfoServicceIml.uploadAvatar(request.getSession(), itemPic))
        {
            modelAndView.setViewName("/user/personal");

        }

        modelAndView.setViewName("/user/personal");

        modelAndView.addObject("flag", "personalMSSG");

        return modelAndView;
    }
}
