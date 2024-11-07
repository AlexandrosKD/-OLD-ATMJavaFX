/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MessageBox {
    public static void show(String message){
        //Stage
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinWidth(250);
        
        //Label_Button
        Label lbl1 = new Label(message);
        Button btnOK = new Button("OK");
        btnOK.setOnAction(e -> stage.close());
        btnOK.getStyleClass().add("button");
        StackPane pane = new StackPane();
        pane.getChildren().addAll(lbl1, btnOK);
        pane.setAlignment(btnOK, Pos.BOTTOM_CENTER);
        Scene scene = new Scene(pane, 350, 250);
        scene.getStylesheets().add("/atm/WarningStyle.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Ενημέρωση");
        stage.showAndWait();
    }   
}
