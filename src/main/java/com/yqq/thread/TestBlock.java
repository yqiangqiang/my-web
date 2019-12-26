package com.yqq.thread;

import com.yqq.entity.User;

import java.util.Date;
import java.util.concurrent.locks.LockSupport;

public class TestBlock {


    public static void main(String[] args) throws InterruptedException {

        TestBlock testBlock = new TestBlock();
        User user = new User();

        T1 t1 = testBlock.new T1(user);
//        T2 t2 = testBlock.new T2(user);
//        T3 t3 = testBlock.new T3(user);

        t1.start();


        Thread.sleep(2*1000);

        System.out.println("主线程睡眠结束");
//        LockSupport.unpark(t1);
        t1.interrupt();
        System.out.println(t1.isInterrupted());
        System.out.println("主线程结束");
    }

    class T1 extends Thread {
        private User user;

        public T1 (User user) {
            this.user = user;
        }
        public void run() {

            System.out.println("t1--start");

            LockSupport.park();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1--end");

//            Thread.currentThread().interrupt();

        }

    }

    class T2 extends Thread {

        public User user;

        public T2(User user) {
            this.user = user;
        }

        public void run() {
            System.out.println("T2 ------ start");

            System.out.println("T2 ------ end");
        }

    }

    class T3 extends Thread {

        public User user;

        public T3(User user) {
            this.user = user;
        }
        public void run() {

        }

    }




}
