package application;

import java.util.ArrayList;

public class Question {

  private boolean used;
  private String question;
  private String topic;
  private String imagePath;
  private ArrayList<Choice> choices;

  public Question(String question, String topic, String imagePath,
      ArrayList<Choice> choices) {
    this.question = question;
    this.topic = topic;
    this.imagePath = imagePath;
    this.choices = choices;
  }

  public void setUsed(boolean used) {
    this.used = used;
  }
  
  public boolean isUsed() {
    return used;
  }

  public String getQuestion() {
    return question;
  }

  public String getTopic() {
    return topic;
  }

  public String getImagePath() {
    return imagePath;
  }

  public ArrayList<Choice> getChoices() {
    return choices;
  }

}
