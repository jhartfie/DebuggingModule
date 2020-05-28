package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.*;
import java.util.Iterator;

public class Controller {
    // FXML Variables
    @FXML
    private GridPane mainPane;
    @FXML
    private Button level1, level2, level3;

    // Variables for returning to home page
    private Scene homePage;
    private Stage mainStage;
    private int currentLevel;
    //
    private LessonPane lessonPane;
    private Scene levelScene;
    private QuizPane quizPane;
    // Path to JSON File
    private final String dir = System.getProperty("user.dir") + "\\user.json";

    //Handles Info Button Click
    @FXML
    protected void handleInfoButtonAction(ActionEvent event) {
        VBox infoBox = new VBox();
        infoBox.setStyle("-fx-background-color: #DCDCDC");
        infoBox.setSpacing(10);
        infoBox.setPadding(new Insets(10, 10, 10, 10));

        // For Writeability
        class InfoLabel extends Label {
            public InfoLabel(String text) {
                setText(text);
                setWrapText(true);
                setPrefWidth(450);
                setStyle("-fx-text-fill: #33383E");
                setTextAlignment(TextAlignment.CENTER);
                setAlignment(Pos.TOP_CENTER);
                setLineSpacing(1);
            }
        }

        // Create Text
        Label msg = new InfoLabel("This Application was created for the 2019-2020 NASA Psyche Mission Debugging Mentality as part of ASU's CSE485/486 Capstone class.");
        msg.setFont(new Font("Arial Bold", 18));
        Label signature = new InfoLabel("Team Members: Hussein Amr, Colter Hanson, Justin Hartfield, Raquel Fierros, Chase Overcash, and Harsh Shah\n\n\n\n");
        signature.setFont(new Font("Arial", 8));
        Label stmt = new InfoLabel("Here is our mission statement:\n");
        stmt.setUnderline(true);
        stmt.setFont(new Font("Arial Bold", 18));
        Label mission = new InfoLabel("We are going to develop a Java application that teaches users all about debugging. Since learning isn’t always the most fun, we decided to implement some gamification via a leveling system (3 levels) and score system (based on quiz grades) within our app so users not only experience a sense of accomplishment but also get an adrenaline rush each time they beat a level and prepare for the next. Levels will start off elementary but become increasingly difficult towards the end. The goal is for the user to ultimately embrace a sort of debugging mindset that they can use in all walks of life, not just within programming.");
        mission.setFont(new Font("Arial", 14));

        // Create and Show Popup
        infoBox.getChildren().addAll(msg, signature, stmt, mission);
        Stage popup = new Stage();
        popup.setScene(new Scene(infoBox, 450, 400));
        popup.setAlwaysOnTop(true);
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initStyle(StageStyle.UTILITY);
        popup.show();
    }

    // Handles Home Button Click
    @FXML
    protected void handleHomeButtonAction(ActionEvent event) {
        mainStage.setScene(homePage);
    }

    // Handles Help Button Click
    protected void handleHelpButtonAction(ActionEvent event){
        VBox infoBox = new VBox();
        infoBox.setStyle("-fx-background-color: #DCDCDC");
        infoBox.setSpacing(10);
        infoBox.setPadding(new Insets(10, 10, 10, 10));

        // For Writeability
        class InfoLabel extends Label {
            public InfoLabel(String text) {
                setText(text);
                setWrapText(true);
                setPrefWidth(450);
                setStyle("-fx-text-fill: #33383E");
                setTextAlignment(TextAlignment.CENTER);
                setAlignment(Pos.TOP_CENTER);
                setLineSpacing(1);
            }
        }

        // Create Text
        Label msg = new InfoLabel("Complete the lessons to unlock more modules!\nComplete the quizzes to unlock new levels!\nInitial levels and lesson unlocked based off your chosen experience level!\nComplete at your own pace!\nReview all completed modules at any time in the future!");
        msg.setFont(new Font("Arial Bold", 18));

        // Create and Show Popup
        infoBox.setAlignment(Pos.CENTER);
        infoBox.getChildren().addAll(msg);
        Stage popup = new Stage();
        popup.setScene(new Scene(infoBox, 450, 300));
        popup.setAlwaysOnTop(true);
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initStyle(StageStyle.UTILITY);
        popup.show();
    }

    // Handles Level Button Selection
    @FXML
    protected void handleLevelButtonAction(ActionEvent event) {
        // Calls makeLevelPane method, passing level number as information
        if (((Control) event.getSource()).getId().equals("level1")) {
            makeLevelPane(1);
        } else if (((Control) event.getSource()).getId().equals("level2")) {
            makeLevelPane(2);
        } else if (((Control) event.getSource()).getId().equals("level3")) {
            makeLevelPane(3);
        }
    }

