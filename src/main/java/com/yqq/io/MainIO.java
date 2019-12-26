package com.yqq.io;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.*;

/**
 * Created by yanqiangqiang on 2018/12/10.
 */
public class MainIO {

    volatile int count = 0;
    Hashtable<String, String> h = new Hashtable<String, String>();

    public static void main(String[] args) throws IOException, InterruptedException {

        MainIO m = new MainIO();

        CountDownLatch cdl = new CountDownLatch(5);

        ExecutorService executorService = Executors.newFixedThreadPool(1);


        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("a");
                m.addContent(Thread.currentThread().getName(),"a");
                cdl.countDown();
            }
        });

        cdl.await(2000, TimeUnit.MICROSECONDS);
//
        executorService.shutdown();
        System.out.println(JSONObject.toJSONString(m.h));

    }

    public void addContent(String key, String value) {
        if(count < 100) {
            h.put(key, value);
            count ++;
        }
    }

}
