package com.dog.comet.event;

/**
 * Created by Administrator on 2017/2/27.
 */

import java.util.List;
import java.util.Map;

public class Comet {
    private String userId;
    private String msgCount;
    private List<Map> msgData;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(String msgCount) {
        this.msgCount = msgCount;
    }

    public List<Map> getMsgData() {
        return msgData;
    }

    public void setMsgData(List<Map> msgData) {
        this.msgData = msgData;
    }
}