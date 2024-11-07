/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainMenu {
    
    public static Stage stage = new Stage();
    public static File userFile;
    
    public static void show(){
        userFile = new File(ATM.codeTxt.getText()+".txt");
        
        Button getMoneyBtn = new Button("Ανάληψη Χρημάτων");
        getMoneyBtn.wrapTextProperty().setValue(true);
        getMoneyBtn.setOnAction(e->Withdrawal.show());
        getMoneyBtn.getStyleClass().add("buttons");
        Button giveMoneyBtn = new Button("Κατάθεση Χρημάτων");
        giveMoneyBtn.setOnAction(e->Deposit.show());
        giveMoneyBtn.getStyleClass().add("buttons");
        giveMoneyBtn.wrapTextProperty().setValue(true);
        Button showMoneyBtn = new Button("Κινήσεις Λογαριασμού");
        showMoneyBtn.setOnAction(e->AccountMovements.show());
        showMoneyBtn.getStyleClass().add("buttons");
        showMoneyBtn.wrapTextProperty().setValue(true);
        
        Button disconnectBtn = new Button("Αποσύνδεση");
        disconnectBtn.setOnAction(e->stage.close());
        disconnectBtn.getStyleClass().add("disconnectbtn");
        
        HBox cent = new HBox(20, getMoneyBtn, giveMoneyBtn, showMoneyBtn);
        cent.setPadding(new Insets(20));
        cent.setAlignment(Pos.CENTER);
        
        HBox top = new HBox(20, disconnectBtn);
        top.setPadding(new Insets(20));
        top.setAlignment(Pos.TOP_RIGHT);
        
        BorderPane pane = new BorderPane();
        pane.setCenter(cent);
        pane.setTop(top);
        Scene scene = new Scene(pane, 500, 200);
        scene.getStylesheets().add("/atm/MainMenuStyle.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Κύριο Μενού");
        stage.show();
    }   
}
