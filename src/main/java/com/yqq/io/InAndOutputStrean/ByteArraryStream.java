package com.yqq.io.InAndOutputStrean;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yanqiangqiang on 2018/12/14.
 */
public class ByteArraryStream {


    public static void main(String[] args) throws IOException {

        int d = 0;
        String a = "a";
        String b = "需要任意组合、加载我们需要的流，用通俗的话来说，把它们层层包裹在一起";


        //创建一个新的字节输入流
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        //向输出流中写入数据
//        bout.write(d);
//        bout.write(a.getBytes());
        bout.write(b.getBytes());

        //返回内部保存的byte数据
        byte[] data = bout.toByteArray();

        for (int i = 0; i < data.length; i++) {
            System.out.println(new String());
        }
        System.out.println("***************************************************");

        //读取字节
        String ss = "中华人民共和国";
        ByteArrayInputStream bInput = new ByteArrayInputStream(ss.getBytes());

        int next;

        List<Byte> l = new ArrayList();

        while ((next = bInput.read()) != -1) {
            Integer n = next;

            if (l.size() % 3 == 0 && l.size() != 0) {

                byte[] bbb = new byte[3];
                for (int i = 0; i < l.size(); i++) {
                    bbb[i] = l.get(i);
                }
                System.out.println(Arrays.toString(bbb));
                System.out.println(new String(bbb));

                l = new ArrayList();

            }
            l.add(n.byteValue());


        }


    }

}
