package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

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
    private BorderPane HomePage; 

    @FXML
    private BorderPane Map_Choosing;
    
    @FXML
    private BorderPane Car_Choosing;
    
    @FXML
    private VBox Item_Chosing;
    
    @FXML
    private Button VaoDua;
    
    @FXML
    private Button QuayLai;
    
    @FXML 
    private Button TiepTucCarChoosing;
    
    @FXML
    private Button QuayLaiMap_Choosing;
    
    @FXML
    private Button TiepTuc_ItemChoosing;
    
    

    public void initialize() {
        readAccountDataFromFile();
        HomePage.setVisible(true);
        Map_Choosing.setVisible(false);
    }

    public void setPlayerName(String playerName) {
        playerNameField.setText(playerName);
    }

    public void setGoldAmount(int goldAmount) {
        goldAmountField.setText(String.valueOf(goldAmount));
    }
    
//hàm đọc dữ liệu từ file --để là tên đăng nhập đầu tiên trong mảng
    private void readAccountDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            String playerName = null;
            int goldAmount = 0;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(USERNAME)) {
                    playerName = line.substring(line.indexOf(":") + 1).trim();
                } else if (line.startsWith(GOLD)) {
                    goldAmount = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
                    break; // Stop reading after finding the first gold amount
                }
            }

            setPlayerName(playerName);
            setGoldAmount(goldAmount);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    	//dang ơi car choosing->Itemchoosing
    	Car_Choosing.setVisible(false);
    	Item_Chosing.setVisible(true);
    }
}

