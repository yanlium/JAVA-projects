package main.Dao;

import main.DB.MySqlDB;
import main.Pojo.courseinfo;
import main.Pojo.selectCourse;
import main.Pojo.studentinfo;
import main.Pojo.teacherinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectCourseDao {
    public List<selectCourse> getSeclectCourseList() throws SQLException {
        //可以存储实体类 集合
        List<selectCourse>getSeclectCourseList = new ArrayList<>();
        //1、获取数据库连接
        Connection connection = MySqlDB.USERDB();
        //2、输入sql语句 准备访问
        PreparedStatement pre = connection.prepareStatement("select s.* ,c.CourseName,t.TeacherName ,st.Name from selectcourseinfo s LEFT JOIN courseinfo c on s.CourseNum = c.CourseNum LEFT JOIN studentinfo st on s.StudentNum = st.Sid LEFT JOIN teacherinfo t on t.TeacherNum = s.TeacherNum");
        //3、执行查询（使用PreparedStatement对象）
        ResultSet rs = pre.executeQuery();
        //4、对结果结合ResultSet 进行输出
        while(rs.next()){
            //输出到控制台
            //将数据保存起来，创建单一个实体类
            selectCourse selectCourse =new selectCourse();
            selectCourse.setStuCourseID(rs.getString(1));
            selectCourse.setStudentNum(rs.getString(2));
            selectCourse.setCourseNum(rs.getInt(3));
            selectCourse.setTeacherNum(rs.getString(4));
            selectCourse.setGrade(rs.getString(5));
            //设置课程名称
            courseinfo courseinfo = new courseinfo();
            courseinfo.setCourseName(rs.getString(6));
            selectCourse.setCourseinfo(courseinfo);
            //设置老师名称
            teacherinfo teacherinfo = new teacherinfo();
            teacherinfo.setTeacherName(rs.getString(7));
            selectCourse.setTeacherinfo(teacherinfo);
            //设置学生名称
            studentinfo studentinfo = new studentinfo();
            studentinfo.setName(rs.getString(8));
            selectCourse.setStudentinfo(studentinfo);

            //数据对象放到列表里面
            getSeclectCourseList.add(selectCourse);
        }
        return getSeclectCourseList;
    }
}
