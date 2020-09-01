package IO和NIO.NIO.FileChannel;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo {

    public static void main(String[] args) {

    }

    @Test
    public void output() throws IOException {
        //1.创建输出流
        FileOutputStream fos = new FileOutputStream("NioTest.txt");
        //2.根据流创建通道
        FileChannel channel = fos.getChannel();
        //3.创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String str = "hello,nio";
        //4.将数据写入buffer中（往缓冲区中存入数据）
        buffer.put(str.getBytes());
        buffer.flip();
        //5.通过通道将数据写入缓冲区（把缓冲区写到通道中）
        channel.write(buffer);
        channel.close();
    }

    @Test
    public void input() throws IOException {
        File file = new File("NioTest.txt");
        FileInputStream fis = new FileInputStream(file);
        FileChannel channel = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate((int) file.length());
        //从通道中读取数据并存到缓冲区中
        channel.read(buffer);
        System.out.println(new String(buffer.array()));
        channel.close();
    }
}
