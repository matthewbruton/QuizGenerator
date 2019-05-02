package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class QuestionNode {

  private VBox node;
  
  // Groups Radio Buttons together so only one can be selected
  private ToggleGroup choices = new ToggleGroup();

  // Radio Buttons to represent choices
  private RadioButton a;
  private RadioButton b;
  private RadioButton c;
  private RadioButton d;

  public QuestionNode(Question question) {
    
    // Set up the VBox node
    node = new VBox(10);
    node.setAlignment(Pos.TOP_CENTER);
    node.setPadding(new Insets(50));
    node.setStyle("-fx-background-color: cadetblue"); // set background color
    
    // Create RadioButtons for four choices
    a = new RadioButton(question.getChoices().get(0).getChoice());
    b = new RadioButton(question.getChoices().get(1).getChoice());
    c = new RadioButton(question.getChoices().get(2).getChoice());
    d = new RadioButton(question.getChoices().get(3).getChoice());

    // add all RadioButtons to the ToggleGroup
    choices.getToggles().addAll(a, b, c, d);
  }

  public VBox getNode() {
    return node;
  }

  public ToggleGroup getChoices() {
    return choices;
  }



}
