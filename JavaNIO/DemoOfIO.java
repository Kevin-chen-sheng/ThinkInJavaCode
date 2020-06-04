package com.itheima.demo.putongio;

import java.io.*;

public class DemoOfIO {
    public static void main(String[] args) {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            long begin = System.currentTimeMillis();
            FileInputStream fis = new FileInputStream("C:\\Users\\da\\Desktop\\my.txt");
            bis = new BufferedInputStream(fis);
            FileOutputStream fos = new FileOutputStream("C:\\Users\\da\\Desktop\\my1.txt");
            bos = new BufferedOutputStream(fos);

            int size = 0;
            //这个缓存数组,估计就是InputStream,OutputStream没有用到缓冲区的例子,估计
            byte[] bytes = new byte[1024];
            while ((size = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, size);
            }
            //刷新输出流,保证全部写出
            bos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
