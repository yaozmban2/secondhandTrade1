package org.yu.service;

import org.springframework.stereotype.Service;
import org.yu.dao.SHTDao;
import org.yu.entity.GoodsEntity;
import org.yu.serviceIml.GoodsInfoService;

import javax.annotation.Resource;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: $date$
 */
@Service(value="goodsInfoServiceIml")
public class GoodsInfoServiceIml implements GoodsInfoService {

    @Resource(name="shtDao")
    private SHTDao shtDao;

    public GoodsEntity getGoods(int goodsID) {

        GoodsEntity goodsEntity = shtDao.selectByGoodsID(goodsID);

        return goodsEntity;
    }

    public String getGoodsType(int typeID) {
        String type;
        switch(typeID){
            case 0: return "全部";
            case 1: return "书籍";
            case 2: return "生活出行";
            case 3: return "衣物鞋包";
            case 4: return "电子产品";
            case 5: return "体育运动";
            case 6: return "其他";
            default: return null;
        }
    }
}
