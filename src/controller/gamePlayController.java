package controller;

import java.net.URL;
import javafx.util.Duration;

import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
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
import javafx.scene.Node;
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
	private Text countdownText;
	private int countdownValue = 3;
	
	private double startTimeroad1 = 0;
	private double startTimeroad2 = 0;
	private double duration_second = 1;
	private double speed = 4;
	private int loop_rounds = 3;
	private int countdown = 4;
	
	private double originalX;
	private Random random = new Random();
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		// Load the road image
		Image roadImage1 = new Image(getClass().getResourceAsStream("/img/map/map2.jpg"));
		Image roadImage2 = new Image(getClass().getResourceAsStream("/img/map/map3.jpg"));
		Image startingroadImage = new Image(getClass().getResourceAsStream("/img/map/startingmap.jpg"));
		Image endingroadImage = new Image(getClass().getResourceAsStream("/img/map/endingmap.jpg"));
		Image car1Image = new Image(getClass().getResourceAsStream("/img/asset/car1.png"));
		roadImageView1.setImage(roadImage1);
		roadImageView2.setImage(roadImage2);
		startingRoadImageView.setImage(startingroadImage);
		endingRoadImageView.setImage(endingroadImage);
		car1ImageView.setImage(car1Image);
		roadImageView2.setVisible(false);
		endingRoadImageView.setVisible(false);
		giaoDienAnchorPane.setMinWidth(700);
		giaoDienAnchorPane.setMaxWidth(700);
		
		Timeline starttimeline = new Timeline();

		// Configure the first KeyFrame
		KeyFrame startstartKeyFrame = new KeyFrame(Duration.ZERO,
		        new KeyValue(startingRoadImageView.translateXProperty(), 2.5)); // Start from the right edge of the pane
		starttimeline.getKeyFrames().add(startstartKeyFrame);

		// Configure the second KeyFrame
		KeyFrame endstartKeyFrame = new KeyFrame(Duration.seconds(duration_second * speed),
		        new KeyValue(startingRoadImageView.translateXProperty(), -1412.5)); // Move to the left edge of the pane
		starttimeline.getKeyFrames().add(endstartKeyFrame);
		// Create a timeline with two KeyFrames
		
		
		
		Timeline timeline = new Timeline();

		// Configure the first KeyFrame
		KeyFrame startKeyFrame = new KeyFrame(Duration.ZERO,
		        new KeyValue(roadImageView1.translateXProperty(), 715)); // Start from the right edge of the pane
		timeline.getKeyFrames().add(startKeyFrame);

		// Configure the second KeyFrame
		KeyFrame endKeyFrame = new KeyFrame(Duration.seconds(duration_second * speed),
		        new KeyValue(roadImageView1.translateXProperty(), -710)); // Move to the left edge of the pane
		timeline.getKeyFrames().add(endKeyFrame);
		
		
		startTimeroad1 = countdown + (duration_second * speed) / 2;
		// Create and configure the second timeline for roadImageView2
		PauseTransition delay = new PauseTransition(Duration.seconds(startTimeroad1));
		Timeline timeline2 = new Timeline();
		KeyFrame startKeyFrame2 = new KeyFrame(Duration.ZERO,
		        new KeyValue(roadImageView2.translateXProperty(), 715)); // Start from the right edge of the pane
		timeline2.getKeyFrames().add(startKeyFrame2);
		KeyFrame endKeyFrame2 = new KeyFrame(Duration.seconds(duration_second * speed),
		        new KeyValue(roadImageView2.translateXProperty(), -710)); // Move to the left edge of the pane
		timeline2.getKeyFrames().add(endKeyFrame2);
		
		
		startTimeroad2 = countdown + duration_second * speed * loop_rounds;
		PauseTransition enddelay = new PauseTransition(Duration.seconds(startTimeroad2));
		Timeline endtimeline = new Timeline();

		// Configure the first KeyFrame
		KeyFrame startendKeyFrame = new KeyFrame(Duration.ZERO,
		        new KeyValue(endingRoadImageView.translateXProperty(), 715)); // Start from the right edge of the pane
		endtimeline.getKeyFrames().add(startendKeyFrame);

		// Configure the second KeyFrame
		KeyFrame endendKeyFrame = new KeyFrame(Duration.seconds(duration_second * speed / 2),
		        new KeyValue(endingRoadImageView.translateXProperty(), 2.5)); // Move to the left edge of the pane
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
	    
	    
	    originalX = car1ImageView.getTranslateX();

	    TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), car1ImageView);
	    translateTransition.setCycleCount(Animation.INDEFINITE);

	    KeyFrame keyFrameCar1 = new KeyFrame(Duration.seconds(2), event -> {
	        double newX = originalX + random.nextDouble() * 200; // Generate a random X position
	        if (newX > car1ImageView.getTranslateX()) {
	            translateTransition.setToX(newX); // Move forward
	        }
	    });

	    Timeline timelineCar1 = new Timeline(keyFrameCar1);
	    timelineCar1.setCycleCount(Animation.INDEFINITE);

	    translateTransition.setAutoReverse(true);
	    translateTransition.setOnFinished(event -> {
	        double currentX = car1ImageView.getTranslateX();
	        if (currentX <= originalX) {
	            translateTransition.setToX(originalX); // Prevent moving backward beyond original X position
	        }
	        timelineCar1.play();
	    });

	    car1ImageView.setTranslateX(originalX); // Set the initial X position
		
		
		starttimeline.setCycleCount(1); 
		endtimeline.setCycleCount(1);
		timeline.setCycleCount(loop_rounds); 
		timeline2.setCycleCount(loop_rounds);

		countdownTimeline.play();
		PauseTransition countdownBeforeStart = new PauseTransition(Duration.seconds(countdown));
		countdownBeforeStart.setOnFinished(event -> {
			starttimeline.play();
			timeline.play();
			timelineCar1.play();
		    translateTransition.play();
		});
		delay.setOnFinished(event -> {
			roadImageView2.setVisible(true);
		    timeline2.play();
		});
		enddelay.setOnFinished(event -> {
			endingRoadImageView.setVisible(true);
		    endtimeline.play();
		});
		countdownBeforeStart.play();
		delay.play();
		enddelay.play();

	}

}
