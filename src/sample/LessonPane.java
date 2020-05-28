package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;

public class LessonPane extends BorderPane {

    private final int level;
    private final int lesson;
    private final BorderPane page1 = new BorderPane();
    private final BorderPane page2 = new BorderPane();
    private final BorderPane page3 = new BorderPane();
    private final BorderPane page4 = new BorderPane();
    private final BorderPane page5 = new BorderPane();
    private final BorderPane page6 = new BorderPane();
    private final BorderPane page7 = new BorderPane();
    private final BorderPane page8 = new BorderPane();
    private final BorderPane page9 = new BorderPane();
    private Title lessonTitle;
    protected StackPane lessonStack = new StackPane();
    private final BorderPane navBar = new BorderPane();
    protected Button backButton = new Button("Back");
    protected Button fwrdButton = new Button("Fwrd");

    public LessonPane(int levelNum, int lessonNum) {
        // Set Class Fields
        this.level = levelNum;
        this.lesson = lessonNum;
        lessonStack.setPrefWidth(750);
        lessonStack.setPrefHeight(700);
        page1.setId("mainTitle");
        page2.setId("page2");
        page3.setId("page3");
        page4.setId("page4");
        page5.setId("page5");
        page6.setId("page6");
        page7.setId("page7");
        page8.setId("page8");
        page9.setId("page9");
        page1.setVisible(true);
        page2.setVisible(false);
        page3.setVisible(false);
        page4.setVisible(false);
        page5.setVisible(false);
        page6.setVisible(false);
        page7.setVisible(false);
        page8.setVisible(false);
        page9.setVisible(false);

        // Create NavBar
        backButton.setVisible(false);

        //test
        // Customize NavBar Ui
        backButton.setStyle("-fx-background-color: #B99A7B;");
        fwrdButton.setStyle("-fx-background-color: #B99A7B;");
        navBar.setStyle("-fx-background-color: #535E6E;");
        navBar.setPrefHeight(50);
        backButton.setPrefHeight(50);
        fwrdButton.setPrefHeight(50);
        // Set NavBar
        navBar.setLeft(backButton);
        navBar.setRight(fwrdButton);
        setBottom(navBar);

        switch (levelNum) {
            case 1:
                switch (lessonNum) {
                    case 1:
                        makeLevel1Lesson1();
                        break;
                    case 2:
                        makeLevel1Lesson2();
                        break;
                    case 3:
                        makeLevel1Lesson3();
                        break;
                }
                break;
            case 2:
                switch (lessonNum) {
                    case 1:
                        makeLevel2Lesson1();
                        break;
                    case 2:
                        makeLevel2Lesson2();
                        break;
                    case 3:
                        makeLevel2Lesson3();
                        break;
                }
                break;
            case 3:
                switch (lessonNum) {
                    case 1:
                        makeLevel3Lesson1();
                        break;
                    case 2:
                        makeLevel3Lesson2();
                        break;
                    case 3:
                        makeLevel3Lesson3();
                        break;
                }
                break;
        }
    }

    public int getLesson() {
        return lesson;
    }

    public int getLevel() {
        return level;
    }

