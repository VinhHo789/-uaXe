package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Bounds;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import javafx.scene.Cursor;

import javafx.stage.Stage;

import javafx.scene.Node;


import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Node;


import javafx.scene.control.Alert;

import javafx.scene.layout.BackgroundFill;
import controller.minigame;

public class TrangChuController {

	@FXML
	private TextField playerNameField;

	@FXML
	private TextField goldAmountField;

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
	private Button VaoDua;// button home

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
	private Button ngan;
	@FXML
	private Button trungbinh;
	@FXML
	private Button dai;
	
	@FXML
	private Button vaoKiemTienButton;

	@FXML
	private Tab duongnhua;

	@FXML
	private Tab duongdat;

	@FXML
	private Tab duongbaron;

	@FXML
	private VBox kietSuc;
	@FXML
	private VBox tocBien;
	@FXML
	private VBox tocHanh;
	@FXML
	private Label goldAmount_value;

	@FXML
	private ImageView xe1;
	@FXML
	private ImageView xe2;
	@FXML
	private ImageView xe3;
	@FXML
	private ImageView xe4;
	@FXML
	private ImageView xe5;
	
	@FXML
	protected ImageView tocHanhImageView;
	
	@FXML
    protected ImageView tocBienImageView;
	
	@FXML
    protected ImageView kietSucImageView;
	
	@FXML
	Label mauDuongDua;
	

    protected ImageView muaVatPhamBackGround;
    
    @FXML
    ImageView setting;
    

	
	



	@FXML
	private Label doDaiDuongDuaText;

	@FXML
	private ImageView backSetting;

	private Tab selectedMap;
	private Button selectedLength;
	private ImageView selectedCar;

	final String BACKGROUND_PATH = "/img/asset/background_Home.jpg";
	final String MUAVATOHAMBACKGROUND_PATH = "/img/asset/bg2.jpg";
	Image bkgImg = new Image(getClass().getResource(BACKGROUND_PATH).toExternalForm());
	Image muaVatPhambkgImg = new Image(getClass().getResource(MUAVATOHAMBACKGROUND_PATH).toExternalForm());

	// final String ItemBACKGOUND_PATH ="";

