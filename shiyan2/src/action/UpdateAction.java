package action;
import bean.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import util.DBUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class UpdateAction   extends ActionSupport {
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student=student;
    }
    public String execute() throws Exception {
        DBUtil db = new DBUtil();
        student.setNum(student.getNum());
        student.setName(student.getName());
        db.updateSaveStudent(student);
        return SUCCESS;
    }
}
