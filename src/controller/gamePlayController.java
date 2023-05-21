package controller;

import java.net.URL;
import javafx.util.Duration;

import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.property.DoubleProperty;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class gamePlayController implements Initializable {
	@FXML
	private AnchorPane giaoDienAnchorPane;

	@FXML
	private ImageView roadImageView1;

	@FXML
	private ImageView roadImageView2;
	
	@FXML
	private ImageView startingRoadImageView;
	
	@FXML
	private ImageView endingRoadImageView;
	
	@FXML
	private ImageView car1ImageView;
	
	@FXML
	private ImageView car2ImageView;
	
	@FXML
	private ImageView car3ImageView;
	
	@FXML
	private ImageView car4ImageView;
	
	@FXML
	private ImageView tocBienImageView;
	
	@FXML
	private ImageView tocHanhImageView;
	
	@FXML
	private ImageView kietSucImageView;
	

	@FXML
	private Text countdownText;
	private int countdownValue = 3;
	
	private double startTimeroad1 = 0;
	private double startTimeroad2 = 0;
	private double duration_second = 1;
	private double speed = 4;
	private int loop_rounds = 6;
	private int countdown = 4;
	
	private double widthImage = 880;
	private double originalX1;
	private double originalX2;
	private double originalX3;
	private double originalX4;
	private Random random = new Random();
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		// Load the road image
		Image roadImage1 = new Image(getClass().getResourceAsStream("/img/map/map2.jpg"));
		Image roadImage2 = new Image(getClass().getResourceAsStream("/img/map/map3.jpg"));
		Image startingroadImage = new Image(getClass().getResourceAsStream("/img/map/startingmap.jpg"));
		Image endingroadImage = new Image(getClass().getResourceAsStream("/img/map/endingmap.jpg"));
		Image car1Image = new Image(getClass().getResourceAsStream("/img/asset/car1.png"));
		Image tocBienImage = new Image(getClass().getResourceAsStream("/img/asset/TocBien.jpg"));
		Image tocHanhImage = new Image(getClass().getResourceAsStream("/img/asset/TocHanh.jpg"));
		Image kietSucImage = new Image(getClass().getResourceAsStream("/img/asset/KietSuc.jpg"));
		roadImageView1.setImage(roadImage1);
		roadImageView2.setImage(roadImage2);
		startingRoadImageView.setImage(startingroadImage);
		endingRoadImageView.setImage(endingroadImage);
		car1ImageView.setImage(car1Image);
		car2ImageView.setImage(car1Image);
		car3ImageView.setImage(car1Image);
		car4ImageView.setImage(car1Image);
		tocBienImageView.setImage(tocBienImage);
		tocHanhImageView.setImage(tocHanhImage);
		kietSucImageView.setImage(kietSucImage);
		roadImageView2.setVisible(false);
		endingRoadImageView.setVisible(false);
		
		CommonFunction.vatPham[1] = true;
		CommonFunction.vatPham[0] = true;
		CommonFunction.vatPham[2] = true;
		
		checkVatPhamStatus();

		
		
		
		
		
		
		Timeline starttimeline = new Timeline();

		// Configure the first KeyFrame
		KeyFrame startstartKeyFrame = new KeyFrame(Duration.ZERO,
		        new KeyValue(startingRoadImageView.translateXProperty(), 0)); // Start from the right edge of the pane
		starttimeline.getKeyFrames().add(startstartKeyFrame);

		// Configure the second KeyFrame
		KeyFrame endstartKeyFrame = new KeyFrame(Duration.seconds(duration_second * speed - 0.4),
		        new KeyValue(startingRoadImageView.translateXProperty(), -widthImage * 2 ),
		        new KeyValue(startingRoadImageView.translateXProperty(), -widthImage * 2,
		                Interpolator.EASE_IN)); // Move to the left edge of the pane with increasing speed
		starttimeline.getKeyFrames().add(endstartKeyFrame);

		// Create a timeline with two KeyFrames



		
		
		
		Timeline timeline = new Timeline();

		// Configure the first KeyFrame
		KeyFrame startKeyFrame = new KeyFrame(Duration.ZERO,
		        new KeyValue(roadImageView1.translateXProperty(), widthImage)); // Start from the right edge of the pane
		timeline.getKeyFrames().add(startKeyFrame);

		// Configure the second KeyFrame
		KeyFrame endKeyFrame = new KeyFrame(Duration.seconds(duration_second * speed),
		        new KeyValue(roadImageView1.translateXProperty(), -widthImage)); // Move to the left edge of the pane
		timeline.getKeyFrames().add(endKeyFrame);
		
		
		
		
		startTimeroad1 = countdown + (duration_second * speed) / 2;
		// Create and configure the second timeline for roadImageView2
		PauseTransition delay = new PauseTransition(Duration.seconds(startTimeroad1));
		Timeline timeline2 = new Timeline();
		KeyFrame startKeyFrame2 = new KeyFrame(Duration.ZERO,
		        new KeyValue(roadImageView2.translateXProperty(), widthImage)); // Start from the right edge of the pane
		timeline2.getKeyFrames().add(startKeyFrame2);
		KeyFrame endKeyFrame2 = new KeyFrame(Duration.seconds(duration_second * speed),
		        new KeyValue(roadImageView2.translateXProperty(), -widthImage)); // Move to the left edge of the pane
		timeline2.getKeyFrames().add(endKeyFrame2);
		
		
		
		
		startTimeroad2 = countdown + duration_second * speed * loop_rounds;
		PauseTransition enddelay = new PauseTransition(Duration.seconds(startTimeroad2));
		Timeline endtimeline = new Timeline();

		// Configure the first KeyFrame
		KeyFrame startendKeyFrame = new KeyFrame(Duration.ZERO,
		        new KeyValue(endingRoadImageView.translateXProperty(), widthImage)); // Start from the right edge of the pane
		endtimeline.getKeyFrames().add(startendKeyFrame);

		// Configure the second KeyFrame
		KeyFrame endendKeyFrame = new KeyFrame(Duration.seconds(duration_second * speed / 2),
		        new KeyValue(endingRoadImageView.translateXProperty(), 0)); // Move to the left edge of the pane
		endtimeline.getKeyFrames().add(endendKeyFrame);
		
		
		countdownText.setText(String.valueOf(countdownValue));
	    countdownText.getStyleClass().add("countdown-text");
	    
	    

	    Timeline countdownTimeline = new Timeline();
	    KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
	        countdownValue--;
	        if (countdownValue >= 1) {
	            countdownText.setText(String.valueOf(countdownValue));
	        } else if (countdownValue == 0) {
	            countdownText.setText("Start");
	        } else {
	            countdownTimeline.stop();
	            countdownText.setVisible(false);
	        }
	    });
	    countdownTimeline.getKeyFrames().add(keyFrame);
	    countdownTimeline.setCycleCount(Timeline.INDEFINITE);
