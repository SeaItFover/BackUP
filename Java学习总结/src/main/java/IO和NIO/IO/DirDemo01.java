package IO和NIO.IO;

import java.io.File;

/**
 * 创建目录
 * 1、mkdir()：确保上级目录存在，不存在创建失败
 * 2、mkdirs()：上级目录可以不存在，不存在一同来创建
 */
public class DirDemo01 {
    public static void main(String[] args) {
        File dir = new File("D:/IDEA/Project/IO/src/com/sort/IO/dir");
        //创建目录
        boolean flag = dir.mkdir();
        System.out.println(flag);

        //所以推荐使用mkdirs，因为他可以一起创建上下级目录
        boolean flag1 = dir.mkdirs();
        System.out.println(flag1);

    }
}
