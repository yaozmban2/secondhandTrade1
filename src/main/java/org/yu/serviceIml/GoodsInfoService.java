package org.yu.serviceIml;

import org.yu.entity.GoodsEntity;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: $date$
 */
public interface GoodsInfoService {

    GoodsEntity getGoods(int goodsID);

    String getGoodsType(int typeID);
    ;
}
