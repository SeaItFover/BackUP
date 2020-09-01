package IO和NIO.NIO.Reactor;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class BIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9090);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        socket.getOutputStream().write(s.getBytes());
        socket.close();
    }
}
