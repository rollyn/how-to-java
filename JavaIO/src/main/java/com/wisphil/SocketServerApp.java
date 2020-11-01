package com.wisphil;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class SocketServerApp {

    private final int port = 5100;
    private ServerSocket serverSocket;
    private ArrayList<Socket> clientList;

    public SocketServerApp() {
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setReuseAddress(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        clientList = new ArrayList<Socket>();
    }


    public void startServer() throws IOException {
        System.out.println("Accepting clients...");
        while(true)  {

            Socket client = serverSocket.accept();
            clientList.add(client);
            System.out.println("New client accepted..." + client.getRemoteSocketAddress());
            System.out.println("Total users: " + clientList.size());
            ChatClientHandler handler = new ChatClientHandler(client,this);
            Thread t = new Thread(handler);
            t.start();
        }
    }

    public synchronized void sendChatMessageToAll(String msg) throws IOException {

        for(Iterator<Socket> it = clientList.iterator(); it.hasNext();) {
            Socket client = it.next();
            if( !client.isClosed() ) {
                PrintWriter pw = new PrintWriter(client.getOutputStream());
                pw.println(msg);
                pw.flush();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServerApp().startServer();
    }

}
