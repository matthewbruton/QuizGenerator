package application;

import java.util.ArrayList;
import java.util.List;

public class Question {

  private boolean used;
  private String question;
  private String topic;
  private String imagePath;
  private List<Choice> choices;

  public Question(String question, String topic, String imagePath, List<Choice> choices) {
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

  public List<Choice> getChoices() {
    return choices;
  }

}
