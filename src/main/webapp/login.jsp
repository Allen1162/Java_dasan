<%--
  Created by IntelliJ IDEA.
  User: 11626
  Date: 2019/12/11
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="/Test7/loginServlet.do" method="get">
        昵称：<input type="text" id="name" name="name">
        <input type="submit" value="登录">
        <input type="reset" value="重置">
    </form>
</body>
</html>
