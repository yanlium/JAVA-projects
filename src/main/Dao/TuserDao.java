package main.Dao;

import main.DB.MySqlDB;
import main.Pojo.tuser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TuserDao {

    public void zc(tuser tuser) throws SQLException {
        //1、获取数据库连接
        Connection connection = MySqlDB.USERDB();
        //2、输入sql语句 准备访问
        PreparedStatement pre = connection.prepareStatement("insert into tuser (username,password,phone,address)value(?,?,?,?)");
        //给占位符添加值
        pre.setString(1,tuser.getUsername());
        pre.setString(2,tuser.getPassword());
        pre.setString(3,tuser.getPhone());
        pre.setString(4,tuser.getAddress());

        //3、执行更新（使用PreparedStatement对象）
        int num = pre.executeUpdate();
        if(num>0){
            System.out.println("注册成功!");
        }else{
            System.out.println("注册失败!");
        }
    }
    //获取数据库内容
    public static  List<tuser> getTuserList() throws SQLException {
        //可以存储字符串 集合
        //List<String>tuserList = new ArrayList<>();
        //可以存储实体类 集合
        List<tuser>tuserList = new ArrayList<>();
        //1、获取数据库连接
        Connection connection = MySqlDB.USERDB();
        //2、输入sql语句 准备访问
        PreparedStatement pre = connection.prepareStatement("select * from tuser");
        //3、执行查询（使用PreparedStatement对象）
        ResultSet rs = pre.executeQuery();
        //4、对结果结合ResultSet 进行输出
        while(rs.next()){
            //输出到控制台
           /* System.out.println(""+rs.getInt(1));
            System.out.println(""+rs.getString(2));
            System.out.println(""+rs.getString(3));
            System.out.println(""+rs.getString(4));
            System.out.println(""+rs.getString(5));*/

            //将数据保存起来，创建单一个实体类
            tuser tuser =new tuser();
            tuser.setUid(+rs.getInt(1));
            tuser.setUsername(rs.getString(2));
            tuser.setPassword(rs.getString(3));
            tuser.setPhone(rs.getString(4));
            tuser.setAddress(rs.getString(5));
            tuserList.add(tuser);
        }

        return tuserList;
    }

    //登录的写法完成
    public  boolean login(String username,String password) throws SQLException {

        //1、获取数据库连接
        Connection connection = MySqlDB.USERDB();
        //2、输入sql语句 准备访问
        PreparedStatement pre = connection.prepareStatement("select * from tuser where username=? and password=?");
        //给占位符添加数据
        pre.setString(1,username);
        pre.setString(2,password);
        //3、执行查询（使用PreparedStatement对象）
        ResultSet rs = pre.executeQuery();
        //4、对结果结合ResultSet 进行输出
        while(rs.next()){
            //如果有数据则登陆成功
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws SQLException {
        //创建对象tuserdao
        TuserDao tuserDao = new TuserDao();
        //调用方法getTuserList返回 集合对象list<tuser>
        List<tuser>tuserList = tuserDao.getTuserList();
        //取数据库数据
        for(int i=0;i<tuserList.size();i++){
            //单一的实体类对象
            tuser tuser = tuserList.get(i);
            //读取单一的对象
            System.out.print("用户编号"+tuser.getUid()+"\t");
            System.out.print("用户名字"+tuser.getUsername()+"\t");
            System.out.print("用户密码"+tuser.getPassword()+"\t");
            System.out.print("用户电话"+tuser.getPhone()+"\t");
            System.out.println("地址"+tuser.getAddress());
        }
        //tuserDao.getTuserList();
    }
}
