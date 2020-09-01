package IO和NIO.IO.IOstudy_02;
/**
 * 拷贝文件实际上就是从一个文件读入然后写到另一个文件中。
 * 思考：利用递归做文件夹的拷贝
 */

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        copyFile("D:\\JAVA\\Idea\\Project\\IO\\src\\com\\sort\\IO\\IOstudy_02\\CopyFile.java","copyFile.txt");
    }

    public static void copyFile(String srcPath,String destPath){
        File src1 = new File(srcPath);
        File src2 = new File(destPath);
        InputStream is = null;
        OutputStream os = null;
        int temp = -1;
        try {
            is = new FileInputStream(src1);
            os = new FileOutputStream(src2);
            while ((temp = is.read()) != -1){
                os.write(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源，分别关闭：先打开的后关闭
            try {
                if (os!=null){
                    os.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null){
                    is.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
