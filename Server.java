/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Server class to manage server connections/sockets
 *
 * @author Dillon
 */
public class Server {

    private ServerSocket serverSocket;
    private Socket acceptSocket;
    private PrintStream out;
    private BufferedReader in;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Main method
     *
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.run();

    }

    public void run() throws IOException {
        try {
            serverSocket = new ServerSocket(4000);
            acceptSocket = serverSocket.accept();

            out = new PrintStream(acceptSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(acceptSocket.getInputStream()));

            while (acceptSocket.isConnected()) {
                String message = in.readLine();
                System.out.println("Client: " + message);

                String reply = scanner.nextLine();
                out.println(reply);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