    public void makeLevel1Lesson1() {
        lessonTitle = new Title("Welcome to level 1 module 1! \n\n Lesson Overview: \n\n This lesson will teach you the basics of debugging nd how it effects your life both in and out of the programming world.\n \n  Key takeaways for this module:\n \n By the end of this lesson you should be familiar with the topic of debugging and know about the basics of bugs.", true);
        page1.setCenter(lessonTitle);

        //page 2
        Title title2 = new Title("What is debugging?",false);
        LessonText tf2 = new LessonText("Debugging is one of the most critical parts of developing and maintaing computer software. By definition debugging is the process of identifying and removing errors from computer hardware or software.  More specifically, we call the process of debugging within a software application “software debugging.” There are a wide variety of different software debugging techniques, and each have their own strengths and weaknesses.  Knowing how to use the right technique is a vital skill for any software developer.");

        page2.setTop(title2);
        page2.setCenter(tf2);


        Title title3 = new Title("Debugging in the real world",false);
        LessonText tf3 = new LessonText("Although debugging is primarily used by software developers, it does not have to be limited to simply computer software. Debugging can also be applied to the real world. Everyday we dubug things without even realizing that we are debugging something!"+"For example, let’s say Jake is driving on the highway and suddenly his car starts to feel wobbly.  Jake should intuitively pull over, knowing that something like this is not normal.  Once pulled over Jake will access the situation and come to find out that he had driven over a nail and his tire is quickly running out of air.  He quickly puts on the spare tire and continues on his way."+"In the above example. Jake realizes his car is acting abnormal and took the neccessary steps to figure out why. This is debugging in the real world.");
        page3.setTop(title3);
        page3.setCenter(tf3);

        Title title4 = new Title("The Basics",false);
        LessonText tf4 = new LessonText("What is a bug?\n\nA bug is an error, flaw or fault in a computer program or system that causes it to produce an incorrect or unexpected result, or to behave in unintended ways.\n\nWhere do bugs come from?\n\nMost bugs arise from mistakes and errors made in either a program's source code or its design, or in components and operating systems used by such programs. A few are caused by compilers producing incorrect code. A program that contains many bugs, and/or bugs that seriously interfere with its functionality, is said to be buggy (defective).\n\nWhy are bugs bad?\n\nBugs can trigger errors, and these errors can cause even more errors and have a ripple effect. Bugs may have subtle effects or cause the program to crash or freeze the computer. Other bugs qualify as security bugs and might, for example, enable a malicious user to bypass access controls in order to obtain unauthorized privileges.");
        page4.setTop(title4);
        page4.setCenter(tf4);

        Title title5 = new Title("Types of Bugs\nSyntax Errors",false);
        try {
            String dir = System.getProperty("user.dir") + "/media/testingonetwothree.png";
            Image img = new Image(new FileInputStream(dir));
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(550);
            imageView.setFitWidth(750);
            page5.setTop(title5);
            page5.setCenter(imageView);
        }catch (Exception e){ System.out.println(e.getMessage());}


        Title title6 = new Title("Types of Bugs",false);
        LessonText tf6 = new LessonText("Logic Errors\n\n\nLogic errors are one of the most common types of bugs. Logic errors occur when the code is mechanically correct but the programmer didn’t correctly translate what tasks needed to be done into code, so the code carries out the wrong steps and consequently gets the wrong answer.");
        page6.setTop(title6);
        page6.setCenter(tf6);

        Title title7 = new Title("Types of Bugs\nSemantic Errors",false);
        try {
            String dir = System.getProperty("user.dir") + "/media/ss2.png";
            Image img = new Image(new FileInputStream(dir));
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(550);
            imageView.setFitWidth(750);
            page7.setTop(title7);
            page7.setCenter(imageView);
        }catch (Exception e){ System.out.println(e.getMessage());}

        Title title8 = new Title("",false);
        try {
            String dir = System.getProperty("user.dir") + "/media/ss3.png";
            Image img = new Image(new FileInputStream(dir));
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(550);
            imageView.setFitWidth(750);
            page8.setTop(title8);
            page8.setCenter(imageView);
        }catch (Exception e){ System.out.println(e.getMessage());}
        page1.setVisible(true);
        page2.setVisible(false);
        page3.setVisible(false);
        page4.setVisible(false);
        page5.setVisible(false);
        page6.setVisible(false);
        page7.setVisible(false);
        page8.setVisible(false);


        lessonStack.getChildren().addAll(page8,page7,page6,page5, page4, page3, page2, page1);
        setCenter(lessonStack);
    }

