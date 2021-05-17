<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<center>
<h2>添加学生</h2>
<s:form action="save" method="post" theme="simple">
    学号：<s:textfield name="student.num"></s:textfield><br>
姓名：<s:textfield name="student.name"></s:textfield><br>
    <s:submit value="添加"></s:submit>
</s:form>
    <a href="showAllStudent.jsp">返回</a>
</center>
</body>
</html>