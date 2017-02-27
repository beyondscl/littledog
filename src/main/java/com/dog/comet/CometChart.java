package com.dog.comet;

import com.dog.controller.system.SessionUtil;
import com.dog.util.CommonStatis;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/2/27.
 */
@Controller
@RequestMapping("/comet")
public class CometChart {

    @RequestMapping("/chart")
    public ModelAndView chart(HttpServletRequest request, HttpServletResponse response, @ModelAttribute MessageDto messageDto) throws Exception {
        Comet4j.sendToPerson(messageDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(SessionUtil.getSession(request).getAttribute(CommonStatis.Login_user));
        modelAndView.setViewName("main");
        return modelAndView;
    }

}
