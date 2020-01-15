package is;

import java.util.ArrayList;
import java.util.Random;

public class Course {
	
	private String courseCode;
	private String name;
	private double credits;
	private ArrayList <WrittenExam> writtenExamList = new ArrayList <WrittenExam>();
	private CourseRegister courseRegister;
	
	public Course (String courseCode, String name, double credits) {
		this.courseCode = courseCode; 
		this.name = name; 
		this.credits = credits; 
	}
	
	public void setCourseRegister(CourseRegister courseRegister) {
		this.courseRegister = courseRegister;
	 }
	public CourseRegister getCourseRegister() {
		 return this.courseRegister;
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
		 WrittenExam exam = null; 
			for (WrittenExam e: writtenExamList) {
				if (e.getExamID().equals(examID)) {
					e = exam; 

				}
			}
			return exam;
	 }
		
	 public void removeWrittenExam(String examID) {
		 WrittenExam e1 = new WrittenExam();
			for (WrittenExam e: writtenExamList) {
				if(e.getExamID().equals(examID)) {
					e1 = e;
				}
			}
			writtenExamList.remove(e1);
		} 
	 
	public String generateCourseCode() {
		Random random = new Random();
		int randomNumber = random.nextInt(90000) + 10000; // Genererar ett nummer random mellan 10000 och 90000
		String generatedCourseCode = "C" + randomNumber;
		return generatedCourseCode;
	}
	
	
	}