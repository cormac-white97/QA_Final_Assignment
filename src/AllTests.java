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
	//Test that more than 10 questions cannot be added
	public void addMoreThanTenQuestions() {
		Survey s = new Survey("Quality Survey");

		// Add questions to the question arraylist
		s.addQuestions("Question 1");
		s.addQuestions("Question 2");
		s.addQuestions("Question 3");
		s.addQuestions("Question 4");
		s.addQuestions("Question 5");
		s.addQuestions("Question 6");
		s.addQuestions("Question 7");
		s.addQuestions("Question 8");
		s.addQuestions("Question 9");
		s.addQuestions("Question 10");
		s.addQuestions("Question 11");


		// Check that each title is added to their respective slots in the arraylist
		assertEquals(false, s.getQuestions().contains("Question 11"));
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

		sr.addAnswers(question1, 3);
		sr.addAnswers(question2, 5);

		assertEquals(3, sr.getAnswer().values().toArray()[0]);
		assertEquals(5, sr.getAnswer().values().toArray()[1]);

	}

	@Test
	//Test that the user cannot add an answer greater than 5
	public void addMoreThanFive() {
		Survey s = new Survey("Quality Survey");

		// Add question to the survey
		s.addQuestions("Customer Service");
		s.addQuestions("Hygine");
		String question1 = s.getQuestions().get(0);

		// creating the new survey respose object and passing in the
		SurveyResponse sr = new SurveyResponse("Marys Answers", s);

		sr.addAnswers(question1, 7);
		sr.addAnswers(question1, 10);


		assertEquals(true, sr.getAnswer().values().isEmpty());

	}


	@Test
	// Get all surveys
	public void getAllSurveys() {
		// Create a number of different surveys
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
	// Test that the user can get a specific survey
	public void getSpecificSurvey() {
		// Create a number of different surveys
		Survey s = new Survey("Quality Survey");
		Survey secondSurvey = new Survey("Advertising Survey");
		Survey thirdSurvey = new Survey("Phone Survey");

		Surveys surveys = new Surveys();
		surveys.addSurvey(s);
		surveys.addSurvey(secondSurvey);
		surveys.addSurvey(thirdSurvey);

		s.addQuestions("Customer Service");
		s.addQuestions("Hygine");

		secondSurvey.addQuestions("Coverage");
		secondSurvey.addQuestions("Clarity");

		Survey specificSurvey = surveys.getSpecificSurvey("Quality Survey");
		Survey secondSpecificSurvey = surveys.getSpecificSurvey("Advertising Survey");

		assertEquals("Quality Survey", specificSurvey.getTitle());
		assertEquals("Customer Service", specificSurvey.getQuestions().get(0));
		assertEquals("Hygine", specificSurvey.getQuestions().get(1));

		assertEquals("Advertising Survey", secondSpecificSurvey.getTitle());
		assertEquals("Coverage", secondSpecificSurvey.getQuestions().get(0));
		assertEquals("Clarity", secondSpecificSurvey.getQuestions().get(1));

	}

	@Test
	// Test to ensure the user can search for responses associated by the survey
	// title
	public void getSecificResponses() {
		// Create two surveys to ensure the right responses are being retrieved
		Survey s = new Survey("Quality Survey");
		Survey secondSurvey = new Survey("Advertising Survey");

		// creating the new survey responses for the "Quality Survey"
		SurveyResponse firstResponse = new SurveyResponse("Mary's Answers", s);
		SurveyResponse secondResponse = new SurveyResponse("John's Reponse", s);
		SurveyResponse thirdResponse = new SurveyResponse("Joe's Reponse", s);

		// Adding two responses to the "Advertising Survey"
		SurveyResponse fourthResponse = new SurveyResponse("Ryan's Reponse", secondSurvey);
		SurveyResponse fifthResponse = new SurveyResponse("David's Reponse", secondSurvey);

		Surveys surveyList = new Surveys();
		// Add both surveys to the survey list
		surveyList.addSurvey(s);
		surveyList.addSurvey(secondSurvey);

		// Add each response to the response list
		surveyList.addResponse(firstResponse);
		surveyList.addResponse(secondResponse);
		surveyList.addResponse(thirdResponse);
		surveyList.addResponse(fourthResponse);
		surveyList.addResponse(fifthResponse);

		// Add each specific search to an arraylist
		ArrayList<SurveyResponse> specificResponses = surveyList.getAssociatedResponses("Quality Survey");
		ArrayList<SurveyResponse> otherSurveyResponses = surveyList.getAssociatedResponses("Advertising Survey");

		// Assert that the right response titles are in the right lists
		assertEquals("Mary's Answers", specificResponses.get(0).getResponseTitle());
		assertEquals("John's Reponse", specificResponses.get(1).getResponseTitle());
		assertEquals("Joe's Reponse", specificResponses.get(2).getResponseTitle());

		assertEquals("Ryan's Reponse", otherSurveyResponses.get(0).getResponseTitle());
		assertEquals("David's Reponse", otherSurveyResponses.get(1).getResponseTitle());

	}

	@Test
	// Test to ensure an answer cannot be added if there are no questions in the
	// survey
	public void emptyQuestionAnswers() {
		Survey s = new Survey("Quality Survey");

		// create the new survey respose object and passing in the answers
		SurveyResponse sr = new SurveyResponse("Marys Answers", s);
		sr.addAnswers(s.getTitle(), 3);
		sr.addAnswers(s.getTitle(), 5);

		assertEquals(true, sr.getAnswer().isEmpty());
	}

	@Test
	// Testing to get the average answer for a survey
	public void getAverageAnswer() {
		// Create a number of different surveys
		Survey s = new Survey("Quality Survey");
		Survey secondSurvey = new Survey("Advertising Survey");
		Survey thirdSurvey = new Survey("Phone Survey");

		s.addQuestions("Customer Service");
		s.addQuestions("Hygine");
		String question1 = s.getQuestions().get(0);
		String question2 = s.getQuestions().get(1);

		secondSurvey.addQuestions("Coverage");
		secondSurvey.addQuestions("Message");

		// creating the new survey respose object and passing in the
		SurveyResponse sr = new SurveyResponse("Marys Answers", s);
		SurveyResponse secondResponse = new SurveyResponse("Joe's Answers", secondSurvey);

		sr.addAnswers(question1, 3);
		sr.addAnswers(question2, 5);

		secondResponse.addAnswers(secondSurvey.getQuestions().get(0), 1);
		secondResponse.addAnswers(secondSurvey.getQuestions().get(1), 4);

		Surveys surveys = new Surveys();
		surveys.addSurvey(s);
		surveys.addSurvey(secondSurvey);
		surveys.addSurvey(thirdSurvey);

		int sAverage = surveys.getAverageAnswer(sr.getAnswer());
		int secondAverage = surveys.getAverageAnswer(secondResponse.getAnswer());

		assertEquals(4, sAverage);
		assertEquals(2, secondAverage);

	}

	@Test
	// Testing to get the overall minimum answer
	public void getMinAnswer() {
		// Create a number of different surveys
		Survey s = new Survey("Quality Survey");
		Survey secondSurvey = new Survey("Advertising Survey");
		Survey thirdSurvey = new Survey("Phone Survey");

		s.addQuestions("Customer Service");
		s.addQuestions("Hygine");
		String question1 = s.getQuestions().get(0);
		String question2 = s.getQuestions().get(1);

		secondSurvey.addQuestions("Coverage");
		secondSurvey.addQuestions("Message");

		// creating the new survey respose object and passing in the
		SurveyResponse sr = new SurveyResponse("Marys Answers", s);
		SurveyResponse secondResponse = new SurveyResponse("Joe's Answers", secondSurvey);

		sr.addAnswers(question1, 3);
		sr.addAnswers(question2, 5);

		secondResponse.addAnswers(secondSurvey.getQuestions().get(0), 1);
		secondResponse.addAnswers(secondSurvey.getQuestions().get(1), 4);

		Surveys surveys = new Surveys();
		surveys.addSurvey(s);
		surveys.addSurvey(secondSurvey);
		surveys.addSurvey(thirdSurvey);

		int sMin = surveys.getMin(sr.getAnswer());
		int secondMin = surveys.getMin(secondResponse.getAnswer());

		assertEquals(3, sMin);
		assertEquals(1, secondMin);
	}

	@Test
	//Testing to get the max answer value
	public void getMaxAnswer() {
		// Create a number of different surveys
				Survey s = new Survey("Quality Survey");
				Survey secondSurvey = new Survey("Advertising Survey");
				Survey thirdSurvey = new Survey("Phone Survey");

				s.addQuestions("Customer Service");
				s.addQuestions("Hygine");
				String question1 = s.getQuestions().get(0);
				String question2 = s.getQuestions().get(1);

				secondSurvey.addQuestions("Coverage");
				secondSurvey.addQuestions("Message");

				// creating the new survey respose object and passing in the
				SurveyResponse sr = new SurveyResponse("Marys Answers", s);
				SurveyResponse secondResponse = new SurveyResponse("Joe's Answers", secondSurvey);

				sr.addAnswers(question1, 3);
				sr.addAnswers(question2, 5);

				secondResponse.addAnswers(secondSurvey.getQuestions().get(0), 1);
				secondResponse.addAnswers(secondSurvey.getQuestions().get(1), 4);

				Surveys surveys = new Surveys();
				surveys.addSurvey(s);
				surveys.addSurvey(secondSurvey);
				surveys.addSurvey(thirdSurvey);

				int sMax = surveys.getMax(sr.getAnswer());
				int secondMax = surveys.getMax(secondResponse.getAnswer());

				assertEquals(5, sMax);
				assertEquals(4, secondMax);
	}
	
	@Test
	//Test to check that the standard deviation is returned
	public void getStandadDeviation() {
		// Create a number of different surveys
		Survey s = new Survey("Quality Survey");
		Survey secondSurvey = new Survey("Advertising Survey");
		Survey thirdSurvey = new Survey("Phone Survey");

		s.addQuestions("Customer Service");
		s.addQuestions("Hygine");
		String question1 = s.getQuestions().get(0);
		String question2 = s.getQuestions().get(1);

		secondSurvey.addQuestions("Coverage");
		secondSurvey.addQuestions("Message");

		// creating the new survey respose object and passing in the
		SurveyResponse sr = new SurveyResponse("Marys Answers", s);
		SurveyResponse secondResponse = new SurveyResponse("Joe's Answers", secondSurvey);

		sr.addAnswers(question1, 3);
		sr.addAnswers(question2, 5);

		secondResponse.addAnswers(secondSurvey.getQuestions().get(0), 1);
		secondResponse.addAnswers(secondSurvey.getQuestions().get(1), 5);

		Surveys surveys = new Surveys();
		surveys.addSurvey(s);
		surveys.addSurvey(secondSurvey);
		surveys.addSurvey(thirdSurvey);

		int sDeviation = surveys.getDeviation(sr.getAnswer());
		int secondDeviation = surveys.getDeviation(secondResponse.getAnswer());

		assertEquals(1, sDeviation);
		assertEquals(2, secondDeviation);
	}

	@Test
	//Test to ensure that the average answer is retreived for a particular question
	public void getSpecificAverage() {
		// Create a number of different surveys
				Survey s = new Survey("Quality Survey");

				s.addQuestions("Customer Service");
				s.addQuestions("Hygine");
				String question1 = s.getQuestions().get(0);
				String question2 = s.getQuestions().get(1);

				// creating the new survey respose object and passing in the
				SurveyResponse sr = new SurveyResponse("Marys Answers", s);
				
				SurveyResponse secondResponse = new SurveyResponse("Joe's Answers", s);

				sr.addAnswers(question1, 3);
				sr.addAnswers(question2, 5);

				secondResponse.addAnswers(question1, 1);
				secondResponse.addAnswers(question2, 4);

				Surveys surveys = new Surveys();
				surveys.addSurvey(s);
				
				surveys.addResponse(sr);
				surveys.addResponse(secondResponse);

				int srAverage = surveys.getAverageForQuestion("Customer Service", surveys.getSr());
				int secondAverage = surveys.getAverageForQuestion("Hygine", surveys.getSr());

				assertEquals(2, srAverage);
				assertEquals(4, secondAverage);
	}

	@Test
	//Test to get the minimum answer for a specific question
	public void getSpecificMinAnswer() {
		// Create a number of different surveys
				Survey s = new Survey("Quality Survey");

				s.addQuestions("Customer Service");
				s.addQuestions("Hygine");
				String question1 = s.getQuestions().get(0);
				String question2 = s.getQuestions().get(1);


				// creating the new survey respose object and passing in the
				SurveyResponse sr = new SurveyResponse("Marys Answers", s);
				SurveyResponse secondResponse = new SurveyResponse("Joe's Answers", s);

				sr.addAnswers(question1, 3);
				sr.addAnswers(question2, 5);
				
				secondResponse.addAnswers(question1, 5);
				secondResponse.addAnswers(question2, 4);
				

				Surveys surveys = new Surveys();
				surveys.addSurvey(s);
				
				surveys.addResponse(sr);
				surveys.addResponse(secondResponse);

				int sMin = surveys.getMinAnswerForQuestion("Customer Service", surveys.getSr());
				int secondMin = surveys.getMinAnswerForQuestion("Hygine", surveys.getSr());

				assertEquals(3, sMin);
				assertEquals(4, secondMin);
	}

	@Test
	//Test that the max answer for a specific question is returned
	public void getSpecificMaxAnswer() {
		// Create a number of different surveys
		Survey s = new Survey("Quality Survey");

		s.addQuestions("Customer Service");
		s.addQuestions("Hygine");
		String question1 = s.getQuestions().get(0);
		String question2 = s.getQuestions().get(1);


		// creating the new survey respose object and passing in the
		SurveyResponse sr = new SurveyResponse("Marys Answers", s);
		SurveyResponse secondResponse = new SurveyResponse("Joe's Answers", s);

		sr.addAnswers(question1, 1);
		sr.addAnswers(question2, 5);
		
		secondResponse.addAnswers(question1, 4);
		secondResponse.addAnswers(question2, 4);
		

		Surveys surveys = new Surveys();
		surveys.addSurvey(s);
		
		surveys.addResponse(sr);
		surveys.addResponse(secondResponse);

		int sMax = surveys.getMaxAnswerForQuestion("Customer Service", surveys.getSr());
		int secondMax = surveys.getMaxAnswerForQuestion("Hygine", surveys.getSr());

		assertEquals(4, sMax);
		assertEquals(5, secondMax);
	}

	@Test
	//Test to get the standard deviation for a specific question
	public void getSpecificStandardDeviation() {
		// Create a number of different surveys
				Survey s = new Survey("Quality Survey");
				
				s.addQuestions("Customer Service");
				s.addQuestions("Hygine");
				String question1 = s.getQuestions().get(0);
				String question2 = s.getQuestions().get(1);

				// creating the new survey respose object and passing in the
				SurveyResponse sr = new SurveyResponse("Marys Answers", s);
				SurveyResponse secondResponse = new SurveyResponse("Joe's Answers", s);

				sr.addAnswers(question1, 3);
				sr.addAnswers(question2, 1);

				secondResponse.addAnswers(question1, 5);
				secondResponse.addAnswers(question2, 5);
				
				Surveys surveys = new Surveys();
				surveys.addSurvey(s);
				surveys.addResponse(sr);
				surveys.addResponse(secondResponse);

				int sDeviation = surveys.getStandardDeviationForQuestion("Customer Service", surveys.getSr(), sr.getAnswer());
				int secondDeviation = surveys.getStandardDeviationForQuestion("Hygine", surveys.getSr(), secondResponse.getAnswer());

				assertEquals(1, sDeviation);
				assertEquals(2, secondDeviation);
	}

}