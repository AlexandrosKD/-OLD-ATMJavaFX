/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 *
 * @author Giwrgos.Gln
 */
public class Withdrawal {

    public static ComboBox<String> cb;

    public static void show() {

        Button returnBtn = new Button("Επιστροφή");
        returnBtn.setOnAction(e -> MainMenu.show());
        returnBtn.getStyleClass().add("disconnectbtn");
        Button disconnectBtn = new Button("Αποσύνδεση");
        disconnectBtn.setOnAction(e -> MainMenu.stage.close());
        disconnectBtn.getStyleClass().add("disconnectbtn");
        HBox top = new HBox(returnBtn, disconnectBtn);
        Label lbl = new Label("Ποσό: ");
        Button withdrawal = new Button("Ανάληψη");
        withdrawal.getStyleClass().add("buttons");
        withdrawal.setOnAction(e -> withdrawalCheck());
        cb = new ComboBox<String>();
        cb.getItems().addAll("100", "200", "300", "400");
        cb.setEditable(false);
        cb.setPromptText("Διάλεξε ποσό");

        HBox hb1 = new HBox(returnBtn, disconnectBtn);
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(120);
        HBox hb2 = new HBox(lbl, cb);
        hb2.setAlignment(Pos.CENTER);
        VBox vb = new VBox(hb1, hb2, withdrawal);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(50);

        Scene scene1 = new Scene(vb, 500, 200);
        scene1.getStylesheets().add("/atm/SubMenuStyle.css");
        MainMenu.stage.setScene(scene1);
        MainMenu.stage.setTitle("Ανάληψη");

    }

    public static void withdrawalCheck(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy ");
        LocalDateTime now = LocalDateTime.now();
        String message;
        String message1;
        String message2 = "";
        String value = (String) cb.getValue();
        message = "\n" + dtf.format(now) + " Ανάληψη " + value + "€";
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


