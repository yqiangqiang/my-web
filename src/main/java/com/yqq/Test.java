package com.yqq;

import com.yqq.entity.User;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Test {

    public static String str = "abc";
    public static String str2 = "ab#cd";
    public static String PREFIX = "&";

    public String string ;

    public static List l = new ArrayList();
    public static void main(String[] args) throws Exception {

        IntStream in = str2.chars();
        int[] ints = in.toArray();
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

        if ("abc".equalsIgnoreCase(str)) {
            System.out.println("aaa");
            return;
        }

//        for (; ; ) {
//            User u = new User();
////            l.add(u);
//        }


//       Thread t1 = new Thread(() -> {
//            for (; ; ) {
//                User u = new User();
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            for (; ; ) {
//                String s = new String();
//            }
//        });
//
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
        /**
        User user = new User();
        WeakReference<User> userWeakReference = new WeakReference<>(user);


        System.out.println("weakUser:" + userWeakReference.get());
        System.gc();
        Thread.sleep(5000);
        System.out.println("GC后："+userWeakReference.get());
         **/


    }

    public Object testFinally() {
        String s = "a";

        User u = new User();
        u.setUserName("a");

        String s2 = new String("s2");
        StringBuilder sb = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();

        sb.append("aaa");
        try {

            return sb;
        }finally {
            u.setUserName("b");

            sb.append("cc");
        }
    }


}
