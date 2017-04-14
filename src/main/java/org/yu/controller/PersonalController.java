package org.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
@Controller
public class PersonalController {

    @RequestMapping("/showPersonal.action")
    public ModelAndView showPersonal(@RequestParam(value = "flag")String flag, HttpServletRequest request) {
        /**
         *   @Description:    显示个人信息
         *   @Author:俞竞雄
         *   @Param:[flag]     接收用户对用户信息页面的选择
         *   @Param:[request]
         *   @return:org.springframework.web.servlet.ModelAndView
         *   @Date:2017-04-14
        */

        ModelAndView modelAndView = new ModelAndView();

        //选择查看个人信息的情况
        if("personalMSSG".equals(flag))
        {
            modelAndView.addObject("flag", "personalMSSG");
        }
        //选择查看站内消息的情况
        else if("correspondMSSG".equals(flag))
        {
            modelAndView.addObject("flag", "correspondMSSG");
        }
        //选择发布新商品的情况
        else if("releaseGoods".equals(flag))
        {
            modelAndView.addObject("flag", "releaseGoods");
        }
        //选择查看发布的商品的情况
        else if("myRelaaseGoodsInfo".equals(flag))
        {
            modelAndView.addObject("flag", "myRelaaseGoodsInfo");
        }
        //查看收藏夹的情况
        else if("myCollectGoodsInfo".equals(flag))
        {
            modelAndView.addObject("flag", "myCollectGoodsInfo");
        }


        modelAndView.setViewName("/user/personal");

        return modelAndView;
    }
}
