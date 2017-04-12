package org.yu.serviceIml;

import org.yu.entity.GoodsEntity;

import java.util.List;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: $date$
 */
public interface IndexService {

    List<GoodsEntity> getGoods(int goodsType);

    String getType(int goodsType);
}
