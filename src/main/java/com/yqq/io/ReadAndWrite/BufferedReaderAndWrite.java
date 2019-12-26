package com.yqq.io.ReadAndWrite;

import java.io.*;

/**
 * Created by yanqiangqiang on 2018/12/14.
 */
public class BufferedReaderAndWrite {

    public static void main(String[] args) throws IOException {

        Reader reader = new FileReader("/Users/derek/Downloads/test.txt");

        BufferedReader br = new BufferedReader(reader);

        String data = br.readLine();
        while (data != null) {
            System.out.println(data);
            data = br.readLine();
        }
        br.close();
        reader.close();

        FileWriter fileWriter = new FileWriter("/Users/derek/Downloads/out.txt");

        BufferedWriter bf = new BufferedWriter(fileWriter);
        bf.write("aabb ccc dd");

        bf.close();
        fileWriter.close();
    }

}
