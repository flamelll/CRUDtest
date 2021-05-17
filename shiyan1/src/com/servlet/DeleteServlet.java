package com.servlet;

import com.util.DBUtil;

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

@WebServlet(name = "DeleteServlet",urlPatterns = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String num = request.getParameter("num");
         System.out.println("num:::"+num);
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = null;
        String sql = "delete from students where num = ?";
        PrintWriter out = response.getWriter();
        int i=0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,num);
            i= ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,null);
        }
        //response.sendRedirect("SelectServlet");
        if(i>=1){out.print("<script>alert('删除成功!');window.location.href='SelectServlet'</script>");}
        else{out.print("<script>alert('删除失败!');window.location.href='SelectServlet'</script>");}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
