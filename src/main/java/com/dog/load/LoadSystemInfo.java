package com.dog.load;

import com.dog.dto.user.UserDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 * 预先加载数据,如果配置成R,C可能会被加载2次。所以Service or Contrallner
 */
@Service
public class LoadSystemInfo {
    @Autowired
    private SessionFactory sessionFactory;
    private Log log = LogFactory.getLog(LoadSystemInfo.class);

    /**
     * init预加载
     */
    @PostConstruct
    public void init() {
        System.out.println("init预加载");
//        log.debug("从数据库加载到某个地方" + this.sessionFactory.openSession().isOpen());//可以手动开启事务
//        Session session = this.sessionFactory.openSession();
//        List list = session.createSQLQuery("SELECT * FROM DOG_USER").addEntity(UserDto.class).list();
//        System.out.println(list.size());
//        session.clear();
//        session.close();
//        log.debug("从数据库加载到某个地方" + this.sessionFactory.getCurrentSession().isOpen());
    }

    /**
     * 销毁
     */
    @PreDestroy
    public void destory() {
        System.out.println("销毁");
    }
}
