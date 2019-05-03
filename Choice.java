// Project: Milestone2
// Authors: Matthew Bruton (mbruton@wisc.edu), Tambre Hu (thu53@wisc.edu), Wei Shi
// (wshi48@wisc.edu), Abigail Shaffer (ajshaffer@wisc.edu), Saketh Challa (spchalla@wisc.edu)
// Lecture Number: 001
// Due Date: 4/26/2019 at 12am
// Other Credit Sources: N/A
// Known Bugs: N/A
// This class represents the choice object, each individual choice/answer, either correct or not, associated with a specific question

package application;

/**
 * @author Abigail Shaffer, Tambre Hu, Saketh Challa, Wei Shi, Matthew Bruton
 *         This class creates an answer Object
 *
 */
public class Choice {

	private String choice;
	private boolean isCorrect; // true if correct, false if not

	/**
	 * Public default constructor
	 */
	public Choice() {
		choice = "Enter Text Here";
		isCorrect = false; // default
	}

	/**
	 * Constructor for the answer, taking input as the text of the question and
	 * whether or not it is the correct answer
	 * 
	 * @param choice    of type String, the String containing the wording of the
	 *                  answer
	 * @param isCorrect of type boolean, true if correct, false if not
	 */
	public Choice(String choice, boolean isCorrect) {
		this.choice = choice;
		this.isCorrect = isCorrect;
	}

	/**
	 * This method simply returns the choice
	 * 
	 * @return choice of type String, the current answer
	 */
	public String getChoice() {
		return choice;
	}

	/**
	 * This method sets the answer option to a specified user input
	 * 
	 * @param choice of type String
	 */
	public void setChoice(String choice) {
		this.choice = choice;
	}

	/**
	 * This method checks if an answer option is correct
	 * 
	 * @return boolean if correct or not, true if correct, false if not
	 */
	public boolean isCorrect() {
		return isCorrect;
	}

	/**
	 * This method changes whether or not an option choice is correct or not
	 * 
	 * @param isCorrect of type boolean, if correct or not
	 */
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

}
