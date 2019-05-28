package com.wj12.jdbctemplate;

import com.wj12.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate的用法
 */
public class JdbcTemplate01 {

    public static void main(String[] args) {

        //spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3307/my");
        ds.setUsername("root");
        ds.setPassword("root");

        //1.创建JdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(ds );
        jt.execute("insert into my values(5,'dd',123.0)");
    }

    /**
     * JdbcTemplate集成IOC
     */
    @Test
    public void test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
//        jdbcTemplate.execute("insert into my values(6,'ee',100)");


        //保存
//        jdbcTemplate.update("insert into my values(?,?,?)",7,"ff",100f);
        //修改
//        jdbcTemplate.update("update my set name = ? where id = ?","fff",7);
        //删除
//        jdbcTemplate.update("delete from  my where id = ?",7);

        //查询
//        List<Account> query = jdbcTemplate.query("select * from my where money > ?", new AccountRowMapper(),100f);
//        for (Account account : query) System.out.println(account);
//        List<Account> query = jdbcTemplate.query("select * from my where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 7);
//        System.out.println(query.isEmpty() ? "没有内容" : query.get(0));

        /*查询返回一行一列*/
        Integer integer = jdbcTemplate.queryForObject("select count(1) from my", Integer.class);
        System.out.println(integer);
    }
}

class AccountRowMapper implements RowMapper<Account> {

    /**
     * 把结果集中的数据封装到Account中，然后由spring把每个Account加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
