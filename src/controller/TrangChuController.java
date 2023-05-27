package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;

public class TrangChuController {

    @FXML
    private TextField playerNameField;

    @FXML
    private TextField goldAmountField;
    
    @FXML
    private ImageView setting;
    
    @FXML
    private Text thoatgame;
    
    @FXML
    private TextField nhapTienCuocTextField;
    
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
    
    @FXML
    private VBox kietSuc;
    @FXML
    private VBox tocBien;
    @FXML
    private VBox tocHanh;
    @FXML
    private Label goldAmount_value;

    

    public void initialize() {
        HomePage.setVisible(true);
        Map_Choosing.setVisible(false);
        
        playGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	CommonFunction.sceneTransition("/view/gamePlay.fxml", event);
            }
        });
        setPlayerName(CommonFunction.username);
        setGoldAmount(CommonFunction.gold);
        handleItem_chosing_kietSuc ();
    }

    public void setPlayerName(String playerName) {
        playerNameField.setText(playerName);
    }

    public void setGoldAmount(int goldAmount) {
        goldAmountField.setText(String.valueOf(goldAmount));
    }
    
    @FXML
    private void handleVaoDuaButtonClick() {
        int goldAmount =CommonFunction.gold;
        if (goldAmount < 1) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Số vàng không đủ");
            alert.setHeaderText(null);
            alert.setContentText("Bạn cần tối thiểu 1 vàng để vào đua!");
            alert.showAndWait();
        } else {
            HomePage.setVisible(false);
            Map_Choosing.setVisible(true);
        }
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
        try {
        	goldAmount_value.setText(Integer.toString(CommonFunction.gold));
            int soTienDatCuoc = Integer.parseInt(nhapTienCuocTextField.getText());
            int soVangHienCo = CommonFunction.gold;

            if (soTienDatCuoc > soVangHienCo) {
                Alert alert = new Alert(AlertType.WARNING, "Bạn không đủ số vàng để đặt cược!", ButtonType.OK);
                alert.showAndWait();
            } else {
                // Trừ số tiền đặt cược khỏi số tiền hiện có
                int soVangConLai = soVangHienCo - soTienDatCuoc;
                setGoldAmount(soVangConLai);
                CommonFunction.gold-=soTienDatCuoc;

                // Hiển thị giao diện của Item Choosing
                HomePage1.setVisible(false);
                Item_Chosing.setVisible(true);
            }
        } catch (NumberFormatException e) {
            // Xử lý lỗi nếu người dùng nhập kí tự không phải số
            Alert alert = new Alert(AlertType.ERROR, "Số vàng không hợp lệ!", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    private void handleNhapTienCuocTextFieldAction() {
        try {
            int soTienDatCuoc = Integer.parseInt(nhapTienCuocTextField.getText());
            int soVangHienCo = CommonFunction.gold;

            if (soTienDatCuoc > soVangHienCo) {
                Alert alert = new Alert(AlertType.WARNING, "Số vàng vượt quá số vàng hiện tại, Vui lòng nhập lại số vàng đặt cược", ButtonType.OK);
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            // Xử lý lỗi nếu người dùng nhập kí tự không phải số
            Alert alert = new Alert(AlertType.ERROR, "Số vàng không hợp lệ!", ButtonType.OK);
            alert.showAndWait();
        }
    }
    
    //coi lại có bị thừa không.
    @FXML
    private void handleTiepTucItemChoosingButtonAction() {
        try {
            int soTienDatCuoc = Integer.parseInt(nhapTienCuocTextField.getText());
            int soVangHienCo = CommonFunction.gold;

            if (soTienDatCuoc > soVangHienCo) {
                Alert alert = new Alert(AlertType.WARNING, "Bạn không đủ số vàng để đặt cược!", ButtonType.OK);
                alert.showAndWait();
            } else {
                // Trừ số tiền đặt cược khỏi số tiền hiện có
                int soVangConLai = soVangHienCo - soTienDatCuoc;
                setGoldAmount(soVangConLai);
                
                // Thực thi xử lý tiếp theo tại đây
                // ...
            }
        } catch (NumberFormatException e) {
            // Xử lý lỗi nếu người dùng nhập kí tự không phải số
            Alert alert = new Alert(AlertType.ERROR, "Số vàng không hợp lệ!", ButtonType.OK);
            alert.showAndWait();
        }
    }
    
    public void handleItem_chosing_kietSuc () {
    // Gắn sự kiện click chuột cho VBox "kietSuc"
    kietSuc.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            try {
                int soVangHienCo =  CommonFunction.gold;
                int giaTriVatPham = 50;

                if (soVangHienCo < giaTriVatPham) {
                    Alert alert = new Alert(AlertType.WARNING, "Bạn không đủ số vàng để mua vật phẩm này!", ButtonType.OK);
                    alert.showAndWait();
                } else {
                    // Trừ tiền và ẩn VBox
                    goldAmount_value.setText(String.valueOf(soVangHienCo - giaTriVatPham));
                    CommonFunction.gold-=giaTriVatPham;
                    kietSuc.setVisible(false);
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(AlertType.ERROR, "Số vàng không hợp lệ!", ButtonType.OK);
                alert.showAndWait();
            }
        }
    });
    }
}

