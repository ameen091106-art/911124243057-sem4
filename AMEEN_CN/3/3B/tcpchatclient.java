
import java.io.*;
import java.net.*;

public class tcpchatclient {

    public static void main(String[] args) {
        Socket client = null;

        try {
            client = new Socket("localhost", 4000);
            System.out.println("Connected to Server.");
            System.out.println("Type 'end' to quit.");

            PrintWriter toServer = new PrintWriter(
                    new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            BufferedReader fromUser = new BufferedReader(
                    new InputStreamReader(System.in));

            String clientMsg, serverMsg;

            while (true) {
                System.out.print("Message to Server: ");
                clientMsg = fromUser.readLine();

                toServer.println(clientMsg);

                if (clientMsg.equalsIgnoreCase("end")) {
                    break;
                }

                serverMsg = fromServer.readLine();
                System.out.println("Server: " + serverMsg);
            }

            fromUser.close();
            fromServer.close();
            toServer.close();
            client.close();

        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
