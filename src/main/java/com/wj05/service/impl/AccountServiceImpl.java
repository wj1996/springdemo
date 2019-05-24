package com.wj05.service.impl;

import com.wj05.dao.interfaces.IAccountDao;
import com.wj05.service.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.*;

/**
 * 依赖注入（DI）(基于注解的方式)
 * 用于创建对象的注解
 *      @Component 把当前类存入spring容器
 *          属性：
 *              value：用于指定bean的id，当不写此属性时，默认为当前类名并且首字母改为小写
 *      Component衍生的注解：
 *      Controller 一般表现层
 *      Service     一般业务层
 *      Repository  一般持久层
 *      以上三个注解的作用和属性与Component是一模一样，是spring框架提供的明确的三层使用的注解，使三层对象更加清晰
 * 用于注入数据的
 *      Autowired:
 *          自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功。
 *          如果IOC容器中没有类型匹配，报错
 *          如果有多个类型匹配时，会根据变量名称去匹配
 *          出现位置：
 *              可以是变量，也可以是方法上
 *              在使用注解注入时，set方法不是必须的
 *      Qualifier:
 *          安装类中注入的基础上再安装名称注入，它在给类成员注入时不能单独使用（需要配合Autowired使用），但是给方法参数注入时可以
 *          属性：
 *              value：用于指定注入bean的id
 *      Resource
 *          如果不想使用上面的，使用Resource注解 实现@Autowired+Qualifier的功能。按照bean的id进行注入
 *          属性：
 *              name：指定bean的id
 *      以上三个注解注入都只能注入其它bean类型的数据，而基本类型和String类型注入无法使用上述注解实现
 *      另外：集合类型的注入只能通过xml的方式实现
 *      Value：
 *          作用：用于注入基本类型和String类型的数据
 *          属性：
 *              value：用于指定数据的值，可以使用spring中的SpEL（也就是spring的el表达式）
 *                  spEL的写法：${表达式}
 *
 * 用于改变作用范围的
 *      Scope
 *          作用：用于指定bean的作用方位
 *          属性：
 *              value：常用取值：singleton（默认），prototype
 * 用于生命周期
 *      PreDestroy
 *          作用：用于指定销毁方法
 *      PostConstruct
 *          作用：用于指定初始方法
 */
@Component
public class AccountServiceImpl implements IAccountService {

    //如果是经常变化的数据，并不适合注入的方式
    private String name;
    private Integer age;
    private Date birthday;


   /* @Autowired
    @Qualifier("accountDao5-2")*/
    @Resource(name = "accountDao5-2")
    private IAccountDao accountDao05;

    /**
     * 复杂类型注入
     */
    private String[] myStr;
    private Set<String> mySet;
    private List<String> myList;
    private Map<String,String> myMap;
    private Properties myProps;
    /**
     * 复杂类型注入
     */
    public AccountServiceImpl() {
    }

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }


    public void saveAccount() {
        accountDao05.saveAccount();
    }


    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", myStr=" + Arrays.toString(myStr) +
                ", mySet=" + mySet +
                ", myList=" + myList +
                ", myMap=" + myMap +
                ", myProps=" + myProps +
                '}';
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct 初始化");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PreDestroy destroy");
    }
}
