package IO和NIO.NIO.BIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class BioClientHandler implements Runnable{

    Socket socket;

    public BioClientHandler(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        InputStream in = null;
        try {
            in = socket.getInputStream();
            byte[] bytes = new byte[1024];
            while (in.read(bytes) != -1) {
                String str = new String (bytes);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
