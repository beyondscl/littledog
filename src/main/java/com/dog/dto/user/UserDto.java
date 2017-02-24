package com.dog.dto.user;

import com.dog.base.basebean.ExtalBean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/21.
 */
public class UserDto extends ExtalBean implements Serializable, Cloneable {
    private String id;
    private String login;
    private String trueName;
    private String loginName;
    private String ukey;
    private int dept;
    private String title;
    private String primaryKey;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUkey() {
        return ukey;
    }

    public void setUkey(String ukey) {
        this.ukey = ukey;
    }

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrimaryKey() {
        return this.primaryKey == null ? this.id : this.primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }
}
