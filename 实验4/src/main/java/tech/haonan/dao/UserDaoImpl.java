package tech.haonan.dao;


import tech.haonan.entity.User;

import java.sql.*;


/**
 * @Author: yhn
 * @Date: 2020/9/24 23:31
 * @Description:
 **/
public class UserDaoImpl implements UserDao {
    @Override
    public User findByUserName(String username, String password) {
        User user = new User();
        Connection con = null;
        Statement sql = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 	//com.mysql.jdbc.Driver已经弃用了，要加上cj
        }
        catch(Exception e) {
            System.out.println("forNameError:" + e);
        }
        // 访问url
        String url = "jdbc:mysql://192.168.43.50:4000/web?useSSL=false&characterEncoding=utf-8&serverTimezone=GMT";	//要加上serverTimezone=GMT，否则会报错
        // mysql数据库 用户名和密码
        String userString = "root";
        String passString = "123456";
        try{
            // 获取链接
            con = DriverManager.getConnection(url, userString, passString);}
        catch(Exception e) {
            System.out.println(e);
        }
        try {
            sql = con.createStatement();
            // sql 查询语句
            String querySentence = "SELECT * FROM userTable where username = ? and password = ?";
            PreparedStatement ps = con.prepareStatement(querySentence);
            // 顶替 sql语句的  ?
            ps.setString(1,username);
            ps.setString(2,password);
            // 执行sql语句
            rs = ps.executeQuery() ;
            while(rs.next()) {
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                System.out.printf("%d\t", user.getId());
                System.out.printf("%s\t", user.getUsername());
                System.out.printf("%s\t",user.getPassword());
            }
            // 关闭连接
            con.close();
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        if(user.getUsername().length() > 0){
           // 如果查询到了信息 那么 返回一个user对象 否则返回null
           return user;
        }else
            return null;
    }
}

