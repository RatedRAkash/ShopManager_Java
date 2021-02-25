/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class Image_Slide extends Application {

    int imgTotal = 0;
    int imgPosition = 0;

    @Override
    public void start(Stage stage) throws MalformedURLException {

        ImageView imgMain = new ImageView();
        ImageView imgThumb = new ImageView();
        imgThumb.setFitHeight(100);
        imgThumb.setFitHeight(200);

        List<File> array_img = new ArrayList<File>();

        final FileChooser fileChooser = new FileChooser();

        Button btnAdd = new Button("Add New");
        btnAdd.setMinWidth(75);
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                try {

                    try {  //  This try --->  if no file is chosen after onpeing the ShowOpenDialog which returns "Null Pointer Exception"
                        File file = fileChooser.showOpenDialog(stage);

                        if (file.isFile()
                                && (file.getName().contains(".jpg") || file.getName().contains(".bmp")
                                || file.getName().contains(".png") || file.getName().contains(".gif"))) {

                            array_img.add(file);
                            imgTotal = array_img.size();

                            if (imgTotal > 1) {
                                imgPosition++;
                            }

                            String thumbURL = file.toURI().toURL().toString();

                            Image imgLoad = new Image(thumbURL);

                            imgThumb.setImage(imgLoad);
                        }
                    } catch (NullPointerException e) {
                        //System.out.println("Choose a file");
                    }

                } catch (MalformedURLException ex) {
                    System.out.println("Error");
                }
            }
        });

        Button btnRemove = new Button("Remove");

        btnRemove.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                try {
                    if (imgTotal > 1) {
                        array_img.remove(imgPosition);

                        if (imgPosition == imgTotal - 1) {
                            imgPosition--;
                        }

                        imgTotal = array_img.size();
                        String thumbURL3 = array_img.get(imgPosition).toURI().toURL().toString();
                        Image imgLoad = new Image(thumbURL3);
                        imgThumb.setImage(imgLoad);

                    } else {
                        array_img.remove(imgPosition);
                        imgPosition = 0;
                        imgTotal = array_img.size();
                        imgThumb.setImage(null);
                        imgMain.setImage(null);
                    }

                } catch (MalformedURLException ex) {
                    System.out.println("Error");
                }
            }
        });

        btnRemove.setMinWidth(75);

        Button btnNext = new Button(">");

        btnNext.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if (imgPosition < imgTotal - 1) {
                    try {
                        imgPosition++;
                        String thumbURL1 = array_img.get(imgPosition).toURI().toURL().toString();
                        Image imgLoad = new Image(thumbURL1);
                        imgThumb.setImage(imgLoad);

                    } catch (MalformedURLException ex) {
                        System.out.println("Error");
                    }
                }
            }
        });

        Button btnPrev = new Button("<");

        btnPrev.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if (imgPosition > 0) {
                    try {
                        imgPosition--;
                        String thumbURL2 = array_img.get(imgPosition).toURI().toURL().toString();
                        Image imgLoad = new Image(thumbURL2);
                        imgThumb.setImage(imgLoad);

                    } catch (MalformedURLException ex) {
                        System.out.println("Error");
                    }
                }
            }
        });

        imgThumb.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                if (t.getButton() == MouseButton.PRIMARY) {
                    try {
                        String imgURL = array_img.get(imgPosition).toURI().toURL().toString();
                        Image imgLoad = new Image(imgURL, 500, 300, true, true, true);
                        imgMain.setImage(imgLoad);
                    } catch (MalformedURLException ex) {
                        System.out.println("Error");
                    }
                }
            }
        });

        HBox panel1 = new HBox(15);
        panel1.setAlignment(Pos.CENTER);
        panel1.getChildren().addAll(btnAdd, btnPrev, imgThumb, btnNext, btnRemove);

        VBox panel2 = new VBox(15);
        panel2.setAlignment(Pos.CENTER);
        panel2.getChildren().addAll(imgMain, panel1);

        Scene scene = new Scene(new Group());

        scene.setRoot(panel2);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
