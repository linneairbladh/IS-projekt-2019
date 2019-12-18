package is;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Controller {
	
	StudentRegister students; //Refererar till modellen ("Studentregistret")
	JFrame frame; //Refererar till det grafiska gränssnittet
	
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
	 
	 
	 //hej

}
