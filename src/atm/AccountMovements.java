/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;


public class AccountMovements {
    
    static String fileinfo;
    
    public static void show(){
        Button returnBtn = new Button("Επιστροφή");
        returnBtn.setOnAction(e->MainMenu.show());
        returnBtn.getStyleClass().add("disconnectbtn");
        Button disconnectBtn = new Button("Αποσύνδεση");
        disconnectBtn.getStyleClass().add("disconnectbtn");
        HBox top = new HBox(returnBtn, disconnectBtn);
        top.setSpacing(120);
        top.setPadding(new Insets(10));
        top.setAlignment(Pos.CENTER);
        TableView data = new TableView();
        data.setEditable(false);
        TableColumn dataCol = new TableColumn("Κινήσεις Λογαριασμού");
        data.getColumns().add(dataCol);
        Text info = new Text();
        fileinfo = "";
        try(BufferedReader reader = new BufferedReader(new FileReader(MainMenu.userFile))){
            String line;
            while((line = reader.readLine()) != null)
                fileinfo+=line+"\n";
        }catch (IOException e){
            e.printStackTrace();
        }
        info.setText(fileinfo);
        
        HBox mid = new HBox(info);
        mid.setAlignment(Pos.CENTER);
        
        BorderPane main = new BorderPane();
        main.setTop(top);
        main.setCenter(mid);
        Scene scene = new Scene(main, 500, 250);
        scene.getStylesheets().add("/atm/SubMenuStyle.css");
        MainMenu.stage.setScene(scene);
        MainMenu.stage.setTitle("Κινήσεις Λογαριασμού");
        disconnectBtn.setOnAction(e->MainMenu.stage.close());
    }
    
}
