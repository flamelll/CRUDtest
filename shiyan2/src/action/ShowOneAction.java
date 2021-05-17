package action;
import bean.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import util.DBUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class ShowOneAction  extends ActionSupport {
    private Student student;
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student=student;
    }
    /*
     * 查询一个学生信息
     */
    public String execute() throws Exception{
        Student student1=new Student();
        DBUtil db=new DBUtil();
        student1=db.showOneStudent(student.getNum());//查询一个学生信息
        Map request=(Map) ActionContext.getContext().get("request");
        request.put("student1", student1);//将查询的学生信息放到Map容器中
        return SUCCESS;
    }
}