	public void initialize() {
		CommonFunction.vatPham[0] = false;
		CommonFunction.vatPham[1] = false;
		CommonFunction.vatPham[2] = false;
		HomePage1.setBackground(new javafx.scene.layout.Background(
				new javafx.scene.layout.BackgroundImage(bkgImg, null, null, null, null)));
		
		Item_Chosing.setBackground(new javafx.scene.layout.Background(
				new javafx.scene.layout.BackgroundImage(muaVatPhambkgImg, null, null, null, null)));


		mauDuongDua.setStyle("-fx-border-radius: 10px;");
		doDaiDuongDuaText.setStyle("-fx-border-radius: 10px;");
		HomePage1.toBack();
		Item_Chosing.toBack();

		HomePage.setVisible(true);
		Map_Choosing.setVisible(false);
		playGameButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
                CommonFunction.playClickSound();
				CommonFunction.sceneTransition("/view/gamePlay.fxml", event);
		    CommonFunction.saveAccountData();
			}
		});
		
		
		setPlayerName(CommonFunction.username);
		setGoldAmount(CommonFunction.gold);
		handleItem_chosing(kietSuc, 400, 2);
		handleItem_chosing(tocBien, 500, 0);
		handleItem_chosing(tocHanh, 200, 1);
		setButtonAnimation(ngan);
		setButtonAnimation(dai);
		setButtonAnimation(trungbinh);

		duongdat.setOnSelectionChanged(event -> handleMapSelection(duongdat));
		duongnhua.setOnSelectionChanged(event -> handleMapSelection(duongnhua));
		duongbaron.setOnSelectionChanged(event -> handleMapSelection(duongbaron));

		ngan.setOnAction(event -> handleLengthSelection(ngan));
		trungbinh.setOnAction(event -> handleLengthSelection(trungbinh));
		dai.setOnAction(event -> handleLengthSelection(dai));

		xe1.setOnMouseClicked(event -> handleCarSelection(xe1));
		xe2.setOnMouseClicked(event -> handleCarSelection(xe2));
		xe3.setOnMouseClicked(event -> handleCarSelection(xe3));
		xe4.setOnMouseClicked(event -> handleCarSelection(xe4));
		xe5.setOnMouseClicked(event -> handleCarSelection(xe5));

		playerNameField.setCursor(Cursor.DEFAULT);
		goldAmountField.setCursor(Cursor.DEFAULT);

		playerNameField.selectedTextProperty().addListener((observableVal, oldVal, newVal) -> {
			playerNameField.deselect();
		});

		goldAmountField.selectedTextProperty().addListener((observableVal, oldVal, newVal) -> {
			goldAmountField.deselect();
		});
		handlebackSetting();
		handlethoatgame();
    
		    choosableSetUp(tocHanhImageView);
		    choosableSetUp(tocBienImageView);
		    choosableSetUp(kietSucImageView);
		    choosableSetUp(VaoDua);
		    choosableSetUp(QuayLai);
		    choosableSetUp(TiepTucCarChoosing);
		    choosableSetUp(QuayLaiMap_Choosing);
		    choosableSetUp(TiepTuc_ItemChoosing);
		    choosableSetUp(playGameButton);
		    choosableSetUp(ngan);
		    choosableSetUp(trungbinh);
		    choosableSetUp(dai);
		    choosableSetUp(xe1);
		    choosableSetUp(xe2);
		    choosableSetUp(xe3);
		    choosableSetUp(xe4);
		    choosableSetUp(xe5);
		    choosableSetUp(vaoKiemTienButton);
		    //choosableSetUp(setting);
		    //choosableSetUp(thoatgame);
		    
		    //Thêm background, logic cho màn hình mua vật phẩm
		    //thêm logic cho thoát game
		    
		    
		    
		    Car_Choosing.setVisible(false);

		playerNameField.setCursor(Cursor.DEFAULT);
		goldAmountField.setCursor(Cursor.DEFAULT);
		
		playerNameField.selectedTextProperty().addListener((observableVal,oldVal,newVal)->{
			playerNameField.deselect();
		});

		goldAmountField.selectedTextProperty().addListener((observableVal,oldVal,newVal)->{
			goldAmountField.deselect();
		});
		playerNameField.setCursor(Cursor.DEFAULT);
		goldAmountField.setCursor(Cursor.DEFAULT);
		
		playerNameField.selectedTextProperty().addListener((observableVal,oldVal,newVal)->{
			playerNameField.deselect();
		});

		goldAmountField.selectedTextProperty().addListener((observableVal,oldVal,newVal)->{
			goldAmountField.deselect();
		});

		

	}

