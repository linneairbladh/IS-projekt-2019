package is;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Controller {
	
	StudentRegister students; //Refererar till modellen ("Studentregister")
	WrittenExam exams; //Refererar till WrittenExam
	JFrame frame; //Refererar till det grafiska gränssnittet
	
	//metoder från StudentRegister
	
	 public Controller(StudentRegister studentReg, JFrame frame) {
		 this.students = studentReg;
		 this.frame = frame;
		 }
	 
	 public void addStudent(String studentID, String sName) { 
		 Student newstudent = new Student(studentID, sName); 
		 students.addStudent(newstudent);
	 }
	 
	 public void addStudent(String studentID, String sName, String result, String letterGrade) {
		 Student newstudent = new Student(studentID, sName);
		 Result studentResult = new Result(result, letterGrade); 
		 studentResult.setStudent(newstudent);
		 students.addStudent(newstudent); }
	 
	 public void removeStudent(String studentID) { 
		 students.removeStudent(studentID);	
	 }
	 
	 public Student findStudent(String studentID) {
		 return students.findStudent(studentID);
	 }
	 
	 
	 //metod från WrittenExam
	 
	 public void addResult(String examID, String date, String location, String time) {
		  Result newresult = new Result(examID, date, location, time);
			exams.addResult(newresult);
		}
	 
	 //metod från Student
	 
	}
