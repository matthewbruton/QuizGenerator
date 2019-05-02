package application;

import java.io.File;
import java.util.List;
import javafx.collections.ObservableList;

public interface QuestionDatabaseADT {

  public void addQuestion(Question question);

  public void saveQuestionsToJSON(File jsonFile);

  public List<Question> getQuestions(String topic);

  public void loadQuestionsFromJSON(File jsonFile);

  public ObservableList<String> getTopics();

}
