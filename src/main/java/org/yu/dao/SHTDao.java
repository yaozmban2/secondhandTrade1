package org.yu.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.yu.entity.GoodsEntity;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: $date$
 */

@Repository(value="shtDao")
public class SHTDao implements SHTDaoIml {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public List<GoodsEntity> selectByGoodsType(int goodsType) {

        Transaction transaction = null;
        Session session = null;
        List<GoodsEntity> list = new ArrayList<GoodsEntity>();
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Criteria criteria = session.createCriteria(GoodsEntity.class);
            criteria.add(Restrictions.eq("typeId", goodsType));

            list = criteria.list();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }

        return list;
    }

    public List<GoodsEntity> selectAllGoods() {

        Transaction transaction = null;
        Session session = null;
        List<GoodsEntity> list = new ArrayList<GoodsEntity>();

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Criteria criteria = session.createCriteria(GoodsEntity.class);
            list = criteria.list();

            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }

        return list;
    }

    public GoodsEntity selectByGoodsID(int goodsID) {

        Transaction transaction = null;
        Session session = null;
        GoodsEntity goodsEntity = null;

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            goodsEntity = (GoodsEntity) session.get(GoodsEntity.class, goodsID);

            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }

        return goodsEntity;
    }
}
