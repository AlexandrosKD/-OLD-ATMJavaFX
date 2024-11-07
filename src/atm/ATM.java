/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class ATM extends Application {
    
    public static TextField codeTxt;
    public static PasswordField passTxt;
    
    @Override
    public void start(Stage primaryStage) {
        Text codeAccount = new Text("Αριθμός Λογαριασμού:");
        codeTxt = new TextField();
        codeTxt.setPromptText("Εισάγεται τον Αριθμό Λογαριασμού σας εδώ");
        HBox hb1 = new HBox(codeAccount, codeTxt);
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(10);
        
        Text passAccount = new Text("Κωδικός Λογαριασμού:");
        passTxt = new PasswordField();
        passTxt.setPromptText("Εισάγεται τον Κωδικό Λογαριασμού σας εδώ");
        HBox hb2 = new HBox(passAccount, passTxt);
        hb2.setAlignment(Pos.CENTER);
        hb2.setSpacing(10);
        
        VBox cut = new VBox(20,hb1,hb2);
        cut.setAlignment(Pos.CENTER);
        
        Button conBtn = new Button("Σύνδεση");
        conBtn.setOnAction(e->connection());
        conBtn.getStyleClass().add("loginbtn");
        Button cancelBtn = new Button("Ακύρωση");
        cancelBtn.setOnAction(e->primaryStage.close());
        cancelBtn.getStyleClass().add("cancelbtn");
        HBox hb3 = new HBox(conBtn, cancelBtn);
        hb3.setAlignment(Pos.CENTER);
        hb3.setSpacing(50);
        hb3.setPadding(new Insets(20));
        
        BorderPane finalCut = new BorderPane();
        finalCut.setCenter(cut);
        finalCut.setBottom(hb3);
        Scene scene = new Scene(finalCut, 450, 200);
        scene.getStylesheets().add("/atm/Styles.css");
        primaryStage.setTitle("Welcome!!!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void connection(){
        if(LogCheck.verifyLogin(codeTxt.getText(), passTxt.getText()))
            MainMenu.show();
        else
            MessageBox.show("Λάθος Αριθμός ή Κωδικός Λογαριασμού!");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
