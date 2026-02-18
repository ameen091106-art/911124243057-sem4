
import java.io.*;
import java.net.*;

public class tcpchatserver {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;

        try {
            server = new ServerSocket(4000);
            System.out.println("Server started on port 4000...");

            client = server.accept();
            System.out.println("Client connected.");

            BufferedReader fromClient = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            PrintWriter toClient = new PrintWriter(
                    new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
            BufferedReader fromUser = new BufferedReader(
                    new InputStreamReader(System.in));

            String clientMsg, serverMsg;

            while (true) {
                clientMsg = fromClient.readLine();

                if (clientMsg == null || clientMsg.equalsIgnoreCase("end")) {
                    break;
                }

                System.out.println("Client: " + clientMsg);

                System.out.print("Message to Client: ");
                serverMsg = fromUser.readLine();
                toClient.println(serverMsg);
            }

            System.out.println("Client Disconnected.");

            fromClient.close();
            toClient.close();
            fromUser.close();
            client.close();
            server.close();

        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
