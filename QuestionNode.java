package application;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class QuestionNode implements NodeWrapperADT {

  // Groups Radio Buttons together so only one can be selected
  ToggleGroup group = new ToggleGroup();
  
  // Radio Buttons to represent choices
  RadioButton a = new RadioButton();
  RadioButton b = new RadioButton();
  RadioButton c = new RadioButton();
  RadioButton d = new RadioButton();
  
  
  
  @Override
  public VBox node() {
    // TODO Auto-generated method stub
    return null;
  }
  
  public ToggleGroup choices() {
    return null;
  }
  
  
  
  

}
