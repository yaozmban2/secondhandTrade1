package org.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.yu.entity.GoodsEntity;
import org.yu.service.GoodsManageServiceIml;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
@Controller
public class GoodsManageController {

    @Resource(name = "goodsManageServiceIml")
    private GoodsManageServiceIml goodsManageServiceIml;

    @RequestMapping("/releaseGoods.action")
    public ModelAndView releaseGoods(GoodsEntity goods, @RequestParam(value = "file") MultipartFile imgPic, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        //没有输入物品名称
        if (goods.getName().equals(""))
        {
            modelAndView.addObject("releaseGoodsResult", "请输入商品名称");
        }
        //没有输入商品简介
        else if (goods.getContent().equals(""))
        {
            modelAndView.addObject("releaseGoodsResult", "请输入商品简介，以便买家了解商品信息");
        }
        //没有输入图片
        else if (imgPic.getSize() < 1)
        {
            modelAndView.addObject("releaseGoodsResult", "请添加商品的照片，以便买家了解商品信息");
        }
        //商品信息合法性验证通过且添加成功
        else if (goodsManageServiceIml.releaseGoods(request.getSession(), goods, imgPic))
        {
            modelAndView.addObject("releaseGoodsResult", "商品添加成功，可进我的商品页面查看");
        }

        //设置跳到personal页面时包含push.jsp页面
        modelAndView.addObject("flag", "releaseGoods");
        //为了设置数据回显
        modelAndView.addObject("goods", goods);
        modelAndView.setViewName("/user/personal");

        return modelAndView;
    }

    @RequestMapping("/showMyReleaseGoods.action")
    public ModelAndView showMyReleaseGoods(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        Integer pageNum = 1;

        //如果用户有发布商品
        if (goodsManageServiceIml.showMyReleaseGoods(request.getSession(), pageNum).size() > 0)
        {
            List<GoodsEntity> list = goodsManageServiceIml.showMyReleaseGoods(request.getSession(), pageNum);
            modelAndView.addObject("myReleaseGoodsItems", list);
        }else{
            modelAndView.addObject("hasGoods", false);
        }

        modelAndView.addObject("rPageNum", pageNum);
        modelAndView.addObject("flag", "myRelaaseGoodsInfo");
        modelAndView.setViewName("/user/personal");

        return modelAndView;
    }

    @RequestMapping("/showMyReleaseGoodsNext.action")
    public ModelAndView showMyReleaseGoodsNext(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        Integer pageNum = 0;

        if(request.getSession().getAttribute("pageNum") != null)
        {
            pageNum = (Integer) request.getSession().getAttribute("pageNum");
            pageNum++;
            //判断是否还有下一页数据
            if (goodsManageServiceIml.showMyReleaseGoods(request.getSession(), pageNum) != null)
            {
                List<GoodsEntity> list = goodsManageServiceIml.showMyReleaseGoods(request.getSession(), pageNum);
                modelAndView.addObject("myReleaseGoodsItems", list);

                //判断是否为最后一页数据
                //若是最后一页数据
                if (list.size() < 5)
                {
                    modelAndView.addObject("isLastPage", true);
                }
            }else{
                modelAndView.addObject("isLastPage", true);
            }
        }

        modelAndView.addObject("rPageNum", pageNum);
        modelAndView.addObject("flag", "myRelaaseGoodsInfo");
        modelAndView.setViewName("/user/personal");

        return modelAndView;
    }

    @RequestMapping("/showMyReleaseGoodsUp.action")
    public ModelAndView showMyReleaseGoodsUp (HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        Integer pageNum = 0;

        if(request.getSession().getAttribute("pageNum") != null)
        {
            pageNum = (Integer) request.getSession().getAttribute("pageNum");
            pageNum--;
            List<GoodsEntity> list = goodsManageServiceIml.showMyReleaseGoods(request.getSession(), pageNum);
            modelAndView.addObject("myReleaseGoodsItems", list);
        }

        modelAndView.addObject("rPageNum", pageNum);
        modelAndView.addObject("flag", "myRelaaseGoodsInfo");
        modelAndView.setViewName("/user/personal");

        return modelAndView;
    }
}
