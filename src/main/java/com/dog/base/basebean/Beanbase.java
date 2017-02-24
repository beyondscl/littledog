package com.dog.base.basebean;

public abstract class Beanbase {

    /**
     * 解决对session对一个对象的多次保存问题
     * @return
     */
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return o;
    }
}
