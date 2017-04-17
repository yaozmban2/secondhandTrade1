package org.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.yu.entity.GoodsEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
@Controller
public class GoodsManageController {

    public ModelAndView releaseGoods(GoodsEntity goods, @RequestParam(value = "file") MultipartFile imgPic, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        return modelAndView;
    }
}
