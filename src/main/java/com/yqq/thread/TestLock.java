package com.yqq.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yanqiangqiang on 2018/12/13.
 */
public class TestLock {

    List l = new ArrayList();
    Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        TestLock testLock = new TestLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                testLock.insert(Thread.currentThread());
            }
        }).start();

        Thread.sleep(1000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                testLock.insert(Thread.currentThread());
            }
        }).start();

        System.out.println("主线程运行结束。。。。。");
    }

    public  void  insert(Thread thread) {


        lock.lock();

        try {
//            Thread.sleep(new Random().nextInt(10)*100);
            Thread.sleep(1000*10);
            System.out.println(thread.getName()+":得到了锁");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(thread.getName()+":释放了锁");
        }

    }

}
