package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChooseCarController implements Initializable {

	@FXML
	protected Button mau1;
	
	@FXML
	protected Button mau2;
	
	@FXML
	protected Button mau3;
	
	@FXML
	protected Button mau4;
	
	@FXML
	protected Button mau5;
	
	@FXML
	protected Button backButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		mau1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	CommonFunction.sceneTransition("/view/betMenu.fxml", event);
            }
        });
		mau2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	CommonFunction.sceneTransition("/view/betMenu.fxml", event);
            }
        });
		
		mau3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	CommonFunction.sceneTransition("/view/betMenu.fxml", event);
            }
        });
		
		mau4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	CommonFunction.sceneTransition("betMenu.fxml", event);
            }
        });
		
		mau5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	CommonFunction.sceneTransition("betMenu.fxml", event);
            }
        });
		
		backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	CommonFunction.sceneTransition("GiaodienUI.fxml", event);
            }
        });
		
	}

}
