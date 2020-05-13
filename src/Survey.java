import java.util.ArrayList;

public class Survey {
	String title;
	ArrayList<String> questions;
	ArrayList<Integer> answers;
	

	public Survey(String title) {
		super();
		this.title = title;
		this.questions = new ArrayList<String>();
		this.answers = new ArrayList<Integer>();
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

	public ArrayList<Integer> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<Integer> answers) {
		this.answers = answers;
	}
	
	public void addQuestions(String question) {
		questions.add(question);
	}
	
}
