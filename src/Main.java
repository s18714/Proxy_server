import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main  extends Thread{
    private int port;

    private Main(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        new Main(7777).start();
        System.out.println("Server started");
    }

    public void run() {
        Socket clientSocket;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while ((clientSocket = serverSocket.accept()) != null) {
                System.out.println("Client accepted " + clientSocket.getLocalPort());
                (new RequestHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}