package com.yqq;

import com.yqq.beans.MyTestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;

public class MainRun {

    public static void main(String[] args) {

        InputStream is = RunTest.class.getResourceAsStream("com/yqq/beans/factory/beanFactoryTest.xml");
        if (is == null) {
            System.out.println("文件未找到");
        }

        ApplicationContext bf = new ClassPathXmlApplicationContext("com/yqq/beans/factory/beanFactoryTest.xml");
        MyTestBean testBean = (MyTestBean) bf.getBean("myTestBean");



        testBean.test();

    }

}
