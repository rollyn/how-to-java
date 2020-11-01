package com.wisphil;

import com.wisphil.model.Account;

import java.io.*;

public class ObjectStream {

    String path = "C:\\practice\\java\\JavaIO\\data.bin";

    public void write() {
        Account account = new Account("001","ETHAN",100d);
        System.out.println("Writing an object..");
        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(account);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        try {
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(new FileInputStream(path));
            Account account = (Account) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println( account );
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
