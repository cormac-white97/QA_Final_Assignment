import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AllTests {
	Survey s;

	@Test
	public void createSurvey() {
		// Create a new Survey object and pass in the title
		Survey s = new Survey("Quality Survey");

		// Chck that the title is equal to the one that was passed in when it was
		// created
		assertEquals("Quality Survey", s.getTitle());
	}

	@Test
	public void addQuestions() {
		Survey s = new Survey("Quality Survey");

		s.addQuestions("Customer Service");
		s.addQuestions("Hygine");

		assertEquals("Customer Service", s.getQuestions().get(0));
		assertEquals("Hygine", s.getQuestions().get(1));
	}


}