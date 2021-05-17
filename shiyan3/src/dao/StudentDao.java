package dao;

import bean.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.unitl;

import java.util.List;

public class StudentDao {
    //调用工具包
    static util.unitl unitl=new unitl();
    static Session session=unitl.lj();
    int a=0;

    /***********添加学生****************************************************/
    public int addstudent(String num,String name){
        int a=0;
        //3、开启事务
        Transaction ts=session.beginTransaction();
        //执行数据库操作
        //添加操作
        Student student=new Student();
        student.setNum(num);
        student.setName(name);
        session.save(student);
        //提交
        ts.commit();
        //关闭session
        //session.close();
        a=1;
        return a;
    }

    /***********查看所有学生****************************************************/
    @SuppressWarnings("unchecked")
    public List<Student> selectall(){
        //执行数据库操作
        //编写hql
        String hql="from Student ";
        List<Student> list=session.createQuery(hql).list();
        return list;
    }
    /***********根据学号删除学生****************************************************/
    public int delete(String  num){
        int a=0;
        //3、开启事务
        Transaction ts=session.beginTransaction();
        //执行数据库操作
        //删除操作
        session.createQuery("delete from Student where num = ?0")
                .setString(0, num).executeUpdate() ;
        //提交
        ts.commit();
        //关闭session
        //session.close();
        a=1;
        return a;
    }
    /***********根据ID查询一个部门****************************************************/
    public List<Student>  selectone(String num){
        //执行数据库操作
        //编写hql
        String hql="select new Student (num,name) from Student where num=?0";
        List<Student> list=session.createQuery(hql)
                .setString(0, num)
                .list();
        return list;
    }
    /***********修改部门****************************************************/
    public void update(String num, String name){
        //执行数据库操作
        //编写hql
        Transaction ts=session.beginTransaction();
        session.createQuery("update Student s set s.name = ?1 where num =?0")
                .setString(0, num).setString(1,name).executeUpdate() ;
        //提交
        ts.commit();
    }

}
