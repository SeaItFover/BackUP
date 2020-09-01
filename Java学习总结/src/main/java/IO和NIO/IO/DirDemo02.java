package IO和NIO.IO;

import java.io.File;

/**
 * 列出下一级
 * 1、list()：列出下级名称
 * 2、listFiles()：列出下级File对象
 * list()返回的是字符串数组，而listFile()返回的是File数组
 *
 * 列出所有的盘符：listRoots
 */
public class DirDemo02 {
    public static void main(String[] args) {
        File dir = new File("D:/JAVA/Idea/Project/IO/src/com/sort/IO");

        //列出下级名称（list只返回一层）
        String[] subNames = dir.list();
        for (String s:subNames){
            System.out.println(s);
        }

        //列出下级对象
        File[] subFiles = dir.listFiles();
        for (File f:subFiles){
            System.out.println(f.getAbsolutePath());
        }

        //所有盘符
        File[] roots= dir.listRoots();
        for (File r:roots){
            System.out.println(r.getAbsolutePath());
        }
    }
}
