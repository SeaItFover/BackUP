package IO和NIO.NIO.Reactor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("xxx come!");

            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes);
            System.out.println("receive client info : " + new String(bytes));
        }
    }
}
