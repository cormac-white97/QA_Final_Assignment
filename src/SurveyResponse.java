import java.util.ArrayList;

public class SurveyResponse {
	Survey survey;
	String responseTitle;
	ArrayList<String> answers;
	
	public SurveyResponse(String responseTitle, Survey survey) {
		super();
		this.survey = survey;
		this.responseTitle = responseTitle;
		this.answers = new ArrayList<>();
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

	public ArrayList<String> getAnswer() {
		return answers;
	}

	public void setAnswer(ArrayList<String> answer) {
		this.answers = answer;
	}
	
	public void addAnswers(String answer) {
		if(survey.getQuestions().isEmpty()) {
			//Cannot add an answer for a question that does not exist
		}
		else {
			answers.add(answer);
		}
	}
	
}
