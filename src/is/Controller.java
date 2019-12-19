package is;

import java.util.ArrayList;
import javax.swing.JFrame;

public class Controller {
	
	StudentRegister students = new StudentRegister(); //Refererar till modellen ("Studentregister")
	WrittenExam exams = new WrittenExam(); //Refererar till WrittenExam
	JFrame frame; //Refererar till det grafiska gränssnittet
	Student s = new Student();
	
	//metoder från StudentRegister
	
	/*
	 public Controller(StudentRegister studentReg, JFrame frame) {
		 this.students = studentReg;
		 this.frame = frame;
		 } 
		 */
	
	//public Controller controller = new Controller ();
	/*
	public void addStudent(Student s) {
		students.addStudent(s);
	}*/
	
	 public void addStudent(String studentID, String sName) { 
		 Student s = new Student(); 
		 students.addStudent(s);
	 }

	 public void removeStudent(String studentID) { 
		 students.removeStudent(studentID);	
	 }
	 
	 public Student findStudent(String studentID) {
		 return students.findStudent(studentID);
	 }
	 
	 
		//// Vet ej om vi behöver
		/*
		
		 
		 public void addStudent(String studentID, String sName, String result, String letterGrade) {
			 Student newstudent = new Student(studentID, sName);
			 Result studentResult = new Result(result, letterGrade); 
			 studentResult.setStudent(newstudent);
			 students.addStudent(newstudent); }
		 
		 */
	 
	 //metod från WrittenExam
	 
	 
	 
	 /*
	 public void addResult(String examID, String date, String location, String time) {
		  Result newresult = new Result(examID, date, location, time);
			exams.addResult(newresult);
		}
*/

	 
	 //metod från Student
	 
	}