    public void makeLevel1Lesson2() {
        lessonTitle = new Title("Welcome to level 1 module 2! \n\n Lesson Overview: \n\n This lesson will go over the various forms of debugging. In orther words, how do you not only recognize the error, but how do we approach fixing it? \n\n Key takeaways for this module: Know the key types of debugging and HOW and WHEN to use each.", true);
        page1.setCenter(lessonTitle);

        Title title2 = new Title("Brute Force",false);
        LessonText tf2 = new LessonText("This is the most common method but the most inefficient. It involves trying every possible input until one works.  This approach can take a very long time, depending on the task on hand.\n\nHow does it work?\nThis exhaustive test involves the problem solving method of systematically entering/trying every single combination of possibilities.");

        page2.setTop(title2);
        page2.setCenter(tf2);


        Title title3 = new Title("Backtracking",false);
        LessonText tf3 = new LessonText("With this particular approach you start where the error was discovered and work backwards until the error is discovered and ultimately fixed.\n\nHow does it work?\nThis method involves using breakpoints to work backwards through the logic of the program until you find the issue. Using this mental reversal of the program we can quickly pinpoint the issue.");

        page3.setTop(title3);
        page3.setCenter(tf3);


        Title title4 = new Title("Program Slicing",false);
        LessonText tf4 = new LessonText("This method is the most complicated and much like the last method involves using the breakpoints in order to find the section where the error is located. This method is best for a large program where you do not know where the issue is.\n\nHow does it work?\nProgram slicing, much like its name divides the program into multiple parts and tests them individually to see what parts have errors and which are good.");

        page4.setTop(title4);
        page4.setCenter(tf4);


        Title title5 = new Title("",false);
        try {
            String dir = System.getProperty("user.dir") + "/media/ss4.png";
            Image img = new Image(new FileInputStream(dir));
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(550);
            imageView.setFitWidth(750);
            page5.setTop(title5);
            page5.setCenter(imageView);
        }catch (Exception e){ System.out.println(e.getMessage());}


        lessonStack.getChildren().addAll(page5,page4, page3, page2, page1);
        setCenter(lessonStack);
    }

    public void makeLevel1Lesson3() {
        lessonTitle = new Title("Beginner Lesson 3: Code Organization", true);
        page1.setCenter(lessonTitle);

        Title title2 = new Title("What are Debug Messages", false);
        LessonText tf2 = new LessonText("These are what the compiler gives as feedback when you run a program.\n" +
                "After trying to run the program, it can successfully run or fail.\n" +
                "If it fails, the compiler will say so, and try to point out lines that cause the problem\n" +
                "There are a variety of types of errors, and these will likely be most helpful for finding syntax errors.\n" +
                "Example: Line: 45 Invalid syntax at ‘;’. Possibly a ‘(‘ is missing.\n");

        page2.setTop(title2);
        page2.setCenter(tf2);

        Title title3 = new Title("How to interpret error messages", false);
        LessonText tf3 = new LessonText("It is not always straightforward what they say, though the first step is to go to the \n" +
                "line that is shown, and see if there is something obvious you can fix. For example \n" +
                "if line 47 from the previous slide shows that you simply didn’t put the close \n" +
                "parenthesis, it will be fixed by adding it at the appropriate place\n" +
                "However this is not always the case. Sometimes an error on one line, could in \n" +
                "actuality be affected by an error on another line.\n" +
                "This makes it important to organize your code to tell what code goes together! \n");

        page3.setTop(title3);
        page3.setCenter(tf3);

        Title title4 = new Title("Organizing Code", false);
        LessonText tf4 = new LessonText("One very helpful way to make debugging a lot easier is to organize your code. \n" +
                "There are many different ways to do this, so it’s important to find a style that \n" +
                "works for you. \n" +
                "Examples can include lining up parenthesis using tabs so that say… a block of \n" +
                "code inside an if statement is tabbed in one way, while code outside of it is tabbed \n" +
                "a level back. \n");

        page4.setTop(title4);
        page4.setCenter(tf4);

        Title title5 = new Title("Examples of Organizing Code", false);
        LessonText tf5 = new LessonText("printf(“Hello world!”); \n" +
                "int number = 5;\n" +
                "while(number >0)\n" +
                "{\n" +
                "\tnumber--; \n" +
                "\tprintf(“The program moved forward”);\n" +
                "}\n");

        page5.setTop(title5);
        page5.setCenter(tf5);

        Title title6 = new Title("A Different Style to Organize Code", false);
        LessonText tf6 = new LessonText("printf(“Hello world!”);\n" +
                "int number = 5;\n" +
                "while(number >0){\n" +
                "\tnumber--; \n" +
                "\tprintf(“The program moved forward”);\n" +
                "}\n");

        page6.setTop(title6);
        page6.setCenter(tf6);

        Title title7 = new Title("The difference between organized and unorganized code", false);
        LessonText tf7 = new LessonText("printf(“Hello world!”); int number = 5; while(number >0){ number--; printf(“The program moved forward”);}”);\n" +
                "This is the same code as the previous slide, but it looks harder to tell what is part of what. It is important \n" +
                "to find SOME way to organize the code so that you can read the code easily and thus find errors easier, \n" +
                "especially in larger snippits of code. Just because it compiles, doesn’t mean it will be easy to debug, \n" +
                "especially as code gets larger.\n" +
                "It isn’t terribly important HOW you choose to organize your code, so much as being able to find a system \n" +
                "that works for you\n");

        page7.setTop(title7);
        page7.setCenter(tf7);

        lessonStack.getChildren().addAll(page7, page6, page5, page4, page3, page2, page1);
        setCenter(lessonStack);
    }

