package IO和NIO.IO;

import java.io.File;

/**
 * 构建File对象
 * 绝对路径和相对路径
 * 1).存在盘符：绝对路径
 * 2).不存在盘符：相对路径 当前目录user.dir
 */

public class FileDemo02 {
    public static void main(String[] args) {
        String path = "D:/JAVA/Idea/Project/IO/src/com/sort/IO/download.jpg";

        //绝对路径
        File file = new File(path);
        System.out.println(file.getAbsolutePath());

        //相对路径
        file = new File("IO.jpg");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(file.getAbsolutePath());
    }
}
