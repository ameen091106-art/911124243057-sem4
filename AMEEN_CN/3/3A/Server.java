
import java.io.*;
import java.net.*;

public class Server {

    public static final int PORT = 4000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server Started on Port: " + PORT);

            socket = serverSocket.accept();
            System.out.println("Client Connected: " + socket.getInetAddress());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage = in.readLine();
            System.out.println("Received from Client: " + clientMessage);

            out.println("Echo: " + clientMessage);

            in.close();
            out.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
