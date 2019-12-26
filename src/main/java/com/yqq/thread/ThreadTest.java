package com.yqq.thread;

import com.yqq.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest extends Thread {

    public volatile Integer i = 0;

    public String str = "a";

    public AtomicInteger atomicInteger = new AtomicInteger(100);

    public volatile List list = new ArrayList();

    public void run() {

        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("i = " + i);
        atomicInteger.incrementAndGet();
        System.out.println("atomicInteger = " + atomicInteger.get());
    }

    public static void main(String[] args) throws InterruptedException {


        ThreadTest threadTest = new ThreadTest();


        /**
         new Thread(threadTest).start();
         new Thread(threadTest).start();

         Thread.sleep(1000*20);

         System.out.println("最后结果："+threadTest.str);
         **/


         ThreadTest.ThreadOne  threadOne = threadTest.new ThreadOne(threadTest.i,threadTest.atomicInteger,threadTest.list);
         ThreadTest.ThreadTwo  threadTwo = threadTest.new ThreadTwo(threadTest.i,threadTest.atomicInteger,threadTest.list);

        threadTwo.start();
        Thread.sleep(200);
        threadOne.start();

         Thread.sleep(2000);
         System.out.println("主线程获取的值    size = "+threadTest.list.size()+"   atomicinteger:"+threadTest.atomicInteger.get());


        System.out.println("主线程结束；");

    }


    public class ThreadOne extends Thread {

        public Integer integer;
        public AtomicInteger atomicInteger;
        public List list;

        public ThreadOne(Integer integer, AtomicInteger atomicInteger,List list) {
            this.integer = integer;
            this.atomicInteger = atomicInteger;
            this.list = list;
        }

        @Override
        public void run() {
            integer = 8;
            atomicInteger.incrementAndGet();
            for (int j = 0; j < 1000; j++) {
                list.add("a");
            }
            System.out.println("threadOne赋值结束!");
        }
    }

    public class ThreadTwo extends Thread {

        public Integer integer;
        public AtomicInteger atomicInteger;
        public List list;

        public ThreadTwo(Integer integer, AtomicInteger atomicInteger,List list) {
            this.integer = integer;
            this.atomicInteger = atomicInteger;
            this.list = list;
        }


        @Override
        public void run() {
            while (list.size() <= 5) {

            }
            System.out.println("threadTwo发现值变化："+list.size());

        }
    }


}
