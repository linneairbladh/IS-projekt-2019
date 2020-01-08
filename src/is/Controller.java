package is;

import java.util.ArrayList;
import javax.swing.JFrame;



public class Controller {
	
	JFrame frame; //Refererar till det grafiska gränssnittet
	
	StudentRegister studentLista = new StudentRegister(); //Refererar till StudentRegister
	//Student newStudent = new Student(); //Referar till Student
	
	WrittenExamRegister writtenExamList = new WrittenExamRegister(); //Refererar till WrittenExamRegister
	WrittenExam writtenExam = new WrittenExam(); //Refererar till WrittenExam
	
	CourseRegister courseRegisterList = new CourseRegister(); //Refererar till CourseRegister
	Course course = new Course(); //Refererar till Course
	Result newResult = new Result (); //Refererar till Result
	
	
	//Knappar på studentfliken
	
	public String addStudent(String sName, String studentID) {
		Student newStudent = new Student(sName, studentID);
		studentLista.addStudent(newStudent);
		return studentLista.validateStudentID(newStudent);			//Adds student to the studentLista and returns a validated studentID
		
	}
	 /*public void addStudent(Student newStudent) { 
		 studentLista.addStudent(newStudent);
	 }*/
	 
	 public Student removeStudent(String studentID) { 
		 return studentLista.removeStudent(studentID);	
	 }
	 
	 public Student findStudent(String studentID) {
		 Student s;
		 s = studentLista.findStudent(studentID);
		 return s;
	 }
	 
	 //GLÖM EJ public Student updateStudent()
	//ny version av updateStudent 
	 public String generateStudentID() {
			Student tmp = new Student("", "");
			String studentID = tmp.generateStudentID();
			return studentID;
		}
	 
	 public void updateStudent(String name, String studentID) {
			Student tmp = studentLista.findStudent(studentID);
			tmp.setName(name);
	 }
	
	 
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
	 

	 //Knappar från WrittenExam-fliken
	 //"Add/remove exam for course:
	 
	 public void addWrittenExam(WrittenExam a) {
			writtenExamList.addWrittenExam(a);
		}
	 
	/* public String[] retrieveAllCourseNames() {
		 return CourseRegister.retrieveAllCourseNames();
	 }*/
	 
 
	 
	 //"Register result for student:"
	 
	 
	 public String addResult(String studentID, String examID, int result) {
			Result newResult = new Result();
			Student newStudent = studentLista.findStudent(studentID);
			WrittenExam newExam = writtenExamList.findWrittenExam(examID);
			StudentRegister newStudentRegister = new StudentRegister();
			
			newResult.setWrittenExam(newExam);
			newExam.addResult(newResult);
			newStudentRegister.addStudent(newStudent);
			newResult.setResult(result);
			newResult.setStudent(newStudent);
			newStudent.addResult(newResult);
			newStudent.addWrittenExam(newExam);
			return newResult.getLetterGrade(); 
	 
	 }
	 
	 public String[] getWrittenExamCourse(String studentID, String[] examID) {
			Student tmpStudent = studentLista.findStudent(studentID);
			String[] examCourse = new String[tmpStudent.getResultList().size()];
			int i = 0;
			if (tmpStudent != null) {
				while (i < examCourse.length) {
					WrittenExam tmpExam = courseRegisterList.findWrittenExam(examID[i]);
					for (Result tmpResult : tmpExam.getExamResult()) {
						if (tmpResult.getStudent().getStudentID().equals(studentID)) {
							examCourse[i] = tmpResult.getWrittenExam().getCourse().getName();	
						}
					}
					i++;
				}
			}
			return examCourse;					//Returns an array of course names for every exam a student has a result on
		}
	 
	 public String[] getWrittenExamGrades(String studentID, String[] examID) {
			Student tmpStudent = studentLista.findStudent(studentID);
			String[] examGrades = new String[tmpStudent.getResultList().size()];
			int i = 0;
			if (tmpStudent != null) {
				while (i < examGrades.length) {
					WrittenExam tmpExam = courseRegisterList.findWrittenExam(examID[i]);
					for (Result tmpResult : tmpExam.getExamResult()) {
						if (tmpResult.getStudent().getStudentID().equals(studentID)) {
							examGrades[i] = tmpResult.getLetterGrade();	
						}
					}
					i++;
				}
			}
			return examGrades;				//Returns an array of grades for every exam a student has a result on
	}
	 
	 public String[] getWrittenExamIDs (String studentID) {
			Student tmpStudent = studentLista.findStudent(studentID);
			String[] examIDs = new String[tmpStudent.getResultList().size()];
			int i = 0;
			if (tmpStudent != null) {
				for (Result tmpResult : tmpStudent.getResultList()) {
					examIDs[i] = tmpResult.getWrittenExam().getExamID();
					i++;
				}
			}
			return examIDs;	
	 }
	 
	 public int[] getWrittenExamResults(String studentID, String[] examID) {
			Student tmpStudent = studentLista.findStudent(studentID);
			int[] examResults = new int[tmpStudent.getResultList().size()];
			int i = 0;
			if (tmpStudent != null) {
				while (i < examResults.length) {
					WrittenExam tmpExam = courseRegisterList.findWrittenExam(examID[i]);
					for (Result tmpResult : tmpExam.getExamResult()) {
						if (tmpResult.getStudent().getStudentID().equals(studentID)) {
							examResults[i] = tmpResult.getResult();	
						}
					}
					i++;
				}
			}
			return examResults;				//Returns an array of results for every exam a student has a result on
		}
	 
	 public int getExamMaxPoints(String examID) {
			WrittenExam tmpExam = writtenExamList.findWrittenExam(examID);
			if (tmpExam == null){
				return 0;
			}
			
			return tmpExam.getMaxPoints();
		}	 	
	 
	 public String getExamDate(String examID) {
			WrittenExam tmpExam = writtenExamList.findWrittenExam(examID);
			if (tmpExam == null){
				return null;
			}
			
			return tmpExam.getDate();
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
		 }
		 return studentArray;
		 
	 }
	 
	
	 }
	 
	
	
		
