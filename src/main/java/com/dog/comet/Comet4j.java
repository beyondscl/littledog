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
 * Created by Administrator on 2017/2/23.
 */
public class Comet4j extends ConnectListener implements ServletContextListener {

    // 频道1
    private static final String CHANNEL1 = "COMMON";//公共频道
    private static final String CHANNEL2 = "PERSON";

    private static final String CHANNEL3 = "PERSONAL";//私人频道
    private static Map<String, ConnectEvent> map = new HashMap<String, ConnectEvent>();


    // 通过频道1推送给前台的变量1
    private static int number1 = 0;
    // 通过频道2推送给前台的变量2
    private static int number2 = 100;

    public static boolean sendToPerson(MessageDto messageDto) {
        ConnectEvent connectEvent = map.get(messageDto.getUid());
        Assert.notNull(connectEvent);
        CometEngine engine = CometContext.getInstance().getEngine();
        engine.sendTo(CHANNEL3, connectEvent.getConn(), messageDto.getMessage());
        return true;
    }

    /**
     * 初始化上下文
     */
    public void contextInitialized(ServletContextEvent arg0) {

        // CometContext ： Comet4J上下文，负责初始化配置、引擎对象、连接器对象、消息缓存等。
        CometContext cc = CometContext.getInstance();
        // 注册频道，即标识哪些字段可用当成频道，用来作为向前台传送数据的“通道”
        cc.registChannel(CHANNEL1);
        cc.registChannel(CHANNEL2);
        cc.registChannel(CHANNEL3);
        CometEngine engine = CometContext.getInstance().getEngine();
        engine.addConnectListener(this);
        Thread myThread = new Thread(new SendToClientThread(), "SendToClientThread");
        // 下面的内部类的方法是个死循环，设置helloAppModule线程为“守护线程”，则当jvm只剩“守护线程”时(主线程结束)，该线程也会结束。
        myThread.setDaemon(true);
        // 开始线程
        myThread.start();
    }

    public void contextDestroyed(ServletContextEvent arg0) {
    }

    @Override
    public boolean handleEvent(ConnectEvent connectEvent) {
        try {
            UserDto userDto = (UserDto) SessionUtil.getSession(connectEvent.getConn().getRequest()).getAttribute(CommonStatis.Login_user);
            String uid = userDto.getLogin();
            map.put(uid, connectEvent);
            //userid 和 connid绑定在一起，用engine去获取用户特定的connecttion实现特定用户的推送消息
        } catch (Exception e) {
        }
        return true;
    }

    /**
     * 内部类线程类
     */
    class SendToClientThread implements Runnable {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                // CometEngine ： 引擎，负责管理和维持连接，并能够必要的发送服务
                CometEngine engine = CometContext.getInstance().getEngine();
                // 参数的意思：通过什么频道（CHANNEL1）发送什么数据（number1++），前台可用可用频道的值（result1）来获取某频道发送的数据
                engine.sendToAll(CHANNEL1, number1++);
                engine.sendToAll(CHANNEL2, number2++);
            }
        }
    }

}