    // Called from Handle Level Button Method
    public void makeLevelPane(int levelNum) {
        try {
            currentLevel = levelNum;
            // Corresponds to JSON Object Key
            String levelName = "Level" + levelNum;

            // Obtain JSON Information from file and assign
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject) parser.parse(new FileReader(dir));

            // Get Value at Key
            String value = (String) jsonObj.get(levelName);

            // Checks if user has access to level
            if (Boolean.parseBoolean(value)) {
                // If user has access Create JSON Array relating to the selected level

                // Store Current Stage and HomePage for Later
                mainStage = (Stage) mainPane.getScene().getWindow();
                homePage = mainPane.getScene();

                // Convert JSON Array corresponding to selected level into a boolean Array

                // Create LevelPane
                LevelPane levelP = new LevelPane(levelNum);

                // Assign Homebutton Action Event so it can return to home scene
                levelP.homeButton.setOnAction(this::handleHomeButtonAction);
                levelP.helpButton.setOnAction(this::handleHelpButtonAction);

                // Assign Lesson/Quiz Button Action Event
                levelP.lesson1.setOnAction(this::handleLessonButtonAction);
                levelP.lesson2.setOnAction(this::handleLessonButtonAction);
                levelP.lesson3.setOnAction(this::handleLessonButtonAction);
                levelP.quiz.setOnAction(this::handleQuizButtonAction);
                // Set Scene to new Level Scene
                levelScene = new Scene(levelP, 750, 750);
                mainStage.setScene(levelScene);
            } else {
                // If User does not have access, create a popup notifying them.
                Stage popup = new PopupWindow("This Level Is Locked Still!\n Complete Prerequisite Levels To Unlock");
                popup.show();
                popup.centerOnScreen();
            }
            //Catch Exceptions
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    // Opens the lesson corresponding to the lesson button clicked
    protected void handleLessonButtonAction(ActionEvent event) {
        try {
            // For Finding Info From JSON
            String levelNum = "Level" + currentLevel;
            String lessonNumber = ((Control) event.getSource()).getId();
            int lessonNum = Integer.parseInt(lessonNumber.substring(6));
            String modules = "Level " + currentLevel + " Modules";
            // Init JSON Parser6
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject) parser.parse(new FileReader(dir));
            JSONArray jsonArray = (JSONArray) jsonObj.get(modules);
            // Parse until Right Lesson
            Iterator<JSONObject> iterator = jsonArray.iterator();
            int i = 1;
            boolean accessible = false;
            // Iterate through JSON to find Value Corresponding to Level
            while (iterator.hasNext()) {
                String value = "" + iterator.next();
                if (i == lessonNum) {
                    accessible = Boolean.parseBoolean(value);
                    break;
                }
                i++;
            }
            // Determine if Lesson is unlocked
            if (accessible) {
                // Create Lesson Scene
                lessonPane = new LessonPane(currentLevel, lessonNum);
                lessonPane.backButton.setOnAction(this::handleBackButtonAction);
                lessonPane.fwrdButton.setOnAction(this::handleFwrdButtonAction);
                Scene scene = new Scene(lessonPane, 750, 750);
                mainStage.setScene(scene);
            } else {
                // Notify User that Lesson is not unlocked yet
                Stage popup = new PopupWindow("This Lesson Is Locked Still!\n Complete Prerequisite Lessons To Unlock");
                popup.show();
                popup.centerOnScreen();
            }
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    // Opens the Quiz corresponding to the Quiz Button clicked
    protected void handleQuizButtonAction(ActionEvent event) {
        try {
            // For Finding Info From JSON
            String modules = "Level " + currentLevel + " Modules";
            // Init JSON Parser
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject) parser.parse(new FileReader(dir));
            JSONArray jsonArray = (JSONArray) jsonObj.get(modules);
            String key = "" + jsonArray.get(3);
            boolean accessible = Boolean.parseBoolean(key);
            // Check if User has Unlocked This Quiz
            if (accessible) {
                // Create Quiz Pane and change scene
                quizPane = new QuizPane(currentLevel);
                quizPane.fwrdButton.setOnAction(this::handleQuizFwdButtonAction);
                Scene quizScene = new Scene(quizPane, 750, 750);
                mainStage.setScene(quizScene);
            } else {
                // Notify user that quiz is not unlocked
                Stage popup = new PopupWindow("This Quiz Is Locked Still!\n Complete Prerequisite Lessons To Unlock");
                popup.centerOnScreen();
                popup.show();
            }
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    // Goes to the previous slide in the lesson
    protected void handleBackButtonAction(ActionEvent event) {
        // Get Stack Pane Slides
        ObservableList<Node> children = lessonPane.lessonStack.getChildren();
        // Update Currently Viewed StackPane
        children.get(0).setVisible(true);
        children.get(children.size() - 1).setVisible(false);
        children.get(0).toFront();
        if (children.get(children.size() - 1).getId().equals("mainTitle")) {
            lessonPane.backButton.setVisible(false);
        }
    }

    // Goes to the next slide in the lesson, if current slide is last slide, it unlocks next lesson/quiz
    protected void handleFwrdButtonAction(ActionEvent event) {
        // Get Pages from Stack Pane
        ObservableList<Node> children = lessonPane.lessonStack.getChildren();
        // Update Pages Visibility
        children.get(children.size() - 1).setVisible(false);
        children.get(children.size() - 1).toBack();
        children.get(children.size() - 1).setVisible(true);
        lessonPane.backButton.setVisible(true);

        // Check if Lesson is now Completed
        if (children.get(children.size() - 1).getId().equals("mainTitle")) {
            try {
                // Update JSON File to Reflect Completed Lesson
                if (lessonPane.getLesson() <= 3) {
                    // Get JSON Array Key
                    String modules = "Level " + lessonPane.getLevel() + " Modules";

                    // Access JSON Array
                    JSONParser parser = new JSONParser();
                    JSONObject jsonObj = (JSONObject) parser.parse(new FileReader(dir));
                    JSONArray jsonArray = (JSONArray) jsonObj.get(modules);

                    //Update JSON File
                    jsonArray.set(lessonPane.getLesson(), "true");
                    jsonObj.replace(modules, jsonArray);

                    //Write new File
                    PrintWriter writer = new PrintWriter(dir);
                    writer.write(jsonObj.toJSONString());
                    writer.flush();
                    writer.close();
                }
            } catch (IOException | ParseException e) {
                System.out.println(e.getMessage());
            }
            mainStage.setScene(levelScene);
        }
    }

    // Moves you to next slide in quiz stackpane. If current slide is last slide, it unlocks next level (if applicable)
    protected void handleQuizFwdButtonAction(ActionEvent event) {
        // Get StackPane Children
        ObservableList<Node> children = quizPane.lessonStack.getChildren();
        // Update Pages Visibility
        if (children.get(children.size() - 1).getId().equals("title")) {
            quizPane.fwrdButton.setText("Submit Quiz");
        } else if (children.get(children.size() - 1).getId().equals("quiz")) {
            quizPane.fwrdButton.setText("Complete Quiz");

            // Calculate the user's score
            int correct = quizPane.calculateScore();
            String resultMsg = ("The number correct is: " + correct);
            if ((double) correct / (double) quizPane.getTotalQuestions() > .70) {
                // User Passes
                if (currentLevel < 3) {
                    // Unlock next Level
                    try {
                        String levelName = "Level" + (currentLevel + 1);
                        JSONParser parser = new JSONParser();
                        JSONObject jsonObj = (JSONObject) parser.parse(new FileReader(dir));
                        jsonObj.replace(levelName, "true");
                        PrintWriter writer = new PrintWriter(dir);
                        writer.write(jsonObj.toJSONString());
                        writer.flush();
                        writer.close();
                    } catch (IOException | ParseException e) {
                        System.out.println(e.getMessage());
                    }
                    quizPane.setResultText(resultMsg + "\n Congratulations you passed the quiz! The next level is unlocked!");
                } else {
                    // User finishes Quiz 3
                    quizPane.setResultText(resultMsg + "\n Congratulations you passed the quiz! \n You have now completed all modules in this application!");
                }

            } else {
                // User Fails
                quizPane.setResultText(resultMsg + "\n Sorry you did not pass this quiz...");
            }
        } else {
            // After viewing results, user is sent to level scene
            quizPane.fwrdButton.setText("Begin Quiz");
            mainStage.setScene(homePage);
        }

        // Actual code to update viewable scene
        children.get(children.size() - 1).setVisible(false);
        children.get(children.size() - 1).toBack();
        children.get(children.size() - 1).setVisible(true);

    }

    public class PopupWindow extends Stage {
        public PopupWindow(String error) throws FileNotFoundException {
            // Vbox To Hold Content
            VBox vbox = new VBox();
            vbox.setAlignment(Pos.CENTER);
            vbox.setSpacing(50);
            vbox.setStyle("-fx-background-color: #DCDCDC; -fx-border-width: 2px; -fx-border-color: #33383E");
            DropShadow shadow = new DropShadow();
            shadow.setBlurType(BlurType.GAUSSIAN);
            shadow.setRadius(10);
            vbox.setEffect(shadow);

            // Image
            String dir = System.getProperty("user.dir") + "\\media\\locked_module.png";
            Image img = new Image(new FileInputStream(dir));
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(200);
            imageView.setFitWidth(200);

            // Text Content
            Label content = new Label(error);
            content.setFont(new Font("Yu Gothic UI", 16));
            content.setStyle("-fx-font-weight: bold; -fx-text-alignment: center;");

            // Create Button
            Button okay = new Button("Go Back");
            okay.setOnAction(this::handleGoBackButtonAction);
            okay.setPrefSize(80, 40);
            okay.setEffect(shadow);
            okay.setStyle("-fx-background-radius: 30; -fx-background-color: #8D9AA6");

            // Add Content to VBox
            vbox.getChildren().addAll(imageView, content, okay);

            // Create Scene
            Scene scene = new Scene(vbox, 350, 450);
            setScene(scene);

            // Customize Window Settings
            initModality(Modality.APPLICATION_MODAL);
            initStyle(StageStyle.UNDECORATED);
            setResizable(false);
        }

        private void handleGoBackButtonAction(ActionEvent event) {
            close();
        }
    }
}