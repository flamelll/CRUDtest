package action;
import bean.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import util.DBUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class ShowAction  extends ActionSupport {
    private Student student;
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student=student;
    }
    public String execute() throws Exception{
        DBUtil db=new DBUtil();
        List<Student> studentList = new ArrayList<Student>();
        try {
            studentList = db.showStudent();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("studentList", studentList);
        return SUCCESS;

    }
}
