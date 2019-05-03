package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class QuestionNode {

  // VBox
  private VBox node;

  // Question
  private Question question;

  // Groups Radio Buttons together so only one can be selected
  private ToggleGroup choices = new ToggleGroup();

  // Labels
  private Label questionLabel;

  // Buttons
  private Button submitButton;

  // Radio Buttons to represent choices
  private RadioButton a;
  private RadioButton b;
  private RadioButton c;
  private RadioButton d;

  public QuestionNode(Question question) {

    // Save question for public getter
    this.question = question;

    // Set up the VBox node
    node = new VBox(10);
    node.setAlignment(Pos.TOP_CENTER);
    node.setPadding(new Insets(50));
    node.setStyle("-fx-background-color: cadetblue"); // set background color

    // Create Labels
    questionLabel = new Label("Q" + question.getQuestionNumber() + ": " + question.getQuestion());
    
    // Create Buttons
    submitButton = new Button("SUBMIT");
    
    // Create RadioButtons for four choices
    a = new RadioButton(question.getChoices().get(0).getChoice());
    b = new RadioButton(question.getChoices().get(1).getChoice());
    c = new RadioButton(question.getChoices().get(2).getChoice());
    d = new RadioButton(question.getChoices().get(3).getChoice());

    // add all RadioButtons to the ToggleGroup
    choices.getToggles().addAll(a, b, c, d);

    // add stuff to VBox
    node.getChildren().addAll(questionLabel, a, b, c, d, submitButton);
  }

  public VBox getNode() {
    return node;
  }

  public ToggleGroup getChoices() {
    return choices;
  }

  public Button getSubmitButton() {
    return submitButton;
  }

  public boolean isCorrect() {
    return ((question.getChoices().get(0).isCorrect() && a.isSelected())
        || (question.getChoices().get(1).isCorrect() && b.isSelected())
        || (question.getChoices().get(2).isCorrect() && c.isSelected())
        || (question.getChoices().get(3).isCorrect() && d.isSelected()));
  }
  
}
