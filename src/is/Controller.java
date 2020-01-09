package is;

import java.util.ArrayList;
import javax.swing.JFrame;

public class Controller {
	
	JFrame frame; //Refererar till det grafiska gränssnittet
	
	StudentRegister studentLista = new StudentRegister(); //Refererar till StudentRegister
	WrittenExamRegister writtenExamList = new WrittenExamRegister(); //Refererar till WrittenExamRegister
	CourseRegister courseRegisterList = new CourseRegister(); //Refererar till CourseRegister
	Result newResult = new Result (); //Refererar till Result
	
	
	//Knappar på studentfliken
	
	public String addStudent(String name, String studentID) {
		Student newStudent = new Student(name, studentID);
		studentLista.addStudent(newStudent);
		return studentLista.validateStudentID(newStudent);			//Adds student to the studentLista and returns a validated studentID
		
	}
	
	public String generateStudentID() {
		Student newStudent = new Student("", ""); 
		String studentID = newStudent.generateStudentID();
		return studentID;
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
	//ny version av updateStudent 
	 
	 
	 public void updateStudent(String name, String studentID) {
			Student tmp = studentLista.findStudent(studentID);
			tmp.setName(name);
	 }
	
	 
	 //Knappar på coursefliken
	 
	 public String addCourse(String courseCode, String name, double credits) {
		 Course newCourse = new Course(courseCode, name, credits); 
		 courseRegisterList.addCourse(newCourse);
		 return courseRegisterList.validateCourseCode(newCourse);
	 }
	 
	 public Course removeCourse(String courseCode) {
		 return courseRegisterList.removeCourse(courseCode);
	 }
	 
	 public Course findCourse(String courseCode) {
		 Course tmp = courseRegisterList.findCourse(courseCode);
		if (tmp == null) {
			return null;
		}
		return tmp;
	}
	 
	 public void u(String name, String studentID) {
			Student tmp = studentLista.findStudent(studentID);
			tmp.setName(name);
	 }
	 
	 /*Course c;
		 c = courseRegisterList.findCourse(courseCode);
		 return c;
	 }*/

	 //Knappar från WrittenExam-fliken
	 //"Add/remove exam for course:
	 
	 public String addWrittenExam(String courseCode, String examID, String time, String location, String date, int maxPoints) {
		WrittenExam newExam = new WrittenExam();
		Course course = courseRegisterList.findCourse(courseCode);
		newExam.setCourse(course);
		newExam.setDate(date);
		newExam.setMaxPoints(maxPoints);
		newExam.setTime(time);
		newExam.setLocation(location);
		newExam.setExamID(examID);
		writtenExamList.addWrittenExam(newExam);
		return writtenExamList.validateExamID(newExam);
		}
	  
	 
	 public String[] retrieveAllCourseNames() {
		 return CourseRegister.retrieveAllCourseNames();
	 }
	 
 
	 
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
	  
	 public String[] retrieveAllStudents(){
		 return studentLista.retrieveAllStudents();
	 }
	 
	 
	 public String [] findStudentArray(String sName) {
		 Student newStudent = studentLista.findStudent(sName);
		 String[] studentArray = new String [3];
		 
		 if(newStudent != null) {
			 studentArray[0] = newStudent.getName();
			 studentArray[1] = newStudent.getStudentID();
		 }
		 return studentArray;
		 
	 }

	public String generateExamID() {
		WrittenExam tmp = new WrittenExam(null, "", "", "", "", 0);
		String examID = tmp.generateExamID();
		return examID;
	}
	
	public String generateCourseCode() {
		Course tmp = new Course("", "", 0);
		String courseCode = tmp.generateCourseCode();
		return courseCode;
	}		 
	
	
	
	 }
	 
	
	
		
