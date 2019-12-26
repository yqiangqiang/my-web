package com.yqq.io.InAndOutputStrean;

import java.io.*;
import java.util.Arrays;

/**
 * Created by yanqiangqiang on 2018/12/14.
 */
public class FileStream {

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/derek/Downloads/test.txt");

        if (!file.exists()) {
            file.createNewFile();
        }else {
            file.deleteOnExit();
            file.createNewFile();
        }


        byte[] buf = "需要任意组合、加载我们需要的流，用通俗的话来说，把它们层层包裹在一起".getBytes();

        //向文件中写内容
        FileOutputStream out = new FileOutputStream(file);
        out.write(buf);
        out.close();

        FileInputStream inputStream = new FileInputStream(file);

        // UTF-8编码长度:3 GBK编码长度:2  GB2312编码长度:2
        byte[] bytes = new byte[3];

        int i;
        while ((i=inputStream.read(bytes))!=-1){
            System.out.println(Arrays.toString(bytes));
            System.out.println(new String(bytes));
        }
//        int i = inputStream.read(bytes);


    }

}
