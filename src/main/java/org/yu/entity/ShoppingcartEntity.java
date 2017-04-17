package org.yu.entity;

import javax.persistence.*;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
@Entity
@Table(name = "shoppingcart", schema = "secondhandtrade", catalog = "")
public class ShoppingcartEntity {
    private int id;
    private int goodsId;
    private int userId;

    @Id
    @Basic
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "goodsId", nullable = false)
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "userId", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingcartEntity that = (ShoppingcartEntity) o;

        if (id != that.id) return false;
        if (goodsId != that.goodsId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + goodsId;
        result = 31 * result + userId;
        return result;
    }
}
