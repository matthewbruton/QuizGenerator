// Project: Milestone2
// Authors: Matthew Bruton (mbruton@wisc.edu), Tambre Hu (thu53@wisc.edu), Wei Shi
// (wshi48@wisc.edu), Abigail Shaffer (ajshaffer@wisc.edu), Saketh Challa (spchalla@wisc.edu)
// Lecture Number: 001
// Due Date: 4/25/2019 at 10pm
// Other Credit Sources: N/A
// Known Bugs: N/A
// This class is the bank that contains all of the questions and topics. The 
// class is able to randomly generate quizzes from the bank of available questions 

package application;

// all import statements
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Abigail Shaffer, Tambre Hu, Saketh Challa, Wei Shi, Matthew Bruton
 * 
 *         This class is the bank that contains all of the questions and topics.
 *         The class is able to randomly generate quizzes from the bank of
 *         available questions
 *
 */
public class QuestionDatabase implements QuestionDatabaseADT {

	List<Question> questions; // keep track of the questions within the database
	List<String> topics; // all available topics that questions can be of type
	FileReader fileReader;
	FileWriter fileWriter;

	/**
	 * Default constructor, initializes the list of questions and topics available
	 */
	public QuestionDatabase() {
		questions = new ArrayList<Question>(); // initialize the questions and topics arraylists
		topics = new ArrayList<String>();
	}

	/**
	 * This method adds a question to the question bank.
	 */
	@Override
	public void addQuestion(Question question) {

		// add question to list of questions
		questions.add(question);

		// adds topic to list of topics if it is not already included
		addTopic(question.getTopic());
	}
	
	public void addTopic(String newTopic) {
		if (topics.contains(newTopic)) {
			return;
		} else {
			topics.add(newTopic);
		}
	}
	
	
	/**
	 * This method saves the questions to the json file
	 * 
	 * @param jsonFilePath of type String, the json file name
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void saveQuestionsToJSON(String jsonFilePath) {

		JSONObject obj = new JSONObject();
		JSONArray questionArray = new JSONArray();

		for (int i = 0; i < questions.size(); ++i) { // for the number of questions in the questions list
			HashMap questionInfo = new HashMap(); // create a hash map
			JSONArray choiceArray = new JSONArray();
			questionInfo.put("meta-data", "unused");
			questionInfo.put("questionText", questions.get(i).getText()); // put the current question (loop through each
																			// question) into the "questionText" of the
																			// JSONFile
			questionInfo.put("topic", questions.get(i).getTopic()); // put the topic associated with the current
																	// question into the "topic" of the JSONFile
			String imagePath = questions.get(i).getImagePath(); // image for the question
			if (imagePath == null) { // means no image associated with the question
				imagePath.equals("none");
			}
			questionInfo.put("image", imagePath);

			questionInfo.put("choiceArray", choiceArray);
			questionArray.add(questionInfo);
		}
		obj.put("questionArray", questionArray);
		try (FileWriter file = new FileWriter(jsonFilePath + ".json")) {
			file.write(obj.toJSONString());
			file.flush();
		} catch (IOException e) { // no exceptions should be thrown
			e.printStackTrace();
		}
	}

	/**
	 * This method gets the list of questions of a specified topic
	 * 
	 * @param topic of type String
	 */
	@Override
	public List<Question> getQuestions(String topic) {
		return questions;
	}

	
	/**
	 * This method sorts the topics in ascending order
	 */
	@Override
	public List<String> getTopics() {
		Collections.sort(topics);
		return topics;
	}
	
	
	/**
	 * This method return the total number of questions
	 */
	public int numberOfQuestions() {
		return questions.size();
		}
	
	
	/**
	 * This method reads and loads the questions from the JSON file into the
	 * questions and topics list, in order to generate a quiz in a later method,
	 * generateQuiz()
	 * 
	 * @param jsonFilePath of type String, the json file name
	 */
	@Override
	public void loadQuestionsFromJSON(String jsonFilePath) {

		try {
			Object obj = new JSONParser().parse(new FileReader(jsonFilePath));
			JSONObject object = (JSONObject) obj;
			JSONArray questions = (JSONArray) object.get("questionArray"); // "questionArray", based on the format of
																			// the JSON files, will specify the
																			// questions

			for (int i = 0; i < questions.size(); i++) { // traverse the list of questions
				JSONObject everyQuestion = (JSONObject) questions.get(i); // get the specific question

				// get the question text
				String text = (String) everyQuestion.get("questionText");

				// get the topic
				String topic = (String) everyQuestion.get("topic");

				// get the image path
				String imagePath = (String) everyQuestion.get("image");
				if (imagePath.equals("none"))
					imagePath = null;

				// get the choices
				JSONArray choiceArray = (JSONArray) everyQuestion.get("choiceArray");
				Choice[] choices = new Choice[choiceArray.size()]; // the number of answers/choices can be of any
																	// length, not just 4
				for (int j = 0; j < choiceArray.size(); j++) {
					JSONObject everyChoice = (JSONObject) choiceArray.get(j);
					boolean answer = true; // default
					if (((String) everyChoice.get("isCorrect")).equals("F")) { // "F" means false
						answer = false;
					}
					choices[j] = new Choice((String) everyChoice.get("choice"), answer);
				}
				// after get the information about the question
				// add the question
				Question question = new Question(topic, imagePath, choices, text);
				addQuestion(question);
			}
		} catch (FileNotFoundException e) { // if any exceptions are thrown, we want to catch them, because program
											// should not crash
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method generates the quiz with the specified topics and specified number
	 * of questions.
	 * 
	 * @param topics of type List<String> that contain all topics the user wishes
	 *               the quiz to be of
	 * @param numQ   of type int, the number of questions the user desires the quiz
	 *               to be (the length)
	 * @return Quiz, a new Quiz from the Quiz class
	 */
	public Quiz generateQuiz(List<String> topics, int numQ) {
		Random randomGenerator = new Random(); // random object in order to generate a randomly order and question quiz
		List<Question> allowableTopicQ = new ArrayList<Question>();
		for (Question q : questions) { // this checks all questions in the list of questions, to see if the given topic
										// is contained with the given (acceptable) topics
			if (topics.contains(q.getTopic())) {
				allowableTopicQ.add(q); // if topic is within allowable topic list, add to List allowableQuestions
			}
		}

		// to generate a random quiz, first create a stack to push onto
		Stack<Question> quizListQ = new Stack<Question>();

		// have to take into account if a user wishes to generate a quiz with more than
		// the amount of questions available in the question database, just generate a
		// quiz with all of the questions in the question database
		if (allowableTopicQ.size() <= numQ) {
			for (Question q : questions) {
				quizListQ.push(q);
			}
		} else { // number of questions desired to generate a quiz is less than the
													// amount of
													// available quiz questions in the database
			for (int j = 0; j < numQ; j++) { // for the number of questions
				quizListQ.push(allowableTopicQ.remove(randomGenerator.nextInt(allowableTopicQ.size())));
			}
		}
		return new Quiz(quizListQ); // create a new quiz with the passed in valid quiz questions
	}

	

}
