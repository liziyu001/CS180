package hw11;

import java.io.*;
import java.net.*;

public class SimpleServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4242);


        System.out.println("Waiting for the client to connect...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());

        String message = reader.readLine();
        System.out.printf("Received from client:\n%s\n", message);




        String response = message.replaceAll(" ",",");


        writer.write(response);
        writer.println();
        writer.flush(); // Ensure data is sent to the client.
        System.out.printf("Sent to client:\n%s\n", response);

        writer.close();
        reader.close();
    }
}