package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class buyItemMenuController implements Initializable{
	
	@FXML
	protected ImageView tocHanh;
	
	@FXML
    protected ImageView tocBien;
	
	@FXML
    protected ImageView kietSuc;
	
	@FXML
    protected Button backButton;
	
	@FXML
    protected Label tocHanhLabel;
	
	@FXML
    protected Label tocBienLabel;
	
	@FXML
    protected Label kietSucLabel;
	
	Main main = new Main();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	    backButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	            main.com.sceneTransition("betMenu.fxml", event);
	        }
	    });
	    
	    final Tooltip tooltip = new Tooltip();
	    
	    tocHanh.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent event) {
	            // Hide the image view and label
	            tocHanh.setVisible(false);
	            tocHanhLabel.setVisible(false);
	        }
	    });

	    tocBien.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent event) {
	            // Hide the image view and label
	            tocBien.setVisible(false);
	            tocBienLabel.setVisible(false);
	        }
	    });

	    kietSuc.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent event) {
	            // Hide the image view and label
	            kietSuc.setVisible(false);
	            kietSucLabel.setVisible(false);
	        }
	    });

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
		         tooltip.show(tocHanh, bounds.getMinX() + bounds.getWidth(), bounds.getMinY());
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
	            tooltip.show(tocHanh, bounds.getMinX() + bounds.getWidth(), bounds.getMinY());
	        }
	    });
	    kietSuc.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent event) {
	            // Code to hide the image info for tocBien
	        	tooltip.hide();
	        }
	    });
	}

}
