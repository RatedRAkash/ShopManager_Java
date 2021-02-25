/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.control.DatePicker;

import javafx.stage.Stage;

/**
 *
 * @web http://java-buddy.blogspot.com/
 */
public class JavaFX_uiTabPane extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("http://java-buddy.blogspot.com/");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 300, Color.WHITE);

        final TabPane tabPane = new TabPane();
        BorderPane mainPane = new BorderPane();
        
        
        
        
        //Create Tabs
        Tab tabA = new Tab();
        tabA.setText("Tab A");
        //Add something in Tab
        DatePicker date_A = new DatePicker();
        date_A.setPromptText("Date of Birth");
        date_A.setMaxWidth(300);
        
        tabA.setContent(date_A);
        tabPane.getTabs().add(tabA);

        Tab tabB = new Tab();
        tabB.setText("Tab B");
        //Add something in Tab
        StackPane tabB_stack = new StackPane();
        tabB_stack.setAlignment(Pos.CENTER);
        tabB_stack.getChildren().add(new Label("Label@Tab B"));
        tabB.setContent(tabB_stack);
        tabPane.getTabs().add(tabB);

        Tab tabC = new Tab();
        tabC.setText("Set Tab Side");
        //Add something in Tab
        VBox tabC_vBox = new VBox();

        Button ButtonLeft = new Button("Set Tab on Left");
        ButtonLeft.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                tabPane.setSide(Side.LEFT);
            }

        });

        Button ButtonTop = new Button("Set Tab on Top");
        ButtonTop.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                tabPane.setSide(Side.TOP);
            }

        });

        Button ButtonRight = new Button("Set Tab on Right");
        ButtonRight.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                tabPane.setSide(Side.RIGHT);
            }

        });

        Button ButtonBottom = new Button("Set Tab on Bottom");
        ButtonBottom.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                tabPane.setSide(Side.BOTTOM);
            }

        });

        tabC_vBox.getChildren().addAll(ButtonLeft, ButtonTop, ButtonRight, ButtonBottom);

        tabC.setContent(tabC_vBox);
        tabPane.getTabs().add(tabC);

        mainPane.setCenter(tabPane);

        mainPane.prefHeightProperty().bind(scene.heightProperty());
        mainPane.prefWidthProperty().bind(scene.widthProperty());

        root.getChildren().add(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
