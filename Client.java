/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Client class to manage client side connections/ports
 *
 * @author Dillon
 */
public class Client {

    private Socket clientSocket;
    private PrintStream out;
    private BufferedReader in;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Main method
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.run();

        System.exit(0);
    }

    public void run() {
        try {
            Socket clientSocket = new Socket("localhost", 4000);
            out = new PrintStream(
                    clientSocket.getOutputStream(), true);;
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println("Hello Server");

            while (clientSocket.isConnected()) {
                String message = in.readLine();
                System.out.println("Server: " + message);

                String reply = scanner.nextLine();
                out.println(reply);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
