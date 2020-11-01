package com.wisphil;

import com.wisphil.model.Account;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileStream {

    public void write() {

        List<String> names = Arrays.asList("JOHN","JAMES","PETER");
        System.out.println("Writing to a file..");
        try {
            OutputStream outputStream = new FileOutputStream("C:\\practice\\java\\JavaIO\\data.txt",true);
            for(String name: names) {
                outputStream.write(name.getBytes());
                outputStream.write("\n".getBytes());
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        List<String> names = new ArrayList<>();
        System.out.println("Reading from a file..");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream("C:\\practice\\java\\JavaIO\\data.txt"), StandardCharsets.UTF_8));) {
            String line;
            while ((line = br.readLine()) != null) {
                names.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(String name: names) {
            System.out.println( name );
        }
    }
}
