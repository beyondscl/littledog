package com.dog.controller.system;

import com.dog.dto.user.UserDto;
import com.dog.util.CommonStatis;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/2/14.
 */
public class SessionUtil {
    private static List<UserDto> userList = new ArrayList<UserDto>();
    private HttpServletRequest request;
    private HttpServletResponse response;

    public static Object getAttribute(String login_user) {
        return null;
    }

    public static void setAttribute(HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * 获取一个session
     *
     * @param request
     * @return
     */
    public static HttpSession getSession(HttpServletRequest request) {
        Assert.notNull(request);
        return request.getSession();
    }


    /**
     * 设置用户的时候特殊处理下
     * 将用户放入一个特定的列表中
     *
     * @param userDto
     * @return
     */
    public static void setUser(HttpServletRequest request, UserDto userDto) {
        Assert.notNull(userDto);
        userDto.setId(UUID.randomUUID().toString());
        getSession(request).setAttribute(CommonStatis.Login_user, userDto);
        userList.add(userDto);//但是不知道用户什么时候过期
    }

    public static List<UserDto> getUserList() {
        return userList;
    }
}
