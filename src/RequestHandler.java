import java.io.*;
import java.net.Socket;

public class RequestHandler extends Thread {
    private Socket clientSocket;
    private BufferedReader clientReader;
    private OutputStreamWriter clientWriter;

    RequestHandler(Socket socket) throws IOException {
        this.clientSocket = socket;
        clientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        clientWriter = new OutputStreamWriter(clientSocket.getOutputStream());
    }

    public void run() {
        try {
            StringBuilder request = new StringBuilder();
            StringBuilder tmpRequest = new StringBuilder();
            Socket outputSocket;
            OutputStreamWriter outputWriter;
            boolean isHttps = false;
            String address = "";
            int port = -1;

            String[] tmp;

            while (!(tmpRequest.append(clientReader.readLine())).toString().isEmpty()) {
                if (!tmpRequest.toString().startsWith("CONNECT")) {
                    if (tmpRequest.toString().startsWith("Host:")) {
                        tmp = tmpRequest.toString().split(":");
                        address = tmp[1].trim();
                        port = tmp.length == 3 ? Integer.parseInt(tmp[2].trim()) : 80;
                    }
                } else
                    isHttps = true;
                request.append(tmpRequest.toString()).append("\n");
                tmpRequest.setLength(0);
            }
            request.append("\n");

            outputSocket = new Socket(address, port);
            outputWriter = new OutputStreamWriter(outputSocket.getOutputStream());
            if (isHttps) {
                clientWriter.write("HTTP/1.0 200 Connection established\r\n Proxy-Agent: ProxyServer/1.0\r\n\r\n");
                clientWriter.flush();
                outputSocket.setSoTimeout(10_000);
                Thread toClient = new Thread(() -> {
                    try {
                        sendPackets(clientSocket, outputSocket);
                    } catch (Exception ignored) {
                    }
                });
                toClient.start();
                sendPackets(outputSocket, clientSocket);
            } else {
                outputWriter.write(request.toString());
                outputWriter.flush();
                try {
                    sendPackets(outputSocket, clientSocket);
                } catch (Exception ignored) {
                }
            }
        } catch (IOException ignored) {
        }
    }

    private void sendPackets(Socket from, Socket to) throws IOException {
        byte[] buffer = new byte[2048];
        int packets;
        do {
            packets = from.getInputStream().read(buffer);
            if (packets > 0) {
                to.getOutputStream().write(buffer, 0, packets);
                if (from.getInputStream().available() == 0)
                    to.getOutputStream().flush();
            }
        } while (packets >= 0);
    }
}