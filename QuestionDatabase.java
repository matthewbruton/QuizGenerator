package application;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.collections.ObservableList;

public class QuestionDatabase implements QuestionDatabaseADT {

  List<Question> questions;
  List<String> topics;
  FileReader fileReader;
  FileWriter fileWriter;

  /**
   * Default constructor
   */
  public QuestionDatabase() {
    questions = new ArrayList<Question>();
     topics = new ArrayList<String>();
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
  public void saveQuestionsToJSON(String jsonFilePath) {

    try {
      fileWriter = new FileWriter(jsonFilePath);
    } catch (IOException e) {
      // e.printStackTrace();
    }

  }

  @Override
  public List<Question> getQuestions(String topic) {
    return questions;
  }

  @Override
  public void loadQuestionsFromJSON(String jsonFilePath) {
    // TODO Auto-generated method stub

    for (Question q : questions) {
      if (!topics.contains(q.getTopic()))
        topics.add(q.getTopic());
    }

  }

  @Override
  public List<String> getTopics() {
    Collections.sort(topics);
    return topics;
  }

}
