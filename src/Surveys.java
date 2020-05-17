import java.util.ArrayList;

public class Surveys {
	ArrayList<Survey> s;
	ArrayList<SurveyResponse> sr;
	
	public Surveys() {
		super();
		this.s = s;
		this.sr = sr;
	}

	public ArrayList<Survey> getS() {
		return s;
	}

	public void setS(ArrayList<Survey> s) {
		this.s = s;
	}

	public ArrayList<SurveyResponse> getSr() {
		return sr;
	}

	public void setSr(ArrayList<SurveyResponse> sr) {
		this.sr = sr;
	}
	
	public void addSurvey(Survey survey) {
		s.add(survey);
	}
	
	public void addRespose(SurveyResponse response) {
		sr.add(response);
	}
	

}