//	private void changemauDuongDuaText() {
//		// TODO Auto-generated method stub
//		String tenmauduongdua="";
//		if(CommonFunction.mapID==null)
//		{
//			tenmauduongdua="";
//		}
//		if(CommonFunction.mapID =="duongdat" ){
//			tenmauduongdua="PHIÊU LƯU BỤI BẠM";
//		}
//		if(CommonFunction.mapID == "duongnhua"){
//			tenmauduongdua="CHINH PHỤC TƯƠNG LAI";
//		}
//		if(CommonFunction.mapID=="duongbaron"){
//			tenmauduongdua="CẦU VƯỢT TỬ THẦN";
//		}
//		
//		
//		mauDuongDua.setText(tenmauduongdua);
//			
//	}

	private void handlethoatgame() {
		// TODO Auto-generated method stub
		thoatgame.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				thoatgame.setFill(Color.RED);
				thoatgame.getScene().setCursor(Cursor.HAND);
			}
		});

		thoatgame.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				thoatgame.setFill(Color.WHITE); // Thay đổi lại màu chữ về màu đen khi di chuột ra khỏi nhãn.
				thoatgame.getScene().setCursor(Cursor.DEFAULT);
			}
		});
		
		thoatgame.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
                CommonFunction.playClickSound();
				Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
                CommonFunction.saveAccountData();
                stg.close();
			}
	    });

	}

	private void handlebackSetting() {

		backSetting.setOnMouseEntered(event -> {
			backSetting.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
			backSetting.getScene().setCursor(Cursor.HAND);
		});

		// Lấy lại giá trị ban đầu khi chuột rời khỏi ImageView
		backSetting.setOnMouseExited(event -> {
			backSetting.setStyle("-fx-effect: null;");
			backSetting.getScene().setCursor(Cursor.DEFAULT);
		});
		
		backSetting.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
                CommonFunction.playClickSound();
				CommonFunction.sceneTransition("/view/GiaodienUI.fxml", event);
			}
	    });


		 

	}

	private void handleMapSelection(Tab tab) {
		if (tab.isSelected()) {
			CommonFunction.playClickSound();
			selectedMap = tab;
		}
	}

	private void handleLengthSelection(Button button) {
		selectedLength = button;
		CommonFunction.playClickSound();
	}

	private void handleCarSelection(ImageView carImageView) {
		if (selectedCar != null) {
			// Đặt lại hiệu ứng của xe trước đó (nếu có)
			selectedCar.setEffect(null);
		}
		CommonFunction.playClickSound();

		// Đặt hiệu ứng cho xe đang được chọn
		carImageView.setEffect(new DropShadow(10, Color.YELLOW));
		String selectedCarID = carImageView.getId();


		// Cập nhật biến selectedCar với xe đang được chọn
		selectedCar = carImageView;
		CommonFunction.carID=selectedCarID;
		

	}

	private void setButtonAnimation(Button ButtonName) {
		ButtonName.setStyle(
				"-fx-background-color: linear-gradient(#ff5400, #be1d00); -fx-background-radius: 30; -fx-text-fill: white; -fx-font-size: 24px; -fx-padding: 10px 20px; -fx-border-color: white; -fx-border-radius: 30; -fx-font-weight: bold; -fx-effect: innershadow(gaussian, #333333, 10, 0.5, 0, 5);");

		ButtonName.setOnMouseEntered(e -> {
			ButtonName.setStyle(
					"-fx-background-color: linear-gradient(#be1d00, #ff5400); -fx-background-radius: 30; -fx-text-fill: white; -fx-font-size: 24px; -fx-padding: 10px 20px; -fx-border-color: white; -fx-border-radius: 30; -fx-font-weight: bold; -fx-effect: innershadow(gaussian, #333333, 10, 0.5, 0, 5);");
		});
		ButtonName.setOnMouseExited(e -> {
			ButtonName.setStyle(
					"-fx-background-color: linear-gradient(#ff5400, #be1d00); -fx-background-radius: 30; -fx-text-fill: white; -fx-font-size: 24px; -fx-padding: 10px 20px; -fx-border-color: white; -fx-border-radius: 30; -fx-font-weight: bold; -fx-effect: innershadow(gaussian, #333333, 10, 0.5, 0, 5);");
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
        CommonFunction.playClickSound();
		int goldAmount = CommonFunction.gold;
		if (goldAmount < 100) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Số vàng không đủ");
			alert.setHeaderText(null);
			alert.setContentText("Bạn cần tối thiểu 100 vàng để vào đua!");
			alert.showAndWait();
		} else {
			HomePage.setVisible(false);
			Map_Choosing.setVisible(true);
		}
	}

	@FXML
	private void QuayLaiHome() {
		CommonFunction.playClickSound();
		HomePage.setVisible(true);
		Map_Choosing.setVisible(false);
	}

	@FXML
	private void TiepTucCarChoosing() {
        CommonFunction.playClickSound();
		if (selectedLength != null) {
			if(selectedMap == null) {
				CommonFunction.mapID = "duongnhua";
			} else {
				String selectedMapId = selectedMap.getId();
				CommonFunction.mapID = selectedMapId;

			}
			String selectedLengthId = selectedLength.getId();
			CommonFunction.mapLength = selectedLengthId;

			String tenmauduongdua="";
			if (selectedMap == duongdat) {
				tenmauduongdua="PHIÊU LƯU BỤI BẬM";
			}

			if (selectedMap == duongbaron) {
				tenmauduongdua="CẦU VƯỢT TỬ THẦN";
			}
			if (selectedMap == duongnhua) {
				tenmauduongdua="CHINH PHỤC TƯƠNG LAI";

			}
			mauDuongDua.setText(tenmauduongdua);

			// Xử lý dựa trên map và độ dài đã chọn
			Map_Choosing.setVisible(false);
			Car_Choosing.setVisible(true);
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Lỗi");
			alert.setHeaderText(null);
			alert.setContentText("Vui lòng chọn map và độ dài trước khi tiếp tục!");
			alert.showAndWait();
		}
	}

	@FXML
	private void QuayLaiMap_Choosing() {
		// dang ở carchosing, quay lại map choosing
        CommonFunction.playClickSound();
		Car_Choosing.setVisible(false);
		Map_Choosing.setVisible(true);
	}

	@FXML
	private void TiepTuc_ItemChoosing() {
		try {

            CommonFunction.playClickSound();
			goldAmount_value.setText(Integer.toString(CommonFunction.gold));
			int soTienDatCuoc = Integer.parseInt(nhapTienCuocTextField.getText());
			int soVangHienCo = CommonFunction.gold;
			if (soTienDatCuoc < 100) {
				throw new NumberFormatException();
			}
			if (soTienDatCuoc > soVangHienCo) {
				Alert alert = new Alert(AlertType.WARNING, "Bạn không đủ số vàng để đặt cược!", ButtonType.OK);
				alert.showAndWait();
			} else if (selectedCar == null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Lỗi");
				alert.setHeaderText(null);
				alert.setContentText("Vui lòng chọn một xe trước khi bắt đầu cuộc đua!");
				alert.showAndWait();
			} else {
				int soVangConLai = soVangHienCo - soTienDatCuoc;
				setGoldAmount(soVangConLai);
				CommonFunction.gold -= soTienDatCuoc;
				CommonFunction.betGold = soTienDatCuoc;
				goldAmount_value.setText(Integer.toString(CommonFunction.gold));
				CommonFunction.carID = selectedCar.getId();
				if(CommonFunction.mapID.equals("duongnhua")) {
					mauDuongDua.setText("CHINH PHỤC TƯƠNG LAI");
				} else if (CommonFunction.mapID.equals("duongdat")) {
					mauDuongDua.setText("PHIÊU LƯU BỤI BẶM");
				} else {
					mauDuongDua.setText("CẦU VƯỢT TỬ THẦN");
				}
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
            CommonFunction.playClickSound();

			if (soTienDatCuoc > soVangHienCo) {
				Alert alert = new Alert(AlertType.WARNING,
						"Số vàng vượt quá số vàng hiện tại, Vui lòng nhập lại số vàng đặt cược", ButtonType.OK);
				alert.showAndWait();
			}
		} catch (NumberFormatException e) {
			// Xử lý lỗi nếu người dùng nhập kí tự không phải số
			Alert alert = new Alert(AlertType.ERROR, "Số vàng không hợp lệ!", ButtonType.OK);
			alert.showAndWait();
		}
	}

	// coi lại có bị thừa không.
	@FXML
	private void handleTiepTucItemChoosingButtonAction() {
		try {
            CommonFunction.playClickSound();
			int soTienDatCuoc = Integer.parseInt(nhapTienCuocTextField.getText());
			int soVangHienCo = CommonFunction.gold;
			if (soTienDatCuoc < 100) {
				throw new NumberFormatException();
			}
			if (soTienDatCuoc > soVangHienCo) {
				Alert alert = new Alert(AlertType.WARNING, "Bạn không đủ số vàng để đặt cược!", ButtonType.OK);
				alert.showAndWait();
			} else {
				// Trừ số tiền đặt cược khỏi số tiền hiện có
				int soVangConLai = soVangHienCo - soTienDatCuoc;
				CommonFunction.betGold = soTienDatCuoc;
				setGoldAmount(CommonFunction.gold);
				CommonFunction.gold = soVangConLai;
				
				
				// goldAmount_value.setText(String.valueOf(CommonFunction.gold));

				// Thực thi xử lý tiếp theo tại đây
				// ...
			}
		} catch (NumberFormatException e) {
			// Xử lý lỗi nếu người dùng nhập kí tự không phải số
			Alert alert = new Alert(AlertType.ERROR, "Số vàng không hợp lệ!", ButtonType.OK);
			alert.showAndWait();
		}
	}

	
	public void handleItem_chosing(VBox itemName, int giaTriVatPham, int num) {
	    // Gắn sự kiện click chuột cho VBox "kietSuc"
	    itemName.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent event) {
				try {
	                CommonFunction.playClickSound();
					
					goldAmount_value.setText(String.valueOf(CommonFunction.gold));
					int soVangHienCo = CommonFunction.gold;
					if (soVangHienCo < giaTriVatPham) {
						Alert alert = new Alert(AlertType.WARNING, "Bạn không đủ số vàng để mua vật phẩm này!",
								ButtonType.OK);
						alert.showAndWait();
					} else {
						// Trừ tiền và ẩn VBox

						goldAmount_value.setText(String.valueOf(soVangHienCo - giaTriVatPham));
						CommonFunction.gold -= giaTriVatPham;
						CommonFunction.vatPham[num] = true;
						// Xử lí thêm Vật Phẩm vào mảng.

						itemName.setVisible(false);
					}
				} catch (NumberFormatException e) {
					Alert alert = new Alert(AlertType.ERROR, "Số vàng không hợp lệ!", ButtonType.OK);
					alert.showAndWait();
				}
			}
	    });
	    
	    // Gắn sự kiện mouse entered cho VBox
	    itemName.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent event) {
	        	
	            // Hiển thị thông tin vật phẩm trong Tooltip
	            Tooltip tooltip = new Tooltip("Tên Vật phẩm: Item " + num + "\n"
	                    + "Giá trị: " + giaTriVatPham + "\n"
	                    + "Mô tả: Mô tả vật phẩm " + num);
	            
	            // Thiết lập kiểu font chữ và màu nền của Tooltip
	            tooltip.setStyle("-fx-font-size: 14px;"
	                    + "-fx-background-color: white;"
	                    + "-fx-text-fill: black;");
	            
	            // Hiển thị Tooltip khi chuột di chuyển vào VBox
	            Tooltip.install(itemName, tooltip);
	        }
	    });

		itemName.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// Hiển thị thông tin vật phẩm trong Tooltip
				String tenVatPham = "";
				String moTa = "";
				if (num == 0) {
					// tốc biến
					tenVatPham = "Tốc Biến";
					moTa = "xe của bạn sẽ biến mất khỏi vị trí hiện tại "
							+ "\nxuất hiện lại ở vị trí phía trước trên đường đua. "
							+ "\nItem này giúp bạn rút ngắn khoảng cách so với đối thủ";
				}
				if (num == 1) {
					// tốc hành
					tenVatPham = "Tốc Hành";
					moTa = " xe của bạn sẽ tăng tốc độ";

				}
				if (num == 2) {
					// kiệt sức
					tenVatPham = "Kiệt Sức";
					moTa = " làm cho những xe đối thủ khác giảm tốc độ"
							+ "\ngiúp bạn bảo vệ vị trí của mình \nvà gây khó khăn cho đối thủ";
				}

				Tooltip tooltip = new Tooltip(
						"Tên Vật phẩm:" + tenVatPham + "\n" + "Giá trị: " + giaTriVatPham + "\n" + "Mô tả:" + moTa);

				// Thiết lập kiểu font chữ và màu nền của Tooltip
				tooltip.setStyle("-fx-font-size: 14px;" + "-fx-background-color: white;" + "-fx-text-fill: black;");

				// Hiển thị Tooltip khi chuột di chuyển vào VBox
				Tooltip.install(itemName, tooltip);
			}
		});
	}

	@FXML
	public void vaoKiemTienAction(ActionEvent event) {
        CommonFunction.playClickSound();
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		CommonFunction.stop();
		new minigame(stage);
	}
	





	public void choosableSetUp(ImageView imageView) {
        // Set event handler for mouse hover
        imageView.setOnMouseEntered((MouseEvent event) -> {
            imageView.getScene().setCursor(Cursor.HAND);
        });

        // Set event handler for mouse exit
        imageView.setOnMouseExited((MouseEvent event) -> {
            imageView.getScene().setCursor(Cursor.DEFAULT);
        });
	}
	
	public void choosableSetUp(Button button) {
        // Set event handler for mouse hover
		button.setOnMouseEntered((MouseEvent event) -> {
			button.getScene().setCursor(Cursor.HAND);
        });

        // Set event handler for mouse exit
		button.setOnMouseExited((MouseEvent event) -> {
			button.getScene().setCursor(Cursor.DEFAULT);
        });
	}
	
	public void choosableSetUp(Text text) {
        // Set event handler for mouse hover
		text.setOnMouseEntered((MouseEvent event) -> {
			text.getScene().setCursor(Cursor.HAND);
        });

        // Set event handler for mouse exit
		text.setOnMouseExited((MouseEvent event) -> {
			text.getScene().setCursor(Cursor.DEFAULT);
        });
	}





}
