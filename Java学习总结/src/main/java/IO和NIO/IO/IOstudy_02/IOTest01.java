package IO和NIO.IO.IOstudy_02;

import java.io.*;

/**
 * 第一个程序：理解操作步骤
 * 1.创建源
 * 2.选择流
 * 3.操作（读取）
 * 4.释放资源
 */
public class IOTest01 {

    public static void main(String[] args) {
        //1.创建源
        File src = new File("abc.txt");
        //2.选择流
        try {
            InputStream is = new FileInputStream(src);
            //3.操作（读取）
            int data1 = is.read();
            int data2 = is.read();
            int data3 = is.read();
            int dara4 = is.read();
            System.out.println((char)data1);
            System.out.println((char)data2);
            System.out.println((char)data3);
            System.out.println((char)dara4);
            //4.释放资源
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
