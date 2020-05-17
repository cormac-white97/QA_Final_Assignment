import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Set;

import org.junit.Test;

public class AllTests {
	Survey s;

	@Test
	// Test that the user can create a new survey
	public void createSurvey() {
		// Create a new Survey object and pass in the title
		Survey s = new Survey("Quality Survey");

		// Check that the title is equal to the one that was passed in when it was
		// created
		assertEquals("Quality Survey", s.getTitle());
	}

	@Test
	// Test that the user can add question to a survey
	public void addQuestions() {
		Survey s = new Survey("Quality Survey");

		// Add questions to the question arraylist
		s.addQuestions("Customer Service");
		s.addQuestions("Hygine");

		// Check that each title is added to their respective slots in the arraylist
		assertEquals("Customer Service", s.getQuestions().get(0));
		assertEquals("Hygine", s.getQuestions().get(1));
	}

	@Test
	// Test that a new SurveyRepose can be created
	public void addResponse() {
		Survey s = new Survey("Quality Survey");
		// creating the new survey respose object and passing in the
		SurveyResponse sr = new SurveyResponse("Marys Answers", s);

		assertEquals("Marys Answers", sr.getResponseTitle());

	}

	@Test
	// Test that the user can add an answer to a response
	public void addAnswer() {
		Survey s = new Survey("Quality Survey");

		// Add question to the survey
		s.addQuestions("Customer Service");
		s.addQuestions("Hygine");
		String question1 = s.getQuestions().get(0);
		String question2 = s.getQuestions().get(1);

		// creating the new survey respose object and passing in the
		SurveyResponse sr = new SurveyResponse("Marys Answers", s);
		
		sr.addAnswers(question1,"3");
		sr.addAnswers(question2,"5");		

		assertEquals("3", sr.getAnswer().values().toArray()[0]);
		assertEquals("5", sr.getAnswer().values().toArray()[1]);
		
	}


	@Test
	// Test to ensure an answer cannot be added if there are no questions in the survey
	public void emptyQuestionAnswers() {
		Survey s = new Survey("Quality Survey");

		// create the new survey respose object and passing in the answers
		SurveyResponse sr = new SurveyResponse("Marys Answers", s);
		sr.addAnswers(s.getTitle(),"3");
		sr.addAnswers(s.getTitle(),"5");

		assertEquals(true, sr.getAnswer().isEmpty());
	}

	
	
}