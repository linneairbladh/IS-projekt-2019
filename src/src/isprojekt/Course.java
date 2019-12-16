package src.isprojekt;

import java.util.ArrayList;

public class Course {
	
 private int courseCode;
 private String name;
 private int credits;
 private ArrayList <WrittenExam> WrittenExamList = new ArrayList <WrittenExam>();
 
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
	return WrittenExamList;
 }
 public void setWrittenExamList(ArrayList <WrittenExam> writtenExamList) {
	WrittenExamList = writtenExamList;
 }
 
 
 
 
}
