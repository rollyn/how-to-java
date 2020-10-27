package com.wisphil;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ThreadingApp extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        ButtonEvent event = new ButtonEvent();

        TextField prime = new TextField();

        Button nonThreadedBtn = new Button("Non Thread");
        Button threadedBtn = new Button("Threaded");

        nonThreadedBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, event.nonThreadedBtnClick(prime));
        threadedBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, event.threadedBtnClick(prime));


        GridPane gridPane = new GridPane();
        gridPane.setMinSize(300, 300);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(prime, 0, 0,2,2);
        gridPane.add(nonThreadedBtn, 0, 2);
        gridPane.add(threadedBtn, 1, 2);

        Scene scene = new Scene(gridPane, 300, 300);
        stage.setScene(scene);
        stage.show();
    }


}
