package main.Pojo;

public class major {
    String MajorNum;
    int DeptNum;
    String MajorName;
    String MajorAssistant;
    String MajorTel;
    //这个实体类，引用了外部主键
    deptinfo deptinfo;

    public main.Pojo.deptinfo getDeptinfo() {
        return deptinfo;
    }

    public void setDeptinfo(main.Pojo.deptinfo deptinfo) {
        this.deptinfo = deptinfo;
    }

    public String getMajorNum() {
        return MajorNum;
    }

    public void setMajorNum(String majorNum) {
        MajorNum = majorNum;
    }

    public int getDeptNum() {
        return DeptNum;
    }

    public void setDeptNum(int deptNum) {
        DeptNum = deptNum;
    }

    public String getMajorName() {
        return MajorName;
    }

    public void setMajorName(String majorName) {
        MajorName = majorName;
    }

    public String getMajorAssistant() {
        return MajorAssistant;
    }

    public void setMajorAssistant(String majorAssistant) {
        MajorAssistant = majorAssistant;
    }

    public String getMajorTel() {
        return MajorTel;
    }

    public void setMajorTel(String majorTel) {
        MajorTel = majorTel;
    }
}
