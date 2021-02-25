/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SaleInfo extends Application {

    Stage window;
    TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        
        window = primaryStage;
        window.setTitle("JavaFX - thenewboston");

        TreeItem<String> root, bucky, megan;
        
        //Root
        root = new TreeItem<>();
        root.setExpanded(true);

        //Bucky
        bucky = makeBranch("Bucky", root);
        makeBranch("thenewboston", bucky);
        makeBranch("YouTube", bucky);
        makeBranch("Chicken", bucky);

        //Megan
        megan = makeBranch("Megan", root);
        makeBranch("Glitter", megan);
        makeBranch("Makeup", megan);

        //Create the tree and hide the main Root
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
                    if (newValue != null)
                        System.out.println(newValue.getValue());
                });

        //Layout
        Button b = new Button("Add");
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(tree);
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(stackPane,b);
        Scene scene = new Scene(hBox, 600, 500);
        
        window.setScene(scene);
        window.show();
    }

    //Create branches
    public TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }


}
