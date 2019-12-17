package src.isprojekt;

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
	 
	 public void addStudent(String studentID, String name, int courseCode, int credits) {
		 Student newstudent = new Student(studentID, name);
		 Course course = new Course(courseCode, credits); 
		 newstudent.setCourse(courseCode); course.setStudent(newstudent);
		 students.addStudent(newstudent); }

}