    public void makeLevel2Lesson1() {
        //title page
        lessonTitle = new Title("Intermediate Lesson 1: Debbuging using Breakpoints", true);
        page1.setCenter(lessonTitle);


        Title title2 = new Title("SAME PROBLEM: CONSIDER THE SOURCE CODE", false);
        //picture of the entire example - page 2
        try {
            String dir = System.getProperty("user.dir") + "\\media\\firstSnippet.png";
            Image img = new Image(new FileInputStream(dir));
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(550);
            imageView.setFitWidth(750);
            page2.setTop(title2);
            page2.setCenter(imageView);
        }catch (Exception e){ System.out.println(e.getMessage());}

        //page 3

        Title title3 = new Title(" Lets run this program and try some sample inputs!", false);

        try {
            String dir = System.getProperty("user.dir") + "\\media\\secondSnippet.png";
            Image img = new Image(new FileInputStream(dir));
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(550);
            imageView.setFitWidth(750);
            page3.setTop(title3);
            page3.setCenter(imageView);
        }catch (Exception e){ System.out.println(e.getMessage());}

        //page 4

        Title title4 = new Title("Lets take a look at the code, to find the issue(bug) we first need to know where to look", false);
        LessonText tf4 = new LessonText("Languages: All\n" +
                "Questions to ask yourself?\n" +
                "What is the purpose of the program that you are using?\n" +
                "Find the function that calculates the result that you are looking for.\n" +
                "How many inputs is the program taking? What is name of the result variable?\n" +
                "After answering the questions\n"+
                "Set break points around the function that we are testing.\n");

        page4.setTop(title4);
        page4.setCenter(tf4);

        //page 5

        try {
            String dir = System.getProperty("user.dir") + "\\media\\thirdSnippet.png";
            Image img = new Image(new FileInputStream(dir));
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(550);
            imageView.setFitWidth(750);
            page5.setCenter(imageView);
        }catch (Exception e){ System.out.println(e.getMessage());}
        //page 6
        try {
            String dir = System.getProperty("user.dir") + "\\media\\fourthSnippet.png";
            Image img = new Image(new FileInputStream(dir));
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(550);
            imageView.setFitWidth(750);
            page6.setCenter(imageView);
        }catch (Exception e){ System.out.println(e.getMessage());}

        //page 7
        try {
            String dir = System.getProperty("user.dir") + "\\media\\fifthSnippet.png";
            Image img = new Image(new FileInputStream(dir));
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(550);
            imageView.setFitWidth(750);
            page7.setCenter(imageView);
        }catch (Exception e){ System.out.println(e.getMessage());}


        //page 8
        Title title8 = new Title("THEN WE HOVER OVER VARIABLES THAT WE WANT TO CHECK VALUE OF", false);
        try {
            String dir = System.getProperty("user.dir") + "\\media\\sixthSnippet.png";
            Image img = new Image(new FileInputStream(dir));
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(550);
            imageView.setFitWidth(750);
            page8.setTop(title8);
            page8.setCenter(imageView);
        }catch (Exception e){ System.out.println(e.getMessage());}


        //page 9
        Title title9 = new Title("We correct the code, we are done!", false);
        try {
            String dir = System.getProperty("user.dir") + "\\media\\seventhSnippet.png";
            Image img = new Image(new FileInputStream(dir));
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(550);
            imageView.setFitWidth(750);
            page9.setTop(title9);
            page9.setCenter(imageView);
        }catch (Exception e){ System.out.println(e.getMessage());}






        lessonStack.getChildren().addAll(page4, page3, page2, page1);
        setCenter(lessonStack);
    }

