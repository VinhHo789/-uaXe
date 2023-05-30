package controller;


//Thêm hiệu ứng kiệt sức
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;

import java.util.*;


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
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.effect.Blend;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.layout.*;
import javafx.event.*;
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
	private StackPane podiumFirstPlaceStackPane;
	
	@FXML
	private StackPane podiumSecondPlaceStackPane;
	
	@FXML
	private StackPane podiumThirdPlaceStackPane;
	
	@FXML
	private AnchorPane podiumAnchorPane;
	
	@FXML
	private AnchorPane thongTinAnchorPane;
	
	@FXML
	private AnchorPane congratEffectAnchorPane;
	
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
	
	@FXML
	private StackPane firstCarPositionStackPane;
	
	@FXML
	private StackPane secondCarPositionStackPane;
	
	@FXML
	private StackPane thirdCarPositionStackPane;
	
	@FXML
	private StackPane car1StackPane;
	
	@FXML
	private StackPane car2StackPane;
	
	@FXML
	private StackPane car3StackPane;
	
	@FXML
	private StackPane car4StackPane;
	
	@FXML
	private StackPane car5StackPane;
	
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
	
	
	
	
	private double startTimeroad1 = 0;
	private double startTimeroad2 = 0;
	private double duration_second = 1;
	private double speed = 4;
	private int loop_rounds = 2;
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
	
	
	
	Image tocBienImage = new Image(getClass().getResourceAsStream("/img/asset/TocBien.jpg"));
	Image tocHanhImage = new Image(getClass().getResourceAsStream("/img/asset/TocHanh.jpg"));
	Image kietSucImage = new Image(getClass().getResourceAsStream("/img/asset/KietSuc.jpg"));
	Image head1Image = new Image(getClass().getResourceAsStream("/img/asset/chars/head1.png"));
	Image head2Image = new Image(getClass().getResourceAsStream("/img/asset/chars/head2.png"));
	Image head3Image = new Image(getClass().getResourceAsStream("/img/asset/chars/head3.png"));
	Image flashEffectImage = new Image(getClass().getResourceAsStream("/img/asset/flashEffect.png"));
	Image tocHanhEffectImage = new Image(getClass().getResourceAsStream("/img/asset/tocHanhEffect.png"));
	
	
	Image car1Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car1.png"));
	Image car2Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car2.png"));
	Image car3Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car3.png"));
	Image car4Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car4.png"));
	Image car5Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car5.png"));
	Image podiumImage = new Image(getClass().getResourceAsStream("/img/asset/podium.png"));
	Image roadImage1 = new Image(getClass().getResourceAsStream("/img/map/3-map2.png"));
	Image roadImage2 = new Image(getClass().getResourceAsStream("/img/map/3-map1.png"));
	Image startingroadImage = new Image(getClass().getResourceAsStream("/img/map/3-startingmap.png"));
	Image endingroadImage = new Image(getClass().getResourceAsStream("/img/map/3-endingmap.png"));
	


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		
		if(CommonFunction.carID.equals("xe1")) {
		car1Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car1.png"));
		car2Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car2.png"));
		car3Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car3.png"));
		car4Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car4.png"));
		car5Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car5.png"));
		}
		
		if(CommonFunction.carID.equals("xe1")) {
			car1Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car1.png"));
			car2Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car2.png"));
			car3Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car3.png"));
			car4Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car4.png"));
			car5Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car5.png"));
		} else if(CommonFunction.carID.equals("xe2")) {
			car1Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car2.png"));
			car2Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car1.png"));
			car3Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car3.png"));
			car4Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car4.png"));
			car5Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car5.png"));
		} else if(CommonFunction.carID.equals("xe3")) {
			car1Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car3.png"));
			car2Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car1.png"));
			car3Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car2.png"));
			car4Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car5.png"));
			car5Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car4.png"));
		} else if(CommonFunction.carID.equals("xe4")) {
			car1Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car4.png"));
			car2Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car2.png"));
			car3Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car1.png"));
			car4Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car3.png"));
			car5Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car5.png"));
		} else if(CommonFunction.carID.equals("xe5")) {
			car1Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car5.png"));
			car2Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car4.png"));
			car3Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car2.png"));
			car4Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car3.png"));
			car5Image = new Image(getClass().getResourceAsStream("/img/asset/cars/car1.png"));
		}
		// Load the road image
		if(CommonFunction.mapID.equals("duongnhua")) {
			roadImage1 = new Image(getClass().getResourceAsStream("/img/map/1-map2.jpg"));
			roadImage2 = new Image(getClass().getResourceAsStream("/img/map/1-map1.jpg"));
			startingroadImage = new Image(getClass().getResourceAsStream("/img/map/1-startingmap.jpg"));
			endingroadImage = new Image(getClass().getResourceAsStream("/img/map/1-endingmap.jpg"));
		}
		else if (CommonFunction.mapID.equals("duongdat")) {
			roadImage1 = new Image(getClass().getResourceAsStream("/img/map/2-map2.png"));
			roadImage2 = new Image(getClass().getResourceAsStream("/img/map/2-map1.png"));
			startingroadImage = new Image(getClass().getResourceAsStream("/img/map/2-startingmap.png"));
			endingroadImage = new Image(getClass().getResourceAsStream("/img/map/2-endingmap.png"));
		}else if(CommonFunction.mapID.equals("duongbaron")){
			roadImage1 = new Image(getClass().getResourceAsStream("/img/map/3-map2.png"));
			roadImage2 = new Image(getClass().getResourceAsStream("/img/map/3-map1.png"));
			startingroadImage = new Image(getClass().getResourceAsStream("/img/map/3-startingmap.png"));
			endingroadImage = new Image(getClass().getResourceAsStream("/img/map/3-endingmap.png"));
		}
		
		if(CommonFunction.mapLength.equals("ngan")) {
			loop_rounds = 4;
		} else if (CommonFunction.mapLength.equals("trungbinh")) {
			loop_rounds = 8;
			
		} else {
			loop_rounds = 12;
		}
			
		
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
		ImageView head1ImageView = new ImageView(head1Image);
		ImageView head2ImageView = new ImageView(head2Image);
		ImageView head3ImageView = new ImageView(head3Image);
		ImageView flashEffectImageView = new ImageView(flashEffectImage);
		ImageView tocHanhEffectImageView = new ImageView(tocHanhEffectImage);
		
		
		roadImageView2.setVisible(false);
		endingRoadImageView.setVisible(false);
		podiumAnchorPane.setVisible(false);
		thongTinAnchorPane.setVisible(false);
		
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
	    flashEffectImageView.setFitWidth(40);
	    flashEffectImageView.setFitHeight(40);
	    
	    tocHanhEffectImageView.setFitWidth(80);
	    tocHanhEffectImageView.setFitHeight(40);
	    
	    head1ImageView.setFitWidth(30); // Set the desired fit width
	    head1ImageView.setFitHeight(30); // Set the desired fit height

	    head2ImageView.setFitWidth(30); // Set the desired fit width
	    head2ImageView.setFitHeight(30); // Set the desired fit height

	    
	    head3ImageView.setFitWidth(30); // Set the desired fit width
	    head3ImageView.setFitHeight(30); // Set the desired fit height
	    
	    if (settingMenuController.charID == 1) {
	        car1StackPane.getChildren().setAll(car1ImageView, head1ImageView);

	        if (random.nextBoolean()) {
	            car2StackPane.getChildren().setAll(car2ImageView);
	            car3StackPane.getChildren().setAll(car3ImageView, head2ImageView);
	            car4StackPane.getChildren().setAll(car4ImageView, head3ImageView);
	            car5StackPane.getChildren().setAll(car5ImageView);
	        } else {
	            car2StackPane.getChildren().setAll(car2ImageView, head3ImageView);
	            car3StackPane.getChildren().setAll(car3ImageView);
	            car4StackPane.getChildren().setAll(car4ImageView);
	            car5StackPane.getChildren().setAll(car5ImageView, head2ImageView);
	        }
	    } else if (settingMenuController.charID == 2) {
	        car1StackPane.getChildren().setAll(car1ImageView, head2ImageView);
	        
	        if (random.nextBoolean()) {
	            car2StackPane.getChildren().setAll(car2ImageView, head3ImageView);
	            car3StackPane.getChildren().setAll(car3ImageView);
	            car4StackPane.getChildren().setAll(car4ImageView);
	            car5StackPane.getChildren().setAll(car5ImageView, head1ImageView);
	        } else {
	            car2StackPane.getChildren().setAll(car2ImageView);
	            car3StackPane.getChildren().setAll(car3ImageView, head1ImageView);
	            car4StackPane.getChildren().setAll(car4ImageView, head3ImageView);
	            car5StackPane.getChildren().setAll(car5ImageView);
	        }
	    } else {
	        if (random.nextBoolean()) {
	            car2StackPane.getChildren().setAll(car2ImageView, head2ImageView);
	            car3StackPane.getChildren().setAll(car3ImageView);
	            car4StackPane.getChildren().setAll(car4ImageView);
	            car5StackPane.getChildren().setAll(car5ImageView, head1ImageView);
	        } else {
	            car2StackPane.getChildren().setAll(car2ImageView);
	            car3StackPane.getChildren().setAll(car3ImageView, head2ImageView);
	            car4StackPane.getChildren().setAll(car4ImageView, head1ImageView);
	            car5StackPane.getChildren().setAll(car5ImageView);
	        }
	        car1StackPane.getChildren().setAll(car1ImageView, head3ImageView);
	    }
