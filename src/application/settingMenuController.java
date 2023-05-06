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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class settingMenuController implements Initializable{
	
	@FXML
	protected Slider volumeSlider;
	
	@FXML
	protected Button backButton;
	
	Main main = new Main();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		main.com.loadConfig();
        volumeSlider.setValue(main.com.volume);
        volumeSlider.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double volume = volumeSlider.getValue() / 100;
                CommonFunction.volume = volume;
                CommonFunction.changeVolume(volume);
                
            }
        });
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	main.com.sceneTransition("GiaodienUI.fxml", event);
            }
        });
	}
	
	

}
