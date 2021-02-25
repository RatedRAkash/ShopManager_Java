/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomePage;


import LoginPage.*;
import static LoginPage.ErrorPage.window;
import com.sun.org.apache.bcel.internal.generic.Instruction;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class HomePage extends Application implements EventHandler<ActionEvent> {

    public static Stage window;
    public static Scene scene;
    public static String f="HomePage/Agency_FB.css";
    Button admin,employee,instructions,settings;
    
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
    
        //f = new Font("Agency FB",30);
        
        window = primaryStage;
        window.setTitle("HomePage");

        admin = new Button("Admin");
        employee = new Button("Employee");
        instructions = new Button("Instructions");
        settings = new Button("Settings");
        
//        admin.setFont(f);
//        employee.setFont(f);
//        instructions.setFont(f);
//        settings.setFont(f);
        
       
        admin.setOnAction(this);
        employee.setOnAction(this);
        instructions.setOnAction(this);
        settings.setOnAction(this);
        
        HBox hBox1 = new HBox(10);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(admin);
        
        HBox hBox2 = new HBox(10);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(employee);
        
        HBox hBox3 = new HBox(10);
        hBox3.setAlignment(Pos.CENTER);
        hBox3.getChildren().addAll(instructions);
        
        HBox hBox4 = new HBox(10);
        hBox4.setAlignment(Pos.CENTER);
        hBox4.getChildren().addAll(settings);
        
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));
        
        
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4);
        
        Image image = new Image("file:///E:\\Java Projects\\ShopManager\\build\\classes\\HomePage\\HomePage.jpg",500,400,true,true,true);
        ImageView img = new ImageView(image);
        img.setPreserveRatio(true);
        
        
        StackPane layout = new StackPane();
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(img,vBox);
        
        //setUserAgentStylesheet(STYLESHEET_CASPIAN);
        
        
        img.fitHeightProperty().bind(window.heightProperty());   // sobsomoy screen aer sathe laghe takbe image ta
        img.fitWidthProperty().bind(window.widthProperty());
        
        scene = new Scene(layout, 800, 500);
        scene.getStylesheets().add(f);
        window.setScene(scene);
        window.show();
        //window.setMaximized(true);
        
    }
    
    @Override
    public void handle(ActionEvent event) {
        
        if (event.getSource() == admin) 
        {
            LoginPageAdmin ob = new LoginPageAdmin();
            window.close();
        }
        
        if (event.getSource() == employee) 
        {
            LoginPageEmployee ob = new LoginPageEmployee();
        }
        
        if (event.getSource() == instructions) 
        {
            Instructions ob = new Instructions();
        }
        
        if (event.getSource() == settings) 
        {
            Settings ob = new Settings();
        }
        
    }

    
}