package IO和NIO.IO;

import java.io.File;

/**
 * 使用面向对象的方式统计文件夹的大小
 *
 * 一定要区分路径path和源文件File类的区别
 */
public class DirCount {
    //文件大小
    private long len;

    //文件路径
    private String path;

    //源文件
    private File src;

    //统计文件数
    private int fileSize;

    //统计文件夹数
    private int dirSize;

    public long getLen(){
        return len;
    }

    public int getFileSize(){
        return fileSize;
    }

    public int getDirSize(){
        return dirSize;
    }

    public DirCount(String path){
        this.path = path;
        this.src = new File(path);
        count(this.src);
    }

    private void count(File src){
        if (src != null && src.exists()){
            if (src.isFile()){
                len+=src.length();
                fileSize++;
            }else{
                dirSize++;
                for (File s:src.listFiles()){
                    count(s);
                }
            }
        }
    }
    public static void main(String[] args) {
        DirCount dirCount = new DirCount("D:\\JAVA\\Idea\\Project\\IO/src");
        System.out.println(dirCount.getLen());
        System.out.println(dirCount.getFileSize());
        System.out.println(dirCount.getDirSize());
    }
}
