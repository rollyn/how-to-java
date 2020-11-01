package com.wisphil;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClientApp implements Runnable {

        private Socket link;
        private PrintWriter outputStream;
        private Scanner inputStream;
        private int port = 5100;
        private String nick;

	public SocketClientApp() throws IOException {
            initialize();
        }

        private void initialize() throws IOException {
            // get server address
            Scanner keyboard = new Scanner(System.in);
            System.out.println("What is the chat server's ip address?");
            String str = keyboard.next();

            System.out.println("What is your nick?");
            nick = keyboard.next();

            InetAddress host = null;
            try {
                host = InetAddress.getByName(str);
            } catch (UnknownHostException e1) {
                System.out.println("Host not found");
            }
            System.out.println("You are now connected to: " + host.getHostAddress());

            link = null;
            try {
                link = new Socket(host, port);
                link.setReuseAddress(true);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("not found");
            }
            inputStream = new Scanner(link.getInputStream());
            outputStream = new PrintWriter(link.getOutputStream());

            Thread t = new Thread(this);
            t.start();

            while (keyboard.hasNextLine()) {
                String msg = keyboard.nextLine();
                outputStream.println(nick + " says: " + msg);
                outputStream.flush();
            }
        }

        public static void main(String[] args) throws Exception {
            new SocketClientApp();
        }

        @Override
        public void run() {
            while (true) {
                if (inputStream.hasNextLine())
                    System.out.println(inputStream.nextLine());
            }
        }
}
