package is;

import java.util.ArrayList;

public class WrittenExam {
	
	private String examID;
	private String date; 
	private String location; 
	private String time; 
	private int maxPoints;
	private Course course;
	private ArrayList<Result>examResult = new ArrayList<Result>();
	
	public WrittenExam(String examID, String date, String location, String time, int maxPoints) {
		// TODO Auto-generated constructor stub
	}

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
	
	public void setCourse (Course course) {
		this.course = course;
	}
	public Course getCourse() {
		return course;
	}
	public void setExamResult(ArrayList<Result>examResult) {
		this.examResult = examResult; 
	}
	public ArrayList<Result> getExamResult() {
		return examResult; 
	}
	
	public void addResult(Result e) {
		examResult.add(e);
	}
}