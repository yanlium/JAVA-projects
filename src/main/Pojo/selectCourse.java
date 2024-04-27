package main.Pojo;

public class selectCourse {
    String StuCourseID;
    String StudentNum;
    int CourseNum;
    String TeacherNum;
    String Grade;
    //教师名称
    teacherinfo teacherinfo;
    //学生
    studentinfo studentinfo;
    //课程
    courseinfo courseinfo;

    public main.Pojo.teacherinfo getTeacherinfo() {
        return teacherinfo;
    }

    public void setTeacherinfo(main.Pojo.teacherinfo teacherinfo) {
        this.teacherinfo = teacherinfo;
    }

    public main.Pojo.studentinfo getStudentinfo() {
        return studentinfo;
    }

    public void setStudentinfo(main.Pojo.studentinfo studentinfo) {
        this.studentinfo = studentinfo;
    }

    public main.Pojo.courseinfo getCourseinfo() {
        return courseinfo;
    }

    public void setCourseinfo(main.Pojo.courseinfo courseinfo) {
        this.courseinfo = courseinfo;
    }

    public String getStuCourseID() {
        return StuCourseID;
    }

    public void setStuCourseID(String stuCourseID) {
        StuCourseID = stuCourseID;
    }

    public String getStudentNum() {
        return StudentNum;
    }

    public void setStudentNum(String studentNum) {
        StudentNum = studentNum;
    }

    public int getCourseNum() {
        return CourseNum;
    }

    public void setCourseNum(int courseNum) {
        CourseNum = courseNum;
    }

    public String getTeacherNum() {
        return TeacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        TeacherNum = teacherNum;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }
}
