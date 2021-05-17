package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.util.DBUtil;

@WebServlet(name = "InsertServlet",urlPatterns = "/InsertServlet")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String num = request.getParameter("num");
        String name = request.getParameter("name");

        Connection conn = DBUtil.getConn();
        PreparedStatement ps = null;
        String sql = "insert into students(num,name) values(?,?)";
        PrintWriter out = response.getWriter();
        int i=0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,num);
            ps.setString(2,name);
            i=ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,null);
        }
        if(i>=1){out.print("<script>alert('添加成功!');window.location.href='SelectServlet'</script>");}
        else{out.print("<script>alert('添加失败!');window.location.href='SelectServlet'</script>");}
        //response.sendRedirect("select");//重定向网页，转到指定的页面。

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
