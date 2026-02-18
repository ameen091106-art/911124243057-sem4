
import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket("localhost", 4000);
            System.out.println("Connected to Server");

            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            System.out.print("Enter message: ");
            String message = userInput.readLine();

            out.println(message);

            String response = in.readLine();
            System.out.println("Server Response: " + response);

            userInput.close();
            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
