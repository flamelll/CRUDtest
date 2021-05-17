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
@WebServlet(name = "UpdateServlet",urlPatterns = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String num = request.getParameter("num");
        String name = request.getParameter("name");
//        System.out.println("num''''"+num);
//        System.out.println("name''''"+name);
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = null;
        String sql = "update students set name=? where num = ?";
        PrintWriter out = response.getWriter();
        int i=0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,num);
            i=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,null);
        }
        //response.sendRedirect("SelectServlet");
        if(i>=1){out.print("<script>alert('修改成功!');window.location.href='SelectServlet'</script>");}
        else{out.print("<script>alert('修改失败!');window.location.href='SelectServlet'</script>");}
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
