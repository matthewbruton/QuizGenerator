package application;

import java.util.Stack;

/**
 * This class is used to generate the basic quiz information for the 
 * QuestionDataBase class
 */
public class Quiz {
		//number of questions
		private int numQuestions;
		
		//number of questions are correct
		private int numCorrect;
		
		//number of questions that are answered
		private int numAnswered;
		
		//array of questions that are used 
		private Stack<Question> questions;
		
		/**
		 * constructor
		 * @param questions
		 */
		public Quiz(Stack<Question> questions) {
			this.questions = questions;
			numQuestions = questions.size();
			numCorrect = 0;
			numAnswered = 0;
		}
		
		/**
		 * goes to the next question
		 * @return next question
		 */
		public Question nextQuestion() {
			if(!questions.isEmpty()) {
				return questions.pop();
			} else return null;
		}
		
		/**
		 * if the answer is correct, increment the numCorrect
		 */
		public void correctQuestion() {
			numCorrect++;
		}
		
		/**
		 * @return true if there is a next question
		 */
		public boolean hasNext() {
			return !questions.isEmpty();
		}
		
		/**
		 * @return number of questions
		 */
		public int getNumQuestions() {
			return numQuestions;
		}
		
		/**
		 * @return number of answered
		 */
		public int getNumAnswered() {
			return numAnswered;
		}
		
		/**
		 * @return number of correct
		 */
		public int getNumCorrect() {
			return numCorrect;
		}
}

