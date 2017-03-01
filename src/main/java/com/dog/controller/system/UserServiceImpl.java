package com.dog.controller.system;

import com.dog.dto.user.UserDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/2/16.
 */
@Service
public class UserServiceImpl implements UserService {
    private Log log = LogFactory.getLog(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;
    public List queryTest() throws Exception {
        return (List) userDao.queryTest();
    }

    /**
     * 插入测试
     *  同一个对象引用，如果只是改变主键就重新u,d,s操作，那么都会错误
     * @return
     * @throws Exception
     */
    public int insertTest() throws Exception {
        System.out.println("=================="+userDao.getSessionFactory().getCurrentSession().isOpen());
        UserDto userDto = new UserDto();
        String id = UUID.randomUUID().toString();
        userDto.setId(id);
        userDto.setLoginName("beyond");
        userDto.setTrueName("no name");
        userDto.setDept(1);
        userDao.save(userDto);
        UserDto u = (UserDto) userDto.clone();
        u.setId(UUID.randomUUID().toString());
        userDao.merge(u);
        return 1;
    }

    @Transactional(readOnly = true)
    public Object queryTestForHbm() {
        return userDao.queryTestForHbm();
    }

}
