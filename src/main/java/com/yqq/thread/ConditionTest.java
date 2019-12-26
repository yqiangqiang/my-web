package com.yqq.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    List list = new ArrayList<>();
    int size = 10;

    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    class Producter implements Runnable {
        volatile boolean flag = true;

        @Override
        public void run() {
            while (flag) {
                lock.lock();
                try {
                    while (list.size() == size) {
                        try {
                            System.out.println("队列已满，等待有空余空间");
                            notFull.await();
                        } catch (InterruptedException e) {
                            flag = false;
                            e.printStackTrace();
                        }
                    }
                    list.add(1);
                    notEmpty.signal();
                    System.out.println("向队列中插入一个元素，剩余空间:"+(size -list.size()));
                } catch (Exception e) {
                    flag = false;
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable{
        volatile boolean flag = true;
        @Override
        public void run() {
            while (flag) {
                lock.lock();

                try {
                    while (list.size() == 0) {
                        try {
                            System.out.println("队列空，等待数据");
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            flag = false;
                            e.printStackTrace();
                        }
                    }
                    list.remove(0);
                    notFull.signal();
                    System.out.println("从队列中取走一个元素，队列中剩余,"+list.size());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();
        Producter producter = conditionTest.new Producter();
        Consumer consumer = conditionTest.new Consumer();
        new Thread(producter).start();
        new Thread(consumer).start();
    }

}