//	    PauseTransition initialDelay = new PauseTransition(Duration.seconds(3));
//	    initialDelay.setOnFinished(event -> {
//	        countdownTimeline.play();
//	    });
//
//	    initialDelay.play();
	    
	    
	    originalX1 = car1ImageView.getTranslateX();
	    originalX2 = car2ImageView.getTranslateX();
	    originalX3 = car3ImageView.getTranslateX();
	    originalX4 = car4ImageView.getTranslateX();

	    TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.8), car1ImageView);
	    TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(1.2), car2ImageView);
	    TranslateTransition translateTransition3 = new TranslateTransition(Duration.seconds(1.1), car3ImageView);
	    TranslateTransition translateTransition4 = new TranslateTransition(Duration.seconds(1), car4ImageView);
	    
//	    randomSpeed(originalX1,translateTransition1);
//	    randomSpeed(originalX2,translateTransition2);
//	    randomSpeed(originalX3,translateTransition3);
//	    randomSpeed(originalX4,translateTransition4);
	    //translateTransition.setAutoReverse(true);
	    
	    

	    

	    car1ImageView.setTranslateX(originalX1);
	    car2ImageView.setTranslateX(originalX2);
	    car3ImageView.setTranslateX(originalX3);
	    car4ImageView.setTranslateX(originalX4);// Set the initial X position

	    translateTransition1.setOnFinished(event -> {
	        double newX;
	        if (originalX1 <=0) {
	            newX = originalX1 + random.nextDouble() * 150; // Add random value
	        } 
	        else if(random.nextBoolean()) {
	            newX = originalX1 - random.nextDouble() * 150; // Subtract random value
	        }
	        else{
	        	newX = originalX1 + random.nextDouble() * 150;
	        	// Generate a random X position
	        }
	        originalX1 = newX;
	        if(newX<0) {
	        	newX = 20;
	        }
	        translateTransition1.setToX(newX);
	        
	        // Update the originalX property with the new value
	        
	        translateTransition1.setDuration(Duration.seconds(random.nextInt(3) + 1));
	        translateTransition1.play();
	    });
	    
	    translateTransition2.setOnFinished(event -> {
	    	double newX;
	        if (originalX2 <=0) {
	            newX = originalX2 + random.nextDouble() * 150; // Add random value
	        } 
	        else if(random.nextBoolean()) {
	            newX = originalX2 - random.nextDouble() * 150; // Subtract random value
	        }
	        else{
	        	newX = originalX2 + random.nextDouble() * 150;
	        	// Generate a random X position
	        }
	        originalX2 = newX;
	        if(newX<=0) {
	        	newX = 50;
	        }
	        translateTransition2.setToX(newX);
	        
	        // Update the originalX property with the new value
	        
	        translateTransition2.setDuration(Duration.seconds(random.nextInt(2) + 1));
	        translateTransition2.play();
	    });
	    
	    translateTransition3.setOnFinished(event -> {
	    	double newX;
	        if (originalX3 <=0) {
	            newX = originalX3 + random.nextDouble() * 150; // Add random value
	        } 
	        else if(random.nextBoolean()) {
	            newX = originalX3 - random.nextDouble() * 150; // Subtract random value
	        }
	        else{
	        	newX = originalX3 + random.nextDouble() * 150;
	        	// Generate a random X position
	        }
	        originalX3 = newX;
	        if(newX<=0) {
	        	newX = 50;
	        }
	        translateTransition3.setToX(newX);
	        
	        // Update the originalX property with the new value
	        
	        translateTransition3.setDuration(Duration.seconds(random.nextInt(2) + 1));
	        translateTransition3.play();
	    });
	    
	    translateTransition4.setOnFinished(event -> {
	    	double newX;
	        if (originalX4 <=0) {
	            newX = originalX4 + random.nextDouble() * 150; // Add random value
	        } 
	        else if(random.nextBoolean()) {
	            newX = originalX4 - random.nextDouble() * 150; // Subtract random value
	        }
	        else{
	        	newX = originalX4 + random.nextDouble() * 150;
	        	// Generate a random X position
	        }
	        originalX4 = newX;
	        if(newX<=0) {
	        	newX = 50;
	        }
	        translateTransition4.setToX(newX);
	        
	        // Update the originalX property with the new value
	        
	        translateTransition4.setDuration(Duration.seconds(random.nextInt(2) + 1));
	        translateTransition4.play();
	    });
	    
	    
	    




	    







		
		
		starttimeline.setCycleCount(1); 
		endtimeline.setCycleCount(1);
		timeline.setCycleCount(loop_rounds); 
		timeline2.setCycleCount(loop_rounds);

		countdownTimeline.play();
		PauseTransition countdownBeforeStart = new PauseTransition(Duration.seconds(countdown));
		countdownBeforeStart.setOnFinished(event -> {
			starttimeline.play();
			timeline.play();
			translateTransition1.play();
		    translateTransition2.play();
		    translateTransition3.play();
		    translateTransition4.play();
		});
		delay.setOnFinished(event -> {
			roadImageView2.setVisible(true);
		    timeline2.play();
		});
		enddelay.setOnFinished(event -> {
			endingRoadImageView.setVisible(true);
		    endtimeline.play();
		});
		endtimeline.setOnFinished(event -> {
			translateTransition1.stop();
		    translateTransition2.stop();
		    translateTransition3.stop();
		    translateTransition4.stop();
		});
		countdownBeforeStart.play();
		delay.play();
		enddelay.play();
		
		vatPhamImageViewSetUp(tocBienImageView);
		vatPhamImageViewSetUp(tocHanhImageView);
		vatPhamImageViewSetUp(kietSucImageView);
		
	
		tocBienImageView.setOnMouseClicked((MouseEvent event) -> {
			translateTransition1.stop(); // Stop the current transition
		    double currentX = car1ImageView.getTranslateX(); // Get the current X position
	    	double newX = currentX + 100;
	    	car1ImageView.setTranslateX(newX);
	    	originalX1 = newX;

	        
	        translateTransition1.setDuration(Duration.seconds(0));
	        translateTransition1.play();
        });
		
		tocHanhImageView.setOnMouseClicked((MouseEvent mouseevent) -> {
			translateTransition1.stop(); // Stop the current transition
		    double currentX = car1ImageView.getTranslateX(); // Get the current X position
	    	double newX = currentX + 120;
	    	TranslateTransition newTransition = new TranslateTransition(Duration.seconds(3), car1ImageView);
	    	originalX1 = newX;
	        newTransition.setToX(newX);
	        newTransition.play();
	        newTransition.setOnFinished(event -> {
	            translateTransition1.setDuration(Duration.seconds(0));
	            translateTransition1.play();
	        });
        });
		
		kietSucImageView.setOnMouseClicked((MouseEvent mouseevent) -> {
			translateTransition2.stop();
			translateTransition3.stop();
			translateTransition4.stop();// Stop the current transition// Get the current X position
	    	double newX2 = originalX2 - 80;
	    	double newX3 = originalX3 - 80;
	    	double newX4 = originalX4 - 80;
	    	TranslateTransition newTransition2 = new TranslateTransition(Duration.seconds(1), car2ImageView);
	    	TranslateTransition newTransition3 = new TranslateTransition(Duration.seconds(1), car3ImageView);
	    	TranslateTransition newTransition4 = new TranslateTransition(Duration.seconds(1), car4ImageView);
	    	
	    	originalX2 = newX2;
	    	originalX3 = newX3;
	    	originalX4 = newX4;
	    	
	        newTransition2.setToX(newX2);
	        newTransition3.setToX(newX3);
	        newTransition4.setToX(newX4);
	        
	        newTransition2.play();
	        newTransition3.play();
	        newTransition4.play();
	        newTransition2.setOnFinished(event -> {
	            translateTransition2.setDuration(Duration.seconds(0));
	            translateTransition2.play();
	        });
	        newTransition3.setOnFinished(event -> {
	            translateTransition3.setDuration(Duration.seconds(0));
	            translateTransition3.play();
	        });
	        newTransition4.setOnFinished(event -> {
	            translateTransition4.setDuration(Duration.seconds(0));
	            translateTransition4.play();
	        });
        });
	}
	
