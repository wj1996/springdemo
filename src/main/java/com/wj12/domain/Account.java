package com.wj12.domain;

public class Account {

    private String name;
    private Integer id;
    private Float money;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Float getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", money=" + money +
                '}';
    }
}
