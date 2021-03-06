/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPage;

import HomePage.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;

public class LoginPageAdmin implements EventHandler<ActionEvent> {

    public static Stage window;
    public static Scene scene;

    Label label1, label2, any_account;
    TextField user_name;
    PasswordField password;
    Button login, create_new;

    //Font f;
    public LoginPageAdmin() {

        //f = new Font("Agency FB",30);
        window = new Stage();
        window.setTitle("Admin Log in/on");

        //initialize
        label1 = new Label(" Admin:   ");
        label2 = new Label("Password:");
        user_name = new TextField("Type User Name");
        password = new PasswordField();
        any_account = new Label("Don't have an account? Click Create");
        login = new Button("Login");
        create_new = new Button("Create");

        user_name.setPrefWidth(300);
        password.setPrefWidth(300);

        label1.getStyleClass().add("login_root");
        label2.getStyleClass().add("login_root");
        any_account.getStyleClass().add("login_root");
        user_name.getStyleClass().add("login_root");
        password.getStyleClass().add("login_root");
        login.getStyleClass().add("login_root");
        create_new.getStyleClass().add("login_root");

//        label1.setFont(f);
//        label2.setFont(f);
//        user_name.setFont(f);
//        password.setFont(f);
//        submit.setFont(f);
        
        login.setOnAction(this);
        create_new.setOnAction(this);

        File file = new File("src/LoginPage/Login.png");
        Image image = new Image(file.toURI().toString());
        ImageView img = new ImageView(image);

        HBox hBox1 = new HBox(10);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(label1, user_name);

        HBox hBox2 = new HBox(10);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(label2, password);

        HBox hBox3 = new HBox(10);
        hBox3.setAlignment(Pos.CENTER);
        hBox3.getChildren().addAll(any_account);

        HBox hBox4 = new HBox(10);
        hBox4.setAlignment(Pos.CENTER);
        hBox4.getChildren().addAll(login, create_new);

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(20);
        vBox.getChildren().addAll(img, hBox1, hBox2, hBox3, hBox4);

        scene = new Scene(vBox, 800, 500);
        scene.getStylesheets().add(HomePage.f);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);  // ei 2 ta use korle agger ta teh ferot jawa jabe nah
        //window.show();
        window.showAndWait();
        //window.fullScreenExitKeyProperty().unbindBidirectional(null);
        //window.setMaximized(true);
        
        window.setOnCloseRequest(e ->{  // This is for "X" button
            e.consume();
            window.close();
            HomePage.window.show();
        });
        
        
    }

    @Override
    public void handle(ActionEvent event) {

        File file = new File("src/LoginPage/AdminLogin.txt");

        Map<String, String> map = new HashMap<String, String>();
        try {
            Scanner sc = new Scanner(file);
            String s = "", user, pass;
            while (sc.hasNext()) {
                int j;
                s = sc.next();
                String[] t = s.split("#");
                user = t[0];
                pass = t[1];
                map.put(user, pass);
                //System.out.println("User:"+user+" Pass:"+pass);
            }

        } catch (FileNotFoundException ex) {

        }

        if (event.getSource() == login) {

            if (map.get(user_name.getText()) != null && password.getText().equals(map.get(user_name.getText()))) {
                window.close();
                System.out.println("Successful");
            } else {
                ErrorPage ob = new ErrorPage();
                ob.Show();
                ob.admin = 1;
                window.close();
            }
        } 
        
        
        else if (event.getSource() == create_new) {
            System.out.println("create");
        }
        

    }

//    public static void main(String[] args) {
//        LoginPageAdmin ob = new LoginPageAdmin();
//    }
}
