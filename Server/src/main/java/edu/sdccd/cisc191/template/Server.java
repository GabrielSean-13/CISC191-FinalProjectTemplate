package edu.sdccd.cisc191.template;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
 //import java.net.ServerSocket;
 //import java.net.Socket;


/**
 * This program is a server that takes connection requests on
 * the port specified by the constant LISTENING_PORT.  When a
 * connection is opened, the program sends the current time to
 * the connected socket.  The program will continue to receive
 * and process connections until it is killed (by a CONTROL-C,
 * for example).  Note that this server processes each connection
 * as it is received, rather than creating a separate thread
 * to process the connection.
 */

// Course Objectives: Module 4-10, 13&15

// creates class that extends "Application" to access Javafx imports
public class Server {

    public static void main(String[] args) throws IOException {
        // Makes a connection to client and accepts it
        ServerSocket serverSocket = null;

       boolean  listeningSocket = true;
        try {
            serverSocket = new ServerSocket(8080);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 2343");
        }

        while(listeningSocket){
            Socket clientSocket = serverSocket.accept();
            MiniServer mini = new MiniServer(clientSocket);
            mini.start();
        }
        serverSocket.close();
    }
    }












   // public static void main(String[] args) {
        //launch(args);
   // }

//    private ServerSocket serverSocket;
//    private Socket clientSocket;
//    private PrintWriter out;
//    private BufferedReader in;
//
//    public void start(int port) throws Exception {
//        serverSocket = new ServerSocket(port);
//        clientSocket = serverSocket.accept();
//        out = new PrintWriter(clientSocket.getOutputStream(), true);
//        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//
//        String inputLine;
//        while ((inputLine = in.readLine()) != null) {
//            CustomerRequest request = CustomerRequest.fromJSON(inputLine);
//            CustomerResponse response = new CustomerResponse(request.getId(), "Jane", "Doe");
//            out.println(CustomerResponse.toJSON(response));
//        }
//    }
//
//    public void stop() throws IOException {
//        in.close();
//        out.close();
//        clientSocket.close();
//        serverSocket.close();
//    }
//
//    public static void main(String[] args) {
//        Server server = new Server();
//        try {
//            server.start(4444);
//            server.stop();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//} //end class Server
