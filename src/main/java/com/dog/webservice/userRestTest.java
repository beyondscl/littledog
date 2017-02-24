package com.dog.webservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/2/14.
 */
@Controller
@RequestMapping("/user/api/")
public class userRestTest {
    /**
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void get(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(id);
        PrintWriter printWriter = response.getWriter();
        printWriter.write("hello");
        printWriter.flush();
        printWriter.close();
    }

    /**
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String update(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(id);
        return "212321312";
    }
}
