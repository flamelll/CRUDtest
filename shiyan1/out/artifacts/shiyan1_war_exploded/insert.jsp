<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<div style="width:100%;text-align:center">
<form action="InsertServlet" method="post">
    学号：<input type="text" name="num"><br>
    姓名：<input type="text" name="name"><br>
    <input type="submit" value="添加">
</form>
    <a href="SelectServlet">返回</a>
</div>
</body>
</html>