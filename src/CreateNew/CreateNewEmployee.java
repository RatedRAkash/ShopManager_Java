/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreateNew;

import HomePage.HomePage;
import LoginPage.*;
import java.io.File;
import java.net.MalformedURLException;
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
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

public class CreateNewEmployee extends Application implements EventHandler<ActionEvent> {

    public static Stage window;
    public static Scene scene;
    public static String f = HomePage.f;

    //public static String f="CreateNew/Agency_FB.css";
    Label name, address, no_phone, email, gender, birthdate_label;
    TextField name_field, no_phone_field, email_field;
    TextArea address_field;
    //CheckBox male, female, other;
    RadioButton male,female,other;
    DatePicker birthdate;
    

    Button add_photo;// employee, instructions, settings;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //f = f.replaceAll("HomePage", "CreateNew");   //  eitar fole  "HomePage/Agency_FB.css" ekon  "CreateNew/Agency_FB.css"  hoye gese... jekene font choto
        window = primaryStage;
        window.setTitle("Account for Employee");

        Group root = new Group();
        scene = new Scene(root, 900, 600);
        scene.getStylesheets().add("HomePage/Agency_FB.css");

        TabPane tabPane = new TabPane();
        tabPane.setStyle("-fx-font-size:  17px");  //  Eita teh change kore dile ei er vitorer shob kisu aer font change hoye jabe

        StackPane mainPane = new StackPane();  //Pura scene tar main Layout hobe ei MainPane

        //TAB-A
        Tab tabA = new Tab("Personal Information");

        name = new Label("Name:");
        gender = new Label("Gender:");
        address = new Label("Address:");
        no_phone = new Label("Phone Number:");
        email = new Label("Email:");
        birthdate_label = new Label("Birth Date:");
                
        add_photo = new Button("Add Photo:");

        name_field = new TextField();
        name_field.setPrefWidth(600);
        address_field = new TextArea();
        address_field.setPrefHeight(150);
        no_phone_field = new TextField();
        email_field = new TextField();

        ToggleGroup group_gender = new ToggleGroup();
        
        male = new RadioButton("Male");
        group_gender.getToggles().add(male);
        male.setOnAction(e ->{
             //System.out.println("Male");
        });
        
        female = new RadioButton("Female");
        group_gender.getToggles().add(female);
        female.setOnAction(e ->{
            //System.out.println("Female");
        });
        
        other = new RadioButton("Other");
        group_gender.getToggles().add(other);
        other.setOnAction(e ->{
            //System.out.println("Other");
        });

        birthdate = new DatePicker();
        birthdate.setPromptText("Date of Birth");
        birthdate.setMaxWidth(300);
        
        //add_photo.setOnAction(this);      
        //Add in TabA
        HBox hBox_A1 = new HBox(10);
        hBox_A1.setAlignment(Pos.CENTER_LEFT);
        hBox_A1.setPadding(new Insets(35));
        hBox_A1.getChildren().addAll(name, name_field);
        
        HBox hBox_A2 = new HBox(10);
        hBox_A2.setAlignment(Pos.CENTER_LEFT);
        hBox_A2.setPadding(new Insets(35));
        hBox_A2.getChildren().addAll(address, address_field);
        
        HBox hBox_A3 = new HBox(10);
        hBox_A3.setAlignment(Pos.CENTER_LEFT);
        hBox_A3.setPadding(new Insets(35));
        hBox_A3.getChildren().addAll(birthdate_label, birthdate);

        HBox hBox_A4 = new HBox(10);
        hBox_A4.setAlignment(Pos.CENTER_LEFT);
        hBox_A4.setPadding(new Insets(35));
        hBox_A4.getChildren().addAll(gender, male, female, other);
        
        HBox hBox_A5 = new HBox(10);
        hBox_A5.setAlignment(Pos.CENTER_LEFT);
        hBox_A5.setPadding(new Insets(35));
        hBox_A5.getChildren().addAll(email, email_field);

        HBox hBox_A6 = new HBox(10);
        hBox_A6.setAlignment(Pos.CENTER_LEFT);
        hBox_A6.setPadding(new Insets(35));
        hBox_A6.getChildren().addAll(no_phone, no_phone_field);

