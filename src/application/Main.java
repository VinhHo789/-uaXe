
package application;
	


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import javafx.scene.Node;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;


public class Main extends Application {
	//start
	//Bien com chua cac bien va ham common
    CommonFunction com = new CommonFunction();
    
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(com.scenePath));
            Scene scene = new Scene(root);

            // Load configuration file
            //loadConfig();

            // Create media and media player objects
            String musicFilePath = "src/music/LND.mp3";
            Media media = new Media(new File(musicFilePath).toURI().toString());

           
            try {
                com.mediaPlayer = new MediaPlayer(media);
                com.mediaPlayer.setVolume(com.volume);
                com.mediaPlayer.setOnError(() -> System.out.println("Error occurred while playing media"));
                com.mediaPlayer.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


	public static void main(String[] args) {
		launch(args);
	}
}


