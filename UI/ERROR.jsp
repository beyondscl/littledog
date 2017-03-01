<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/10
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("basePath",basePath);
%>
<base href="${basePath}" />
<html>
<head>
    <title>抱歉，出错了</title>
</head>
<body>
<div style="text-align: center;">
    <h3>我的天，服务器心情不好出错啦!</h3>
</div>
</body>
</html>
