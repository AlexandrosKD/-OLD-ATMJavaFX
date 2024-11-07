/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Deposit {

    public static TextField dept;

    public static void show() {

        Button returnBtn = new Button("Επιστροφή");
        returnBtn.setOnAction(e -> MainMenu.show());
        returnBtn.getStyleClass().add("disconnectbtn");
        Button disconnectBtn = new Button("Αποσύνδεση");
        disconnectBtn.setOnAction(e -> MainMenu.stage.close());
        disconnectBtn.getStyleClass().add("disconnectbtn");
        HBox top = new HBox(returnBtn, disconnectBtn);
        Label lbl = new Label("Ποσό: ");
        Button depositBtn = new Button("Κατάθεση");
        depositBtn.getStyleClass().add("buttons");
        depositBtn.setOnAction(e -> depositCheck());
        dept = new TextField();

        HBox hb1 = new HBox(returnBtn, disconnectBtn);
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(120);
        HBox hb2 = new HBox(lbl, dept);
        hb2.setAlignment(Pos.CENTER);
        VBox vb = new VBox(hb1, hb2, depositBtn);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(50);

        Scene scene1 = new Scene(vb, 500, 200);
        scene1.getStylesheets().add("/atm/SubMenuStyle.css");
        MainMenu.stage.setScene(scene1);
        MainMenu.stage.setTitle("Κατάθεση");

    }
    
    public static void depositCheck(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy ");
        LocalDateTime now = LocalDateTime.now();
        String message;
        String message1;
        String message2 = "";
        String value = dept.getText();
        message = "\n" + dtf.format(now) + " Κατάθεση " + value + "€";
        int codeTxtIndex = ATM.codeTxt.getText().length();
        String codeTxt = ATM.codeTxt.getText();
        for (int i = 1; i <= codeTxtIndex; i++) {
            if (i >= codeTxtIndex - 3) {
                message2 += "x";
            } else {
                message2 += codeTxt.charAt(i-1);
            }
        }
        message1 = "**************************************" + "\n" + "Αριθμός λογαριασμού: " + message2 + "\n" + "Τύπος Συναλλαγής:  Κατάθεση" + "\n" + "Ποσό: " + value + "€\n" + "Ημερομηνία: " + dtf.format(now) + "\n" + "**************************************";
        MessageBox.show(message1);
        try{
        FileWriter fw = new FileWriter(MainMenu.userFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(message);
        bw.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }        
    }
}

