package main.Pojo;

import java.util.Date;

public class teacherinfo {
    int TeacherNum;
    String DeptNum;
    String TeacherName;
    String TeacherSex;
    Date TeacherBirthday;
    String TeacherTitle;

    public int getTeacherNum() {
        return TeacherNum;
    }

    public void setTeacherNum(int teacherNum) {
        TeacherNum = teacherNum;
    }

    public String getDeptNum() {
        return DeptNum;
    }

    public void setDeptNum(String deptNum) {
        DeptNum = deptNum;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public String getTeacherSex() {
        return TeacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        TeacherSex = teacherSex;
    }

    public Date getTeacherBirthday() {
        return TeacherBirthday;
    }

    public void setTeacherBirthday(Date teacherBirthday) {
        TeacherBirthday = teacherBirthday;
    }

    public String getTeacherTitle() {
        return TeacherTitle;
    }

    public void setTeacherTitle(String teacherTitle) {
        TeacherTitle = teacherTitle;
    }
}
