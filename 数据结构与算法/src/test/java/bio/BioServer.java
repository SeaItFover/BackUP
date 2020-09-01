package bio;

import java.io.IOException;
import java.net.ServerSocket;

public class BioServer {

    private ServerSocket serverSocket;

    public BioServer() {
        try {
            this.serverSocket = new ServerSocket(9090);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BioServer bioServer = new BioServer();
        while (true) {
            try {
                System.out.println("first come");
                bioServer.serverSocket.accept();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
