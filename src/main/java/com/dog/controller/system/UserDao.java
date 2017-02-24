package com.dog.controller.system;

import com.dog.base.db.jdbc.dao.BaseJdbcTemplet;
import com.dog.dto.user.UserDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/2/16.
 */
@Repository
public class UserDao extends BaseJdbcTemplet {

    public Object queryTest() {
        return super.getJdbcTemplate().queryForList(" SELECT COUNT(1) FROM DOG_USER");
    }

    /**
     * 不建议用opensession
     *
     * @return
     */
    public Object queryTestForHbm() {
        return super.getSessionFactory().getCurrentSession().createSQLQuery("SELECT COUNT(1) FROM DOG_USER").list();
    }

}
