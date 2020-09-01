package IO和NIO.IO;

import java.io.File;

/**
 * 名称分隔符 \(windows)   /(linux)
 */
public class PathDemo01 {
    public static void main(String[] args) {
        String path = "D:\\JAVA\\Idea\\Project\\IO\\src\\com\\sort\\IO\\download.jpg";
        System.out.println(File.separatorChar);
        System.out.println(path);

        //建议
        //1.
        path = "D:/JAVA/Idea/Project/IO/src/com/sort/IO/download.jpg";
        //2.
        path = "D:"+File.separator+"JAVA"+File.separator+"Idea"+File.separator+"Project"+File.separator+"IO"+File.separator+"src"+File.separator+"com"+File.separator+"sort"+File.separator+"IO"+File.separator+"download.jpg";
        System.out.println(path);
    }
}
