package com.wj.jdbc;

import java.sql.*;

/**
 * 程序的耦合
 *      耦合：程序间的依赖关系
 *      包括：
 *          类之间的依赖
 *          方法间的依赖
 *      解耦：
 *          降低程序间的依赖关系
 *      实际开发中：
 *          编译期不依赖，运行时才依赖
 *      解耦的思路：
 *          第一步：使用反射来创建对象，而避免使用new关键字
 *          第二步：通过读取配置文件来获取要创建的对象全限定名
 *
 *          配置文件可以是xml也可以是properties
 */
public class JdbcDemo {


    public static void main(String[] args) throws ClassNotFoundException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        try {
            //2.获取连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/my?useSSL=false","root","root");
            //3.获取操作数据的预处理对象
            PreparedStatement preparedStatement = connection.prepareStatement("select * from my");
            //4.遍历处理
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + ","  + resultSet.getString(2));
            }
            //5.释放连接
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
