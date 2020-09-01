package IO和NIO.IO.IOstudy_02;

import java.io.*;

/**
 * 测试关于Read方法的一些东西
 * read(byte[] b)返回的是存到缓冲数组b中的字节个数。ps：不一定是b.length，如果数据没那么大，就只是实际数据量
 * read(byte[] b,int off,int len)返回的也是存到b中的实际有效字节数，off和len指定的是将数据存到b中什么位置。
 *
 * read()方法返回的是本次读取到的字节，这一点和另外两个方法不太一样。
 *
 */
public class TestRead {

    public static void main(String[] args) {
        File src = new File("spy.txt");
        InputStream is = null;
        try {
            is = new FileInputStream(src);
//            byte[] flush = new byte[100];
////            int temp = -1;
////            while ((temp = is.read(flush,0,3)) != -1){
////                System.out.println(temp);
////                System.out.println(ArraysClass.toString(flush));
////            }
            System.out.println(is.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
