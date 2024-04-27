package main.Dao;

import main.DB.MySqlDB;
import main.Pojo.studentinfo;
import main.Pojo.teacherinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherInfoDao {
    public static List<teacherinfo> getTeacherInfoList() throws SQLException {

        //可以存储实体类 集合
        List<teacherinfo> teacherinfoList = new ArrayList<>();
        //1、获取数据库连接
        Connection connection = MySqlDB.USERDB();
        //2、输入sql语句 准备访问
        PreparedStatement pre = connection.prepareStatement("select * from teacherInfo");
        //3、执行查询（使用PreparedStatement对象）
        ResultSet rs = pre.executeQuery();
        //4、对结果结合ResultSet 进行输出
        while(rs.next()){
            teacherinfo teacherinfo = new teacherinfo();
            teacherinfo.setTeacherNum(rs.getInt(1));
            teacherinfo.setDeptNum(rs.getString(2));
            teacherinfo.setTeacherName(rs.getString(3));
            teacherinfo.setTeacherSex(rs.getString(4));
            teacherinfo.setTeacherBirthday(rs.getDate(5));
            teacherinfo.setTeacherTitle(rs.getString(6));
            teacherinfoList.add(teacherinfo);
        }
        return teacherinfoList;
    }
}
