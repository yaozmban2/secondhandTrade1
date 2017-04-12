package org.yu.dao;

import org.yu.entity.GoodsEntity;

import java.util.List;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: $date$
 */
public interface SHTDaoIml {

    List<GoodsEntity> selectByGoodsType(int goodsType);

    List<GoodsEntity> selectAllGoods();

    GoodsEntity selectByGoodsID(int goodsID);
}
