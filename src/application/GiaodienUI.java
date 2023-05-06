package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class GiaodienUI implements Initializable{
	@FXML
	protected Button playButton;
	
	@FXML
	protected Button settingButton;
	
	@FXML
	protected Button quitButton;
	
	Main main = new Main();


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
        playButton.setOnAction((event)-> {
        	main.com.sceneTransition("ChooseCar.fxml", event);
        });

        // Create the Setting button
        settingButton.setOnAction((event)-> {
        	main.com.sceneTransition("settingMenu.fxml", event);
        });

        // Create the Quit button
        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
                stg.close();
            }
        });
	}
	
	

}