//	public void randomSpeed(double originalXProperty, TranslateTransition translateTransition) {
//	    translateTransition.setOnFinished(event -> {
//	        double originalX = originalXProperty.get(); // Get the current value of originalX
//	        double newX;
//	        if (random.nextBoolean()) {
//	            newX = originalX + random.nextDouble() * 100; // Add random value
//	        } else {
//	            newX = originalX - random.nextDouble() * 100; // Subtract random value
//	        } // Generate a random X position
//	        
//	        if (newX > originalX) {
//	            translateTransition.setToX(newX - originalX); // Move forward
//	        } else {
//	            translateTransition.setToX(originalX - newX); // Move backward
//	        }
//	        
//	        // Update the originalX property with the new value
//	        originalXProperty.set(newX);
//	        
//	        translateTransition.setDuration(Duration.seconds(random.nextInt(3) + 1));
//	        translateTransition.play();
//	    });
//	}
	
	public double getOriginalX1() {
		return originalX1;
	}

	public void setOriginalX1(double originalX1) {
		this.originalX1 = originalX1;
	}

	public double getOriginalX2() {
		return originalX2;
	}

	public void setOriginalX2(double originalX2) {
		this.originalX2 = originalX2;
	}

	public double getOriginalX3() {
		return originalX3;
	}

	public void setOriginalX3(double originalX3) {
		this.originalX3 = originalX3;
	}

	public double getOriginalX4() {
		return originalX4;
	}

	public void setOriginalX4(double originalX4) {
		this.originalX4 = originalX4;
	}

	public void useItem(double originalX, TranslateTransition translateTransition, int item, ImageView imageView) {
	    if(item == 1) {
	    	

	    }
	    
	    if(item == 2) {
	    	translateTransition.stop(); // Stop the current transition
		    double currentX = imageView.getTranslateX(); // Get the current X position
	    	double newX = currentX + 150;
	    	TranslateTransition newTransition = new TranslateTransition(Duration.seconds(3), imageView);
	        newTransition.setToX(newX);
	        newTransition.play();
	        newTransition.setOnFinished(event -> {
	            translateTransition.setDuration(Duration.seconds(random.nextInt(3) + 1));
	            translateTransition.play();
	        });
	    }
	    
	    if(item == 3) {
	    	translateTransition.stop(); // Stop the current transition
		    double currentX = imageView.getTranslateX(); // Get the current X position
	    	double newX = currentX - 50;
	    	TranslateTransition newTransition = new TranslateTransition(Duration.seconds(2), imageView);
	        newTransition.setToX(newX);
	        newTransition.play();
	        newTransition.setOnFinished(event -> {
	            translateTransition.setDuration(Duration.seconds(random.nextInt(3) + 1));
	            translateTransition.play();
	        });
	    }
		
	}
	
	public void vatPhamImageViewSetUp(ImageView imageView) {
        // Set event handler for mouse hover
        imageView.setOnMouseEntered((MouseEvent event) -> {
            imageView.getScene().setCursor(Cursor.HAND);
        });

        // Set event handler for mouse exit
        imageView.setOnMouseExited((MouseEvent event) -> {
            imageView.getScene().setCursor(Cursor.DEFAULT);
        });
	}
	
	public void checkVatPhamStatus() {
		if(CommonFunction.vatPham[0] == false) {
			tocBienImageView.setDisable(true);
		}
		else {
			tocBienImageView.setDisable(false);
		}
		
		if(CommonFunction.vatPham[1] == false) {
			tocHanhImageView.setDisable(true);
		}
		else {
			tocHanhImageView.setDisable(false);
		}
		
		if(CommonFunction.vatPham[2] == false) {
			kietSucImageView.setDisable(true);
		}
		else {
			kietSucImageView.setDisable(false);
		}
	}

}
