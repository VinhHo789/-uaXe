package controller;

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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class GiaodienUI implements Initializable{
	@FXML
	protected Button playButton;
	
	@FXML
	protected Button settingButton;
	
	@FXML
	protected Button quitButton;
	
	@FXML
	protected AnchorPane mainAnchorPane;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CommonFunction.play();
        playButton.setOnAction((event)-> {
        	try {
                FXMLLoader loader = new FXMLLoader(CommonFunction.class.getResource("/view/TrangchuView.fxml"));
                StackPane root = loader.load();
                Scene scene = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Create the Setting button
        settingButton.setOnAction((event)-> {
        	CommonFunction.sceneTransition("/view/settingMenu.fxml", event);
        });

        // Create the Quit button
        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
                stg.close();
            }
        });
        mainAnchorPane.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("/img/asset/background.jpg").toExternalForm())
        		, null, null, null, null)));
	}
	
	

}
