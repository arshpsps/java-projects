package org.arshpsps.server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
    public static void Serve(int port) throws IOException {
        // read from conn , send to all other conn
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("waiting for connection...");


        ArrayList<Socket> connections = new ArrayList<>();

        // noinspection InfiniteLoopStatement
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected! " + clientSocket.getInetAddress().toString());
            connections.add(clientSocket);

            // remove later
            break;
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(connections.get(0).getInputStream()));
        PrintWriter out = new PrintWriter(connections.get(0).getOutputStream(), true);

        String message = in.readLine();
        System.out.println("Client : " + message);

        connections.get(0).close();
        serverSocket.close();
    }
}
