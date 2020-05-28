package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class QuizPane extends BorderPane {
    protected StackPane lessonStack = new StackPane();
    protected Button fwrdButton = new Button("Begin Quiz");
    private final BorderPane page1 = new BorderPane();
    private final VBox page2 = new VBox();
    protected BorderPane page3 = new BorderPane();
    private int totalQuestions;
    private Question Q1,Q2,Q3,Q4, Q5, Q6, Q7, Q8, Q9, Q10, Q11, Q12;
    private Question[] questions;
    public QuizPane(int level)
    {
        //Init Vars
        lessonStack.setPrefWidth(750);
        lessonStack.setPrefHeight(700);
        page1.setId("title");
        page2.setId("quiz"); page2.setVisible(false);
        page3.setId("results");page3.setVisible(false);
        page2.setSpacing(5);
        Title resultTitle = new Title("Quiz Results:",false);
        page3.setTop(resultTitle);

        // Customize NavBar Ui
        fwrdButton.setStyle("-fx-background-color: #B99A7B; -fx-font-size: 18px; -fx-font-weight: bold");
        fwrdButton.setPrefHeight(50);
        fwrdButton.setPrefWidth(750);
        fwrdButton.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));

        //
        page2.setStyle("-fx-font-size: 20; -fx-background-color: #DCDCDC ");
        page2.setAlignment(Pos.CENTER);
        setBottom(fwrdButton);

        //Create Necessary Quiz
        switch (level){
            case 1:
                createQuiz1();
                break;
            case 2:
                createQuiz2();
                break;
            case 3:
                createQuiz3();
                break;
        }
        setAlignment(getCenter(),Pos.CENTER);
    }

    // Create the Quiz for Level 1
    public void createQuiz1()
    {

        // Filler Code
        // Replace!!
        Title quizTitle = new Title("Beginner Debugging Quiz", true);
        page1.setCenter(quizTitle);

        // Question 1
        Label Question1 = new Label("1. Which of the following is an example of debugging?");
        Question1.setStyle("-fx-font-weight: bold;");
        Q1 = new Question("Max is without a laptop, but needs to submit homework.\nAfter assessment, he determines he can use his phone.","Nancy's simple calculator program is giving incorrect results.\nAfter inspection she realizes an error in her code and fixes it.", "Both", "Both");

        // Question 2
        Label Question2 = new Label("2. Which of these statements about bugs is FALSE?");
        Question2.setStyle("-fx-font-weight: bold;");
        Q2 = new Question("Bugs can be errors, flaws, and faults","A single bug can trickle down, creating more bugs", "Bugs can't be caused by the user", "Bugs can't be caused by the user");

        // Question 3
        Label Question3 = new Label("3. What is an example of a semantic error?");
        Question3.setStyle("-fx-font-weight: bold;");
        Q3 = new Question("Working code with an incorrect output","Code that runs, but is disorganized", "An error caused by a missing semicolon", "Working code with an incorrect output");

        // Question 4
        Label Question4 = new Label("4. What is an example of a syntax error?");
        Question4.setStyle("-fx-font-weight: bold;");
        Q4 = new Question("Error in logic","Missing [or extra] parenthesis/bracket in code", "Code that runs, but displays the wrong output", "Missing [or extra] parenthesis/bracket in code");

        // Question 5
        Label Question5 = new Label("5. What is code organization?");
        Question5.setStyle("-fx-font-weight: bold;");
        Q5 = new Question("The order in which code must be written","A technique to help make code easier to read", "How the system reads the code it's given", "A technique to help make code easier to read");

        // Question 6
        Label Question6 = new Label("6. What is the main point of code organization?");
        Question6.setStyle("-fx-font-weight: bold;");
        Q6 = new Question("To ensure that the code will run","To ensure that bugs will not occur in the code", "To make it easier to debug", "To make it easier to debug");

        // Question 7
        Label Question7 = new Label("7. What is one ideal way to organize your code");
        Question7.setStyle("-fx-font-weight: bold;");
        Q7 = new Question("With Tabs","The Way Easiest for You to Read", "The way you were taught in class", "The Way Easiest for You to Read");

        // Question 8
        Label Question8 = new Label("8. Which of the following can be used to help organize code");
        Question8.setStyle("-fx-font-weight: bold;");
        Q8 = new Question("Proper Tabbing","Creating code blocks", "All of the Above", "All of the Above");

        // Question 9
        Label Question9 = new Label("9. Which debugging method would be the best choice for this situation: \n");
        Label Question9Prompt = new Label("Jessica is new to coding and is writing a simple \"Hello World\" program in JAVA,\nShe has only three lines of code and the program is giving an error.");
        Question9.setStyle("-fx-font-weight: bold;");
        Question9Prompt.setLabelFor(Question9);
        Question9Prompt.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-font-style: italic");
        Q9 = new Question("Backtracking","Program Slicing", "Bruteforce", "Bruteforce");

        page2.getChildren().addAll(Question1, Q1, Question2,Q2, Question3, Q3, Question4, Q4, Question5, Q5, Question6, Q6, Question7, Q7, Question8, Q8, Question9, Question9Prompt, Q9);
        questions = new Question[]{Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9};
        totalQuestions = 9;
        page2.setAlignment(Pos.TOP_LEFT);
        lessonStack.getChildren().setAll(page3,page2,page1);
        setCenter(lessonStack);
    }

    // Create the Quiz for Level 2
    public void createQuiz2()
    {
        Title quizTitle = new Title("Intermediate Debugging Quiz", true);
        page1.setCenter(quizTitle);

        // Question 1
        Label Question1 = new Label("1. What SHOULDN’T be considered when debugging using breakpoints?");
        Question1.setStyle("-fx-font-weight: bold;");
        Q1 = new Question("Scope of breakpoints","Number of BreakPoints", "Input and Output Functionality", "Input and Output Functionality");

        // Question 2
        Label Question2 = new Label("2. What does Error Clustering mean?");
        Question2.setStyle("-fx-font-weight: bold;");
        Q2 = new Question("Gather all errors","Gather all errors and categorize the by type", "Solve a chunk of errors one by one", "Solve a chunk of errors one by one");

        // Question 3
        Label Question3 = new Label("3. What is the intuition in Bug Clustering?");
        Question3.setStyle("-fx-font-weight: bold;");
        Q3 = new Question("Fixing one class helps find common class errors","Fixing one type of error can offset errors of other types", "Both", "Both");

        // Question 4
        Label Question4 = new Label("4. Which one of these is NOT a type of error?");
        Question4.setStyle("-fx-font-weight: bold;");
        Q4 = new Question("Variable value error","Memory allocation error", "Class name error", "Variable value error");

        // Question 5
        Label Question5 = new Label("5. Which is a bisection approach to locate the error in code larger than 50 lines?");
        Question5.setStyle("-fx-font-weight: bold;");
        Q5 = new Question("Simplifying the function","Print Statements", "Adding comments", "Print Statements");

        // Question 6
        Label Question6 = new Label("6. Which are alternatives for when error debugging tools are not available?");
        Question6.setStyle("-fx-font-weight: bold;");
        Q6 = new Question("Divide and conquer","Printing or commenting out function return values", "Both", "Both");

        // Question 7
        Label Question7 = new Label("7. Which process could find error source in function f() = (x();y();z())?");
        Question7.setStyle("-fx-font-weight: bold;");
        Q7 = new Question("Rearrange the order of the methods","Comment out one function at a time", "Add comments to explain the function role", "Comment out one function at a time");

        // Question 8
        Label Question8 = new Label("8. Which divide and conquer method uses comments to find function errors?");
        Question8.setStyle("-fx-font-weight: bold;");
        Q8 = new Question("Comment code out until error ceases","Comment out only function return values", "Both", "Comment code out until error ceases");

        // Question 9
        Label Question9 = new Label("9. A function is returning an unexpected value. What can you do?");
        Question9.setStyle("-fx-font-weight: bold;");
        Q9 = new Question("Print variables after each calculation","Comment out calculations that change values", "Rearrange the order of the values assigned", "Print variables after each calculation");


        // Question 10
        Label Question10 = new Label("10. Implementing boolean flags can be used to?");
        Question10.setStyle("-fx-font-weight: bold;");
        Q10 = new Question("Signify if a function returns an unexpected value, stop execution","Signify if a function is successful, continue execution", "Both", "Both");


        // Question 11
        Label Question11 = new Label("11. Removing portions of code that are not relevant to the bug aims to?");
        Question11.setStyle("-fx-font-weight: bold;");
        Q11 = new Question("Use of debuggers","Binary search", "Creating simpler code to highlight the bug", "Creating simpler code to highlight the bug");

        // Question 12
        Label Question12 = new Label("12. Which are strategic locations for print statements to locate function errors?");
        Question12.setStyle("-fx-font-weight: bold;");
        Q12 = new Question("After a value is changed by a function","After every value assignment", "End of code block, after a value is changed multiple times", "After a value is changed by a function");


        page2.getChildren().addAll(Question1, Q1, Question2,Q2, Question3, Q3, Question4, Q4, Question5, Q5, Question6, Q6, Question7, Q7, Question8, Q8, Question9, Q9, Question10, Q10, Question11, Q11, Question12, Q12);

        questions = new Question[]{Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10, Q11, Q12};
        totalQuestions = 12;
        page2.setAlignment(Pos.TOP_LEFT);
        lessonStack.getChildren().setAll(page3,page2,page1);
        setCenter(lessonStack);
    }

    // Create the Quiz for Level 3
    public void createQuiz3()
    {
        ////Page 1
        Title quizTitle = new Title("Advanced Debugging Quiz", true);
        page1.setCenter(quizTitle);

        ////Page 2
        //Q1
        Label Question1 = new Label("1. Where do you usually print the stack trace from?");
        Question1.setStyle("-fx-font-weight: bold;");
        Q1 = new Question("From Console","From Compiler Settings","From Code","From Code");

        //Q2
        Label Question2 = new Label("2. Where do you usually access memory faults from?");
        Q2 = new Question("From Console","From Compiler Settings","From Code","From Console");
        Question2.setStyle("-fx-font-weight: bold;");

        //Q3
        Label Question3 = new Label("3. Select the Memory Error.");
        Q3 = new Question("IO Exception","Segmentation Fault", "Missing Return Statement", "Segmentation Fault");
        Question3.setStyle("-fx-font-weight: bold;");

        //Q4
        Label Question4 = new Label( "4. Automated Testing is usually done through?");
        Q4 = new Question("Code","Compiler Features","Both", "Both");
        Question4.setStyle("-fx-font-weight: bold;");

        //breakpoint lesson questions
        //Q5
        Label Question5 = new Label( "5. What SHOULDN’T be considered when debugging using breakpoints?");
        Q5 = new Question("Scope of breakpoints","Numbers of breakpoints","Purpose of program", "Numbers of breakpoints");
        Question5.setStyle("-fx-font-weight: bold;");


        //Q6
        Label Question6 = new Label( "6. What button do you use to skip to next function call in the call stack?");
        Q6 = new Question("Step over","Step on","Skip", "Step over");
        Question6.setStyle("-fx-font-weight: bold;");


        //Q7
        Label Question7 = new Label( "7. Where do you look if you get the wrong result from a multiply function?");
        Q7 = new Question("Result variable","Multiply Function","Stack overflow", "Multiply Function");
        Question7.setStyle("-fx-font-weight: bold;");


        //Q8
        Label Question8 = new Label( "8. what type of variables do you keep track when you step over? ");
        Q8 = new Question("Variables","Local and Global variables","Function Variables", "Local and Global variables");
        Question8.setStyle("-fx-font-weight: bold;");


        //bug clustering questions
        //Q9
        Label Question9 = new Label( "9. What does Error Clustering mean? ");
        Q9 = new Question("Gather all errors","A technique to solve a chunk of errors one by one.","Gather all errors and categorize them by error types", "Gather all errors and categorize them by error types");
        Question9.setStyle("-fx-font-weight: bold;");

        //Q10

        Label Question10 = new Label( "10. What is the first step when using Error Clustering?");
        Q10 = new Question("Google","Gather all errors in a sheet","All of the above", "Gather all errors in a sheet");
        Question10.setStyle("-fx-font-weight: bold;");

        //Q11
        Label Question11 = new Label( "11. What is the intuition in Bug Clustering?");
        Q11 = new Question("Fixing one class helps find common class errors","Fixing one type of error can offset errors of other types.\n","Both", "Both");
        Question11.setStyle("-fx-font-weight: bold;");


        //Q12
        Label Question12 = new Label( "12. Which one of these is NOT a type of error?");
        Q12 = new Question("Variable value error","Memory allocation error","Class name error", "Class name error");
        Question12.setStyle("-fx-font-weight: bold;");


        page2.getChildren().addAll(Question1, Q1, Question2,Q2, Question3, Q3, Question4, Q4, Question5, Q5, Question6, Q6, Question7, Q7, Question8, Q8, Question9, Q9, Question10, Q10, Question11, Q11, Question12, Q12);

        questions = new Question[]{Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10, Q11, Q12};
        totalQuestions = 12;
        page2.setAlignment(Pos.TOP_LEFT);
        //page2.setStyle("-fx-wrap-text: true");
        lessonStack.getChildren().setAll(page3,page2,page1);
        setCenter(lessonStack);
    }

    // Update results text based off score received
    public void setResultText(String results)
    {
        sample.LessonPane.LessonText resultText = new sample.LessonPane.LessonText(results);
        page3.setCenter(resultText);
    }

    // Returns Quiz Score
    public int calculateScore(){
        int score = 0;
        // Iterate through questions and calculate score
        try {
            for (Question q : questions) {
                if (((RadioButton) q.toggleGroup.getSelectedToggle()).getText().equals(q.getAnswer())) {
                    score++;
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println("Non answered questions ");
            // Do something?
        }
        return score;
    }

    public int getTotalQuestions()
    {
        return totalQuestions;
    }

    public class Question extends HBox{
        protected RadioButton a1;
        protected RadioButton a2;
        protected RadioButton a3;
        private final String answer;
        protected ToggleGroup toggleGroup = new ToggleGroup();
        public Question(String a, String b, String c, String ans)
        {
            // Creates vertical set of possible answers.
            this.answer = ans;
            RadioButton a1 = new RadioButton(a);
            a1.setId(a);
            RadioButton a2 = new RadioButton(b);
            a2.setId(b);
            RadioButton a3 = new RadioButton(c);
            a3.setId(c);
            toggleGroup.getToggles().addAll(a1,a2,a3);
            getChildren().addAll(a1,a2,a3);
            setAlignment(Pos.TOP_LEFT);
            setSpacing(5);
            setStyle("-fx-font-size: 12px;");
        }

        public String getAnswer() {
            return answer;
        }
    }
}
