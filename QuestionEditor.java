package application;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class QuestionEditor {

  // private List<TextField> choiceTexts;
  // private List<ToggleGroup> choiceGroups;
  private VBox form;
  private Label questionEditorLabel;
  private TextField questionField;
  private TextField topicField;
  private TextField imagePathField;
  // Groups Radio Buttons together so only one can be selected
  private ToggleGroup choices;
  // Radio Buttons to represent choices
  private RadioButton a;
  private RadioButton b;
  private RadioButton c;
  private RadioButton d;

  private TextField aField;
  private TextField bField;
  private TextField cField;
  private TextField dField;

  private HBox aHBox;
  private HBox bHBox;
  private HBox cHBox;
  private HBox dHBox;

  private Button saveButton;
  private Button homeButton;

  public QuestionEditor() {

    form = new VBox(10);
    form.setAlignment(Pos.TOP_CENTER);
    form.setPadding(new Insets(50));
    form.setStyle("-fx-background-color: aquamarine"); // set background color
    questionEditorLabel = new Label("QUESTION EDITOR");
    questionEditorLabel.setFont(Font.font("Times New Roman", 32));
    questionField = new TextField("TYPE QUESTION");
    topicField = new TextField("TYPE TOPIC");
    imagePathField = new TextField("TYPE IMAGE PATH");

    choices = new ToggleGroup();
    // Create RadioButtons for four choices
    a = new RadioButton();
    b = new RadioButton();
    c = new RadioButton();
    d = new RadioButton();

    // add all RadioButtons to the ToggleGroup
    choices.getToggles().addAll(a, b, c, d);

    aField = new TextField("TYPE AN ANSWER");
    bField = new TextField("TYPE AN ANSWER");
    cField = new TextField("TYPE AN ANSWER");
    dField = new TextField("TYPE AN ANSWER");

    aHBox = new HBox(10);
    bHBox = new HBox(10);
    cHBox = new HBox(10);
    dHBox = new HBox(10);

    aHBox.getChildren().addAll(a, aField);
    bHBox.getChildren().addAll(b, bField);
    cHBox.getChildren().addAll(c, cField);
    dHBox.getChildren().addAll(d, dField);

    saveButton = new Button("SAVE");
    homeButton = new Button("HOME");

    // saveButton.setOnAction(e -> primaryStage.setScene(questionEditorScene));
    // homeButton.setOnAction(e -> primaryStage.setScene(scene));


    // Add stuff to homePage
    form.getChildren().addAll(questionEditorLabel, questionField, topicField, imagePathField, aHBox,
        bHBox, cHBox, dHBox, saveButton, homeButton);

    // Add stuff to homePage
    // homePage.getChildren().addAll(homePageLabel, addNewQuestionButton, topicBox,
    // numberOfQuestionsLabel, numberOfQuestionsHBox, uploadFileHBox, generateQuizButton, pic);

  }

  // public List<TextField> getChoiceTexts() {
  // return choiceTexts;
  // }

  // public List<ToggleGroup> getChoiceGroups() {
  // return choiceGroups;
  // }

  public Button getHomeButton() {
    return homeButton;
  }

  public Button getSaveButton() {
    return saveButton;
  }

  public VBox getForm() {
    return form;
  }

  public String getQuestion() {
    return questionField.getText();
  }

  public String getTopic() {
    return topicField.getText();
  }

  public String getA() {
    return aField.getText();
  }

  public String getB() {
    return bField.getText();
  }

  public String getC() {
    return cField.getText();
  }

  public String getD() {
    return dField.getText();
  }

  public boolean aIsCorrect() {
    return a.isSelected();
  }

  public boolean bIsCorrect() {
    return b.isSelected();
  }

  public boolean cIsCorrect() {
    return c.isSelected();
  }

  public boolean dIsCorrect() {
    return d.isSelected();
  }

  public String getImagePath() {
    return imagePathField.getText();
  }

}
