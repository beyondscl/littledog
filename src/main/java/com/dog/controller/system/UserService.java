package com.dog.controller.system;

import com.dog.base.db.jdbc.inter.BaseJdbcTempletService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */
@Service
public interface UserService extends BaseJdbcTempletService {

    List queryTest() throws Exception;
    int insertTest() throws Exception;
    Object queryTestForHbm();

}
