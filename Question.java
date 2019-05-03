// Project: Milestone2
// Authors: Matthew Bruton (mbruton@wisc.edu), Tambre Hu (thu53@wisc.edu), Wei Shi
// (wshi48@wisc.edu), Abigail Shaffer (ajshaffer@wisc.edu), Saketh Challa (spchalla@wisc.edu)
// Lecture Number: 001
// Due Date: 4/25/2019 at 10pm
// Other Credit Sources: N/A
// Known Bugs: N/A
// This class represents a Question object. The class produces a Question with a specified
// topic, image, and answer choices.

package application;

// necessary import statements
import java.util.ArrayList;
import java.util.List;

/**
 * @author Abigail Shaffer, Tambre Hu, Saketh Challa, Wei Shi, Matthew Bruton
 *         This method creates a Question object
 */
public class Question {

	// the characteristics / attributes of a question
	private String topic;
	private String imagePath;
	private Choice[] choices;
	private String text;

	/**
	 * The constructor of a Question taking in parameters
	 * 
	 * @param topic     of type String, the topic associated with this question
	 * @param imagePath of type String, the image associated with this question
	 * @param choices   of type Choice[], list of answer options for the given
	 *                  question
	 * @param text      of type String, the text of the question
	 */
	public Question(String topic, String imagePath, Choice[] choices, String text) { //Choice[] choices
		// initializing the variables
		this.topic = topic;
		this.imagePath = imagePath;
		this.choices = choices;
		this.text = text;
	}

	/**
	 * Get the topic of the current question
	 * 
	 * @return topic of type String
	 */
	public String getTopic() {
		return this.topic;
	}

	/**
	 * This method returns the imagePath of the current question
	 * 
	 * @return imagePath of type String
	 */
	public String getImagePath() {
		return this.imagePath;
	}

	/**
	 * This method gets all choices, which can be any number, for the current
	 * question
	 * 
	 * @return choices of type Choice[], the list of answer choices for the current
	 *         question
	 */
	public Choice[] getChoices() {
		return this.choices;
	}

	/**
	 * This method returns what the question is asking, the text field
	 * 
	 * @return text of type String of the Question
	 */
	public String getText() {
		return this.text;
	}

}
