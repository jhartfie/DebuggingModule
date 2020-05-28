package sample;

import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class Title extends Label {
    Title(String text, boolean isMainTitle)
    {
        setText(text);
        setStyle("-fx-font-size: 36px; -fx-wrap-text: true; -fx-background-color:#8d9aa6; -fx-text-fill: #33383E; -fx-font-weight: bolder");
        if (isMainTitle)
        {
            setPrefSize(750,700);
        }
        else
        {
            setPrefSize(750,100);
            setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        }
        setTextAlignment(TextAlignment.CENTER);
        setContentDisplay(ContentDisplay.CENTER);
    }
}
