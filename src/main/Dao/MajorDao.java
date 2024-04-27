package main.Dao;

import main.DB.MySqlDB;
import main.Pojo.deptinfo;
import main.Pojo.major;
import main.Pojo.tuser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MajorDao {
    public static List<major> getmajorList() throws SQLException {
        //可以存储实体类 集合
        List<major>majorList = new ArrayList<>();
        //1、获取数据库连接
        Connection connection = MySqlDB.USERDB();
        //2、输入sql语句 准备访问
        PreparedStatement pre = connection.prepareStatement("SELECT m.*,d.DeptName FROM majorinfo m  LEFT JOIN deptinfo d on m.DeptNum = d.DeptNum");
        //3、执行查询（使用PreparedStatement对象）
        ResultSet rs = pre.executeQuery();
        //4、对结果结合ResultSet 进行输出
        while(rs.next()){
            //输出到控制台
            //将数据保存起来，创建单一个实体类
            major major =new major();
            major.setMajorNum(rs.getString(1));
            major.setDeptNum(rs.getInt(2));
            major.setMajorName(rs.getString(3));
            major.setMajorAssistant(rs.getString(4));
            major.setMajorTel(rs.getString(5));
            //创建对象
            deptinfo dt = new deptinfo();
            dt.setDeptName(rs.getString(6));
            //将对象放入实体类里面
            major.setDeptinfo(dt);

            //数据对象放到列表里面
            majorList.add(major);
        }
        return majorList;
    }
}
