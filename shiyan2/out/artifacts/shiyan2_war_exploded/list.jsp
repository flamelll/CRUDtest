<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<body >
<center>
<h2>学生信息情况</h2>
<hr>
<a href="insert.jsp">添加学生</a>
<table border="1">
    <tr align="center">
        <td>学号</td>
        <td>姓名</td>
        <td colspan ="2">操作</td>
    </tr>
    <s:iterator value="#request.studentList" var="list">
        <tr>
            <td><s:property value="#list.num"/></td>
            <td><s:property value="#list.name"/></td>

            <td>
                <a href="deleteStudent.action?student.num=<s:property value="#list.num"/>" onClick="if(!confirm('确定删除该信息吗？'))return false;else return true;">删除</a>
            </td>
            <td>
                <a href="updateStudent.action?student.num=<s:property value="#list.num"/>">修改</a>
            </td>
        </tr>
    </s:iterator>
</table>
<p>
</center>
</body>
</html>