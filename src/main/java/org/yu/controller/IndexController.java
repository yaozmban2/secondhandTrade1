package org.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.yu.entity.GoodsEntity;
import org.yu.service.IndexServiceIml;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:俞竞雄
 * @Description:显示首页的处理器
 * @Date: $date$
 */
@Controller
public class IndexController  {

    //将indexService对象注入
    @Resource(name="indexServiceIml")
    private IndexServiceIml indexServiceIml;

    @RequestMapping("/indexController.action")
    public ModelAndView showItem(@RequestParam(value="ceta")int ceta) throws Exception {

            ModelAndView modelAndView = new ModelAndView();

            //通过该方法查询数据库中货物类型为ceta值的货物并返回
            List<GoodsEntity> list = indexServiceIml.getGoods(ceta);
            //通过该方法判断ceta值所对应的类型名称
            String type = indexServiceIml.getType(ceta);

            modelAndView.addObject("goodsItems", list);
            modelAndView.addObject("returnCeta",ceta);
            modelAndView.addObject("type",type);

            modelAndView.setViewName("index");

            return modelAndView;
    }
}
