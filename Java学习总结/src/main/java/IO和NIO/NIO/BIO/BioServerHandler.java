package IO和NIO.NIO.BIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BioServerHandler implements Runnable{

    private Socket socket;

    public BioServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            byte[] bytes = new byte[1024];
            while (in.read(bytes) != -1) {
                String str = new String(bytes);
                System.out.println("Client send the message: " + str);
                String string = str.trim().equalsIgnoreCase("SJ") ? new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) : "what do you give me?";
                out.write(string.getBytes());
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try{
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
