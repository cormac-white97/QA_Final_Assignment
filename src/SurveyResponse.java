import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SurveyResponse {
	Survey survey;
	String responseTitle;
	LinkedHashMap<String, Integer> answers;

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

	public HashMap<String, Integer> getAnswer() {
		return answers;
	}

	public void setAnswer(LinkedHashMap<String, Integer> answer) {
		this.answers = answer;
	}

	public void addAnswers(String question, int answer) {
		if (survey.getQuestions().isEmpty()) {
			// Cannot add an answer for a question that does not exist
		} else {
			if(answer < 6) {
				answers.put(question, answer);
			}
			
		}
	}

}
