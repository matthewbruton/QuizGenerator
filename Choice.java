package application;

public class Choice {

  private String choice;
  private boolean isCorrect;
  
  public Choice() {
    choice = "Enter Text Here";
    isCorrect = false;
  }
  
  public Choice(String choice, boolean isCorrect) {
    this.choice = choice;
    this.isCorrect = isCorrect;
  }
  
  public String getChoice() {
    return choice;
  }
  
  public void setChoice(String choice) {
    this.choice = choice;
  }
  
  public boolean isCorrect() {
    return isCorrect;
  }
  
  public void setCorrect(boolean isCorrect) {
    this.isCorrect = isCorrect;
  }
  
}
