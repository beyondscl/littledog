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
<jsp:include page="${basePath}/comm/header.jsp"></jsp:include>
<html>
<head>
    <title>MAIN JSP</title>
    <script src="${basePath}js/interTest.js"></script>
    <script>
        var str ='2017-5-01';
        var date = new Date(str );
        document.write(date);
    </script>
</head>
<body>
this is main jsp
<h6>接口测试</h6>
</body>
</html>