        VBox vBox_A = new VBox();
        vBox_A.setAlignment(Pos.CENTER);

        vBox_A.getChildren().addAll(hBox_A1, hBox_A2, hBox_A3, hBox_A4, hBox_A5, hBox_A6);

        Image image_A = new Image("file:///E:\\Java Projects\\ShopManager\\build\\classes\\HomePage\\HomePage.jpg", 500, 400, true, true, true);
        ImageView img_A = new ImageView(image_A);
        img_A.setPreserveRatio(true);

        StackPane stackPane_A = new StackPane();
        stackPane_A.setPadding(new Insets(10));
        stackPane_A.getChildren().addAll(img_A, vBox_A);

        img_A.fitHeightProperty().bind(window.heightProperty());
        img_A.fitWidthProperty().bind(window.widthProperty());

        tabA.setContent(stackPane_A);
        //tabPane.getTabs().add(tabA);

        //TAB-B
        Tab tabB = new Tab("Job Information");
        //Add something in Tab
        StackPane tabB_stack = new StackPane();
        tabB_stack.setAlignment(Pos.CENTER);
        tabB_stack.getChildren().add(new Label("Name"));
        tabB.setContent(tabB_stack);
        //tabPane.getTabs().add(tabB);

        
        
        
        //TAB-C
        Tab tabC = new Tab("Add Photo");

        final Canvas canvas = new Canvas(300, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BLUE);
        gc.fillRect(10, 10, 300, 300);
        
        ImageView imgMain = new ImageView();
        imgMain.setFitHeight(300);
        //imgMain.setFitWidth(300);
        imgMain.setPreserveRatio(true);
        //List<File> array_img = new ArrayList<File>();

        FileChooser fileChooser = new FileChooser();

        add_photo = new Button("Add Photo");
        add_photo.setMinWidth(75);
        add_photo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try {

                    try {            //  This try --->  if no file is chosen after onpeing the ShowOpenDialog which returns "Null Pointer Exception"
                        File file = fileChooser.showOpenDialog(window);

                        if (file.isFile()
                                && (file.getName().contains(".jpg") || file.getName().contains(".bmp")
                                || file.getName().contains(".png") || file.getName().contains(".gif"))) {

                            //array_img.add(file);
                            //imgTotal = array_img.size();
                            String thumbURL = file.toURI().toURL().toString();

                            Image imgLoad = new Image(thumbURL);

                            imgMain.setImage(imgLoad);
                        }
                    } catch (NullPointerException e) {
                        //System.out.println("Choose a file");
                    }

                } catch (MalformedURLException ex) {
                    System.out.println("Error");
                }
            }
        });

        HBox hBox_C1 = new HBox(15);
        hBox_C1.setAlignment(Pos.CENTER);
        hBox_C1.getChildren().addAll(add_photo);

        StackPane stackPane_img = new StackPane();
        stackPane_img.setPadding(new Insets(10));
        stackPane_img.getChildren().addAll(canvas,imgMain);
        
        VBox vBox_C = new VBox(15);
        vBox_C.setAlignment(Pos.CENTER);
        vBox_C.getChildren().addAll(stackPane_img, hBox_C1);
        tabC.setContent(vBox_C);

//        StackPane stackPane_C = new StackPane();
//        stackPane_C.setPadding(new Insets(10));
//        stackPane_C.getChildren().addAll(img_A, vBox_C);
//        tabC.setContent(stackPane_C);
//
//        img_A.fitHeightProperty().bind(window.heightProperty());
//        img_A.fitWidthProperty().bind(window.widthProperty());
        
        mainPane.getChildren().addAll(tabPane);
        mainPane.prefHeightProperty().bind(scene.heightProperty());
        mainPane.prefWidthProperty().bind(scene.widthProperty());

        root.getChildren().add(mainPane);
        tabPane.getTabs().addAll(tabA, tabB, tabC);
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);  //Tab gular Cross button off kore dibe
        //scene = new Scene(tabPane, 800, 500 
        window.setScene(scene);
        window.setMaximized(true);
        window.show();

    }

    @Override
    public void handle(ActionEvent event) {

        if (event.getSource() == add_photo) {
            LoginPageAdmin ob = new LoginPageAdmin();
            window.close();
        }

    }

}
