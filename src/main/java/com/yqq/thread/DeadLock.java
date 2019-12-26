package com.yqq.thread;

public class DeadLock implements Runnable{

    public static int flag;
    static Object o1 = new Object();
    static Object o2 = new Object();

    @Override
    public void run() {

        if (flag == 1) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName()+"获取了o1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName()+"获取了o2");
                }
            }

        }else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName()+"获取了o2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName()+"获取了o1");
                }
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {

        flag = 1;
        Thread t1 = new Thread(new DeadLock());
        Thread t2 = new Thread(new DeadLock());
        t1.start();
        Thread.sleep(1000);
        flag = 2;
        t2.start();
    }

}
