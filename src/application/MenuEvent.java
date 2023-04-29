package application;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javafx.scene.Node;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class MenuEvent {
	private Main main;
	public MenuEvent() {
        Main main = new Main();
        this.main=main;
    }
    public MenuEvent(Main main) {
        this.main = main;
    }

    public Scene handlePlayButton(AnchorPane root, Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(MenuEvent.class.getResource("ChooseCar.fxml"));
        root = loader.load();
        main.setupChooseCarEventHandlers(root, primaryStage);
        Scene scene = new Scene(root);
        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(scene);
        return scene;
    }

    public Scene handleSettingButton(AnchorPane root, Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(MenuEvent.class.getResource("settingMenu.fxml"));
        root = loader.load();
        Slider volumeSlider = (Slider) root.lookup("#volumeSlider");
        Button backButton = (Button) root.lookup("#backButton");
        main.loadConfig();
        volumeSlider.setValue(main.volume);
        volumeSlider.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double volume = volumeSlider.getValue() / 100;
                main.mediaPlayer.setVolume(volume);
                main.saveConfig(volumeSlider);
            }
        });
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(MenuEvent.class.getResource("GiaodienUI.fxml"));
                    AnchorPane root = loader.load();
                    main.setupMenuEventHandlers(root, primaryStage);
                    Scene scene = new Scene(root);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Scene scene = new Scene(root);
        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(scene);
        return scene;
    }

    public void handleQuitButton(ActionEvent event, Stage primaryStage) {
        primaryStage.close();
    }
}
