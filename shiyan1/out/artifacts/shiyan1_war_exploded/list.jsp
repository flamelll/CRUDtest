<%@ page import="java.util.List" %>
<%@ page import="com.bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息</title>
</head>
<body>
<table border="1" align="center">
    <thead>
    <tr>
        <td>
            学号
        </td>
        <td>
            姓名
        </td>
        <td colspan="2">
            操作
        </td>
        <td>

        </td>
        <td>
            <a href="insert.jsp">添加</a>
        </td>
    </tr>
    </thead>
    <tbody>
    <%
        List<Student> students = (ArrayList)session.getAttribute("stu");
        for (Student student : students){
    %>
    <tr>
        <td>
            <%=student.getNum() %>
        </td>
        <td>
            <%=student.getName() %>
        </td>
        <td>
            <a href="DeleteServlet?num=<%=student.getNum() %>">删除</a>
        </td>
        <td>
            <a href="update.jsp?num=<%=student.getNum() %>">更新</a>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>