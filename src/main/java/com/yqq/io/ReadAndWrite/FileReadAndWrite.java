package com.yqq.io.ReadAndWrite;

import java.io.*;

/**
 * Created by yanqiangqiang on 2018/12/14.
 */
public class FileReadAndWrite {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("/Users/derek/Downloads/test.txt");

        int temp;
        while ((temp = fileReader.read()) !=-1){
            System.out.println((char) temp);
        }
        fileReader.close();


        Writer writer = new FileWriter("/Users/derek/Downloads/out.txt");
        writer.write("word");
        writer.close();

    }

}
