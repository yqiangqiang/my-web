package com.yqq.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueDemo {

    class Producer implements Runnable{
        BlockingQueue<Integer> queue;
        public Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(200);
                    queue.put(i);
                    System.out.println("生产了产品："+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    class Consumer implements Runnable{
        BlockingQueue<Integer> queue;
        public Consumer(BlockingQueue<Integer> queue){
            this.queue = queue;
        }
        @Override
        public void run() {
            while (true) {
                String name = Thread.currentThread().getName();
                try {
                    Integer data = queue.take();
                    System.out.println(name+"消费了"+data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();
        QueueDemo demo = new QueueDemo();

        Producer producer = demo.new Producer(queue);
        Consumer consumer = demo.new Consumer(queue);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();


    }
}
