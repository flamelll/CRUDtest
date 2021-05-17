<%@ page import="java.sql.Connection" %>
<%@ page import="com.util.DBUtil" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新</title>
</head>
<body>

<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");

    String num = request.getParameter("num");

    Connection conn = DBUtil.getConn();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "select * from students where num = ?";
    try{
        ps = conn.prepareStatement(sql);
        ps.setString(1,num);
        rs = ps.executeQuery();
        while (rs.next()){
            String num1 = rs.getString("num");
            String name = rs.getString("name");
%>
<div style="width:100%;text-align:center">
<form action="UpdateServlet" method="post">
    学号：<input type="text" name="num" value="<%=num1 %>" readonly="true"><br>
    姓名：<input type="text" name="name" value="<%=name %>"><br>
    <input type="submit" value="修改">
</form>
    <a href="SelectServlet">返回</a>
</div>
<%
        }
    }catch (Exception e){
        e.printStackTrace();
    }finally {
        DBUtil.closeConn(conn,ps,rs);
    }
%>
</body>
</html>

