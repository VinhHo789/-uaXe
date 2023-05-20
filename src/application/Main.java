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

import controller.CommonFunction;
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

	//Dat dep trai

	//Bien com chua cac bien va ham common
	public CommonFunction com = new CommonFunction();
    
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/DangNhap.fxml"));
            Scene scene = new Scene(root);

            // Load configuration file
            //loadConfig();

            // Create media and media player objects


           
            try {
            	CommonFunction.play();
            	CommonFunction.changeVolume(CommonFunction.volume);
                
                CommonFunction.mediaPlayer.setOnError(() -> System.out.println("Error occurred while playing media"));
                CommonFunction.mediaPlayer.play();
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


