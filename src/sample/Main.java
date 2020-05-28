package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main extends Application {

    // Path location of JSON File
    private final String dir = System.getProperty("user.dir") + "\\user.json";
    // Allows for access to Popup Stage info
    private Label ta;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("NASA Psyche Capstone Project: The Debugging mindset");
        primaryStage.setScene(new Scene(root, 750, 750));
        primaryStage.show();

        // Checks if User's First time using
        File file = new File(dir);
        if (!file.exists())
        {
            // Call Start Up Popup Method
            popup();
        }

    }

    // Displays Popup to get User Exp Level
    public void popup() {
        // Create Popup
        Stage popup = new Stage();
        // Create BorderPane
        BorderPane bp = new BorderPane();
        bp.setStyle("-fx-background-color: #DCDCDC;");
        bp.setPadding(Insets.EMPTY);
        bp.setBlendMode(BlendMode.DARKEN);

        //Popup Label
        ta = new Label("Select Your Current Debugging Experience:");
        ta.setFont(new Font("Arial",16));
        ta.setStyle("-fx-font-family: 'Yu Gothic UI'; -fx-text-fill:#535E6E;-fx-font-weight: bolder");
        bp.setCenter(ta);

        // HBox to hold Buttons
        HBox choice = new HBox();
        choice.setPadding(Insets.EMPTY);

        // Makes Experience Buttons

        class ExpButton extends Button{
            ExpButton(String text)
            {
                //setShape(new Rectangle());
                setText(text);
                setId(text);
                setPrefWidth(120);
                setPrefHeight(35);
                setStyle("-fx-background-color: #B99A7B; -fx-font-weight: bold; -fx-border-width: 1px; -fx-border-color: #000000; -fx-background-radius: 0; -fx-padding: 0");
            }
        }
        Button beginner = new ExpButton("Beginner");
        Button intermediate = new ExpButton("Intermediate");
        Button advanced = new ExpButton("Advanced");

        // Add button actions
        beginner.setOnAction(this::handleExpButton);
        intermediate.setOnAction(this::handleExpButton);
        advanced.setOnAction(this::handleExpButton);

        // Add buttons to Border Pane
        choice.getChildren().addAll(beginner,intermediate,advanced);

        // If User doesnt choose a button
        popup.setOnCloseRequest(this::handleCloseEvent);

        // Add button Border Pane to larger borderPane
        bp.setBottom(choice);
        //Display the Popup
        Scene scene = new Scene(bp, 360, 150);
        popup.setScene(scene);
        popup.centerOnScreen();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setResizable(false);
        popup.initStyle(StageStyle.UNDECORATED);
        popup.show();
    }

    // Popup Window Closed Handle Method
    protected void handleCloseEvent(WindowEvent event)
    {
        // If user doesn't select a level of experience, assign them as a beginner
        initializeLevels(1);
    }

    // Pop Up Buttons Handle Method
    protected void handleExpButton(ActionEvent event) {
        // Close the Popup when a button's pressed
        Stage popup = (Stage) ta.getScene().getWindow();
        popup.close();

        // Pass information to Initialized Method based on button pressed.
        String button = ((Control) event.getSource()).getId();
        if (button.equals("Beginner")) {
            initializeLevels(1);
        } else if (button.equals("Intermediate")) {
            initializeLevels(2);
        } else if (button.equals("Advanced")) {
            initializeLevels(3);
        } else {
            initializeLevels(1);
        }
    }

    // Writes to JSON File on first use of application
    public void initializeLevels(int exp) {
        String accessible2 = "false";
        String accessible3 = "false";
        if (exp >= 2)
        {
            accessible2 = "true";
            if (exp == 3)
                accessible3 = "true";
        }

        // Make JSON File Objects
        JSONObject json = new JSONObject();
        JSONArray modules1 = new JSONArray();
        JSONArray modules2 = new JSONArray();
        JSONArray modules3 = new JSONArray();
        // Write Levels
        json.put("Level1", "true");
        json.put("Level2",accessible2);
        json.put("Level3",accessible3);
        // Write Level 1 Modules
        modules1.add("true");
        modules1.add(accessible2);
        modules1.add(accessible2);
        modules1.add(accessible2);
        // Write Level 2 Modules
        modules2.add("true");
        modules2.add(accessible3);
        modules2.add(accessible3);
        modules2.add(accessible3);
        // Write Level 3 Modules
        modules3.add("true");
        modules3.add("false");
        modules3.add("false");
        modules3.add("false");
        // Add Modules to JSON
        json.put("Level 1 Modules", modules1);
        json.put("Level 2 Modules", modules2);
        json.put("Level 3 Modules", modules3);
        try {
            // Write Objects to File
            PrintWriter writer = new PrintWriter(dir);
            writer.write(json.toJSONString());
            writer.flush();
            writer.close();
        } // Catch Exceptions and Print errors
        catch (IOException e){ System.out.println(e.getMessage());}

    }

    // Main Function
    public static void main(String[] args) {
        launch(args);
    }

}
