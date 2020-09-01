package IO和NIO.IO.IOstudy_02;

import java.io.*;
import java.util.Arrays;

/**
 * 依然是四个标准步骤
 * 变化的是操作部分（分段读取）
 */
public class IOTest03 {

    public static void main(String[] args) {
        File src = new File("D:\\JAVA\\Idea\\Project\\IO\\src/hahha.txt");
        try {
            src.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is = null;
        try {
            is = new FileInputStream(src);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] car = new byte[3];
        try{
            int len = -1;
            if ((len = is.read(car)) != -1){
                //字符数组->字符串（解码）
                System.out.println(Arrays.toString(car));
                String s = new String(car,0,len);
                System.out.println(s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            if(null!=is){
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
