<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<center>
    <h3>该学生信息</h3>
    <hr>
    <s:set  value="#request.student1" var="onestu"></s:set>
    <form action="updateSaveStudent.action" method="post" enctype="multipart/form-data" >
        <table border="1" width="400">
            <tr>
                <td>学号：</td>
                <td>
                    <input type="text" name="student.num" value="<s:property value="#onestu.num"/>" readonly/>
                </td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td>
                    <input type="text" name="student.name" value="<s:property value="#onestu.name"/>"/>
                </td>
            </tr>
        </table>
        <p>
            <input type="submit" value="修改"/>
            <input type="button" value="返回" onclick="javascript:history.back();"/>
    </form>
</center>
</body>
</html>