/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;


public class FX_TabPane extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        
        TabPane tb = new TabPane();
        
        Tab item1= new Tab("Write");
        Tab item2= new Tab("Read");
        Tab item3= new Tab("Edit");
        
        item1.setOnSelectionChanged(null);
       
        tb.getTabs().addAll(item1,item2,item3);
        
        
        Scene scene = new Scene(tb);
        
        window.setScene(scene);
        //window.setFullScreen(true);
        window.setMaximized(true);
        window.show();
    }
}