    public void makeLevel2Lesson2() {
        //Title - page 1
        lessonTitle = new Title("Intermediate Lesson 2: Bug Clustering", true);
        page1.setCenter(lessonTitle);

        //page 2
        Title title2 = new Title("Debbuging: BUG CLUSTERING", false);


        LessonText tf2 = new LessonText("Languages: All\n" +
                "Important strategy in debugging large source code files with many errors.\n" +
                "GENERAL IDEA: we gather all errors in a sheet to form a personal error/output log, \n" +
                "we conduct analysis on the error/output log and classify error type.\n" +
                "Some common error types:\n" +
                "-variable value errors\n" +
                "-memory allocation errors\n"+
                "-language specific syntax error\n"+
                "Knowing these error types can often lead us to find bugs faster.\n");

        page2.setTop(title2);
        page2.setCenter(tf2);

        //page 3
        Title title3 = new Title("EXAMPLE", false);
        page3.setTop(title3);
        //picture of the entire example
        try {
            String dir = System.getProperty("user.dir") + "\\media\\Example.png";
            Image img = new Image(new FileInputStream(dir));
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(550);
            imageView.setFitWidth(750);
            page3.setCenter(imageView);
        }catch (Exception e){ System.out.println(e.getMessage());}

        //page 4
        Title title4 = new Title("Intuition – clustering errors", false);

        LessonText tf4 = new LessonText("Languages: All\n" +
                "Scenario:  All errors in the error log from different classes show similarity. \n" +
                "Approach: we determine that similarity, if one bug is fixed in one class, other errors dependent on that class will be automatically fixed, that is the intuition.\n");

        page4.setTop(title4);
        page4.setCenter(tf4);


        lessonStack.getChildren().addAll(page4, page3, page2, page1);
        setCenter(lessonStack);
    }

    public void makeLevel2Lesson3() {
        lessonTitle = new Title("Intermediate Lesson 2: Print Statements and Simplifying Methods", true);
        page1.setCenter(lessonTitle);

        // Page 2
        Title title2 = new Title("Printing Statements", false);
        LessonText tf2 = new LessonText("Languages: All\n" +
                "Description: As a more beginner friendly alternative to a debugger, print statements are simple method can help visualize what is happening in the code. It can be used as a tool for finding where the code stops executing due to errors. For instance, implementing print statements is useful for seeing the value of a variable and applying a divide and conquer approach.\n" +
                "Let’s say there is a piece of code for a function that is outputting undesirable results, then the print statement approach would be applicable to pinpoint errors. If it is uncertain that a section of code is being executed (certain conditions are not being met or certain values are not being updated), dropping print statements after these lines of code is a simple and quick way to determine where the errors are.\n" +
                "Approach: For a bisection approach, print statements can locate where the program stops running due to bugs—this method eliminates as much code as possible. For example, in a program with errors that has 500 lines of code it is hard to trace the line of code that contains errors. If a print statement is placed at line 300, and the output is running properly or returning the correct values, then lines 1-299 are error free.\n" +
                " If a print statement is placed on line 400 and the program does not run, then the error is in between line 301-399. Then a print statement is placed in the middle of those lines, at line 350. If the program runs, then it can be concluded that the error is in lines 351-399, if not then the error lies between lines 301-349. Keep repeating the process to pinpoint the exact location that is causing the program to throw errors. \n");
        page2.setTop(title2);
        page2.setCenter(tf2);

        // Page 3
        // Image example
        Title title3 = new Title("Example: Print Statements ", false);
        try {
            String dir = System.getProperty("user.dir") + "\\media\\Print_statements.png";
            Image img = new Image(new FileInputStream(dir));
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(550);
            imageView.setFitWidth(750);
            page3.setTop(title3);
            page3.setCenter(imageView);
        }catch (Exception e){ System.out.println(e.getMessage());}

        // Page 4
        Title title4 = new Title("Simplifying Methods", false);
        LessonText tf4 = new LessonText("Languages: All\n" +
                "Description: Simplifying is minimally invasive probe like print statements. Implementing this method highlights the functions that return errors by eliminating sections of code to target the problem areas. Comments can be utilized to isolate certain function calls in a method.\n" +
                "Approach: The goal is to make the code simpler and therefore easier to track what is yielding error messages. For instance, if part of a method calls three different functions, this strategy would comment out each function call to pinpoint the faulty one that is outputting errors. Other elements within functions, such as values, can also be commented out to localize problem areas.\n");

        page4.setCenter(tf4);
        page4.setTop(title4);

        // Page 5
        // Image example
        Title title5 = new Title("Example: Simplifying Methods ", false);
        try {
            String dir = System.getProperty("user.dir") + "\\media\\Simplifying_methods.png";
            Image img = new Image(new FileInputStream(dir));
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(550);
            imageView.setFitWidth(750);
            page5.setTop(title5);
            page5.setCenter(imageView);
        }catch (Exception e){ System.out.println(e.getMessage());}

        lessonStack.getChildren().addAll(page5,page4, page3, page2, page1);
        setCenter(lessonStack);
    }

