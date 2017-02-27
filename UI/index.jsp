<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/23
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("basePath",basePath);
%>
<base href="${basePath}" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="comm/header.jsp"/>
<html>
<head>
    <title>你好，请登录</title>
    <script type="text/javascript">
        function init(){
            var number1 = document.getElementById('number1');
            var number2 = document.getElementById('number2');
            /* 建立连接，conn 即web.xml中 CometServlet的&lt;url-pattern>*/
            JS.Engine.start('conn');
            // 监听后台某个频道
            JS.Engine.on(
                    {
                        // 对应服务端 “频道1” 的值 result1
                        COMMON : function(message){
                            number1.innerHTML = "这里是公共频道"+message;
                        },
                        // 对应服务端 “频道2” 的值 result2
                        PERSON : function(num2){
                            number2.innerHTML = num2;
                        },
                    }
            );
        }
    </script>
</head>
<body onload="init()">
数字1：<span id="number1">...</span><br>
数字2：<span id="number2">...</span>
<form action="user/login" method="post">
    <input type="text"     name="login" value="">用户名<br>
    <input type="password" name="password" value="">密码<br>
    <button type="submit" value="login">login</button>
</form>
</body>
</html>
