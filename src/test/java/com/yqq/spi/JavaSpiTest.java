package com.yqq.spi;

import com.yqq.dubbo.spi.Robot;
import com.yqq.entity.User;
import com.yqq.jdkVersion.TestInterface;
import org.junit.Test;

import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.ServiceLoader;

public class JavaSpiTest {

    @Test
    public void sayHello() throws IOException {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("java spi");
        serviceLoader.forEach(Robot::sayHello);



    }

}
