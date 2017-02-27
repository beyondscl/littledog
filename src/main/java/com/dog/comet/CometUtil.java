package com.dog.comet;

import org.comet4j.core.CometConnection;
import org.comet4j.core.CometContext;
import org.comet4j.core.CometEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/27.
 */
public class CometUtil {
    private static CometContext cc = CometContext.getInstance();
    private static CometEngine engine = CometContext.getInstance().getEngine();
    private static List<String> chnnal = new ArrayList<String>();

    /**
     * 对单个通道发送特定的消息
     *
     * @return
     */
    public static boolean sendToPerson(HttpServletRequest request, HttpServletResponse response, String channel, Object message) {
        if (!chnnal.contains(channel)) {
            cc.registChannel(channel);
            chnnal.add(channel);
        }
        CometConnection cometConnection = engine.getConnection(channel);
        cometConnection = cometConnection == null ? new CometConnection(request, response) : cometConnection;
        engine.sendTo(channel, cometConnection, message);
        return true;
    }
}
