package src.src.isprojekt;

import src.isprojekt.*;
import java.util.ArrayList;

public class Student {
	
	private String studentID;
	private String name;
	private ArrayList<Result>resultList = new ArrayList<Result>();
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
