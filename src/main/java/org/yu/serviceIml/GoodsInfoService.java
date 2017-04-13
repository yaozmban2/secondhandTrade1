package org.yu.serviceIml;

import org.yu.entity.GoodsEntity;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: $date$
 */
public interface GoodsInfoService {

    /**
     *   @Description: 根据商品ID获得商品信息
     *   @Author:俞竞雄
     *   @Param:goodsID 商品ID
     *   @return:GoodsEntity 返回商品信息
     *   @Date:2017-04-13
    */
    GoodsEntity getGoods(int goodsID);

    /**
     *   @Description: 根据商品类型ID获得商品类型名称
     *   @Author:俞竞雄
     *   @Param:typeID 商品类型ID
     *   @return:String 商品类型名称
     *   @Date:2017-04-14
    */
    String getGoodsType(int typeID);
    ;
}
