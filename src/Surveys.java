import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

	public ArrayList<SurveyResponse> getAssociatedResponses(String title) {
		ArrayList<SurveyResponse> returnList = new ArrayList<>();
		for (int i = 0; i < sr.size(); i++) {
			if (sr.get(i).getSurvey().getTitle().equals(title)) {
				returnList.add(sr.get(i));
			}
		}

		return returnList;
	}

	public Survey getSpecificSurvey(String title) {
		Survey returnSurvey = null;
		for (Survey survey : s) {
			if (survey.getTitle().equals(title)) {
				returnSurvey = survey;
			}
		}

		return returnSurvey;
	}

	public int getAverageAnswer(HashMap<String, Integer> answerList) {
		int average = 0;

		for (Integer answer : answerList.values()) {
			average += answer;
		}
		average = (int) average / answerList.values().size();

		return average;
	}

	public int getMin(HashMap<String, Integer> answerList) {
		int min = Collections.min(answerList.values());
		return min;
	}

	public int getMax(HashMap<String, Integer> answerList) {
		int max = Collections.max(answerList.values());
		return max;
	}

	public int getDeviation(HashMap<String, Integer> answerList) {
		double sum = 0.0, standardDeviation = 0.0;
		int length = answerList.values().size();

		for (double num : answerList.values()) {
			sum += num;
		}

		double mean = sum / length;

		for (double num : answerList.values()) {
			standardDeviation += Math.pow(num - mean, 2);
		}

		return (int) Math.sqrt(standardDeviation / length);
	}

	public int getAverageForQuestion(String questionTitle, ArrayList<SurveyResponse> responseList) {
		int average = 0;
		ArrayList<Integer> answers = new ArrayList();

		for (int i = 0; i < responseList.size(); i++) {
			LinkedHashMap<String, Integer> searchList = (LinkedHashMap<String, Integer>) responseList.get(i)
					.getAnswer();

			for (int j = 0; j < searchList.keySet().size(); j++) {

				String searchTitle = searchList.keySet().toArray()[j].toString();
				if (searchTitle.equals(questionTitle)) {
					answers.add(Integer.parseInt(searchList.values().toArray()[j].toString()));
				}
			}

		}

		for (Integer answer : answers) {
			average += answer;
		}
		average = (int) average / answers.size();

		return average;
	}

	public int getMinAnswerForQuestion(String questionTitle, ArrayList<SurveyResponse> responseList) {
		int min = 0;
		ArrayList<Integer> answers = new ArrayList();

		for (int i = 0; i < responseList.size(); i++) {

			LinkedHashMap<String, Integer> searchList = (LinkedHashMap<String, Integer>) responseList.get(i)
					.getAnswer();

			for (int j = 0; j < searchList.keySet().size(); j++) {

				String searchTitle = searchList.keySet().toArray()[j].toString();
				if (searchTitle.equals(questionTitle)) {
					answers.add(Integer.parseInt(searchList.values().toArray()[j].toString()));
				}
			}

		}

		min = Collections.min(answers);

		return min;
	}

	public int getMaxAnswerForQuestion(String questionTitle, ArrayList<SurveyResponse> responseList) {
		int max = 0;
		ArrayList<Integer> answers = new ArrayList();

		for (int i = 0; i < responseList.size(); i++) {

			LinkedHashMap<String, Integer> searchList = (LinkedHashMap<String, Integer>) responseList.get(i)
					.getAnswer();

			for (int j = 0; j < searchList.keySet().size(); j++) {

				String searchTitle = searchList.keySet().toArray()[j].toString();
				if (searchTitle.equals(questionTitle)) {
					answers.add(Integer.parseInt(searchList.values().toArray()[j].toString()));
				}
			}

		}

		max = Collections.max(answers);

		return max;
	}

	public int getStandardDeviationForQuestion(String questionTitle, ArrayList<SurveyResponse> responseList, HashMap<String, Integer> answerList) {
		
		ArrayList<Integer> answers = new ArrayList();
		double sum = 0.0, standardDeviation = 0.0;
		int length =answerList.values().size();
		
		for (int i = 0; i < responseList.size(); i++) {
			LinkedHashMap<String, Integer> searchList = (LinkedHashMap<String, Integer>) responseList.get(i)
					.getAnswer();

			for (int j = 0; j < searchList.keySet().size(); j++) {

				String searchTitle = searchList.keySet().toArray()[j].toString();
				if (searchTitle.equals(questionTitle)) {
					answers.add(Integer.parseInt(searchList.values().toArray()[j].toString()));
				}
			}
		}
		
		for (double num : answers) {
			sum += num;
		}

		double mean = sum / length;

		for (double num : answers) {
			standardDeviation += Math.pow(num - mean, 2);
		}

		return (int) Math.sqrt(standardDeviation / length);
	}
}
