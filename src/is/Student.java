package is;

import java.util.ArrayList;

public class Student {
	
	private String studentID;
	private String sName;
	private ArrayList<Result>resultList = new ArrayList<Result>();
	
	//Constructor för att lägga till student
	/*
	public Student(String studentID, String sName) {
		this.studentID = studentID; 
		this.sName = sName; 
	}*/

	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return sName;
	}
	public void setName(String sName) {
		this.sName = sName;
	}
	public ArrayList<Result> getResultList() {
		return resultList;
	}
	public void setResultList(ArrayList<Result> resultList) {
		this.resultList = resultList;
	}
	public void addResult(Result r) {
		resultList.add(r);
	}

}