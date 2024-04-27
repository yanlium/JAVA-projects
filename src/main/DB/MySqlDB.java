package main.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDB {
    static String URL = "jdbc:mysql://localhost:3306/day1211";
    static String username = "root";
    static String password = "123456";

    //静态块 作用：提前加载到内存
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    //数据库连接方法 代码优化
    public  static Connection USERDB() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, username, password);
        return connection;
    }
    public static void main(String[] args) throws SQLException{
        Connection connection = MySqlDB.USERDB();
        //得到数据库连接
        if(connection!=null){
            System.out.println("数据库连接成功");
        }else{
            System.out.println("数据库连接失败");
        }

    }
}
