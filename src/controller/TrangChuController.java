package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
<<<<<<< HEAD
import javafx.scene.Cursor;
=======
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Node;
>>>>>>> f72b6e74551b3d8c07d3e501d71ea41583227c15
import javafx.scene.control.Alert;

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
	
	@FXML
    protected ImageView muaVatPhamBackGround;
	

	private Tab selectedMap;
	private Button selectedLength;
	private ImageView selectedCar;

	final String BACKGROUND_PATH = "/img/asset/background_Home.jpg";
	Image bkgImg = new Image(getClass().getResource(BACKGROUND_PATH).toExternalForm());

	public void initialize() {
		HomePage1.setBackground(new javafx.scene.layout.Background(
				new javafx.scene.layout.BackgroundImage(bkgImg, null, null, null, null)));

		HomePage1.toBack();

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
		
<<<<<<< HEAD
		 final Tooltip tooltip = new Tooltip();
		 tocHanh.setOnMouseEntered(new EventHandler<MouseEvent>() {
		        @Override
		        public void handle(MouseEvent event) {
		            tooltip.setText("Tăng tốc 60% trong vòng 3 giây");
		            tooltip.setAutoHide(false);
		            Bounds bounds = tocHanh.localToScreen(tocHanh.getBoundsInLocal());
		            tooltip.show(tocHanh, bounds.getMinX() + bounds.getWidth(), bounds.getMinY());
		        }
		    });

		    tocHanh.setOnMouseExited(new EventHandler<MouseEvent>() {
		        @Override
		        public void handle(MouseEvent event) {
		            tooltip.hide();
		        }
		    });

		    
		    tocBien.setOnMouseEntered(new EventHandler<MouseEvent>() {
		        @Override
		        public void handle(MouseEvent event) {
		        	 tooltip.setText("Dịch chuyển 1 khoảng nhỏ về phía trước");
			         tooltip.setAutoHide(false);
			         Bounds bounds = tocBien.localToScreen(tocBien.getBoundsInLocal());
			         tooltip.show(tocBien, bounds.getMinX() + bounds.getWidth(), bounds.getMinY());
		        }
		    });
		    tocBien.setOnMouseExited(new EventHandler<MouseEvent>() {
		        @Override
		        public void handle(MouseEvent event) {
		            // Code to hide the image info for tocBien
		        	tooltip.hide();
		        }
		    });
		    
		    kietSuc.setOnMouseEntered(new EventHandler<MouseEvent>() {
		        @Override
		        public void handle(MouseEvent event) {
		        	tooltip.setText("Làm chậm mọi kẻ thù đi 30% trong 2 giây");
		            tooltip.setAutoHide(false);
		            Bounds bounds = kietSuc.localToScreen(kietSuc.getBoundsInLocal());
		            tooltip.show(kietSuc, bounds.getMinX() + bounds.getWidth(), bounds.getMinY());
		        }
		    });
		    kietSuc.setOnMouseExited(new EventHandler<MouseEvent>() {
		        @Override
		        public void handle(MouseEvent event) {
		            // Code to hide the image info for tocBien
		        	tooltip.hide();
		        }
		    });
		    
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
		    
		    //Thêm background, logic cho màn hình mua vật phẩm
		    //thêm logic cho thoát game
		    
		    
		    

		    
=======
		playerNameField.setCursor(Cursor.DEFAULT);
		goldAmountField.setCursor(Cursor.DEFAULT);
		
		playerNameField.selectedTextProperty().addListener((observableVal,oldVal,newVal)->{
			playerNameField.deselect();
		});

		goldAmountField.selectedTextProperty().addListener((observableVal,oldVal,newVal)->{
			goldAmountField.deselect();
		});
>>>>>>> f72b6e74551b3d8c07d3e501d71ea41583227c15
	}

	private void handleMapSelection(Tab tab) {
		if (tab.isSelected()) {
			selectedMap = tab;
		}
	}

	private void handleLengthSelection(Button button) {
		selectedLength = button;
	}

	private void handleCarSelection(ImageView carImageView) {
		if (selectedCar != null) {
			// Đặt lại hiệu ứng của xe trước đó (nếu có)
			selectedCar.setEffect(null);
		}

		// Đặt hiệu ứng cho xe đang được chọn
		carImageView.setEffect(new DropShadow(10, Color.YELLOW));

		// Cập nhật biến selectedCar với xe đang được chọn
		selectedCar = carImageView;
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
		int goldAmount = CommonFunction.gold;
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
		if (selectedMap != null && selectedLength != null) {
			String selectedMapId = selectedMap.getId();
			CommonFunction.mapID = selectedMapId;
			String selectedLengthId = selectedLength.getId();
			CommonFunction.mapLength = selectedLengthId;

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
		Car_Choosing.setVisible(false);
		Map_Choosing.setVisible(true);
	}

	@FXML
	private void TiepTuc_ItemChoosing() {
		try {
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
	}
	
<<<<<<< HEAD
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

=======
	@FXML
	public void vaoKiemTienAction(ActionEvent event) {
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		CommonFunction.stop();
		new minigame(stage);
	}
>>>>>>> f72b6e74551b3d8c07d3e501d71ea41583227c15

}
