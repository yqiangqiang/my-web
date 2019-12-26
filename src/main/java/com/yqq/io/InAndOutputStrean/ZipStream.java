package com.yqq.io.InAndOutputStrean;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by yanqiangqiang on 2018/12/14.
 */
public class ZipStream {

    public static void main(String[] args) throws IOException {

        //需要压缩的文件
        File file = new File("/Users/derek/Downloads/test.txt");
        File file2 = new File("/Users/derek/Downloads/test2.txt");

        //压缩后的文件
        File zipFile = new File("/Users/derek/Downloads/test2.zip");
        if (zipFile.exists()) {
            zipFile.delete();
        }

        //输入流
        InputStream inputStream = new FileInputStream(file);
        InputStream inputStream2 = new FileInputStream(file2);

        //压缩流
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));

        //开始编写新的ZIP文件条目，并将流定位到条目数据的开头
        zipOutputStream.putNextEntry(new ZipEntry(file.getName()));


        //写入文件到zip流
        int temp ;
        while ((temp = inputStream.read()) != -1) {
            zipOutputStream.write(temp);
        }

        zipOutputStream.putNextEntry(new ZipEntry(file2.getName()));

        while ((temp = inputStream2.read()) != -1) {
            zipOutputStream.write(temp);
        }

        inputStream.close();
        zipOutputStream.close();




    }

}
