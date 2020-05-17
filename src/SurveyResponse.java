import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SurveyResponse {
	Survey survey;
	String responseTitle;
	LinkedHashMap<String, String> answers;

	public SurveyResponse(String responseTitle, Survey survey) {
		super();
		this.survey = survey;
		this.responseTitle = responseTitle;
		this.answers = new LinkedHashMap<>(10, .75f, true);
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public String getResponseTitle() {
		return responseTitle;
	}

	public void setResponseTitle(String responseTitle) {
		this.responseTitle = responseTitle;
	}

	public HashMap<String, String> getAnswer() {
		return answers;
	}

	public void setAnswer(LinkedHashMap<String, String> answer) {
		this.answers = answer;
	}

	public void addAnswers(String question, String answer) {
		if (survey.getQuestions().isEmpty()) {
			// Cannot add an answer for a question that does not exist
		} else {
			answers.put(question, answer);
		}
	}

	public LinkedHashMap<String, String> getSpecificSurveyReposes(String surveyTitle) {

		return answers;

	}

}
