import java.util.ArrayList;

public class Survey {
	String title;
	ArrayList<String> questions;
	

	public Survey(String title) {
		super();
		this.title = title;
		this.questions = new ArrayList<String>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<String> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<String> questions) {
		this.questions = questions;
	}

	
	public void addQuestions(String question) {
		questions.add(question);
	}
	
	
	
}