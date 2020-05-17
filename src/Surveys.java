import java.util.ArrayList;

public class Surveys {
	ArrayList<Survey> s;
	ArrayList<SurveyResponse> sr;
	
	public Surveys() {
		super();
		this.s = new ArrayList<Survey>();
		this.sr = new ArrayList<SurveyResponse>();
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
	
	public void addResponse(SurveyResponse response) {
		sr.add(response);
	}
	
	public ArrayList<SurveyResponse> getAssociatedResponses(String title){
		ArrayList<SurveyResponse> returnList = new ArrayList<>();
		for(int i=0; i < sr.size(); i++) {
			if(sr.get(i).getSurvey().getTitle().equals(title)) {
				returnList.add(sr.get(i));
			}
		}
		
		return returnList;
	}
	

}