    public void makeLevel3Lesson1() {

        //Title Page
        lessonTitle = new Title("Advanced Lesson 1: Further Information Necessary", true);
        page1.setCenter(lessonTitle);

        //Page 2
        Title title2 = new Title("Printing Stack Trace", false);
        LessonText tf2 = new LessonText("Languages: All\n" +
                "Description: Printing out the compiling steps that can be followed to see the steps leading to an error\n" +
                "Medium Level related concept: Utilizing break points to determine history leading to the bug.\n" +
                "Low Level related concept: Examining Code Lines before the bug or point of break, and working down to or up from the line of error.\n" +
                "\n" +
                "Steps: Vary but typically is done through the console or through a line of code\n" +
                "\n" +
                "Use: Printing the stack trace is a helpful tool to view exactly what went wrong, as well as where. Stack trace will give any useful method information and usually displays the error that causes a bug. Stack trace allows one to see how events transpire making it easy to pinpoint if certain things occur out of your preferred time line. \n");

        page2.setTop(title2);
        page2.setCenter(tf2);

        //Page 3 Use an Image Example
        Title title3 = new Title("Example: Printing the stack trace", false);
        page3.setTop(title3);
        try {
            String dir = System.getProperty("user.dir") + "\\media\\stack_trace_example.png";
            Image img = new Image(new FileInputStream(dir));
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(550);
            imageView.setFitWidth(750);
            page3.setCenter(imageView);
        }catch (Exception e){ System.out.println(e.getMessage());}

        //Page 4
        Title title4 = new Title("Accessing Memory Dump", false);
        LessonText tf4 = new LessonText("Languages: Typically Object Oriented (C++, Java)\n" +
                "Description: Accessing the information of a memory dump (typically of a segmentation fault induced by bad memory allocation) that is usually discarded\n" +
                "Medium Level related concept: Using Try-Catch Statements to catch errors before they happen and use those captured errors to learn the errors information.\n" +
                "Low level related concept: Could not think of one (need to look further into this one)\n" +
                "\n" +
                "Steps: Vary (console command for C++, Implemented objects and several lines of code for Java). Relies on using Linux commands to view a memory dump location\n" +
                "\n" +
                "Use: Accessing a memory dump is useful in times where nothing else is. While stack trace and breakpoints can lead one to where the error occurs, they can fail to assess the full details of memory related errors. Accessing a memory dump allows you to see the type of memory error, and see more specific details on why it occurred. Memory is a complicated concept, and in memory allocation driven languages (Ex. C++) knowing how to understand and combat these errors are important.\n");
        page4.setCenter(tf4);
        page4.setTop(title4);

        //Add Pages to stack Pane
        lessonStack.getChildren().addAll(page4, page3, page2, page1);
        //Add Stack Pane to Border Pane Center
        setCenter(lessonStack);
    }

