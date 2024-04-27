package main.Page;

import main.Dao.*;
import main.Pojo.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class 面向对象 {
    //全局对象、变量,添加静态才可以使用
    static Scanner scanner = new Scanner(System.in);


    //面向对象
    public  static void main(String[] args) throws SQLException, IOException {
        //进入初始化
        init();
    }

    public static void init() throws SQLException {
        //和控制台交互 Scanner控制台输入的类
        //判断是否继续操作
        boolean bl = true;
        while(bl) {
            System.out.println("-----------欢迎进入课程设计系统-----------");
            System.out.println("1、登录");
            System.out.println("2、注册");
            System.out.println("3、退出程序");
            //和控制台交互 Scanner控制台输入的类
            System.out.print("请输入需要操作的编号：");
            //输入数据
            int 输入整型对象 = scanner.nextInt();
            switch (输入整型对象) {
                case 1:
                    login(输入整型对象);
                    break;
                case 2:
                    zc();
                    break;
                case 3:
                    bl = false;
                    break;
            }
        }
    }

    public static void zc() throws SQLException {
        System.out.println("请输入注册用户名：");
        String username = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        System.out.println("请输入电话：");
        String phone = scanner.next();
        System.out.println("请输入地址：");
        String address = scanner.next();

        //当数据保存到实体类
        tuser tuser = new tuser();
        tuser.setUsername(username);
        tuser.setPassword(password);
        tuser.setPhone(phone);
        tuser.setAddress(address);

        //将数据存储到数据库
        TuserDao tuserDao = new TuserDao();
        tuserDao.zc(tuser);

        //注册完成之后进行登录
        init();
    }
    //变成一个全局变量
    //static

    public static  void login(int 输入整型对象) throws SQLException {
            boolean 执行课程设计界面 = true;
            System.out.println("-----------欢迎进入课程设计系统登录界面-----------");

            //定义一个变量，判断
            boolean login_boolean = true;
            while (login_boolean) {

                System.out.println("请输入用户名:");
                String username = scanner.next();

                System.out.println("请输入密码:");
                String password = scanner.next();

                //数据库验证是否成功
                TuserDao tuserDao = new TuserDao();
                //判断是否登录成功
                boolean bl = tuserDao.login(username, password);
                if (bl) {
                    //定义不循环
                    login_boolean = false;
                    System.out.println("登录成功");

                    //执行循环

                    while (执行课程设计界面){
                        System.out.println("-----------欢迎进入课程设计系统界面-----------");
                        System.out.println("1、学生信息");
                        System.out.println("2、教师信息");
                        System.out.println("3、管理员（用户信息表）信息");
                        System.out.println("4、专业信息");
                        System.out.println("5、院系信息");
                        System.out.println("6、课程信息");
                        System.out.println("7、选课信息");
                       /* System.out.println("8、退出");*/
                        System.out.println("请输入查询信息编码：");
                        String 查询信息编码 = scanner.next();
                        //循环执行
                        courseSystem(查询信息编码);
                        System.out.println("是否退出？");
                        String 是否退出到登录 = scanner.next();
                        if(是否退出到登录.equals("yes")||是否退出到登录.equals("是")||是否退出到登录.equals("退出")||是否退出到登录.equals("y")){
                            执行课程设计界面 = false;
                        }
                    }

                }else {
                    System.out.println("登录失败");//登录失败设置返回重新登录页面
                    //进入原来的登录界面
                }
            }

    }



    //执行课程设计系统注册界面内容
    public static void courseSystem(String 查询信息编码) throws SQLException {
        switch (查询信息编码) {
            case "1":
                StudentInfoDao studentinfoDao = new StudentInfoDao();
                List<studentinfo> studentinfoList = studentinfoDao.getStudentInfoList();
                for (int i = 0; i < studentinfoList.size(); i++) {
                    //单一的实体类对象
                    studentinfo studentinfo = studentinfoList.get(i);
                    //读取单一的对象
                    System.out.print("学生编号：" + studentinfo.getSid() + "\t");
                    System.out.print("专业编号：" + studentinfo.getNum() + "\t");
                    System.out.print("学生姓名：" + studentinfo.getName() + "\t");
                    System.out.print("学生性别：" + studentinfo.getSex() + "\t");
                    System.out.print("学生生日：" + studentinfo.getBirthday() + "\t");
                    System.out.println("学生地址：" + studentinfo.getAddress() + "\t");

                }
                break;
            case "2":
                TeacherInfoDao teacherInfoDao = new TeacherInfoDao();
                List<teacherinfo> teacherInfoList = teacherInfoDao.getTeacherInfoList();
                for (int i = 0; i < teacherInfoList.size(); i++) {
                    //单一的实体类对象
                    teacherinfo teacherinfo = teacherInfoList.get(i);
                    //读取单一的对象
                    System.out.print("教师编号：" + teacherinfo.getTeacherNum() + "\t");
                    System.out.print("院系编号：" + teacherinfo.getDeptNum() + "\t");
                    System.out.print("教师姓名：" + teacherinfo.getTeacherName() + "\t");
                    System.out.print("性别：" + teacherinfo.getTeacherSex() + "\t");
                    System.out.print("生日：" + teacherinfo.getTeacherBirthday() + "\t");
                    System.out.println("职称：" + teacherinfo.getTeacherTitle() + "\t");

                }
                break;
            case "3":
                //进入用户信息读取页面
                //创建对象tuserdao
                TuserDao tuserDao = new TuserDao();
                //调用方法getTuserList返回集合对象list<tuser>
                List<tuser> tuserList = tuserDao.getTuserList();
                //取数据库数据
                for (int i = 0; i < tuserList.size(); i++) {
                    //单一的实体类对象
                    tuser tuser = tuserList.get(i);
                    //读取单一的对象
                    System.out.print("用户编号：" + tuser.getUid() + "\t");
                    System.out.print("用户名字：" + tuser.getUsername() + "\t");
                    System.out.print("用户密码：" + tuser.getPassword() + "\t");
                    System.out.print("用户电话：" + tuser.getPhone() + "\t");
                    System.out.println("地址：" + tuser.getAddress());
                }
                break;
            case "4":
                MajorDao MajorDao = new MajorDao();
                List<major> majors = MajorDao.getmajorList();
                //取数据库数据
                for (int i = 0; i < majors.size(); i++) {
                    //单一的实体类对象
                    major major = majors.get(i);
                    //读取单一的对象
                    System.out.print("专业编号：" + major.getMajorNum() + "\t");
                    System.out.print("院系编号：" + major.getDeptNum() + "\t");
                    System.out.print("院系名称：" + major.getDeptinfo().getDeptName() + "\t");
                    System.out.print("专业名称：" + major.getMajorName() + "\t");
                    System.out.print("专业负责人：" + major.getMajorAssistant() + "\t");
                    System.out.println("负责人电话：" + major.getMajorTel() + "\t");

                }
                break;
            case "5":
                deptDao deptDao = new deptDao();
                List<deptinfo> depts = deptDao.getdeptList();
                //取数据库数据
                for (int i = 0; i < depts.size(); i++) {
                    //单一的实体类对象
                    deptinfo deptinfo = depts.get(i);
                    //读取单一的对象
                    System.out.print("院系编号：" + deptinfo.getDeptNum() + "\t");
                    System.out.print("院系名称：" + deptinfo.getDeptName() + "\t");
                    System.out.print("院系主任：" + deptinfo.getDeptChairman() + "\t");
                    System.out.print("电话：" + deptinfo.getDeptTel() + "\t");
                    System.out.println("详情：" + deptinfo.getDeptDesc() + "\t");

                }
                break;
            case "6":
                CourseDao CourseDao = new CourseDao();
                List<courseinfo> courses = CourseDao.getcourseInfoList();
                //取数据库数据
                for (int i = 0; i < courses.size(); i++) {
                    //单一的实体类对象
                    courseinfo courseinfo = courses.get(i);
                    //读取单一的对象
                    System.out.print("课程号码：" + courseinfo.getCourseNum() + "\t");
                    System.out.print("课程名：" + courseinfo.getCourseName() + "\t");
                    System.out.print("学分：" + courseinfo.getCourseCredit() + "\t");
                    System.out.print("学时：" + courseinfo.getCourseClass() + "\t");
                    System.out.println("课程介绍：" + courseinfo.getCourseDesc() + "\t");

                }
                break;
            case "7":
                SelectCourseDao SelectCourseDao = new SelectCourseDao();
                List<selectCourse> selectCourses = SelectCourseDao.getSeclectCourseList();
                //取数据库数据
                for (int i = 0; i < selectCourses.size(); i++) {
                    //单一的实体类对象
                    selectCourse selectCourse = selectCourses.get(i);
                    //读取单一的对象
                    System.out.print("选课编号：" + selectCourse.getStuCourseID() + "\t");
                    System.out.print("学生编号：" + selectCourse.getStudentNum() + "\t");
                    System.out.print("课程编号：" + selectCourse.getCourseNum() + "\t");
                    System.out.print("教师编号：" + selectCourse.getTeacherNum() + "\t");
                    System.out.print("成绩：" + selectCourse.getGrade() + "\t");
                    System.out.print("学生名称：" + selectCourse.getStudentinfo().getName() + "\t");
                    System.out.print("课程名称：" + selectCourse.getCourseinfo().getCourseName() + "\t");
                    System.out.println("教师名称：" + selectCourse.getTeacherinfo().getTeacherName() + "\t");

                }
                break;
        }
    }

}
