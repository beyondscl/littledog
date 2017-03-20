package com.dog.test;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/3/15.
 */
public class HashMapTest extends HttpServlet {

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        ArrayList<String> b = new ArrayList<String>(a);
        b.toArray();
        b.toArray();
        String[] s = new String[10];
        b.toArray(s);
        HashMap m = new HashMap();
        m.put(1,2);
        m.put(1,3);
        m.put(2,4);
        System.out.println(m.size());
    }
}
