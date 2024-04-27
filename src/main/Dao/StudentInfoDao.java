package main.Dao;

import main.DB.MySqlDB;
import main.Pojo.studentinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentInfoDao {
    //获取数据库内容
    public static  List<studentinfo> getStudentInfoList() throws SQLException {

        //可以存储实体类 集合
        List<studentinfo> studentInfoList = new ArrayList<>();
        //1、获取数据库连接
        Connection connection = MySqlDB.USERDB();
        //2、输入sql语句 准备访问
        PreparedStatement pre = connection.prepareStatement("select * from studentInfo");
        //3、执行查询（使用PreparedStatement对象）
        ResultSet rs = pre.executeQuery();
        //4、对结果结合ResultSet 进行输出
        while(rs.next()){
            studentinfo studentinfo = new studentinfo();
            studentinfo.setSid(rs.getString(1));
            studentinfo.setNum(rs.getString(2));
            studentinfo.setName(rs.getString(3));
            studentinfo.setSex(rs.getString(4));
            studentinfo.setBirthday(rs.getString(5));
            studentinfo.setAddress(rs.getString(6));
            studentInfoList.add(studentinfo);
        }
        return studentInfoList;
    }


}
