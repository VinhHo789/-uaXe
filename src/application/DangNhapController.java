package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DangNhapController implements Initializable {

	@FXML
	protected ListView<String> usernamesList;
	
	@FXML
	protected Button okButton;
	
	@FXML
	protected TextField newUsernameField;
	
	@FXML
	protected Button createButton;
	
	@Override
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
        // Read the usernames and their associated money from user.txt and store them in an ObservableList of Strings
        ObservableList<String> usernamesAndMoney = FXCollections.observableArrayList();
        try (Scanner scanner = new Scanner(new File("user.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                String username = tokens[0];
                String money = tokens[1];
                String formattedString = String.format("%-90s %10s", username, money);
                usernamesAndMoney.add(formattedString);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Set the usernames and their associated money as the items of the ListView
        usernamesList.setItems(usernamesAndMoney);
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Get the new username from the newUsernameField
                String newUsername = newUsernameField.getText();
                if (!newUsername.trim().isEmpty()) {
                    // Append the new username and money to the user.txt file
                    try (PrintWriter writer = new PrintWriter(new FileWriter("user.txt", true))) {
                        writer.println(newUsername + ",100");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // Add the new username and money to the ObservableList and refresh the ListView
                    String formattedString = String.format("%-90s %10s", newUsername, "100");
                    usernamesAndMoney.add(formattedString);
                    usernamesList.refresh();
                    // Clear the newUsernameField
                    newUsernameField.clear();
                }
            }
        });
        okButton.setOnAction((event) -> {
                // Get the selected username from the ListView
                String selectedUsername = usernamesList.getSelectionModel().getSelectedItem();
                
                if (selectedUsername != null) {
                    try {
                        // Load the DangNhapUI.fxml file
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("GiaodienUI.fxml"));
                        Parent root = loader.load();
                        Scene scene = new Scene(root);
                        String css = getClass().getResource("application.css").toExternalForm();
                        scene.getStylesheets().add(css);
                        // Set up the event handlers for the DangNhapUI
                        Stage stg = (Stage)((Button)event.getSource()).getScene().getWindow();
                        stg.setScene(scene);
                        // Set the scene to the DangNhapUI
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        
	}
}
