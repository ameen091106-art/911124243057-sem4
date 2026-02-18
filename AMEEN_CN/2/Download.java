
import java.io.*;
import java.net.*;

public class Download {

    public static void main(String[] args) {
        String fileName = "digital_image_processing.jpg";
        String website = "http://tutorialspoint.com/java_dip/images/" + fileName;

        System.out.println("Downloading File From: " + website);

        try {
            URL url = new URL(website);
            InputStream inputStream = url.openStream();
            FileOutputStream outputStream = new FileOutputStream(fileName);

            byte[] buffer = new byte[2048];
            int length;

            while ((length = inputStream.read(buffer)) != -1) {
                System.out.println("Buffer Read of length: " + length);
                outputStream.write(buffer, 0, length);
            }

            inputStream.close();
            outputStream.close();

            System.out.println("Download Completed Successfully.");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
