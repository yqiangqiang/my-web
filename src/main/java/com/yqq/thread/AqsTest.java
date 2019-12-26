package com.yqq.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AqsTest {

    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        AqsTest aqsTest = new AqsTest();
        Thread t1 = aqsTest.new T1();
        Thread t2 = aqsTest.new T2();
        Thread t3 = aqsTest.new T3();

        t1.start();
        Thread.sleep(100);
        t3.start();
        t2.start();


        Thread.sleep(5*1000);

    }

    class T1 extends Thread{
        public void run() {
            lock.lock();

            System.out.println("T1 ----start");

            try {
                System.out.println("T1 阻塞");
                c1.await();
                System.out.println("T1 被唤醒");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("T1-------end");
            }


        }
    }

    class T2 extends Thread{
        public void run() {
            lock.lock();
            System.out.println("T2 ----start");
            c1.signal();
            try {
                System.out.println("T2 --- 唤醒了T1");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("T2-------end");
            }

        }
    }

    class T3 extends Thread{
        public void run() {
            lock.lock();
            System.out.println("T3 ----start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("T3-------end");
            }

        }
    }

}
