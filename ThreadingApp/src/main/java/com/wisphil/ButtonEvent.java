package com.wisphil;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

public class ButtonEvent {

    public EventHandler<MouseEvent> nonThreadedBtnClick(TextField primeTf) {
        EventHandler<MouseEvent> event = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                primeTf.clear();
                System.out.println("nonThreadedBtnClick...");
                BigInteger bigInteger = new BigInteger(4000, new Random());
                BigInteger prime = bigInteger.nextProbablePrime();
                primeTf.setText( String.valueOf(prime));
            }
        };
        return event;
    }

    public EventHandler<MouseEvent> threadedBtnClick(TextField primeTf) {

        EventHandler<MouseEvent> event = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                System.out.println("threadedBtnClick...");
                primeTf.clear();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            BigInteger bigInteger = new BigInteger(4000, new Random());
                            BigInteger prime = bigInteger.nextProbablePrime();
                            primeTf.setText( String.valueOf(prime));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        };
        return event;
    }

}
