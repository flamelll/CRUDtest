<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生</title>
</head>
<body>
<center>
<h1>修改学生</h1>
<form action="StudentServlet" method="post">
    <input type="hidden" value="4" name="type">
    学号:<input type="text" value="${list.name }" name="num" readonly><br/>
    姓名:<input type="text" name="name" value="${list.num}"><br/>
    <input type="submit" value="修改">
</form>
    <a href="StudentServlet">返回</a>
</center>
</body>
</html>
