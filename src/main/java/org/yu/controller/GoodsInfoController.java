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
    public ModelAndView showGoods(@RequestParam(value = "goodsid")int goodsID) throws Exception{
        /**
         *   @Description: 根据商品ID显示商品详情
         *   @Author:俞竞雄
         *   @Param:[goodsID] 商品ID
         *   @return:org.springframework.web.servlet.ModelAndView
         *   @Date:2017-03-14
        */

        ModelAndView modelAndView = new ModelAndView();

        //根据ID获得商品的信息并放入goodsEntity实体中
        GoodsEntity goodsEntity = goodsInfoServiceIml.getGoods(goodsID);
        //获得商品的类型名称
        String goodsType = goodsInfoServiceIml.getGoodsType(goodsEntity.getTypeId());

        //将商品信息和商品类型名称分别放到request中
        modelAndView.addObject("goods",goodsEntity);
        modelAndView.addObject("goodsType",goodsType);
        modelAndView.setViewName("goods/info");

        return modelAndView;
    }
}
