package is;

import java.util.ArrayList;
import java.util.Random;

public class WrittenExam {
	
	private String examID;
	private String date; 
	private String location; 
	private String time;
	private int maxPoints = 100; //Max points är alltid 100
	private Course course;
	private ArrayList<Result>examResult = new ArrayList<Result>();
	private StudentRegister studentRegisterList = new StudentRegister();
	

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
	public void setCourse (Course course) {
		this.course = course;
	}
	public Course getCourse() {
		return course;
	}
	public void addStudent(Student s) {
		studentRegisterList.addStudent(s);
		
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
	public Result removeResult(int result) {
		for (Result r : examResult) {
			if(r.getResult() ==(result)) {
				examResult.remove(r);
				return r;	
			}
		}
		return null;
	} 
	

	public String generateExamID() {
		Random random = new Random();
		int randomInt = random.nextInt(90000) + 10000; 		//Genererar ett random nummer mellan 1000 och 90000
		String generatedExamID = "E" + randomInt;
		return generatedExamID;
	}

		
}
