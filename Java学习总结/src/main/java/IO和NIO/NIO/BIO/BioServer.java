package IO和NIO.NIO.BIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {

    private ServerSocket serverSocket;

    public BioServer() throws IOException {
        this.serverSocket = new ServerSocket(8888);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client" + socket.getRemoteSocketAddress().toString() + "come in");
            //socket.getInputStream().read();
            //由于我们不知道客户端什么时候发来消息，所有输入需要开一个线程防止阻塞。
            //同样由于我们这台服务器连接这多个客户端，因此输出也放到那个多线程中。
            new Thread(new BioServerHandler(socket)).start();
        }
    }

    public static void main(String[] args) throws IOException {
        BioServer server = new BioServer();
    }
}
