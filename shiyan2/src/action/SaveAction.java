package action;
import bean.Student;
import util.DBUtil;
import com.opensymphony.xwork2.ActionSupport;
public class SaveAction  extends ActionSupport {
    private Student student;
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student=student;
    }
    public String execute() throws Exception{
        DBUtil db=new DBUtil();
        Student stu=new Student();
        stu.setNum(student.getNum());
        stu.setName(student.getName());
        if(db.save(stu)){
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

}
