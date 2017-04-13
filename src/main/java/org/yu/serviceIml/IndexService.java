package org.yu.serviceIml;

import org.yu.entity.GoodsEntity;

import java.util.List;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: $date$
 */
public interface IndexService {

    /**
     *   @Description: 根据商品类型ID获得所有该类型的商品
     *   @Author:俞竞雄
     *   @Param:goodsType 商品类型ID
     *   @return:List<GoodsEntity> 包含所有商品信息的list集合
     *   @Date:2017-04-14
    */
    List<GoodsEntity> getGoods(int goodsType);

    /**
     *   @Description: 根据商品类型ID获得该类型的名称
     *   @Author:俞竞雄
     *   @Param:goodsType 商品类型ID
     *   @return:String    商品类型名称
     *   @Date:2017-04-14
    */
    String getType(int goodsType);
}
