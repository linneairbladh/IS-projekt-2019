package src.isprojekt;

import java.util.ArrayList;

public class Course {
	
	private String courseCode;
	private String name;
	private double credits;
	private ArrayList <WrittenExam> writtenExamList = new ArrayList <WrittenExam>();
 
	 public Course(String newcourseCode, String newname, int newcredits) {
		 this.courseCode = newcourseCode; 
		 this.name = newname; 
		 this.credits = newcredits; 

	}
	public String getCourseCode() {
		return courseCode;
	 }
	 public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	 }
	 public String getName() {
		return name;
	 }
	 public void setName(String name) {
		this.name = name;
	 }
	 public double getCredits() {
		return credits;
	 }
	 public void setCredits(double credits) {
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
		 WrittenExam a = null; 
			for (WrittenExam a1: writtenExamList) {
				if (a1.getExamID().equals(examID)) {
					a1 = a; 

				}
			}
			return a;
	 }
		
	 
	 public void removeWrittenExam(String examID) {
		 WrittenExam a1 = this.findWrittenExam(examID);
				writtenExamList.remove(a1);
			}
	}
	 
