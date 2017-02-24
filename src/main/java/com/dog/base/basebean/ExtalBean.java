package com.dog.base.basebean;

/**
 * Created by Administrator on 2017/2/22.
 */
public abstract class ExtalBean extends  PageBean {
    /**
     * 自定义
     * 获取一条数据的描述
     * @return
     */
    public  abstract String getTitle();

    /**
     * 自定义
     * 获取一条数据的主键(或者唯一标识)
     * @return
     */
    public  abstract String getPrimaryKey();
}
