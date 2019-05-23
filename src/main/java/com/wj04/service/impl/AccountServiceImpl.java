package com.wj04.service.impl;

import com.wj04.service.interfaces.IAccountService;

import java.util.*;

/**
 * 依赖注入（DI）
 */
public class AccountServiceImpl implements IAccountService {

    //如果是经常变化的数据，并不适合注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    /**
     * 复杂类型注入
     */
    private String[] myStr;
    private Set<String> mySet;
    private List<String> myList;
    private Map<String,String> myMap;
    private Properties myProps;

    public void setMyStr(String[] myStr) {
        this.myStr = myStr;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("saveAccount");
    }

    public void init() {
        System.out.println("init");
    }

    public void destroy() {
        System.out.println("destroy");
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
}
