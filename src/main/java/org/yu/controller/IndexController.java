package org.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.yu.entity.GoodsEntity;
import org.yu.service.IndexServiceIml;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author:俞竞雄
 * @Description:显示首页的处理器
 * @Date: 2017-03-13
 */
@Controller
public class IndexController  {

    //将indexService对象注入
    @Resource(name="indexServiceIml")
    private IndexServiceIml indexServiceIml;

    @RequestMapping("/indexController.action")
    public ModelAndView showItem(@RequestParam(value="ceta")int ceta, HttpServletRequest request) throws Exception {
            /**
            *   @Description: 根据商品类型ID显示主页信息
            *   @Author:俞竞雄
            *   @Param:[ceta] 页面传递过来的一个数字，表示商品类型ID
            *   @return:org.springframework.web.servlet.ModelAndView
            *   @Date:2017-03-13
            */

            ModelAndView modelAndView = new ModelAndView();

            //通过该方法查询数据库中货物类型为ceta值的货物并返回
            List<GoodsEntity> list = indexServiceIml.getGoods(ceta);
            //通过该方法判断ceta值所对应的类型名称
            String type = indexServiceIml.getType(ceta);

            //将要显示的数据添加到modelAndView中
            //返回的商品信息合集
            modelAndView.addObject("goodsItems", list);
            //返回的商品类型ID
            modelAndView.addObject("returnCeta",ceta);
            //返回商品类型名称
            modelAndView.addObject("type",type);

            //使用index.jsp页面显示
            modelAndView.setViewName("index");

            return modelAndView;
    }
}
