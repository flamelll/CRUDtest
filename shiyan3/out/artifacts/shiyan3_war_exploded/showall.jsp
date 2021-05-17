<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>学生信息</title>
</head>
<body>
<center>
<h1>学生信息</h1>
<a href="insert.jsp">添加</a>
<table border="1">
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="stu">
        <tr>
            <td>${stu.num}</td><td>${stu.name}</td>
            <td><a href="StudentServlet?type=5&&num=${stu.num}">修改</a><!-- 修改前先查一个 -->
                  
                <a href="StudentServlet?type=3&&num=${stu.num}">删除</a></td>

        </tr>
    </c:forEach>
</table>
</center>
</body>
</html>
