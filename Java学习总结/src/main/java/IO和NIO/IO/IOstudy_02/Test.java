package IO和NIO.IO.IOstudy_02;

/**
 * 如果读到文件的最后一个元素，那么输出结果为-1
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class Test {
    public static void main(String[] args) {
        /**
         * 创建源
         * 选择流
         * 操作
         * 释放
         */
        File file = new File("D:\\JAVA\\Idea\\Project\\IO\\src/aaa.txt");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            int temp;
            while ((temp = inputStream.read()) != -1){
                System.out.println((char)temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
