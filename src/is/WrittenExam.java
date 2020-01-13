package is;

import java.util.ArrayList;
import java.util.Random;

import isprojekt.Result;


public class WrittenExam {
	
	private String examID;
	private String date; 
	private String location; 
	private String time;
	private int maxPoints;
	private Course course;
	private ArrayList<Result>examResult = new ArrayList<Result>();
	private StudentRegister studentRegisterList = new StudentRegister();
	
	/*public WrittenExam(String examID, String time, String location, String date, int maxPoints) {
		this.examID = examID; 
		this.time = time; 
		this.location = location; 
		this.date = date; 
		this.maxPoints = maxPoints; 
	}*/

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
	
	public Result findResult(int result) {
		for (Result tmp : examResult) {
			if(tmp.getResult()==(result)) {
				return tmp;
			}
		}
		return null;
	}
	public void addStudent(Student s) {
		studentRegisterList.addStudent(s);
	}

	public String generateExamID() {
		Random random = new Random();
		int randomInt = random.nextInt(90000) + 10000; 		//Generates a random number between 10000 and 99999
		String examID = "E" + randomInt;
		return examID;
	}

	

	
		
	}
