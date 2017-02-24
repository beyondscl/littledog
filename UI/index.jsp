<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/10
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="WEB-INF/comm/header.jsp"></jsp:include>
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
                        result1 : function(num1){
                            number1.innerHTML = num1;
                        },
                        // 对应服务端 “频道2” 的值 result2
                        result2 : function(num2){
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
<form action="user/login">
    <button type="submit" value="login">login</button>
</form>
</body>
</html>
