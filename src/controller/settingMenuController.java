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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class settingMenuController implements Initializable{
	
	@FXML
	public Slider volumeSlider;
	
	@FXML
	protected Button backButton;
	@FXML
	protected Button volumeButton;
	@FXML
	protected Pane settingMenu;
	@FXML
	protected GridPane charGrid;
	@FXML
	protected Button charBtn;
	@FXML
	protected Button charBtn1;
	@FXML
	protected Button charBtn2;
	@FXML
	protected Button charBtn3;
	@FXML
	protected Button resetBtn;
	
	public static int charID = 1;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		settingMenu.setVisible(true);
		// TODO Auto-generated method stub
		CommonFunction.loadConfig();
        volumeSlider.setValue(CommonFunction.volume*100);
        System.out.println(CommonFunction.volume);
        //System.out.println(volumeSlider.getValue());
        volumeSlider.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double volume = volumeSlider.getValue() / 100;
                CommonFunction.volume = volume;
                CommonFunction.changeVolume(volume);  
                System.out.println(CommonFunction.volume);
            }
        });
        
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if (charGrid.isVisible()==true) {
            		settingMenu.setVisible(true);
        			charGrid.setVisible(false);
            	}
            	else {
            		CommonFunction.sceneTransition("/view/GiaodienUI.fxml", event);
            	}
            }
        });
        /*
        backButton.setOnAction((event) -> {
	        settingMenu.setVisible(true);
			charGrid.setVisible(false);
        });*/
        
        
        
        charBtn.setOnAction((event) -> {
        	settingMenu.setVisible(false);
    		charGrid.setVisible(true);
    		updateCharBtns(settingMenuController.charID);
        });
        
        // 1st Char Btn
        charBtn1.setOnAction((event) -> {
        	charID = 1;
        	updateCharBtns(settingMenuController.charID);
        });
        // 2nd Char Btn
        charBtn2.setOnAction((event) -> {
        	charID = 2;
        	updateCharBtns(settingMenuController.charID);
        });
        // 3rd Char Btn
        charBtn3.setOnAction((event) -> {
        	charID = 3;
        	updateCharBtns(settingMenuController.charID);
        });
        
        
	}
	
	public void openCharacterMenu(ActionEvent e) {
		settingMenu.setVisible(false);
		charGrid.setVisible(true);
	}
	
	public void updateCharBtns(int i) {
		setEnable(charBtn1);
		setEnable(charBtn2);
		setEnable(charBtn3);
		if (i==1) {
			setDisable(charBtn1);
		}
		else if (i==2) {
			setDisable(charBtn2);
		}
		else {
			setDisable(charBtn3);
		}
	}
	public void setDisable(Button btn) {
		btn.setDisable(true);
		btn.setText("Đã chọn");
	}
	public void setEnable(Button btn) {
		btn.setDisable(false);
		btn.setText("Chọn");
	}
	

}
