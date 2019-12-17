package src.isprojekt;

import java.util.ArrayList;

public class WrittenExam {
	
	private String examID;
	private String date; 
	private String location; 
	private String time; 
	private int maxPoints;
	private ArrayList<Result> examResultList = new ArrayList<Result>();
	
	public String getExamID() {
		return examID;
	}
	public void setExamID(String examID) {
		this.examID = examID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return location; 
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getMaxPoints() {
		return maxPoints;
	}
	public void setMaxPoints(int maxPoints) {
		this.maxPoints = maxPoints;
	} 
	public void setExamResultList (ArrayList<Result>examResultList) {
		this.examResultList = examResultList; 
	}
	public ArrayList<Result> getExamResult() {
		return examResultList; 
	}
	
	public void addResult(Result e) {
		examResultList.add(e);
	}

}
