package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBUtil;
import com.bean.Student;
@WebServlet(name = "SelectServlet",urlPatterns = "/SelectServlet")
public class SelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        Connection conn = DBUtil.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from students";
        List<Student> students = new ArrayList<Student>();

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Student student = new Student(rs.getString(2),rs.getString(1));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        HttpSession session = request.getSession();
        session.setAttribute("stu",students);
        response.sendRedirect("list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
