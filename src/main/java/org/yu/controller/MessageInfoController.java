package org.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.yu.entity.MessageCustom;
import org.yu.service.MessageInfoServiceIml;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
@Controller
public class MessageInfoController {

    @Resource(name = "messageInfoServiceIml")
    private MessageInfoServiceIml messageInfoServiceIml;

    @RequestMapping("/showMessageInfo.action")
    public ModelAndView showMessageInfo(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        Integer pageNum = 1;

        if (messageInfoServiceIml.showMessageInfo(request.getSession(), pageNum))
        {
            modelAndView.addObject("flag", "correspondMSSG");
        }
        else {
            modelAndView.addObject("messageResult", "您尚未收到任何消息！");
            modelAndView.addObject("flag", "correspondMSSG");
        }

        modelAndView.setViewName("/user/personal");

        return modelAndView;
    }

    @RequestMapping("/showMessageInfoNextPage.action")
    public ModelAndView showMessageInfoNextPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        Integer pageNum = 0;

        if(request.getSession().getAttribute("pageNum") != null)
        {
            pageNum = (Integer) request.getSession().getAttribute("pageNum");
            pageNum++;
            if (messageInfoServiceIml.showMessageInfo(request.getSession(), pageNum))
            {
                modelAndView.addObject("flag", "correspondMSSG");
            }
        }

        if (request.getSession().getAttribute("messageList") != null)
        {
            List<MessageCustom> list = (List<MessageCustom>) request.getSession().getAttribute("messageList");
            if (list.size() < 5)
            {
                modelAndView.addObject("messageResult", "已经达到最大页数");
            }
        }

        modelAndView.setViewName("/user/personal");

        return modelAndView;
    }

    @RequestMapping("/showMessageInfoUpPage.action")
    public ModelAndView showMessageInfoUpPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        Integer pageNum = 0;

        if(request.getSession().getAttribute("pageNum") != null)
        {
            pageNum = (Integer) request.getSession().getAttribute("pageNum");
            pageNum--;
            if (messageInfoServiceIml.showMessageInfo(request.getSession(), pageNum))
            {
                modelAndView.addObject("flag", "correspondMSSG");
            }
        }
        if (request.getSession().getAttribute("messageList") != null)
        {
            List<MessageCustom> list = (List<MessageCustom>) request.getSession().getAttribute("messageList");
            if (list.size() < 5)
            {
                modelAndView.addObject("messageResult", "已经达到最大页数");
            }
        }

        modelAndView.setViewName("/user/personal");

        return modelAndView;
    }

    @RequestMapping("/sendMessage.action")
    public ModelAndView sendMessage(HttpServletRequest request, @RequestParam(value = "InputMess")String inputMess, @RequestParam(value = "InputEmailToSend")String inputEmailToSend) {
        ModelAndView modelAndView = new ModelAndView();

        if (messageInfoServiceIml.sendMessage(request, inputMess, inputEmailToSend, modelAndView))
        {
            modelAndView.addObject("sendMessageResult", "消息成功发送！");
        } else {
            modelAndView.addObject("inputMess", inputMess);
        }

        modelAndView.addObject("flag", "correspondMSSG");
        modelAndView.addObject("isSendMessage", "true");

        modelAndView.setViewName("/user/personal");

        return  modelAndView;
    }

    @RequestMapping("/toSendMessagePage.action")
    public ModelAndView toSendMessagePage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("flag", "correspondMSSG");
        modelAndView.addObject("isSendMessage", "true");

        modelAndView.setViewName("/user/personal");

        return modelAndView;
    }

}
