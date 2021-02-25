/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomePage;


import static HomePage.HomePage.f;
import static HomePage.HomePage.scene;
import LoginPage.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class Settings implements EventHandler<ActionEvent> {

    public static Stage window;
    public static Scene scene;
    Button admin,employee,apply_button;
    Label Change_Font;
    
    
    Settings()
    {
        window = new Stage();
        window.setTitle("Settings");

        admin = new Button("None");
        employee = new Button("None");
        
        apply_button = new Button("Apply");
        Change_Font = new Label("Change Font:");
        
        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        //getItems returns the ObservableList object which you can add items to
        
        choiceBox.getItems().addAll("Agency FB", "Cooper Black", "Arial", "Algerian");

        //Set a default value
        choiceBox.setValue("Agency FB");
        
        apply_button.setOnAction(e -> getChoice(choiceBox));
       
        admin.setOnAction(this);
        employee.setOnAction(this);
        
        
        HBox hBox1 = new HBox(10);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(Change_Font,choiceBox);
        
        HBox hBox2 = new HBox(10);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(admin);
        
        HBox hBox3 = new HBox(10);
        hBox3.setAlignment(Pos.CENTER);
        hBox3.getChildren().add(employee);
        
        HBox hBox4 = new HBox(10);
        hBox4.setAlignment(Pos.CENTER);
        hBox4.getChildren().addAll(apply_button);
        
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));
        
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4);
        
        //setUserAgentStylesheet(STYLESHEET_CASPIAN);
        scene = new Scene(vBox, 800, 500);
        scene.getStylesheets().add(f);
        window.setScene(scene);
        window.show();
        //window.setMaximized(true);
        
    }
    
    @Override
    public void handle(ActionEvent event) {
        
        if (event.getSource() == admin) 
        {
            //LoginPageAdmin ob = new LoginPageAdmin();
            window.close();
        }
        
        if (event.getSource() == employee) 
        {
            //LoginPageEmployee ob = new LoginPageEmployee();
        }
        
    }
    
    //To get the value of the selected item
    private void getChoice(ChoiceBox<String> choiceBox){
        
        String str = choiceBox.getValue();
        
        if(str=="Agency FB") 
        {
            HomePage.f="HomePage/Agency_FB.css";
            HomePage.scene.getStylesheets().add(f);
            scene.getStylesheets().add(HomePage.f);
        }
        
        else if(str=="Arial") 
        {
            HomePage.f="HomePage/Arial.css";
            HomePage.scene.getStylesheets().add(f);
            scene.getStylesheets().add(HomePage.f);
        }
        
        else if(str=="Cooper Black") 
        {
            HomePage.f="HomePage/Cooper_Black.css";
            HomePage.scene.getStylesheets().add(HomePage.f);
            scene.getStylesheets().add(HomePage.f);
        }
        
        else if(str=="Algerian") 
        {
            HomePage.f="HomePage/Algerian.css";
            HomePage.scene.getStylesheets().add(f);
            scene.getStylesheets().add(HomePage.f);
        }
        
    }
    
}