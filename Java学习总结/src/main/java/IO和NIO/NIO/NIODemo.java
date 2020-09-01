package IO和NIO.NIO;

import org.junit.Test;

import java.nio.ByteBuffer;


/**
 * 缓冲区中的四个核心属性：
 * mark < position < limit < capacity
 *
 */
public class NIODemo {

    @Test
    public void test2() {
//        mark();
//        reset();
    }

    @Test
    public void test() {
        String str = "abcde";

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        System.out.println("-----------------------");

        buffer.put(str.getBytes());
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        System.out.println("-----------------------");

        buffer.flip();
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        System.out.println("-----------------------");

        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println((char)buffer.get(4));
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());


        buffer.rewind();  //重复读数据
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        buffer.clear();
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
    }
}
