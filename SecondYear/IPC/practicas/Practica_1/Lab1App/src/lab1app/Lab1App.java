/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1app;

import static java.awt.SystemColor.text;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author colla
 */
public class Lab1App extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Label tic = new Label("Tic Tac Toe");
        GridPane grid = new GridPane();
        Hbox hb = new
                     
        VBox root = new VBox(5);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(lbl, text, btn);
        
        
     

Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

}
    public static void main(String[] args) {
        launch(args);
    }
    
}
