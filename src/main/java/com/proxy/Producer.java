package com.proxy;

public class Producer implements IProducer{

    public void saleProduct(float money) {
        System.out.println("begin sale " + money);
    }

    public void afterService(float money) {
        System.out.println("begin after " + money);
    }
}
