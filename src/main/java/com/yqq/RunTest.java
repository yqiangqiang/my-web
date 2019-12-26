package com.yqq;

import com.sun.xml.internal.bind.v2.util.XmlFactory;
import com.yqq.entity.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by yanqiangqiang on 2018/12/17.
 */
public class RunTest {

    public static final User u = new User();

    public static final String s = "a";

    public static void main(String[] args) throws InterruptedException {


        System.out.println(Integer.numberOfLeadingZeros(3));
        System.out.println(10<<3);
        System.out.println(15 >>> 3);
        System.out.println("(系统线程数：)availableProcess:"+Runtime.getRuntime().availableProcessors());


        RunTest mainRun = new RunTest();

        ApplicationContext bf = new ClassPathXmlApplicationContext("beanTest.xml");
        User user = (User) bf.getBean("testBean");

        System.out.println("userName"+user.getUserName());



    }






}
