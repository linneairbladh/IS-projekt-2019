package is;

import java.util.ArrayList;
import javax.swing.JFrame;

public class Controller {
	
	StudentRegister studentLista; //Refererar till modellen ("Studentregister")
	WrittenExam examLista; //Refererar till WrittenExam
	JFrame frame; //Refererar till det grafiska gränssnittet

	
	//metoder från StudentRegister
	
	
	 public Controller(StudentRegister studentLista, JFrame frame) {
		 this.studentLista = studentLista;
		 this.frame = frame;
		 } 
	
	//public Controller controller = new Controller ();
	/*
	public void addStudent(Student s) {
		students.addStudent(s);
	}*/
	
	 public void addStudent(String studentID, String sName) { 
		 Student s = new Student(); 
		 studentLista.addStudent(s);
	 }

	 public void removeStudent(String studentID) { 
		 studentLista.removeStudent(studentID);	
	 }
	 
	 public Student findStudent(String studentID) {
		 return studentLista.findStudent(studentID);
	 }
	 
	 
	 /*
		//// Vet ej om vi behöver 
		 public void addStudent(String studentID, String sName, String result, String letterGrade) {
			 Student newstudent = new Student(studentID, sName);
			 Result studentResult = new Result(result, letterGrade); 
			 studentResult.setStudent(newstudent);
			 students.addStudent(newstudent); }
		 
		
	 
	 //metod från WrittenExam
	 
	 
	
	 public void addResult(String examID, String date, String location, String time) {
		  Result newresult = new Result(examID, date, location, time);
			exams.addResult(newresult);
		}

	  */
	 
	 //metod från Student
	 
	}
