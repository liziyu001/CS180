package hw11;

import javax.imageio.IIOException;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class StatisticsClient {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        JOptionPane.showMessageDialog(null, "Welcome to Statistics Client",
                "Statistics Client", JOptionPane.INFORMATION_MESSAGE);
        int port = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Enter the port number you want to connect:",
                "Statistics Client", JOptionPane.QUESTION_MESSAGE));
        String host = JOptionPane.showInputDialog(null,
                "Enter the host name you want to connect:",
                "Statistics Client", JOptionPane.QUESTION_MESSAGE);
        try {
            Scanner scan = new Scanner(System.in);
            Socket socket = new Socket("localhost", 4242);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            JOptionPane.showMessageDialog(null, "Connection Established",
                    "Statistics Client", JOptionPane.INFORMATION_MESSAGE);
            String input = JOptionPane.showInputDialog(null,
                    "Enter the String you want to send:",
                    "Statistics Client", JOptionPane.QUESTION_MESSAGE);
            writer.write(input);
            writer.println();
            writer.flush();
            String s1 = reader.readLine();
            JOptionPane.showMessageDialog(null, s1,
                    "Statistics Client", JOptionPane.INFORMATION_MESSAGE);
            writer.close();
            reader.close();
        } catch (UnknownHostException e){
            System.out.println("Host not found");
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
