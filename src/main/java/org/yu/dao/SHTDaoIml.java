package org.yu.dao;

import org.yu.entity.GoodsEntity;
import org.yu.entity.UserEntity;

import java.util.List;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: $date$
 */
public interface SHTDaoIml {

    /**
     *   @Description: 根据商品类型ID查询该类型商品
     *   @Author:俞竞雄
     *   @Param:goodsType 商品类型ID
     *   @return:List<GoodsEntity> 所有商品集合
     *   @Date:2017-04-13
    */
    List<GoodsEntity> selectByGoodsType(int goodsType);

    /**
     *   @Description: 查询所有商品
     *   @Author:俞竞雄
     *   @return:List<GoodsEntity> 所有商品集合
     *   @Date:2017-04-13
    */
    List<GoodsEntity> selectAllGoods();

    /**
     *   @Description: 根据商品ID查询商品
     *   @Author:俞竞雄
     *   @Param:goodsID 商品ID
     *   @return:GoodsEntuty 商品信息
     *   @Date:2017-04-13
    */
    GoodsEntity selectByGoodsID(int goodsID);

    /**
     *   @Description: 根据email查询用户
     *   @Author:俞竞雄
     *   @Param:email  用户email
     *   @return:UserEntity 用户的信息
     *   @Date:2017-04-13   
    */
    UserEntity selectUserByEmail(String email);

    /**
     *   @Description: 插入用户
     *   @Author:俞竞雄
     *   @Param:user 要插入的用户信息
     *   @return:
     *   @Date:2017-04-13
    */
    void insertUser(UserEntity user);
}
