package org.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.yu.entity.GoodsEntity;
import org.yu.service.GoodsInfoServiceIml;

import javax.annotation.Resource;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: $date$
 */
@Controller
public class GoodsInfoController {

    @Resource(name="goodsInfoServiceIml")
    private GoodsInfoServiceIml goodsInfoServiceIml;

    @RequestMapping(value="/showGoods.action")
    public ModelAndView showGoods(@RequestParam(value = "goodsid")int goodsID){
        ModelAndView modelAndView = new ModelAndView();

        GoodsEntity goodsEntity = goodsInfoServiceIml.getGoods(goodsID);
        String goodsType = goodsInfoServiceIml.getGoodsType(goodsEntity.getTypeId());

        modelAndView.addObject("goods",goodsEntity);
        modelAndView.addObject("goodsType",goodsType);
        modelAndView.setViewName("goods/info");

        return modelAndView;
    }
}
