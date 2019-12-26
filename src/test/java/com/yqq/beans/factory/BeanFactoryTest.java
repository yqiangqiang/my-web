package com.yqq.beans.factory;

import com.yqq.beans.MyTestBean;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class BeanFactoryTest {

    @Test
    public void testSimpleLoad() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        InputStream inputStream = this.getClass().getResourceAsStream("beanFactoryTest.xml");

        if (inputStream == null) {
            System.out.println("未加载到文件：");
        }

        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml",this.getClass()));
        MyTestBean testBean = bf.getBean("myTestBean",MyTestBean.class);
        Assert.assertEquals(testBean.getStr(),"testStr");



    }

}
