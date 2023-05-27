package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class TrangChuController {

    public static Map<String, String> accounts = new HashMap<>();
    public static Map<String, Integer> accounts_gold = new HashMap<>();
    final String FILE_PATH = "src/data/accountData";
    final String USERNAME = "Username";
    final String PASSWORD = "Password";
    final String GOLD = "Gold";
    final Integer INIT_GOLD = 1000;

    @FXML
    private TextField playerNameField;

    @FXML
    private TextField goldAmountField;
    
    @FXML
    private ImageView setting;
    
    @FXML
    private Text thoatgame;
    
    @FXML
    private BorderPane HomePage1;
    
    @FXML
    private AnchorPane HomePage; 

    @FXML
    private AnchorPane Map_Choosing;
    
    @FXML
    private AnchorPane Car_Choosing;
    
    @FXML
    private VBox Item_Chosing;
    
    @FXML
    private Button VaoDua;//button home
    
    @FXML
    private Button QuayLai;
    
    @FXML 
    private Button TiepTucCarChoosing;
    
    @FXML
    private Button QuayLaiMap_Choosing;
    
    @FXML
    private Button TiepTuc_ItemChoosing;
    
    @FXML
    private Button playGameButton;
    

    public void initialize() {
        HomePage.setVisible(true);
        Map_Choosing.setVisible(false);
        
        playGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	CommonFunction.sceneTransition("/view/gamePlay.fxml", event);
            }
        });
		
    }

    public void setPlayerName(String playerName) {
        playerNameField.setText(playerName);
    }

    public void setGoldAmount(int goldAmount) {
        goldAmountField.setText(String.valueOf(goldAmount));
    }
    
    @FXML
    private void handleVaoDuaButtonClick() {
    		HomePage.setVisible(false);
            Map_Choosing.setVisible(true);
    }
    
    @FXML 
    private void QuayLaiHome() {
    	HomePage.setVisible(true);
        Map_Choosing.setVisible(false);
    }
    @FXML
    private void TiepTucCarChoosing() {
        Map_Choosing.setVisible(false);
        Car_Choosing.setVisible(true);
    }
    @FXML 
    private void QuayLaiMap_Choosing() {
    //dang ở carchosing, quay lại map choosing
    	Car_Choosing.setVisible(false);
        Map_Choosing.setVisible(true);
    }
    @FXML
    private void TiepTuc_ItemChoosing() {
    	//dang ở car choosing->Itemchoosing
    	HomePage1.setVisible(false);
    	Item_Chosing.setVisible(true);
    }
}

