package com.dog.controller.system;

import com.dog.base.db.jdbc.inter.BaseJdbcTempletService;
import com.dog.dto.user.UserDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/2/16.
 */
@Service
public interface UserService extends BaseJdbcTempletService {

    public List queryTest() throws Exception;
    public int insertTest() throws Exception;
    public Object queryTestForHbm();

}
