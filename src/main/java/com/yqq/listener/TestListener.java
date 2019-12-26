package com.yqq.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by yanqiangqiang on 2018/12/3.
 */
public class TestListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("listener loading。。。。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
