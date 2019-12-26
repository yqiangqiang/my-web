package com.yqq.dubbo.spi.impl;

import com.yqq.dubbo.spi.Robot;

public class Bumblebee implements Robot {
    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}
