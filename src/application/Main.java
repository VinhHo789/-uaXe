
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


public class Main extends Application {
	//start
	private static final String CONFIG_FILE_PATH = "config.properties";
    private static final String VOLUME_KEY = "volume";

    private Properties config = new Properties();
    private double volume = 0.5;
    private MediaPlayer mediaPlayer;
    public void start(Stage primaryStage) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("GiaodienUI.fxml"));
            setupMenuEventHandlers(root, primaryStage);
            Scene scene = new Scene(root);

            // Load configuration file
            loadConfig();

            // Create media and media player objects
            String musicFilePath = "src/music/LND.mp3";
            Media media = new Media(new File(musicFilePath).toURI().toString());

           
            try {
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setVolume(volume);
                mediaPlayer.setOnError(() -> System.out.println("Error occurred while playing media"));
                mediaPlayer.play();
            } catch (Exception e) {
                e.printStackTrace();
            }


            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

	
	//menu screen
	private void setupMenuEventHandlers(AnchorPane root, Stage primaryStage) {
		Button playButton = (Button) root.lookup("#playButton");
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseCar.fxml"));
                    AnchorPane root = loader.load();
                    setupChooseCarEventHandlers(root, primaryStage);
                    Scene scene = new Scene(root);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create the Setting button
        Button settingButton = (Button) root.lookup("#settingButton");
        settingButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("settingMenu.fxml"));
                    AnchorPane root = loader.load();
                    Slider volumeSlider = (Slider) root.lookup("#volumeSlider");
                    Button backButton = (Button) root.lookup("#backButton");
                    loadConfig();
                    volumeSlider.setValue(volume);
                    volumeSlider.setOnMouseReleased(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            double volume = volumeSlider.getValue();
                            volume = volumeSlider.getValue();
                            volume = volume / 100;
                            mediaPlayer.setVolume(volume);
                            saveConfig(volumeSlider);
                        }
                    });

                    backButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("GiaodienUI.fxml"));
                                AnchorPane root = loader.load();
                                setupMenuEventHandlers(root, primaryStage);
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
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create the Quit button
        Button quitButton = (Button) root.lookup("#quitButton");
        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
	}
	
	private void setupChooseCarEventHandlers(AnchorPane root, Stage primaryStage) {
		Button mau1 = (Button) root.lookup("#mau1");
		Button mau2 = (Button) root.lookup("#mau2");
		Button mau3 = (Button) root.lookup("#mau3");
		mau1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("betMenu.fxml"));
                    AnchorPane root = loader.load();
                    setupbetMenuEventHandlers(root, primaryStage);
                    Scene scene = new Scene(root);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
		mau2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("betMenu.fxml"));
                    AnchorPane root = loader.load();
                    setupbetMenuEventHandlers(root, primaryStage);
                    Scene scene = new Scene(root);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
		
		mau3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("betMenu.fxml"));
                    AnchorPane root = loader.load();
                    setupbetMenuEventHandlers(root, primaryStage);
                    Scene scene = new Scene(root);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
		Button backButton = (Button) root.lookup("#backButton");
		backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("GiaodienUI.fxml"));
                    AnchorPane root = loader.load();
                    setupMenuEventHandlers(root, primaryStage);
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
	
	private void setupbetMenuEventHandlers(AnchorPane root, Stage primaryStage)
	{
		
		Button backButton = (Button) root.lookup("#backButton");
		backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseCar.fxml"));
                    AnchorPane root = loader.load();
                    setupChooseCarEventHandlers(root, primaryStage);
                    Scene scene = new Scene(root);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
		
		Button okButton = (Button) root.lookup("#okButton");
		okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("buyItemMenu.fxml"));
                    AnchorPane root = loader.load();
                    setupbuyItemMenuEventHandlers(root, primaryStage);
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
	
	private void setupbuyItemMenuEventHandlers(AnchorPane root, Stage primaryStage) {
	    ImageView tocHanh = (ImageView) root.lookup("#tocHanhicon");
	    ImageView tocBien = (ImageView) root.lookup("#tocBienicon");
	    ImageView kietSuc = (ImageView) root.lookup("#kietSucicon");
	    Button backButton = (Button) root.lookup("#backButton");
	    backButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	            try {
	                FXMLLoader loader = new FXMLLoader(getClass().getResource("betMenu.fxml"));
	                AnchorPane root = loader.load();
	                setupbetMenuEventHandlers(root, primaryStage);
	                Scene scene = new Scene(root);
	                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
	                window.setScene(scene);
	                window.show();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    });
	    
	    final Tooltip tooltip = new Tooltip();
	    Label tocHanhLabel = (Label) root.lookup("#tocHanhLabel");
	    Label tocBienLabel = (Label) root.lookup("#tocBienLabel");
	    Label kietSucLabel = (Label) root.lookup("#kietSucLabel");
	    
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
	
	private void loadConfig() {
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



	private void saveConfig(Slider volumeSlider) {
	    config.setProperty("volume", String.valueOf(volumeSlider.getValue()));
	    try (FileOutputStream out = new FileOutputStream(CONFIG_FILE_PATH)) {
	        config.store(out, "Volume Configuration");
	    } catch (IOException e) {
	        // ignore, unable to save config
	    }
	}


	public static void main(String[] args) {
		launch(args);
	}
}


	public static void main(String[] args) {
		launch(args);
	}
}

