package isprojekt;

import src.isprojekt.*;
import java.util.ArrayList;

public class Course {
	
	private int courseCode;
	private String name;
	private int credits;
	private ArrayList <WrittenExam> writtenExamList = new ArrayList <WrittenExam>();
 
	 public Course(int courseCode, int credits) {
		 this.courseCode = courseCode; 
		 this.credits = credits; 
		// TODO Auto-generated constructor stub
	}
	public int getCourseCode() {
		return courseCode;
	 }
	 public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	 }
	 public String getName() {
		return name;
	 }
	 public void setName(String name) {
		this.name = name;
	 }
	 public int getCredits() {
		return credits;
	 }
	 public void setCredits(int credits) {
		this.credits = credits;
	 }
	 public ArrayList <WrittenExam> getWrittenExamList() {
		return writtenExamList;
	 }
	 public void setWrittenExamList(ArrayList <WrittenExam> writtenExamList) {
		this.writtenExamList = writtenExamList;
	 }
	 public void addWrittenExam(WrittenExam a) {
		 writtenExamList.add(a);
	 }
	 public WrittenExam findWrittenExam(String examID) {
			for (WrittenExam a: writtenExamList) {
				if (a.getExamID().equals(examID)) {
					//osäker på examID
					return a;
				} else {
					return null;
				}
			}
			return null;
		}
	 
	 public WrittenExam removeWrittenExam(WrittenExam a) {
		 WrittenExam a1 = this.findWrittenExam(name);
		 //osäker på name
			if(a1!= null) {
				this.writtenExamList.remove(a1);
			}
		return a1;
	}
	 }
	 
