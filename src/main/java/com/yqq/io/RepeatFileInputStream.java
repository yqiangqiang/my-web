package com.yqq.io;



import java.io.ByteArrayOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanqiangqiang on 2018/12/14.
 */
public class RepeatFileInputStream {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInput = new FileInputStream("/Users/derek/Downloads/test2.txt");

        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();


        int t;
        while ((t = fileInput.read()) != -1) {
            byteOutputStream.write(t);
        }


        InputStream inputStream = new ByteArrayInputStream(byteOutputStream.toByteArray());
        System.out.println();
        System.out.println("第二次读取：********************************************************************************");
        Reader reader = new InputStreamReader(inputStream);
        int temp ;
        while ((temp = reader.read()) != -1) {
            System.out.print((char)temp);
        }
        System.out.println();
        System.out.println("第三次次读取：********************************************************************************");

        InputStream inputStream1 = new ByteArrayInputStream(byteOutputStream.toByteArray());
        Reader reader1 = new InputStreamReader(inputStream1);
        int tt ;
        while ((tt = reader1.read()) != -1) {
            System.out.print((char) tt);
        }
        System.out.println();



    }


    public static void printStr(List<Byte> dataList) {

        if (dataList == null || dataList.size() == 0) {
            System.out.println("dataList is null or size is 0");
            return;
        }
        byte[] bytes = new byte[dataList.size()];

        for (int i = 0; i < dataList.size(); i++) {
            bytes[i] = dataList.get(i);
        }
        System.out.print(new String(bytes));

    }


}
