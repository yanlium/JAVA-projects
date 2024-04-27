package main.Dao;

import main.DB.MySqlDB;
import main.Pojo.courseinfo;
import main.Pojo.deptinfo;
import main.Pojo.major;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    public static List<courseinfo> getcourseInfoList() throws SQLException {
        //可以存储实体类 集合
        List<courseinfo>courseinfoList = new ArrayList<>();
        //1、获取数据库连接
        Connection connection = MySqlDB.USERDB();
        //2、输入sql语句 准备访问
        PreparedStatement pre = connection.prepareStatement("SELECT * FROM courseinfo");
        //3、执行查询（使用PreparedStatement对象）
        ResultSet rs = pre.executeQuery();
        //4、对结果结合ResultSet 进行输出
        while(rs.next()){
            //输出到控制台
            //将数据保存起来，创建单一个实体类
            courseinfo courseinfo =new courseinfo();
            courseinfo.setCourseNum(rs.getInt(1));
            courseinfo.setCourseName(rs.getString(2));
            courseinfo.setCourseCredit(rs.getString(3));
            courseinfo.setCourseClass(rs.getString(4));
            courseinfo.setCourseDesc(rs.getString(5));

            //数据对象放到列表里面
            courseinfoList.add(courseinfo);
        }
        return courseinfoList;
    }
}
