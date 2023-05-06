package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class CommonFunction {
	protected Properties config = new Properties();
    public static double volume = 0.5;
    public String scenePath = "DangNhap.fxml";
	protected String CONFIG_FILE_PATH = "config.properties";
    protected String VOLUME_KEY = "volume";
    public static String musicFilePath = "src/music/LND.mp3";
    public static Media media = new Media(new File(musicFilePath).toURI().toString());
    public static MediaPlayer mediaPlayer;
    protected int money = 0;
    
    

   
    public static void play() {
    	mediaPlayer = new MediaPlayer(media);
    }
    public static void changeVolume(double vol) {
    	mediaPlayer.setVolume(vol);
    }
    public void changeMusic(String path){
        try {
            media = new Media(new File(path).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setVolume(volume);
            mediaPlayer.setOnError(() -> System.out.println("Error occurred while playing media"));
            mediaPlayer.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    }
    public void sceneTransition (String path, ActionEvent event){
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    protected void loadConfig() {
	    try (FileInputStream in = new FileInputStream(CONFIG_FILE_PATH)) {
	        config.load(in);
	        String volumeString = config.getProperty(VOLUME_KEY);
	        if (volumeString != null) {
	            volume = Double.parseDouble(volumeString);
	        }
	    } catch (IOException e) {
	        // ignore, use default values
	    }
	}



	protected void saveConfig(Slider volumeSlider) {
	    config.setProperty("volume", String.valueOf(volumeSlider.getValue()));
	    try (FileOutputStream out = new FileOutputStream(CONFIG_FILE_PATH)) {
	        config.store(out, "Volume Configuration");
	    } catch (IOException e) {
	        // ignore, unable to save config
	    }
	}
	
}
