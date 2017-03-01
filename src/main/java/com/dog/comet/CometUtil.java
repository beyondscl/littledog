package com.dog.comet;

import com.dog.controller.system.SessionUtil;
import com.dog.dto.user.UserDto;
import com.dog.util.CommonStatis;
import org.comet4j.core.CometContext;
import org.comet4j.core.CometEngine;
import org.comet4j.core.event.ConnectEvent;
import org.comet4j.core.listener.ConnectListener;
import org.springframework.util.Assert;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public class CometUtil extends ConnectListener implements ServletContextListener {
    private static CometContext cc = CometContext.getInstance();
    private static CometEngine engine = CometContext.getInstance().getEngine();
    private static String PERSONAL = "PERSONAL";
    private static final Map<String, ConnectEvent> map = new HashMap<String, ConnectEvent>();

    public static boolean sendToPerson(MessageDto messageDto) {
        ConnectEvent connectEvent = map.get(messageDto.getUid());
        Assert.notNull(connectEvent);
        engine.sendTo(PERSONAL, engine.getConnection(connectEvent.getConn().getId()), messageDto.getMessage());
        return true;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        cc.registChannel(PERSONAL);
        engine.addConnectListener(this);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    @Override
    public boolean handleEvent(ConnectEvent connectEvent) {
        try {
            UserDto userDto = (UserDto) SessionUtil.getSession(connectEvent.getConn().getRequest()).getAttribute(CommonStatis.Login_user);
            String uid = userDto.getLogin();
            map.put(uid, connectEvent);
            //userid 和 connid绑定在一起，用engine去获取用户特定的connecttion实现特定用户的推送消息
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
