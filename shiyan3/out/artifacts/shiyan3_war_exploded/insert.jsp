<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/4/28
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<center>
<h1>添加学生</h1>
<form action="StudentServlet" method="post">
    <input type="hidden" value="1" name="type">
    学号：<input type="text" name="num"/><br/>
    姓名：<input type="text" name="name"/><br/>
    <input type="submit" value="提交">
</form>
<a href="StudentServlet">返回</a>
</center>
</body>

</html>
