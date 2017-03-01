<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/27
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/JavaScript" src="${pageContext.request.contextPath}/js/comet4j.js"></script>

<script type="text/javascript">
    var count = 0;
    function test() {
        // 建立连接，conn 即web.xml中 CometServlet的<url-pattern>
        JS.Engine.start('/conn');
        <%
             //保存用户id到session中
             session.setAttribute("currentUserId","abc");
        %>
        // 监听后台某个频道
        JS.Engine.on(
                {
                    // 对应服务端 “频道1” 的值 msgCount
                    msgCount: function (msgCount) {
                        document.getElementById("msgCount").innerHTML = msgCount;
                    },
                    // 对应服务端 “频道2” 的值 msgData
                    msgData: function (msgData) {
                        document.getElementById("msgCount").innerHTML = msgData;
                    },
                }
        );
    }
</script>

<body onload="test();">
消息数量：<span id="msgCount"></span>
消息数据：<span id="msgData"></span>
</body>