package org.yu.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.yu.entity.GoodsEntity;
import org.yu.entity.UserEntity;
import org.yu.utils.MD5Encrypt;

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

    //注入sessionFactory
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    //注入md5Encrypt
    @Resource(name="md5Encrypt")
    private MD5Encrypt md5Encrypt;

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

    public UserEntity selectUserByEmail(String email) {

        Transaction transaction = null;
        Session session = null;
        UserEntity userEntity = null;

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Criteria criteria = session.createCriteria(UserEntity.class);
            criteria.add(Restrictions.eq("email", email));
            userEntity = (UserEntity) criteria.uniqueResult();

            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }

        return userEntity;
    }

    public void insertUser(UserEntity user){

        Transaction transaction = null;
        Session session = null;

        try {
            user.setPwd(md5Encrypt.encoderByMd5(user.getPwd()));
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(user);

            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
    }
}
