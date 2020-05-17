import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
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
	//Get all surveys
	public void getAllSurveys() {
		//Create a number of different surveys
		Survey s = new Survey("Quality Survey");
		Survey secondSurvey = new Survey("Advertising Survey");
		Survey thirdSurvey = new Survey("Phone Survey");
		
		Surveys surveys = new Surveys();
		surveys.addSurvey(s);
		surveys.addSurvey(secondSurvey);
		surveys.addSurvey(thirdSurvey);
		
		ArrayList<Survey> surveyList = surveys.getS();
		
		assertEquals("Quality Survey", surveyList.get(0).getTitle());
		assertEquals("Advertising Survey", surveyList.get(1).getTitle());
		assertEquals("Phone Survey", surveyList.get(2).getTitle());

	}
	
	@Test
	//Test to ensure the user can search for responses associated by the survey title
	public void getSecificResponses() {
		//Create two surveys to ensure the right responses are being retrieved
		Survey s = new Survey("Quality Survey");
		Survey secondSurvey = new Survey("Advertising Survey");
		
		// creating the new survey responses for the "Quality Survey"
		SurveyResponse firstResponse = new SurveyResponse("Mary's Answers", s);
		SurveyResponse secondResponse = new SurveyResponse("John's Reponse", s);
		SurveyResponse thirdResponse = new SurveyResponse("Joe's Reponse", s);
		
		//Adding two responses to the "Advertising Survey"
		SurveyResponse fourthResponse = new SurveyResponse("Ryan's Reponse", secondSurvey);
		SurveyResponse fifthResponse = new SurveyResponse("David's Reponse", secondSurvey);

		Surveys surveyList = new Surveys();
		//Add both surveys to the survey list
		surveyList.addSurvey(s);
		surveyList.addSurvey(secondSurvey);
	
		//Add each response to the response list
		surveyList.addResponse(firstResponse);
		surveyList.addResponse(secondResponse);
		surveyList.addResponse(thirdResponse);
		surveyList.addResponse(fourthResponse);
		surveyList.addResponse(fifthResponse);

		//Add each specific search to an arraylist
		ArrayList<SurveyResponse> specificResponses = surveyList.getAssociatedResponses("Quality Survey");
		ArrayList<SurveyResponse> otherSurveyResponses = surveyList.getAssociatedResponses("Advertising Survey");

		//Assert that the right response titles are in the right lists
		assertEquals("Mary's Answers", specificResponses.get(0).getResponseTitle());
		assertEquals("John's Reponse", specificResponses.get(1).getResponseTitle());
		assertEquals("Joe's Reponse", specificResponses.get(2).getResponseTitle());
		
		assertEquals("Ryan's Reponse", otherSurveyResponses.get(0).getResponseTitle());
		assertEquals("David's Reponse", otherSurveyResponses.get(1).getResponseTitle());


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