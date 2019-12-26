package com.yqq.thread;

public class SyncTest {

    public static void main(String[] args) throws InterruptedException {

        SyncTest syncTest = new SyncTest();
        Thread t1 = new Thread(() -> {
            syncTest.new Sync().test1();
        });
        Thread t2 = new Thread(() -> {
            syncTest.new Sync().test2();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
//        Thread.sleep(10000);
        System.out.println("主线程结束");

    }

    class Sync{

        public void test1() {
            synchronized (Sync.class) {
                try {
                    System.out.println("锁到class对象开始执行。。。。start");
                    Thread.sleep(3000);
                    System.out.println("锁到class对象开始执行。。。。end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void test2() {
//            synchronized (Sync.class) {
                System.out.println("同步方法------开始执行");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("同步方法------执行结束");
//            }

        }


    }


}
