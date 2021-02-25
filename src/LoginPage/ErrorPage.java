package LoginPage;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ErrorPage {

    Label label,img_label;
    public static Stage window;
    static int admin=0,employee=0;

    public ErrorPage() {
    
        window = new Stage();
        window.setTitle("Wrong Password or User Name");
    }
    
    public void Show(){
        
        //Font f = new Font("Agency FB",20);
        
        Image image = new Image("file:///E:\\Java Projects\\ShopManager\\build\\classes\\LoginPage\\WrongPassword.jpg",500,400,true,true,true);   //    "file:///" --->  eita dite hobe shob location aer agge 
        
        //image class aer instructor:
        //URL
        //Width
        //Height
        //PreserveRatio
        //smooth
        //BackgroundLoading
        
        ImageView img = new ImageView(image);
        img.setPreserveRatio(true);
        
        Button add = new Button("Add");
        
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(img);
       
        StackPane stackPane = new StackPane();
        stackPane.setPadding(new Insets(10));
        stackPane.getChildren().addAll(img,add);
        
        Scene scene = new Scene(stackPane);
//        
//        StackPane root = new StackPane();
//        
//        root.setStyle(
//            " -fx-background-image:  url(" + " 'src/LoginPage/WrongPassword.jpg' " + ");" 
//                    +
//            "-fx-background-size: cover;"
//        );
//        
        
        img.fitHeightProperty().bind(window.heightProperty());
        img.fitWidthProperty().bind(window.widthProperty());
        //window.setScene(new Scene(root));
        window.setScene(scene);
        window.setMaximized(true);
        window.show();
        
        window.setOnCloseRequest(e ->{  // This is for "X" button
            
            e.consume();
            window.close();
            
            if(admin==1)
            {
                LoginPageAdmin.window.show();
                admin=0;
            }
            
            if(employee==1)
            {
                LoginPageEmployee.window.show();
                employee=0;
            }
            
            
        });
    }

}