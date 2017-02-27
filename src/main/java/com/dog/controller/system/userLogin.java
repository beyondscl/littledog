package com.dog.controller.system;

import com.dog.dto.user.UserDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute UserDto userDto) throws Exception {
        Assert.notNull(userDto.getLogin());
        SessionUtil.setUser(request, userDto);
        logger.info(userDto.getLogin() + "登录了");
//        logger.info(userService.queryTest().get(0));
//        logger.info(userService.queryTestForHbm());
//        logger.info(userService.insertTest());
        return "main";
    }

}
