package com.yqq.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * Created by yanqiangqiang on 2018/12/18.
 */
public class TestNio {

    public static void main(String[] args) throws IOException {

        //第一步是获取通道。我们从 FileInputStream 获取通道
        FileInputStream fileInputStream = new FileInputStream("/Users/derek/Downloads/test2.txt");
        FileChannel channel = fileInputStream.getChannel();

        //下一步是创建缓冲区：
        ByteBuffer byteBuffer = ByteBuffer.allocate(2048);

        //最后，需要将数据从通道读到缓冲区中，如下所示：
        channel.read(byteBuffer);

        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            System.out.println((char) byteBuffer.get());
        }

    }

}
