package util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
public class DBUtil {
    Connection conn;
    PreparedStatement pstmt;
    String url = "jdbc:mysql://localhost:3306/javaeeshiyan?useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true";
    String user = "root";
    String pwd = "123456";
    public DBUtil(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url,user,pwd);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public boolean save(Student student){
        try{
            pstmt=conn.prepareStatement("insert into students values(?,?)");
            pstmt.setString(1, student.getNum());
            pstmt.setString(2, student.getName());
            pstmt.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public List<Student> showStudent() throws SQLException, ClassNotFoundException{
        ResultSet rs = null;
        List<Student> list = new ArrayList<Student>();
        String sql = "select * from students";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Student student = new Student();
                student.setNum(rs.getString("num"));
                student.setName(rs.getString("name"));
                list.add(student);
            }
            conn.close();
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public Student showOneStudent(String num) {
        ResultSet rs = null;
        String sql = "select * from students where num=" + num;
        Student student = new Student();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                student.setNum(rs.getString("num"));
                student.setName(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    /*
     * 删除一个学生
     */
    public void deleteStudent(String num) {
        String sql = "delete from students where num=" + num;
        System.out.println(num + "::::num");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /*
     * 更新一个学生的信息
     */
    public Student updateSaveStudent(Student student) {
        String sql = "update students set name=? where num=" + student.getNum();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getName());
            pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }
}
