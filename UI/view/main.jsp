<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/23
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.dog.dto.user.UserDto" %>
<%@ page import="com.dog.util.CommonStatis" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    request.setAttribute("basePath", basePath);
    UserDto userDto = (UserDto) request.getSession().getAttribute(CommonStatis.Login_user);
%>
<base href="${basePath}"/>
<jsp:include page="/comm/header.jsp"></jsp:include>
<html>
<head>
    <title>MAIN JSP</title>
    <script src="${pageContext.request.contextPath}/js/interTest.js"></script>
    <script>
        function rsetTest() {
            var con = document.getElementById("COMMON");
            var per = document.getElementById("PERSON");
            /* 建立连接，conn 即web.xml中 CometServlet的&lt;url-pattern>*/
            JS.Engine.start('conn');
            // 监听后台某个频道
            JS.Engine.on(
                    {
                        // 对应服务端 公共频道
                        COMMON: function (message) {
                            con.innerHTML = "这里是公共频道" + message;
                        },
                        // 对应服务端 公共频道
                        PERSONAL: function (message) {
                            per.innerHTML = "这里是私人频道" + message;
                        },
                    }
            )
        }
    </script>
</head>
<body onload="rsetTest();">
this is main jsp
<h6>rest接口测试</h6>
<h6>聊天测试</h6>
<ul>
    <li>当前用户<%=userDto.getLogin()%>
    </li>
</ul>
<form action="${pageContext.request.contextPath}/comet/chart" method="post">
    <label>
        <input type="text" name="uid" value="">
        用户名
    </label><br>
    <label>
        <input type="text" name="message" value="">
        消息
    </label><br>
    <button type="submit" value="chart">chart</button>
</form>
公共：<span id="COMMON">...</span><br>
私人：<span id="PERSON">...</span><br>

</body>
</html>
