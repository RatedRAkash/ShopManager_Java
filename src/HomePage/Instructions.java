/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomePage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Instructions {

    Stage window;
    Label label;

    Instructions() {
       
        //File file = new File("E:\\Java Projects\\JavaProject\\Files\\Instructions.txt");
        File file = new File("src/HomePage/Instructions.txt");

        String str="";
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(file));

            String s;
            while ((s = br.readLine()) != null) {
                str+=s;
            }
        } 
        
        
        catch (Exception e) {

        }
        
        label = new Label(str);
        label.setPrefSize(200, 200);
        
        window = new Stage();
        window.setTitle("Instructions");

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(label);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout, 250, 300);
        window.setScene(scene);
        window.showAndWait();
        
    }
    
//    public static void main(String[] args) {
//        Instructions ob = new Instructions();
//    }

}