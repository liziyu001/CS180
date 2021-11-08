package hw11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class StatisticsServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4242);


        System.out.println("Waiting for the client to connect...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());

        String message = reader.readLine();
        System.out.printf("Received from client:\n%s\n", message);

        int l = message.length();
        int w = message.split(" ").length;
        int p = 0;
        for (int i = 0; i < message.length(); i++) {
            if (!(Character.isLetter(message.charAt(i)))) {
                p ++;
            }
        }

        int c = message.length();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' '){
                c --;
            }
        }


        String response = "Length: " + l + "\n" + "Number of words: " + w + "\n" + "Number of punctuations: " + p
                + "\n" + "Character count without spaces: " + c + "\n";


        writer.write(response);
        writer.flush(); // Ensure data is sent to the client.
        writer.close();
        reader.close();
    }
}
