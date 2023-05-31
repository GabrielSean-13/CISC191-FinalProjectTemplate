package edu.sdccd.cisc191.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

// Helper class that makes the server listen to multiple clients using threads
public class MiniServer extends Thread {

    private Socket socket = null;

    public MiniServer(Socket socket) {

        super("MiniServer");
        this.socket = socket;

    }

    public void run(){

        InputStreamReader in = null;
        try {
            in = new InputStreamReader(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bf = new BufferedReader(in);

        String str = null;
        try {
            str = bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Client : " + str);
    }
    //implement your methods here
}
