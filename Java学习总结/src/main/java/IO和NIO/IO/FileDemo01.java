package IO和NIO.IO;

import java.io.File;

public class FileDemo01 {
    public static void main(String[] args) {
        String path = "D:/JAVA/Idea/Project/IO/src/com/sort/IO/download.jpg";

        //构建File对象的三种方式
        //1.
        File file = new File(path);
        System.out.println(file.length());

        //2.
        file = new File("D:/JAVA/Idea/Project/IO/src/com/sort/IO","download.jpg");
        System.out.println(file.length());
        file = new File("D:/JAVA/Idea/Project/IO/src/com","sort/IO/download.jpg");
        System.out.println(file.length());

        //3.
        file = new File(new File("D:/JAVA/Idea/Project/IO/src/com/sort/IO"),"download.jpg");
        System.out.println(file.length());
    }
}
