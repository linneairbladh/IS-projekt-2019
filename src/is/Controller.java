package is;

import java.util.ArrayList;
import javax.swing.JFrame;


public class Controller {
	
	JFrame frame; //Refererar till det grafiska gränssnittet
	
	StudentRegister studentLista = new StudentRegister(); //Refererar till StudentRegister
	Student newStudent = new Student(); //Referar till Student
	
	WrittenExamRegister writtenExamList = new WrittenExamRegister(); //Refererar till WrittenExamRegister
	WrittenExam writtenExam = new WrittenExam(); //Refererar till WrittenExam
	
	CourseRegister courseRegisterList = new CourseRegister(); //Refererar till CourseRegister
	Course course = new Course(); //Refererar till Course
	Result newResult = new Result (); //Refererar till Result
	
	
	//Knappar på studentfliken
	
	 public void addStudent(Student newStudent) { 
		 studentLista.addStudent(newStudent);
	 }
	 
	 public Student removeStudent(String studentID) { 
		 return studentLista.removeStudent(studentID);	
	 }
	 
	 public Student findStudent(String studentID) {
		 Student s;
		 s = studentLista.findStudent(studentID);
		 return s;
	 }
	 
	 //GLÖM EJ public Student updateStudent()
	 
	 //Knappar på coursefliken
	 
	 public void addCourse(Course newCourse) {
		 courseRegisterList.addCourse(newCourse);
	 }
	 
	 public Course removeCourse(String courseCode) {
		 return courseRegisterList.removeCourse(courseCode);
	 }
	 
	 public Course findCourse(String courseCode) {
		 return courseRegisterList.findCourse(courseCode);
	 }
	 
	 /* GLÖM EJ public Course updateCourse() {
		 return course; 
	 }
	 */
	 
	 
	 //Knappar från WrittenExam-fliken
	 //"Add/remove exam for course:
	 
	 public void addWrittenExam(WrittenExam a) {
			writtenExamList.addWrittenExam(a);
		}
	 
	 
	 
	 
	 //"Register result for student:"
	 
	 public void addResult(String examID, String date, String location, String time) {
		  Result newresult = new Result();
			writtenExam.addResult(newresult);
		}
	

	  
	 
	 //metod från Student
		//// Vet ej om vi behöver 
	 
		 /*public void addStudent(String studentID, String sName) {
			 Student newstudent = new Student(studentID, sName);
			 studentLista.addStudent(newstudent); } 
			 
			 */
		 
	//public Controller controller = new Controller();
		
		//metoder från StudentRegister
		 public Controller() {
			 this.studentLista = studentLista;
			 this.frame = frame;
			 } 
	  
	 public String []retrieveAllStudents(){
		 return studentLista.retrieveAllStudents();
	 }
	 
	 public String [] findStudentArray(String studentID) {
		 Student newStudent = studentLista.findStudent(studentID);
		 String[] studentArray = new String [3];
		 
		 if(newStudent != null) {
			 studentArray[0] = newStudent.getName();
			 studentArray[1] = newStudent.getStudentID();
			 studentArray[2] = newStudent.ge
		 }
		 return studentArray;
		 
	 }
	 
	
	 }
	 
	
	
		