//	    AnchorPane.setTopAnchor(car1StackPane, AnchorPane.getTopAnchor(car1ImageView));
//	    AnchorPane.setLeftAnchor(car1StackPane, AnchorPane.getLeftAnchor(car1ImageView));
//	    AnchorPane.setRightAnchor(car1StackPane, AnchorPane.getRightAnchor(car1ImageView));
//	    AnchorPane.setBottomAnchor(car1StackPane, AnchorPane.getBottomAnchor(car1ImageView));



	    



	 originalX1 = car1StackPane.getTranslateX();
	 originalX2 = car2StackPane.getTranslateX();
	 originalX3 = car3StackPane.getTranslateX();
	 originalX4 = car4StackPane.getTranslateX();
	 originalX5 = car5StackPane.getTranslateX();

	 TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), car1StackPane);
	 TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), car2StackPane);
	 TranslateTransition translateTransition3 = new TranslateTransition(Duration.seconds(0.5), car3StackPane);
	 TranslateTransition translateTransition4 = new TranslateTransition(Duration.seconds(0.5), car4StackPane);
	 TranslateTransition translateTransition5 = new TranslateTransition(Duration.seconds(0.5), car5StackPane);

	 translateTransition1.setToX(50);
	 translateTransition2.setToX(40);
	 translateTransition3.setToX(20);
	 translateTransition4.setToX(30);
	 translateTransition5.setToX(50);

	 car1StackPane.setTranslateX(originalX1);
	 car2StackPane.setTranslateX(originalX2);
	 car3StackPane.setTranslateX(originalX3);
	 car4StackPane.setTranslateX(originalX4);// Set the initial X position
	 car5StackPane.setTranslateX(originalX5);// Set the initial X position
	 
	 


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
	    
	    
	    
	    car1StackPane.translateXProperty().addListener((obs, oldValue, newValue) -> {
	        currentX1 = newValue.doubleValue();
	        updatePlaceImageViews();

	    });

	    // Listener for car2StackPane position
	    car2StackPane.translateXProperty().addListener((obs, oldValue, newValue) -> {
	        currentX2 = newValue;
	        updatePlaceImageViews();
	    });

	    // Listener for car3StackPane position
	    car3StackPane.translateXProperty().addListener((obs, oldValue, newValue) -> {
	        currentX3 = newValue;
	        updatePlaceImageViews();
	    });

	    // Listener for car4StackPane position
	    car4StackPane.translateXProperty().addListener((obs, oldValue, newValue) -> {
	        currentX4 = newValue;
	        updatePlaceImageViews();
	    });

	    // Listener for car5StackPane position
	    car5StackPane.translateXProperty().addListener((obs, oldValue, newValue) -> {
	        currentX5 = newValue;
	        updatePlaceImageViews();
	    });

	    
	    TranslateTransition endTranslateTransition1 = new TranslateTransition(Duration.seconds(1), car1StackPane);
	    TranslateTransition endTranslateTransition2 = new TranslateTransition(Duration.seconds(1), car2StackPane);
	    TranslateTransition endTranslateTransition3 = new TranslateTransition(Duration.seconds(1), car3StackPane);
	    TranslateTransition endTranslateTransition4 = new TranslateTransition(Duration.seconds(1), car4StackPane);
	    TranslateTransition endTranslateTransition5 = new TranslateTransition(Duration.seconds(1), car5StackPane);
	    
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
		CommonFunction.stop();
		CommonFunction.musicFilePath="src/music/countdown.mp3";
		CommonFunction.play();
		countdownTimeline.play();
		
		PauseTransition countdownBeforeStart = new PauseTransition(Duration.seconds(countdown));
		countdownBeforeStart.setOnFinished(event -> {
			CommonFunction.musicFilePath="src/music/raceSound.mp3";
			CommonFunction.play();
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
			CommonFunction.stop();
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
		    	congratEffectAnchorPane.toFront();
		    	setPodiumPlaceImageViews();
		    	if(random.nextBoolean()) {
		    		CommonFunction.musicFilePath="src/music/cheeringsound.mp3";
					CommonFunction.play();
		    	}
		    	else {
		    		CommonFunction.musicFilePath="src/music/cheeringsound2.mp3";
					CommonFunction.play();
		    	}
		    		
		    	
			    //playCongratEffect();
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
		    double currentX = car1StackPane.getTranslateX(); // Get the current X position
	    	double newX = currentX + 90;
	    	
	    	
	    	
	    	TranslateTransition flashTranslateTransition5 = new TranslateTransition(Duration.seconds(0.5), flashEffectImageView);
	    	flashEffectImageView.setTranslateX(car1StackPane.getTranslateX());
	    	flashEffectImageView.setTranslateY(car1StackPane.getTranslateY() + car1StackPane.getLayoutY());
	    	flashTranslateTransition5.setToX(car1StackPane.getTranslateX());
	    	flashTranslateTransition5.setToY(car1StackPane.getTranslateY() + car1StackPane.getLayoutY());
	    	giaoDienAnchorPane.getChildren().add(flashEffectImageView);
	    	
	    	car1StackPane.setTranslateX(newX);
	    	originalX1 = newX;
	    	translateTransition1.setDuration(Duration.seconds(0));
		    translateTransition1.play();
	    	flashTranslateTransition5.play();
	    	flashTranslateTransition5.setOnFinished(translateevent -> {
	    		giaoDienAnchorPane.getChildren().remove(flashEffectImageView);
	        });
	    	
	    	
	    	


	        
	       
        });
		
		tocHanhImageView.setOnMouseClicked((MouseEvent mouseevent) -> {
			//tocHanhImageView.setDisable(true);
			translateTransition1.stop(); // Stop the current transition
		    double currentX = car1StackPane.getTranslateX(); // Get the current X position
	    	double newX = currentX + 130;
	    	TranslateTransition newTransition = new TranslateTransition(Duration.seconds(3), car1StackPane);
	    	TranslateTransition newTocHanhTransition = new TranslateTransition(Duration.seconds(3), tocHanhEffectImageView);
	    	tocHanhEffectImageView.setTranslateX(car1StackPane.getTranslateX());
	    	tocHanhEffectImageView.setTranslateY(car1StackPane.getTranslateY() + car1StackPane.getLayoutY());
	    	giaoDienAnchorPane.getChildren().add(tocHanhEffectImageView);
	    	originalX1 = newX;
	        newTransition.setToX(newX);
	        newTocHanhTransition.setToX(newX);
	        newTransition.play();
	        newTocHanhTransition.play();
	        
	        newTransition.setOnFinished(event -> {
	            translateTransition1.setDuration(Duration.seconds(0));
	            translateTransition1.play();
	            giaoDienAnchorPane.getChildren().remove(tocHanhEffectImageView);
	        });
        });
		
		kietSucImageView.setOnMouseClicked((MouseEvent mouseevent) -> {
			kietSucImageView.setDisable(true);
			translateTransition2.stop();
			translateTransition3.stop();
			translateTransition4.stop();
			translateTransition5.stop();// Stop the current transition// Get the current X position
	    	double newX2 = originalX2 - 50;
	    	double newX3 = originalX3 - 50;
	    	double newX4 = originalX4 - 50;
	    	double newX5 = originalX5 - 50;
	    	TranslateTransition newTransition2 = new TranslateTransition(Duration.seconds(1), car2StackPane);
	    	TranslateTransition newTransition3 = new TranslateTransition(Duration.seconds(1), car3StackPane);
	    	TranslateTransition newTransition4 = new TranslateTransition(Duration.seconds(1), car4StackPane);
	    	TranslateTransition newTransition5 = new TranslateTransition(Duration.seconds(1), car5StackPane);
	    	
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
		
		thoatGameButton.setOnMouseEntered((MouseEvent event) -> {
			thoatGameButton.getScene().setCursor(Cursor.HAND);
        });

        // Set event handler for mouse exit
		thoatGameButton.setOnMouseExited((MouseEvent event) -> {
			thoatGameButton.getScene().setCursor(Cursor.DEFAULT);
        });
		
		tiepTucChoiButton.setOnMouseEntered((MouseEvent event) -> {
			tiepTucChoiButton.getScene().setCursor(Cursor.HAND);
        });

        // Set event handler for mouse exit
		tiepTucChoiButton.setOnMouseExited((MouseEvent event) -> {
			tiepTucChoiButton.getScene().setCursor(Cursor.DEFAULT);
        });
		
		thoatGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
                stg.getOnCloseRequest().handle(new WindowEvent(stg, WindowEvent.WINDOW_CLOSE_REQUEST));;
               
                
            }
        });
		
		tiepTucChoiButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try {
                    FXMLLoader loader = new FXMLLoader(CommonFunction.class.getResource("/view/TrangchuView.fxml"));
                    StackPane root = loader.load();
                    Scene scene = new Scene(root);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
	    List<StackPane> placeStackPanes = Arrays.asList(firstCarPositionStackPane, secondCarPositionStackPane, thirdCarPositionStackPane);

	    // Create a list of the ImageView objects
	    List<StackPane> carStackPanes = Arrays.asList(car1StackPane, car2StackPane, car3StackPane, car4StackPane, car5StackPane);

	    // Sort the carStackPanes based on the translateX values in descending order
	    carStackPanes.sort(Comparator.comparingDouble(StackPane::getTranslateX).reversed());

	    // Clear the placeStackPanes
	    for (StackPane stackPane : placeStackPanes) {
	        stackPane.getChildren().clear();
	    }

	    // Update the placeStackPanes with the top three carStackPanes
	    for (int i = 0; i < Math.min(carStackPanes.size(), placeStackPanes.size()); i++) {
	        StackPane carStackPane = carStackPanes.get(i);
	        StackPane placeStackPane = placeStackPanes.get(i);

	        // Create new ImageView instances and add them to the placeStackPane
	        for (Node child : carStackPane.getChildren()) {
	            if (child instanceof ImageView) {
	                ImageView originalImageView = (ImageView) child;
	                ImageView newImageView = new ImageView(originalImageView.getImage());
	                newImageView.setFitWidth(originalImageView.getFitWidth() * 1.2);
	                newImageView.setFitHeight(originalImageView.getFitHeight() * 1.2);
	                placeStackPane.getChildren().add(newImageView);
	            }
	        }
	    }
	}


	



	
	private void setPodiumPlaceImageViews() {
	    List<StackPane> placeStackPanes = Arrays.asList(podiumFirstPlaceStackPane, podiumSecondPlaceStackPane, podiumThirdPlaceStackPane);

	    // Create a list of the ImageView objects
	    List<StackPane> carStackPanes = Arrays.asList(car1StackPane, car2StackPane, car3StackPane, car4StackPane, car5StackPane);

	    // Sort the carStackPanes based on the translateX values in descending order
	    carStackPanes.sort(Comparator.comparingDouble(StackPane::getTranslateX).reversed());

	    // Clear the placeStackPanes
	    for (StackPane stackPane : placeStackPanes) {
	        stackPane.getChildren().clear();
	    }

	    // Update the placeStackPanes with the top three carStackPanes
	    for (int i = 0; i < Math.min(carStackPanes.size(), placeStackPanes.size()); i++) {
	    	StackPane carStackPane = carStackPanes.get(i);
	        StackPane placeStackPane = placeStackPanes.get(i);

	        // Create new ImageView instances and add them to the placeStackPane
	        for (Node child : carStackPane.getChildren()) {
	            if (child instanceof ImageView) {
	                ImageView originalImageView = (ImageView) child;
	                ImageView newImageView = new ImageView(originalImageView.getImage());
	                newImageView.setFitWidth(originalImageView.getFitWidth() * 1.5);
	                newImageView.setFitHeight(originalImageView.getFitHeight() * 1.5);
	                placeStackPane.getChildren().add(newImageView);
	            }
	        }
	    }

	    // Check the position of car1StackPane and update the UI accordingly
	    if (carStackPanes.indexOf(car1StackPane) == 0) {
	        thongBaoText.setText("Chúc mừng, bạn đã về nhất và chiến thắng!");
	        soTienAnDuocText.setText("Số tiền ăn được: " + CommonFunction.betGold * 4);
	        CommonFunction.gold += CommonFunction.betGold * 4;
	        soTienHienCoText.setText("Số tiến hiện có: " + CommonFunction.gold);
	    } else if (carStackPanes.indexOf(car1StackPane) == 1) {
	        thongBaoText.setText("Rất tiếc, bạn đã về nhì, chỉ 1 chút nữa thôi!");
	        soTienAnDuocText.setText("Số tiền ăn được: "+ CommonFunction.betGold * 0.5);
	        CommonFunction.gold += CommonFunction.betGold * 0.5;
	        soTienHienCoText.setText("Số tiến hiện có: " + CommonFunction.gold);
	    } else if (carStackPanes.indexOf(car1StackPane) == 2) {
	        thongBaoText.setText("Thật đáng tiếc, bạn đã về ba, cố hơn nữa nhé!");
	        soTienAnDuocText.setText("Số tiền ăn được: "+ CommonFunction.betGold * 0.5);
	        CommonFunction.gold += CommonFunction.betGold * 0.5;
	        soTienHienCoText.setText("Số tiến hiện có: " + CommonFunction.gold);
	    } else {
	        thongBaoText.setText("Không sao, cố gắng cải thiện hơn bạn nhé!");
	        soTienAnDuocText.setText("Số tiền ăn được: 0");
	        soTienHienCoText.setText("Số tiến hiện có: " + CommonFunction.gold);
	    }
	}

	public void playCongratEffect() {
		// Create a File object with the path to the video file
        String videoPath = "src/music/congratEffect.mp4";
        File videoFile = new File(videoPath);

        // Convert the File object to a file URI
        String fileUri = videoFile.toURI().toString();

        // Create a Media object with the file URI
        Media media = new Media(fileUri);

        // Create a MediaPlayer and associate it with the Media object
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        // Create a MediaView and bind it to the MediaPlayer
        MediaView mediaView = new MediaView(mediaPlayer);

        Color greenScreenColor = Color.GREEN;

        // Create a ColorInput with the green screen color
        ColorInput colorInput = new ColorInput();
        colorInput.setPaint(greenScreenColor);

        // Create a Blend effect with the ColorInput
        Blend blend = new Blend();
        blend.setTopInput(colorInput);

        // Apply the Blend effect to the MediaView
        mediaView.setEffect(blend);
        
        congratEffectAnchorPane.getChildren().add(mediaView);
        mediaPlayer.play();

	}


}
