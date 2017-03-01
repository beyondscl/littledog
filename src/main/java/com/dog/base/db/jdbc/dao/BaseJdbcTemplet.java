package com.dog.base.db.jdbc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


/**
 * Created by Administrator on 2017/2/16.
 * batchUpdate适合于批量增、删、改操作；
 * update(…)：使用于增、删、改操作；
 * execute（）：执行一个独立的sql语句，包括ddl语句；
 * queryForInt ：查询出一个整数值
 */
@Repository
public class BaseJdbcTemplet {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SessionFactory sessionFactory;

    protected JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * 获取session之前先清空
     * @return
     */
    public Session getSessionAfterClear(){
        Session session = this.getSessionFactory().getCurrentSession();
        session.clear();
        return session;
    }
    /**
     * 获取session之前不先清空
     * @return
     */
    public Session getSession(){
        return this.getSessionFactory().getCurrentSession();
    }
    /**
     * 保存一个对象
     * @param object
     * @return
     */
    public Serializable save(Object object){
        return this.getSessionFactory().getCurrentSession().save(object);
    }
    /**
     * 保存更新或者保存一个对象，并强制更新数据库
     * @param object
     * @return
     */
    public Object merge(Object object){
        return this.getSessionFactory().getCurrentSession().merge(object);
    }
}
