package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

public class QuestionDatabase implements QuestionDatabaseADT {

  List<Question> questions;
  ObservableList<String> topics;

  /**
   * Default constructor
   */
  public QuestionDatabase() {
    questions = new ArrayList<Question>();
    // topics = new FXCollections.observableArrayList();
  }

  @Override
  public void addQuestion(Question question) {
    // add question to list of questions
    questions.add(question);

    // adds topic to list of topics if it is not already included
    if (!topics.contains(question.getTopic()))
      topics.add(question.getTopic());
  }

  @Override
  public void saveQuestionsToJSON(File jsonFile) {
    // TODO Auto-generated method stub

  }

  @Override
  public List<Question> getQuestions(String topic) {
    return questions;
  }

  @Override
  public void loadQuestionsFromJSON(File jsonFile) {
    // TODO Auto-generated method stub

  }

  @Override
  public ObservableList<String> getTopics() {
    return topics;
  }

}
