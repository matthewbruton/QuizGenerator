package application;

import java.util.ArrayList;
import java.util.List;

public interface QuestionDatabaseADT {

  public void addQuestion(Question question);

  public void saveQuestionsToJSON(String jsonFilePath);

  public ArrayList<Question> getQuestions(String topic);

  public void loadQuestionsFromJSON(String jsonFilePath);

  public List<String> getTopics();

}
