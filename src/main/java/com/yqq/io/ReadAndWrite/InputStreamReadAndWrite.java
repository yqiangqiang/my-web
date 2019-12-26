package com.yqq.io.ReadAndWrite;

import java.io.*;

/**
 * Created by yanqiangqiang on 2018/12/14.
 */
public class InputStreamReadAndWrite {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = new FileInputStream("/Users/derek/Downloads/test.txt");

        InputStream is = new ByteArrayInputStream("测试一下哈".getBytes());
        Reader reader = new InputStreamReader(is);

        int data = reader.read();
        while (data != -1) {
            System.out.println((char) data);
            data = reader.read();
        }
        inputStream.close();
        reader.close();


        OutputStream outputStream = new FileOutputStream("/Users/derek/Downloads/out.txt");

        Writer writer = new OutputStreamWriter(outputStream);
        writer.write("hello");

        writer.close();
        outputStream.close();
    }

}
