package IO和NIO.IO;

import java.io.File;

/**
 *计算文件或者文件夹的大小
 */
public class DirDemo04 {
    public static void main(String[] args) {
        File src = new File("D:\\JAVA\\Idea\\Project\\IO");
        count(src);
        System.out.println(len);
    }

    private static long len = 0;
    public static void count(File src){
        if (src.isFile()){
            len+=src.length();
        }else {
            for (File s:src.listFiles()){
                count(s);
            }
        }

    }
}