package org.yu.service;

import org.springframework.stereotype.Service;
import org.yu.dao.SHTDao;
import org.yu.entity.GoodsEntity;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: $date$
 */
@Service(value="indexServiceIml")
public class IndexServiceIml implements org.yu.serviceIml.IndexService {

    @Resource(name="shtDao")
    private SHTDao shtDao;

    public List<GoodsEntity> getGoods(int goodsType) {
        List<GoodsEntity> list = new ArrayList<GoodsEntity>();

        if(goodsType > 0 && goodsType < 7) {
            list = shtDao.selectByGoodsType(goodsType);
        }else if(goodsType == 0) {
            list = shtDao.selectAllGoods();
        }

        return list;
    }

    public String getType(int goodsType) {

        String type;
        switch(goodsType){
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
