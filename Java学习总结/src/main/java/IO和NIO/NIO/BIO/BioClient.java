package IO和NIO.NIO.BIO;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class BioClient {

    static Socket socket = null;

    public static void main(String[] args) throws IOException {
        socket = new Socket("127.0.0.1", 9090);
        OutputStream out = null;
        //因为我们并不知道服务端什么时候给我们发来消息，所以输入需要新开一个线程，防止阻塞
        //输出的话由我们自己控制，没有必要，
        new Thread(new BioClientHandler(socket)).start();
        try {
            out = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String line = scanner.nextLine();
                if (line.trim().equalsIgnoreCase("exit")) {
                    break;
                }
                out.write(line.getBytes());
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