    public void makeLevel3Lesson2() {
        // Page 1
        lessonTitle = new Title("Advanced Lesson 2: Advanced Testing", true);
        page1.setCenter(lessonTitle);

        // Page 2
        Title title2 = new Title("Automated Testing", false);
        LessonText tf2 = new LessonText("Languages: All\n" +
                "Description: Utilizing test case classes (Example JUnit 5 for Java) to test working or partially working code in order to assess if errors or bugs exist in the code, if bugs are known, then can be used to figure out when they occur and when they do not occur. (Code Coverage might be good to include here).\n" +
                "Medium level related concept: Writing test cases and hand testing coding paths with these test cases to find bugs or errors in the code.\n" +
                "Low Level related coding concept: Using print to console statements as a means of determining bugs or errors and their place in the code.\n" +
                "\n" +
                "Steps: Vary (For example: Java, create a JUnit class, give the actual code real inputs, and compare the returned results to your expected results, do this for all possible paths)\n" +
                "\n" +
                "Use: Automated testing can be a useful concept for find logical and situational bugs that are hidden from most manual testing. Automated testing is good at finding errors that occur on border values, situations and scenarios that sit at the edge of what is possible, and by exploring scenarios that don’t follow strong logical sense.\n");
        page2.setCenter(tf2);
        page2.setTop(title2);

        //Page 3
        Title title3 = new Title("Example: Automated Testing", false);
        page3.setTop(title3);
        try {
            String dir = System.getProperty("user.dir") + "\\media\\intellij_run_test.png";
            Image img = new Image(new FileInputStream(dir));
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(550);
            imageView.setFitWidth(750);
            page3.setCenter(imageView);
        }catch (Exception e){ System.out.println(e.getMessage());}

        //Add pages to stack Pane
        page1.setVisible(true);
        page2.setVisible(false);
        page3.setVisible(false);
        lessonStack.getChildren().addAll(page3, page2, page1);
        //Add Stack Pane to Border Pane Center
        setCenter(lessonStack);
    }

    public void makeLevel3Lesson3() {
        //Page 1
        lessonTitle = new Title("Advanced Lesson 3: Debugging Checklist", true);
        page1.setCenter(lessonTitle);

        //Page 2
        Title title2 = new Title("The Debugging Checklist", false);
        LessonText LessonText = new LessonText("Languages: All\n" +
                "Description: A planned list or flowchart that aids a programming in debugging.\n" +
                "Use: A debugging checklist is a valuable concept that helps a programmer decide what kind of debugging concept should be used for what scenario. There is no absolute way to debug so a debugging checklist should be something used as a guideline and suited towards the debugger. A debugging checklist should take in the debugger’s knowledge, strength, as well as their own personal beliefs and comforts.\n");

        page2.setTop(title2);
        page2.setCenter(LessonText);

        //Page 3
        Title title3 = new Title("Debugging Checklist Example", false);
        LessonText tf3 = new LessonText("1a. If an error shows up, what is the error? \n" +
                "\t2a. If syntax (or similar) error is displayed, does compiler outline it (most modern compilers should), or does error give a line for the error? Check for red squiggles fix if easily fixable.\n" +
                "\t2b. If error is that of an exception, Put try and catch around code, crab the exception as it occurs and print its information to the console, use that information to fix the problem. If necessary, research the exception to determine what is causing it, if not easily fixable, proceed to 3a/3b.\n" +
                "\t2c. If error is that of segmentation fault, access segmentation core dump and see what’s going on. Certain languages like C++ will allow for commands to warn about problematic memory coding lines that could help as well. \n" +
                "\t\t3a. If issue was not solved: Print stack trace and run through exactly what lead up to the error.\n" +
                "\t\t\t4a. If printing stack trace does not help, try using breakpoints and the compilers debugging mode to slowly go through the code and keep track of variables.\n" +
                "1b. If coding is compiling but output is wrong?\n" +
                "\t2d. If wrong for multiple inputs, create a test file and test all possible coding paths. If error still cant be determined, use 4a. For each incorrect path, or until all paths are corrected.\n" +
                "\t2e. If there is only one input and one (wrong) expected output, use 4a. To determine where the variables go wrong.\n" +
                "1c. If code sometimes compiles?\n" +
                "\t2f. For bugs follow 1a.\n" +
                "\t2g. For output errors follow 1b.\n");

        page3.setTop(title3);
        page3.setCenter(tf3);
        //Add pages to stack Pane
        lessonStack.getChildren().addAll(page3, page2, page1);

        //Add Stack Pane to Border Pane Center
        setCenter(lessonStack);
    }

    public static class LessonText extends Label {
        public LessonText(String string) {
            setText(string);
            setPrefSize(750, 600);
            setStyle("-fx-background-color: #DCDCDC; -fx-wrap-text: true; -fx-text-fill: #33383E; -fx-font-size: 18px; -fx-font-weight: bold; -fx-font-family: Arial;");
            setTextAlignment(TextAlignment.JUSTIFY);
            setContentDisplay(ContentDisplay.TOP);
            setPadding(new Insets(5, 5, 5, 10));
        }
    }


}

