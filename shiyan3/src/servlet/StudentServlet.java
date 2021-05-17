package servlet;

import bean.Student;
import dao.StudentDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet",urlPatterns = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    StudentDao sd=new StudentDao();
    public StudentServlet(){
        super();
    }
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //用type接受页面的值
        String type ="";
        type = request.getParameter("type");
        if ("1".equals(type)) {        //添加学生的方法
            addStudent(request, response);
        }else if ("".equals(type)||null==type) {    //查询所有部门的方法
            selectall(request, response);
        }else if ("3".equals(type)) {    //根据ID删除部门
            deletestudent(request, response);
        }else if ("4".equals(type)) {    //根据修改部门
            update(request, response);
        }else if ("5".equals(type)) {    //根据ID查询一个部门
            selectone(request, response);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        this.doPost(request, response);
        out.flush();
        out.close();
    }
    /***********************添加学生*********************************************************/
    public void addStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String num=request.getParameter("num");
        String name=request.getParameter("name");
        int a=sd.addstudent(num,name);
        if (a>0) {
            selectall(request, response);
            System.out.println("添加部门成功");
        }else {
            System.out.println("添加部门失败");
            response.sendRedirect("insert.jsp");
        }
    }
    /***********************查询所有学生*********************************************************/
    public void selectall(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> list=new ArrayList<Student>();
        list=sd.selectall();
        request.setAttribute("list", list);
        RequestDispatcher rd=request.getRequestDispatcher("showall.jsp");
        rd.forward(request, response);
    }
    /***********************根据ID删除部门*********************************************************/
    public void deletestudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String num=request.getParameter("num");
        sd.delete(num);
        selectall(request, response);
    }
    /***********************根据学号查找学生*********************************************************/
    public void selectone(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String num=request.getParameter("num");
        List<Student> list=sd.selectone(num);
        for(Student stu:list){
            //System.out.println(bb.getBmname()+bb.getId());
            request.setAttribute("list", stu);
        }
        //System.out.println("aa");
        RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
        rd.forward(request, response);
    }
    /***********************修改学生*********************************************************/
    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String num=request.getParameter("num");
        String name=request.getParameter("name");
        sd.update(num, name);
        selectall(request, response);
    }
    public void init() throws ServletException {
        // Put your code here
    }


}
