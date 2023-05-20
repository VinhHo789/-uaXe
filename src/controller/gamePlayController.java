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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
	private Button btn;

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
		roadImageView1.setImage(roadImage1);
		roadImageView2.setImage(roadImage2);
		startingRoadImageView.setImage(startingroadImage);
		endingRoadImageView.setImage(endingroadImage);
		car1ImageView.setImage(car1Image);
		car2ImageView.setImage(car1Image);
		car3ImageView.setImage(car1Image);
		car4ImageView.setImage(car1Image);
		roadImageView2.setVisible(false);
		endingRoadImageView.setVisible(false);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Timeline starttimeline = new Timeline();

		// Configure the first KeyFrame
		KeyFrame startstartKeyFrame = new KeyFrame(Duration.ZERO,
		        new KeyValue(startingRoadImageView.translateXProperty(), 0)); // Start from the right edge of the pane
		starttimeline.getKeyFrames().add(startstartKeyFrame);

		// Configure the second KeyFrame
		KeyFrame endstartKeyFrame = new KeyFrame(Duration.seconds(duration_second * speed),
		        new KeyValue(startingRoadImageView.translateXProperty(), -widthImage*2)); // Move to the left edge of the pane
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

	    TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(2), car1ImageView);
	    TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(2), car2ImageView);
	    TranslateTransition translateTransition3 = new TranslateTransition(Duration.seconds(2), car3ImageView);
	    TranslateTransition translateTransition4 = new TranslateTransition(Duration.seconds(2), car4ImageView);
	    
	    randomSpeed(originalX1,translateTransition1);
	    randomSpeed(originalX2,translateTransition2);
	    randomSpeed(originalX3,translateTransition3);
	    randomSpeed(originalX4,translateTransition4);
	    //translateTransition.setAutoReverse(true);
	    
	    

	    

	    car1ImageView.setTranslateX(originalX1);
	    car1ImageView.setTranslateX(originalX2);
	    car1ImageView.setTranslateX(originalX3);
	    car1ImageView.setTranslateX(originalX4);// Set the initial X position

	    
	    
	    




	    







		
		
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
		    translateTransition1.stop();
		    translateTransition2.stop();
		    translateTransition3.stop();
		    translateTransition4.stop();
		});
		countdownBeforeStart.play();
		delay.play();
		enddelay.play();
		
		btn.setOnAction(new EventHandler<ActionEvent>() {

	        private double duration = timeline.getCycleDuration().toSeconds();

	        @Override
	        public void handle(ActionEvent event) {
	            if (duration > 1) {
	                duration--;
	                starttimeline.setRate(timeline.getCycleDuration().toSeconds() / duration);
	                timeline.setRate(timeline.getCycleDuration().toSeconds() / duration);
	                timeline2.setRate(timeline.getCycleDuration().toSeconds() / duration);
	                endtimeline.setRate(timeline.getCycleDuration().toSeconds() / duration);
	            }
	        }
	    });

	}
	public void randomSpeed(double originalX, TranslateTransition translateTransition) {
		translateTransition.setOnFinished(event -> {
	        double newX = originalX + random.nextDouble() * 200; // Generate a random X position
	        if (newX > originalX) {
	            translateTransition.setToX(newX - originalX); // Move forward
	        } else {
	            translateTransition.setToX(originalX - newX); // Move backward
	        }
	        translateTransition.setDuration(Duration.seconds(random.nextInt(3) + 1));
	        translateTransition.play();
	    });
	}

}
