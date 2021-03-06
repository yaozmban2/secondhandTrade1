package org.yu.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.yu.entity.GoodsEntity;
import org.yu.entity.MessageEntity;
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

    public UserEntity selectUserById(Integer userID) {

        Transaction transaction = null;
        Session session = null;
        UserEntity userEntity = null;

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Criteria criteria = session.createCriteria(UserEntity.class);
            criteria.add(Restrictions.eq("id", userID));
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

    public void insertMessage(MessageEntity messageEntity) {

        Transaction transaction = null;
        Session session = null;

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(messageEntity);

            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    public void insertGoods(GoodsEntity goods) {

        Transaction transaction = null;
        Session session = null;

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(goods);

            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    public Integer selectMessageCount(UserEntity user) {

        Transaction transaction = null;
        Session session = null;
        Integer messCount = null;

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Criteria criteria = session.createCriteria(MessageEntity.class);
            criteria.add(Restrictions.eq("messToId", user.getId()));
            criteria.setProjection(Projections.rowCount());
            Object obj = criteria.uniqueResult();

            Long lobj = (Long) obj;
            messCount = lobj.intValue();

            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }

        return messCount;
    }

    public void updateUser(UserEntity user) {
        Transaction transaction = null;
        Session session = null;

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(user);

            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }

    }

    public List<MessageEntity> selectMessageInfo(Integer messToId, Integer pageNum) {

        List<MessageEntity> list = null;
        Transaction transaction = null;
        Session session = null;

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Criteria criteria = session.createCriteria(MessageEntity.class);
            //设置按messToTd=收信用户ID进行条件查询
            criteria.add(Restrictions.eq("messToId", messToId));
            //设置按升序查询
            criteria.addOrder(Order.asc("messFromId"));
            //设置开始位置：(当前页 - 1) * 每页记录数
            criteria.setFirstResult((pageNum - 1) * 5);
            //每页显示记录数
            criteria.setMaxResults(5);
            //查询数据库
            list = criteria.list();

            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }

        return list;
    }

    public List<GoodsEntity> selectMyRealseGoodsInfo(Integer productID, Integer pageNum) {
        Transaction transaction = null;
        Session session = null;
        List<GoodsEntity> list = null;

        try{
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(GoodsEntity.class);
            //设置查询条件为商品创建者ID为用户ID
            criteria.add(Restrictions.eq("producterId", productID));
            //设置数据库按照商品状态ID升序查询
            criteria.addOrder(Order.asc("status"));
            //设置分页查询的第几页和每页显示数量
            criteria.setFirstResult((pageNum - 1) * 5);
            criteria.setMaxResults(5);

            list = criteria.list();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }

        return list;
    }
}
