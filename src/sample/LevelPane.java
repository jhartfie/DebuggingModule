package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

import javax.swing.plaf.basic.BasicArrowButton;
import java.io.FileInputStream;

public class LevelPane extends BorderPane {
    // Fields that need to be accessed from Controller
    protected Button homeButton = new Button("Home");
    protected  Button helpButton = new Button("Help");
    protected LessonButton lesson1 = new LessonButton("Lesson1");
    protected LessonButton lesson2 = new LessonButton("Lesson2");
    protected LessonButton lesson3 = new LessonButton("Lesson3");
    protected QuizButton quiz = new QuizButton();
    private int levelNum;
    public LevelPane(int level)
    {
        // Initialize Fields
        this.levelNum = level;
        homeButton.setStyle("-fx-background-color: #DCDCDC");
        homeButton.setBlendMode(BlendMode.HARD_LIGHT);
        helpButton.setStyle("-fx-background-color: #DCDCDC");
        helpButton.setBlendMode(BlendMode.HARD_LIGHT);

        // Arrows
        ImageView arrow1 = new ImageView();
        ImageView arrow2 = new ImageView();
        ImageView arrow3 = new ImageView();
        try {
            String dir = System.getProperty("user.dir") + "\\media\\the_arrow.png";
            Image img = new Image(new FileInputStream(dir));
            arrow1 = new ImageView(img); arrow1.setFitHeight(60); arrow1.setFitWidth(50);
            arrow2 = new ImageView(img); arrow2.setFitHeight(60); arrow2.setFitWidth(50);
            arrow3 = new ImageView(img); arrow3.setFitHeight(60); arrow3.setFitWidth(50);

        }
        catch (Exception e) { System.out.println(e.getMessage());}

        // Set Lesson Button ID's
        lesson1.setId("Lesson1");
        lesson2.setId("Lesson2");
        lesson3.setId("Lesson3");
        // Create Nav Bar
        BorderPane nav = new BorderPane();
        nav.setStyle("-fx-background-color: #33383E;");
        nav.setLeft(homeButton);
        nav.setRight(helpButton);
        setTop(nav);
        // Add Buttons to UI
        HBox hbox =  new HBox();
        hbox.setStyle("-fx-background-color: #535E6E;");
        hbox.setPadding(new Insets(15, 12,12,15));
        hbox.setSpacing(30);
        hbox.getChildren().addAll(lesson1, arrow1, lesson2, arrow2, lesson3, arrow3, quiz);
        hbox.setAlignment(Pos.CENTER);
        setCenter(hbox);
    }

    public class LessonButton extends Button {
        public LessonButton(String name)
        {
            setText(name);
            setShape(new Circle(5));
            setPrefWidth(85);
            setPrefHeight(75);
            setStyle("-fx-background-color: #B99A7B; -fx-text-fill:#D5DFD9; -fx-font-weight: bold; -fx-font-size: 16px;" );
        }

    }

    public class QuizButton extends Button {
        public QuizButton()
        {
            setText("Quiz");
            setShape(new Circle(10));
            setPrefHeight(100); setPrefWidth(100);
            setStyle("-fx-background-color: #B99A7B; -fx-text-fill:#D5DFD9; -fx-font-weight: bolder; -fx-font-size: 18px;" );
        }
    }
}
