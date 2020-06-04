package com.itheima.demo.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo {
    public static void nio(){
        RandomAccessFile aFile=null;
        try {
            aFile=new RandomAccessFile("C:\\Users\\da\\Desktop\\my.txt","rw");
            //channel获取数据
            FileChannel fileChannel = aFile.getChannel();
            //初始化buffer,如果实际数据本身小于1024,那limit就是实际数据大小
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //从channel中的数据写入buffer
            int read = fileChannel.read(buffer);
            //有几个字符
            System.out.println(read);

            while (read!=-1){
                //buffer切换为读取模式
                buffer.flip();
                //读取数据
                while (buffer.hasRemaining()){
                    System.out.println((char) buffer.get());
                }
                //清空buffer区
                buffer.compact();
                //继续将数据写入缓存区
                read=fileChannel.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(aFile!=null){
                    aFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        ChannelDemo.nio();
    }
}
