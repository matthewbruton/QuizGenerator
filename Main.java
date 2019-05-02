// Project: Milestone2
// Authors: Matthew Bruton (mbruton@wisc.edu), Tambre Hu (thu53@wisc.edu), Wei Shi
// (wshi48@wisc.edu), Abigail Shaffer (ajshaffer@wisc.edu), Saketh Challa (spchalla@wisc.edu)
// Lecture Number: 001
// Due Date: 4/25/2019 at 10pm
// Other Credit Sources: N/A
// Known Bugs: N/A
// This class produces the JavaFX GUI for our quiz generator program. The
// class presents the main layout view that the user will see for the program.

package application;

import java.util.ArrayList;
import java.util.List;
// import statements (can be ignored, but all javafx import statements)
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Main extends Application implements EventHandler<ActionEvent> {

  int numberOfQuestions; // the number of questions in the quiz

  // four boolean values representing which choice is correct, of which only one
  // is right
  boolean choiceAIsCorrect;
  boolean choiceBIsCorrect;
  boolean choiceCIsCorrect;
  boolean choiceDIsCorrect;

  // VBox
  VBox homePage;

  // HBox
  HBox numberOfQuestionsHBox;
  HBox uploadFileHBox;

  // Stuff
  Label homePageLabel;
  Button addNewQuestionButton;
  ObservableList<String> topics; // list of the potential topics
  ComboBox<String> topicBox;
  Label numberOfQuestionsLabel;
  Button decreaseNumberOfQuestionsButton; // button to decrease the number of questions at user's
                                          // desire

  TextField numberOfQuestionsField; // where the integer representing the number of questions will
                                    // be held in a text field

  Button increaseNumberOfQuestionsButton; // button to increase the number of questions at user's
                                          // desire

  Button uploadFileButton;
  TextField uploadFileField;
  Button generateQuizButton;

  Label quizEditorLabel;
  TextField questionField;
  TextField topicField;

  // where choices A,B,C,D will be held visually in a text field
  TextField choiceFieldA;
  TextField choiceFieldB;
  TextField choiceFieldC;
  TextField choiceFieldD;

  // four buttons to represent the four choices
  Button choiceButtonA;
  Button choiceButtonB;
  Button choiceButtonC;
  Button choiceButtonD;
  // button to allow functionality of saving questions within the quiz
  Button saveQuestionButton;
  Button homeButton; // button to be pressed when to return to home screen

  ImageView pic; // picture to present on the home page

  Scene scene;
  Scene questionEditorScene;
  Scene quizScene;

  QuestionEditor questionEditor;

  QuestionDatabase questionDatabase;

  List<QuestionNode> generatedQuiz;

  @Override
  public void start(Stage primaryStage) {
    try {

      // Data
      numberOfQuestions = 1; // start at 0 as the default number of questions, an empty quiz
      choiceAIsCorrect = false;
      choiceBIsCorrect = false;
      choiceCIsCorrect = false;
      choiceDIsCorrect = false;

      // VBox
      homePage = new VBox(10);
      homePage.setAlignment(Pos.TOP_CENTER);
      homePage.setPadding(new Insets(50));
      homePage.setStyle("-fx-background-color: azure"); // set background color

      // HBox
      numberOfQuestionsHBox = new HBox(10);
      uploadFileHBox = new HBox(10);
      numberOfQuestionsHBox.setAlignment(Pos.CENTER);
      uploadFileHBox.setAlignment(Pos.CENTER);

      // QuestionDatabase
      questionDatabase = new QuestionDatabase();

      homePageLabel = new Label("QUIZ GENERATOR");
      homePageLabel.setFont(Font.font("Times New Roman", 32));
      addNewQuestionButton = new Button("ADD NEW QUESTION");

      // drop down list of topics
      topics = FXCollections.observableArrayList(questionDatabase.getTopics());
      topicBox = new ComboBox<String>(topics);
      topicBox.setPromptText("SELECT A TOPIC");
      numberOfQuestionsLabel = new Label("Number of Questions: ");
      numberOfQuestionsLabel.setFont(Font.font("Times New Roman", 20));
      decreaseNumberOfQuestionsButton = new Button("<"); // this ">" button will decrease the number
                                                         // of questions
      numberOfQuestionsField = new TextField("" + numberOfQuestions);
      increaseNumberOfQuestionsButton = new Button(">"); // this ">" button will increase the number
                                                         // of questions

      uploadFileButton = new Button("upload file");
      uploadFileField = new TextField("file.json");
      generateQuizButton = new Button("GENERATE QUIZ");

      quizEditorLabel = new Label("QUIZ EDITOR");
      questionField = new TextField("Type question");
      topicField = new TextField("Type topic");
      choiceFieldA = new TextField("Type choice");
      choiceFieldB = new TextField("Type choice");
      choiceFieldC = new TextField("Type choice");
      choiceFieldD = new TextField("Type choice");
      choiceButtonA = new Button("" + choiceAIsCorrect);
      choiceButtonB = new Button("" + choiceBIsCorrect);
      choiceButtonC = new Button("" + choiceCIsCorrect);
      choiceButtonD = new Button("" + choiceDIsCorrect);

      pic = new ImageView(new Image("questionmark.jpg"));
      pic.setFitHeight(70);
      pic.setPreserveRatio(true);

      // Set up questionEditor Page
      questionEditor = new QuestionEditor();
      questionEditorScene = new Scene(questionEditor.getForm(), 400, 500); // scene dimensions
      questionEditorScene.getStylesheets()
          .add(getClass().getResource("application.css").toExternalForm());
      questionEditor.getHomeButton().setOnAction(e -> primaryStage.setScene(scene));
      questionEditor.getSaveButton().setOnAction(e -> {
        Choice aChoice = new Choice(questionEditor.getA(), questionEditor.aIsCorrect());
        Choice bChoice = new Choice(questionEditor.getB(), questionEditor.bIsCorrect());
        Choice cChoice = new Choice(questionEditor.getC(), questionEditor.cIsCorrect());
        Choice dChoice = new Choice(questionEditor.getD(), questionEditor.dIsCorrect());
        List<Choice> choices = new ArrayList<Choice>();
        choices.add(aChoice);
        choices.add(bChoice);
        choices.add(cChoice);
        choices.add(dChoice);
        Question newQuestion = new Question(questionEditor.getQuestion(), questionEditor.getTopic(),
            questionEditor.getImagePath(), choices);
        questionDatabase.addQuestion(newQuestion);
        topics = FXCollections.observableArrayList(questionDatabase.getTopics());
        topicBox = new ComboBox<String>(topics);

        // Update stuff to homePage
        homePage.getChildren().clear();
        homePage.getChildren().addAll(homePageLabel, addNewQuestionButton, topicBox,
            numberOfQuestionsLabel, numberOfQuestionsHBox, uploadFileHBox, generateQuizButton, pic);
      });

      // Set up a generated quiz page
      // quizScene = new Scene(questionNode.getNode(), 400, 500); // scene dimensions
      // quizScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
      // generatedQuiz = new ArrayList<QuestionNode>();
      // TODO this stuff
      // questionEditor.getHomeButton().setOnAction(e -> primaryStage.setScene(quizScene));

      // Add events to buttons
      addNewQuestionButton.setOnAction(e -> primaryStage.setScene(questionEditorScene));
      decreaseNumberOfQuestionsButton.setOnAction(this);
      increaseNumberOfQuestionsButton.setOnAction(this);

      // Adds buttons and text fields to hBox
      numberOfQuestionsHBox.getChildren().addAll(decreaseNumberOfQuestionsButton,
          numberOfQuestionsField, increaseNumberOfQuestionsButton);
      uploadFileHBox.getChildren().addAll(uploadFileButton, uploadFileField);

      // Add stuff to homePage
      homePage.getChildren().addAll(homePageLabel, addNewQuestionButton, topicBox,
          numberOfQuestionsLabel, numberOfQuestionsHBox, uploadFileHBox, generateQuizButton, pic);

      scene = new Scene(homePage, 400, 450); // scene dimensions
      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

      scene.setRoot(homePage);
      // set the title
      primaryStage.setTitle("Quiz Generator by ateam 64");
      primaryStage.setScene(scene);
      primaryStage.show();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void handle(ActionEvent event) {
    // if (event.getSource() == addNewQuestionButton) {
    // System.out.println("addNewQ");
    //
    // questionEditor = new QuestionEditor();
    // questionEditorScene = new Scene(questionEditor.getForm(), 400, 450); // scene dimensions
    // scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    //
    // }

    // Decrement the number of questions by one and update the text field showing this count
    if (event.getSource() == decreaseNumberOfQuestionsButton) {
      if (numberOfQuestions > 1) // do not decrease unless greater than one to maintain a positive
                                 // amount of questions
        numberOfQuestions--;
      numberOfQuestionsField.setText("" + numberOfQuestions);
    }

    // Increment the number of questions by one and update the text field showing this count
    if (event.getSource() == increaseNumberOfQuestionsButton) {
      numberOfQuestions++;
      numberOfQuestionsField.setText("" + numberOfQuestions);
    }

  }

}
