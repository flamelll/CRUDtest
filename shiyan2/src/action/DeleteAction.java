package action;
import bean.Student;
import com.opensymphony.xwork2.ActionSupport;
import util.DBUtil;
public class DeleteAction  extends ActionSupport{
    private Student student;
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student=student;
    }
    public String execute() throws Exception {
        Student student1 = new Student();
        DBUtil db = new DBUtil();
        db.deleteStudent(student.getNum());
        System.out.println("学号为"+student.getNum() + "的学生信息已经被删除！");
        return SUCCESS;
    }
}
