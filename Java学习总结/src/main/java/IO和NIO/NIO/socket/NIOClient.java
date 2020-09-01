package IO和NIO.NIO.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

//网络客户端程序
public class NIOClient {
    public static void main(String[] args) throws IOException {

        //1. 得到一个网络通道
        SocketChannel channel = SocketChannel.open();

        //2. 设置非阻塞方式
        channel.configureBlocking(false);

        //3.提供服务器端的IP地址和端口号
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8080);

        //4.连接服务器端
        if (!channel.connect(address)) {
            while (!channel.finishConnect()) {
                System.out.println("coding, connecting");
            }
        }

        //5. 得到一个缓冲区并存入数据
        String msg = "hello,Server";
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());

        System.in.read();

    }

}
