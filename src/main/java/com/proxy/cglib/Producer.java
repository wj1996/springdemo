package com.proxy.cglib;

import com.proxy.IProducer;

public class Producer {

    public void saleProduct(float money) {
        System.out.println("begin sale " + money);
    }

    public void afterService(float money) {
        System.out.println("begin after " + money);
    }
}
