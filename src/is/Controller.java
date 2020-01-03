package is;

import java.util.ArrayList;
import javax.swing.JFrame;

public class Controller {
	
	StudentRegister studentLista; //Refererar till modellen ("Studentregister")
	WrittenExamRegister examLista;
	WrittenExam exam; //Refererar till WrittenExam
	JFrame frame; //Refererar till det grafiska gränssnittet
	//public Controller controller = new Controller ();
	
	//metoder från StudentRegister
	 public Controller(StudentRegister studentLista, WrittenExamRegister examLista, JFrame frame) {
		 this.studentLista = studentLista;
		 this.frame = frame;
		 } 
	
	 public void addStudent(String studentID, String sName) { 
		 Student s = new Student(studentID, sName); 
		 studentLista.addStudent(s);
	 }

	 public void removeStudent(String studentID) { 
		 studentLista.removeStudent(studentID);	
	 }
	 
	 public Student findStudent(String studentID) {
		 Student s;
		 s = studentLista.findStudent(studentID);
		 return s;
	 }
	 
	 public String []retrieveAllStudents(){
		 return studentLista.retrieveAllStudents();
	 }
	 
	 //metoder från WrittenExamRegister
	 public void addWrittenExam(String examID, String date, String location, String time, int maxPoints) {
		 WrittenExam a = new WrittenExam(examID, date, location, time, maxPoints);
		 examLista.addWrittenExam(a);
		
	 }
	 
	
		//// Vet ej om vi behöver 
		/* public void addStudent(String studentID, String sName, String result, String letterGrade) {
			 Student newstudent = new Student(studentID, sName);
			 Result studentResult = new Result(result, letterGrade); 
			 studentResult.setStudent(newstudent);
			 studentLista.addStudent(newstudent); }
		 
		
	 
	 //metod från WrittenExam
	 
	 
	 public void addResult(String examID, String date, String location, String time) {
		  Result newresult = new Result(examID, date, location, time);
			examLista.addResult(newresult);
		}

	 */
	 
	
	}
