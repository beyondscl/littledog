package com.dog.controller.system;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/2/10.
 */

@SuppressWarnings("ALL")
@Controller
@RequestMapping("/user")
public class userLogin {
    protected final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() throws Exception {
//        logger.info(userService.queryTest().get(0));
//        logger.info(userService.queryTestForHbm());
//        logger.info(userService.insertTest());
        return "main";
    }

}
