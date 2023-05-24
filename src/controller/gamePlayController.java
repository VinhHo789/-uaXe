package controller;

import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
	private ImageView car5ImageView;
	
	@FXML
	private ImageView tocBienImageView;
	
	@FXML
	private ImageView tocHanhImageView;
	
	@FXML
	private ImageView kietSucImageView;
	
	@FXML
	private ImageView firstCarPositionImageView;
	
	@FXML
	private ImageView secondCarPositionImageView;
	
	@FXML
	private ImageView thirdCarPositionImageView;
	
	@FXML
	private Text firstText;
	
	@FXML
	private Text secondtext;
	
	@FXML
	private Text thirdText;

	@FXML
	private Text countdownText;
	private int countdownValue = 3;
	@FXML
	private ImageView podiumImageView;
	
	@FXML
	private ImageView podiumFirstPlaceImageView;
	
	@FXML
	private ImageView podiumSecondPlaceImageView;
	
	@FXML
	private ImageView podiumThirdPlaceImageView;
	
	@FXML
	private AnchorPane podiumAnchorPane;
	
	@FXML
	private AnchorPane thongTinAnchorPane;
	
	@FXML
	private Text soTienAnDuocText;
	
	@FXML
	private Text soTienHienCoText;
	
	@FXML
	private Text thongBaoText;
	
	@FXML
	private Button tiepTucChoiButton;
	
	@FXML
	private Button thoatGameButton;
	
	
	private double startTimeroad1 = 0;
	private double startTimeroad2 = 0;
	private double duration_second = 1;
	private double speed = 4;
	private int loop_rounds = 1;
	private int countdown = 4;
	
	private double widthImage = 880;
	private double originalX1;
	private double originalX2;
	private double originalX3;
	private double originalX4;
	private double originalX5;
	
	private Number currentX1;
	private Number currentX2;
	private Number currentX3;
	private Number currentX4;
	private Number currentX5;
	private double randomSpeed = 100;
	ColorAdjust fadeEffect = new ColorAdjust();
     // Set saturation to 0 for grayscale effect
	private Random random = new Random();
	
	
	Image car1Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car1.png"));
	Image car2Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car2.png"));
	Image car3Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car3.png"));
	Image car4Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car4.png"));
	Image car5Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car5.png"));
	Image tocBienImage = new Image(getClass().getResourceAsStream("/img/asset/TocBien.jpg"));
	Image tocHanhImage = new Image(getClass().getResourceAsStream("/img/asset/TocHanh.jpg"));
	Image kietSucImage = new Image(getClass().getResourceAsStream("/img/asset/KietSuc.jpg"));

	Image podiumImage = new Image(getClass().getResourceAsStream("/img/asset/podium.png"));
	
	
	Map<Double, ImageView> carMap = new TreeMap<>(Comparator.reverseOrder());
	private double[] xepHang = new double[5];
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		// Load the road image
		
		Image roadImage1 = new Image(getClass().getResourceAsStream("/img/map/map2.jpg"));
		Image roadImage2 = new Image(getClass().getResourceAsStream("/img/map/map3.jpg"));
		Image startingroadImage = new Image(getClass().getResourceAsStream("/img/map/startingmap.jpg"));
		Image endingroadImage = new Image(getClass().getResourceAsStream("/img/map/endingmap.jpg"));
		roadImageView1.setImage(roadImage1);
		roadImageView2.setImage(roadImage2);
		startingRoadImageView.setImage(startingroadImage);
		endingRoadImageView.setImage(endingroadImage);
		car1ImageView.setImage(car1Image);
		car2ImageView.setImage(car2Image);
		car3ImageView.setImage(car3Image);
		car4ImageView.setImage(car4Image);
		car5ImageView.setImage(car5Image);
		tocBienImageView.setImage(tocBienImage);
		tocHanhImageView.setImage(tocHanhImage);
		kietSucImageView.setImage(kietSucImage);
		podiumImageView.setImage(podiumImage);
		
		
		roadImageView2.setVisible(false);
		endingRoadImageView.setVisible(false);
		podiumAnchorPane.setVisible(false);
		thongTinAnchorPane.setVisible(false);
		CommonFunction.vatPham[1] = true;
		CommonFunction.vatPham[0] = true;
		CommonFunction.vatPham[2] = true;
		checkVatPhamStatus();
		tocBienImageView.setDisable(true);
		tocHanhImageView.setDisable(true);
		kietSucImageView.setDisable(true);
		fadeEffect.setBrightness(-0.7); // Adjust the brightness value as desired
	    fadeEffect.setSaturation(0.0);
		
		

		
		
		
		
		
		
		Timeline starttimeline = new Timeline();

		// Configure the first KeyFrame
		KeyFrame startstartKeyFrame = new KeyFrame(Duration.ZERO,
		        new KeyValue(startingRoadImageView.translateXProperty(), 0)); // Start from the right edge of the pane
		starttimeline.getKeyFrames().add(startstartKeyFrame);

		// Configure the second KeyFrame
		KeyFrame endstartKeyFrame = new KeyFrame(Duration.seconds(duration_second * speed ),
		        new KeyValue(startingRoadImageView.translateXProperty(), -widthImage * 2 )); // Move to the left edge of the pane with increasing speed
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
	    originalX5 = car5ImageView.getTranslateX();
	    
	    TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), car1ImageView);
	    TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), car2ImageView);
	    TranslateTransition translateTransition3 = new TranslateTransition(Duration.seconds(0.5), car3ImageView);
	    TranslateTransition translateTransition4 = new TranslateTransition(Duration.seconds(0.5), car4ImageView);
	    TranslateTransition translateTransition5 = new TranslateTransition(Duration.seconds(0.5), car5ImageView);

	    translateTransition1.setToX(50);
	    translateTransition2.setToX(40);
	    translateTransition3.setToX(20);
	    translateTransition4.setToX(30);
	    translateTransition5.setToX(50);
	    

	    car1ImageView.setTranslateX(originalX1);
	    car2ImageView.setTranslateX(originalX2);
	    car3ImageView.setTranslateX(originalX3);
	    car4ImageView.setTranslateX(originalX4);// Set the initial X position
	    car5ImageView.setTranslateX(originalX5);// Set the initial X position

	    translateTransition1.setOnFinished(event -> {
	        double newX;
	        if (originalX1 <=0) {
	            newX = originalX1 + random.nextDouble() * randomSpeed; // Add random value
	        } 
	        else if(random.nextBoolean()) {
	            newX = originalX1 - random.nextDouble() * randomSpeed; // Subtract random value
	        }
	        else{
	        	newX = originalX1 + random.nextDouble() * randomSpeed;
	        	// Generate a random X position
	        }
	        originalX1 = newX;
	        if(newX<0) {
	        	newX = 40;
	        }
	        translateTransition1.setToX(newX);
	        
	        // Update the originalX property with the new value
	        
	        translateTransition1.setDuration(Duration.seconds(random.nextInt(3) + 1));
	        translateTransition1.play();
	    });
	    
	    translateTransition2.setOnFinished(event -> {
	    	double newX;
	        if (originalX2 <=0) {
	            newX = originalX2 + random.nextDouble() * randomSpeed; // Add random value
	        } 
	        else if(random.nextBoolean()) {
	            newX = originalX2 - random.nextDouble() * randomSpeed; // Subtract random value
	        }
	        else{
	        	newX = originalX2 + random.nextDouble() * randomSpeed;
	        	// Generate a random X position
	        }
	        originalX2 = newX;
	        if(newX<=0) {
	        	newX = 20;
	        }
	        translateTransition2.setToX(newX);
	        
	        // Update the originalX property with the new value
	        
	        translateTransition2.setDuration(Duration.seconds(random.nextInt(3) + 1));
	        translateTransition2.play();
	    });
	    
	    translateTransition3.setOnFinished(event -> {
	    	double newX;
	        if (originalX3 <=0) {
	            newX = originalX3 + random.nextDouble() * randomSpeed; // Add random value
	        } 
	        else if(random.nextBoolean()) {
	            newX = originalX3 - random.nextDouble() * randomSpeed; // Subtract random value
	        }
	        else{
	        	newX = originalX3 + random.nextDouble() * randomSpeed;
	        	// Generate a random X position
	        }
	        originalX3 = newX;
	        if(newX<=0) {
	        	newX = 30;
	        }
	        translateTransition3.setToX(newX);
	        
	        // Update the originalX property with the new value
	        
	        translateTransition3.setDuration(Duration.seconds(random.nextInt(3) + 1));
	        translateTransition3.play();
	    });
	    
	    translateTransition4.setOnFinished(event -> {
	    	double newX;
	        if (originalX4 <=0) {
	            newX = originalX4 + random.nextDouble() * randomSpeed; // Add random value
	        } 
	        else if(random.nextBoolean()) {
	            newX = originalX4 - random.nextDouble() * randomSpeed; // Subtract random value
	        }
	        else{
	        	newX = originalX4 + random.nextDouble() * randomSpeed;
	        	// Generate a random X position
	        }
	        originalX4 = newX;
	        if(newX<=0) {
	        	newX = 10;
	        }
	        translateTransition4.setToX(newX);
	        
	        // Update the originalX property with the new value
	        
	        translateTransition4.setDuration(Duration.seconds(random.nextInt(3) + 1));
	        translateTransition4.play();
	    });
	    
	    translateTransition5.setOnFinished(event -> {
	    	double newX;
	        if (originalX5 <=0) {
	            newX = originalX5 + random.nextDouble() * randomSpeed; // Add random value
	        } 
	        else if(random.nextBoolean()) {
	            newX = originalX5 - random.nextDouble() * randomSpeed; // Subtract random value
	        }
	        else{
	        	newX = originalX5 + random.nextDouble() * randomSpeed;
	        	// Generate a random X position
	        }
	        originalX5 = newX;
	        if(newX<=0) {
	        	newX = 20;
	        }
	        translateTransition5.setToX(newX);
	        
	        // Update the originalX property with the new value
	        
	        translateTransition5.setDuration(Duration.seconds(random.nextInt(3) + 1));
	        translateTransition5.play();
	    });
	    
	    
	    
	    car1ImageView.translateXProperty().addListener((obs, oldValue, newValue) -> {
	        currentX1 = newValue.doubleValue();
	        updatePlaceImageViews();

	    });

	    // Listener for car2ImageView position
	    car2ImageView.translateXProperty().addListener((obs, oldValue, newValue) -> {
	        currentX2 = newValue;
	        updatePlaceImageViews();
	    });

	    // Listener for car3ImageView position
	    car3ImageView.translateXProperty().addListener((obs, oldValue, newValue) -> {
	        currentX3 = newValue;
	        updatePlaceImageViews();
	    });

	    // Listener for car4ImageView position
	    car4ImageView.translateXProperty().addListener((obs, oldValue, newValue) -> {
	        currentX4 = newValue;
	        updatePlaceImageViews();
	    });

	    // Listener for car5ImageView position
	    car5ImageView.translateXProperty().addListener((obs, oldValue, newValue) -> {
	        currentX5 = newValue;
	        updatePlaceImageViews();
	    });

	    
	    TranslateTransition endTranslateTransition1 = new TranslateTransition(Duration.seconds(1), car1ImageView);
	    TranslateTransition endTranslateTransition2 = new TranslateTransition(Duration.seconds(1), car2ImageView);
	    TranslateTransition endTranslateTransition3 = new TranslateTransition(Duration.seconds(1), car3ImageView);
	    TranslateTransition endTranslateTransition4 = new TranslateTransition(Duration.seconds(1), car4ImageView);
	    TranslateTransition endTranslateTransition5 = new TranslateTransition(Duration.seconds(1), car5ImageView);
	    
	    double initialDuration = 3.0; // Initial duration of the transition in seconds
	    double decelerationRate = 0.8; // Rate at which the transition slows down
	    Interpolator deceleratingInterpolator = new Interpolator() {
	        @Override
	        protected double curve(double t) {
	            return 1 - Math.pow(1 - t, decelerationRate);
	        }
	    };
	    endTranslateTransition1.setInterpolator(deceleratingInterpolator);
	    endTranslateTransition2.setInterpolator(deceleratingInterpolator);
	    endTranslateTransition3.setInterpolator(deceleratingInterpolator);
	    endTranslateTransition4.setInterpolator(deceleratingInterpolator);
	    endTranslateTransition5.setInterpolator(deceleratingInterpolator);
	    
	    
	    GaussianBlur blur = new GaussianBlur(10);
	    




	    







		
		
		starttimeline.setCycleCount(1); 
		endtimeline.setCycleCount(1);
		timeline.setCycleCount(loop_rounds); 
		timeline2.setCycleCount(loop_rounds);

		countdownTimeline.play();
		PauseTransition countdownBeforeStart = new PauseTransition(Duration.seconds(countdown));
		countdownBeforeStart.setOnFinished(event -> {
			checkVatPhamStatus();
			starttimeline.play();
			timeline.play();
			translateTransition1.play();
		    translateTransition2.play();
		    translateTransition3.play();
		    translateTransition4.play();
		    translateTransition5.play();
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
		    translateTransition5.stop();
		    endTranslateTransition1.setToX(currentX1.doubleValue()+ 200);
		    endTranslateTransition2.setToX(currentX2.doubleValue()+ 200);
		    endTranslateTransition3.setToX(currentX3.doubleValue()+ 200);
		    endTranslateTransition4.setToX(currentX4.doubleValue()+ 200);
		    endTranslateTransition5.setToX(currentX5.doubleValue()+ 200);
		    endTranslateTransition1.play();
		    endTranslateTransition2.play();
		    endTranslateTransition3.play();
		    endTranslateTransition4.play();
		    endTranslateTransition5.play();
		    endTranslateTransition1.setOnFinished(endevent -> {
		    	translateTransition1.stop();
			    translateTransition2.stop();
			    translateTransition3.stop();
			    translateTransition4.stop();
			    translateTransition5.stop();
		    	giaoDienAnchorPane.setEffect(blur);
		    	podiumAnchorPane.setVisible(true);
		    	podiumAnchorPane.toFront();
		    	setPodiumPlaceImageViews();
		    	thongTinAnchorPane.setVisible(true);
		    	thongTinAnchorPane.setStyle("-fx-background-color: white;");
		    	thongTinAnchorPane.setOpacity(0.8);
		    	thongTinAnchorPane.toFront();
		    	
		    	
		    });
		});
		countdownBeforeStart.play();
		delay.play();
		enddelay.play();
		
		vatPhamImageViewSetUp(tocBienImageView);
		vatPhamImageViewSetUp(tocHanhImageView);
		vatPhamImageViewSetUp(kietSucImageView);
		
		tocBienImageView.disableProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
            	tocBienImageView.setEffect(fadeEffect);
            } else {
            	tocBienImageView.setEffect(null); // Clear the effect when enabled
            }
        });
		
		tocHanhImageView.disableProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
            	tocHanhImageView.setEffect(fadeEffect);
            } else {
            	tocHanhImageView.setEffect(null); // Clear the effect when enabled
            }
        });
		
		kietSucImageView.disableProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
            	kietSucImageView.setEffect(fadeEffect);
            } else {
            	kietSucImageView.setEffect(null); // Clear the effect when enabled
            }
        });
		tocBienImageView.setOnMouseClicked((MouseEvent event) -> {
			tocBienImageView.setDisable(true);
			translateTransition1.stop(); // Stop the current transition
		    double currentX = car1ImageView.getTranslateX(); // Get the current X position
	    	double newX = currentX + 100;
	    	car1ImageView.setTranslateX(newX);
	    	originalX1 = newX;

	        
	        translateTransition1.setDuration(Duration.seconds(0));
	        translateTransition1.play();
        });
		
		tocHanhImageView.setOnMouseClicked((MouseEvent mouseevent) -> {
			tocHanhImageView.setDisable(true);
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
			kietSucImageView.setDisable(true);
			translateTransition2.stop();
			translateTransition3.stop();
			translateTransition4.stop();
			translateTransition5.stop();// Stop the current transition// Get the current X position
	    	double newX2 = originalX2 - 80;
	    	double newX3 = originalX3 - 80;
	    	double newX4 = originalX4 - 80;
	    	double newX5 = originalX5 - 80;
	    	TranslateTransition newTransition2 = new TranslateTransition(Duration.seconds(1), car2ImageView);
	    	TranslateTransition newTransition3 = new TranslateTransition(Duration.seconds(1), car3ImageView);
	    	TranslateTransition newTransition4 = new TranslateTransition(Duration.seconds(1), car4ImageView);
	    	TranslateTransition newTransition5 = new TranslateTransition(Duration.seconds(1), car5ImageView);
	    	
	    	originalX2 = newX2;
	    	originalX3 = newX3;
	    	originalX4 = newX4;
	    	originalX5 = newX5;
	        newTransition2.setToX(newX2);
	        newTransition3.setToX(newX3);
	        newTransition4.setToX(newX4);
	        newTransition5.setToX(newX5);
	        
	        
	        newTransition2.play();
	        newTransition3.play();
	        newTransition4.play();
	        newTransition5.play();
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
	        newTransition5.setOnFinished(event -> {
	            translateTransition5.setDuration(Duration.seconds(0));
	            translateTransition5.play();
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
		fadeEffect.setBrightness(-0.7); // Adjust the brightness value as desired
	    fadeEffect.setSaturation(0.0);
		if(CommonFunction.vatPham[0] == false) {
			tocBienImageView.setDisable(true);
			tocBienImageView.setEffect(fadeEffect);
		}
		else {
			tocBienImageView.setDisable(false);
		}
		
		if(CommonFunction.vatPham[1] == false) {
			tocHanhImageView.setDisable(true);
			tocHanhImageView.setEffect(fadeEffect);
		}
		else {
			tocHanhImageView.setDisable(false);
		}
		
		if(CommonFunction.vatPham[2] == false) {
			kietSucImageView.setDisable(true);
			kietSucImageView.setEffect(fadeEffect);
		}
		else {
			kietSucImageView.setDisable(false);
		}
	}
	
	
	
	private void updatePlaceImageViews() {
		List<ImageView> placeImageViews = Arrays.asList(firstCarPositionImageView, secondCarPositionImageView, thirdCarPositionImageView);

	    // Create a list of the ImageView objects
	    List<ImageView> carImageViews = Arrays.asList(car1ImageView, car2ImageView, car3ImageView, car4ImageView, car5ImageView);

	    // Sort the carImageViews based on the currentX values in descending order
	    carImageViews.sort(Comparator.comparingDouble(ImageView::getTranslateX).reversed());

	    // Clear the placeImageViews
	    for (ImageView imageView : placeImageViews) {
	        imageView.setImage(null);
	    }

	    // Update the placeImageViews with the top three carImageViews
	    for (int i = 0; i < Math.min(carImageViews.size(), placeImageViews.size()); i++) {
	        ImageView carImageView = carImageViews.get(i);
	        ImageView placeImageView = placeImageViews.get(i);
	        placeImageView.setImage(carImageView.getImage());
	    }
	}
	
	private void setPodiumPlaceImageViews() {
		List<ImageView> placeImageViews = Arrays.asList(podiumFirstPlaceImageView, podiumSecondPlaceImageView, podiumThirdPlaceImageView);

	    // Create a list of the ImageView objects
	    List<ImageView> carImageViews = Arrays.asList(car1ImageView, car2ImageView, car3ImageView, car4ImageView, car5ImageView);

	    // Sort the carImageViews based on the currentX values in descending order
	    carImageViews.sort(Comparator.comparingDouble(ImageView::getTranslateX).reversed());

	    // Clear the placeImageViews
	    for (ImageView imageView : placeImageViews) {
	        imageView.setImage(null);
	    }

	    // Update the placeImageViews with the top three carImageViews
	    for (int i = 0; i < Math.min(carImageViews.size(), placeImageViews.size()); i++) {
	        ImageView carImageView = carImageViews.get(i);
	        ImageView placeImageView = placeImageViews.get(i);
	        placeImageView.setImage(carImageView.getImage());
	    }
	    
	    if (carImageViews.get(0) == car1ImageView) {
	        thongBaoText.setText("Chúc mừng, bạn đã về nhất và chiến thắng!");
	        soTienAnDuocText.setText("Tien cuoc * 4");
	    } else if(carImageViews.get(1) == car1ImageView){
	        thongBaoText.setText("Rất tiếc, bạn đã về nhì, chỉ 1 chút nữa thôi!");
	        soTienAnDuocText.setText("Tien cuoc * 0.5");
	    } else if (carImageViews.get(2) == car1ImageView) {
	    	thongBaoText.setText("Thật đáng tiếc, bạn đã về ba, cố hơn nữa nhé!");
	    	soTienAnDuocText.setText("Tien cuoc * 0.5");
	    } else {
	    	thongBaoText.setText("Không sao, cố gắng cải thiện hơn bạn nhé! ");
	    }
	}


}
