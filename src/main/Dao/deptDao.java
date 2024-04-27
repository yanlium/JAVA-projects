package main.Dao;

import main.DB.MySqlDB;
import main.Pojo.deptinfo;
import main.Pojo.major;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class deptDao {
    public  List<deptinfo> getdeptList() throws SQLException {
        //可以存储实体类 集合
        List<deptinfo>deptinfoList = new ArrayList<>();
        //1、获取数据库连接
        Connection connection = MySqlDB.USERDB();
        //2、输入sql语句 准备访问
        PreparedStatement pre = connection.prepareStatement("SELECT * FROM deptinfo");
        //3、执行查询（使用PreparedStatement对象）
        ResultSet rs = pre.executeQuery();
        //4、对结果结合ResultSet 进行输出
        while(rs.next()){
            //输出到控制台
            //将数据保存起来，创建单一个实体类
            deptinfo deptinfo =new deptinfo();
            deptinfo.setDeptNum(rs.getInt(1));
            deptinfo.setDeptName(rs.getString(2));
            deptinfo.setDeptChairman(rs.getString(3));
            deptinfo.setDeptTel(rs.getString(4));
            deptinfo.setDeptDesc(rs.getString(5));
            //数据对象放到列表里面
            deptinfoList.add(deptinfo);
        }
        return deptinfoList;
    }

}
