package is;

import java.util.ArrayList;
import javax.swing.JFrame;

public class Controller {
	
	JFrame frame; //Refererar till det grafiska gränssnittet
	
	StudentRegister studentLista = new StudentRegister(); //Refererar till StudentRegister
	WrittenExamRegister writtenExamList = new WrittenExamRegister(); //Refererar till WrittenExamRegister
	CourseRegister courseRegisterList = new CourseRegister(); //Refererar till CourseRegister
	//Result newResult = new Result (); //Refererar till Result
	WrittenExam writtenExam = new WrittenExam();
	
	public Controller() {
		this.courseRegisterList = new CourseRegister();
		this.studentLista = new StudentRegister();
		this.writtenExamList = new WrittenExamRegister();
	}
	
	public Controller (StudentRegister studentLista, CourseRegister courseRegisterList, WrittenExamRegister writtenExamList) {
		this.courseRegisterList = courseRegisterList;
		this.studentLista = studentLista;
		this.writtenExamList = writtenExamList;
	}
	
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
	 public String findStudent(String studentID) {
		 Student tmp = studentLista.findStudent(studentID);
		 if (tmp == null) {
			 return null;
		 }
		 return tmp.getName();
	 } 
	 public void removeStudent(String studentID) { 
		 studentLista.removeStudent(studentID);	
	 }

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
	 //Void?
	 public Course removeCourse(String courseCode) {
		 return courseRegisterList.removeCourse(courseCode);
	 }
	 
	 public String findCourse(String courseCode) {
		 Course tmp = courseRegisterList.findCourse(courseCode);
		if (tmp == null) {
			return null;
		}
		return tmp.getName();
	}
	 
	 public double getCourseCredit(String courseCode) {
		 Course tmp = courseRegisterList.findCourse(courseCode);
		if (tmp == null) {
			return 0;
		}
		return tmp.getCredits();
	}
	  
	public String generateExamID() {
			WrittenExam tmp = new WrittenExam();
			String examID = tmp.generateExamID();
			return examID;
		}
	
	public void updateCourse(String courseCode, String name, double credits) {
		Course newCourse = courseRegisterList.findCourse(courseCode);
		newCourse.setName(name);
		newCourse.setCredits(credits);
	}
	
	public void updateCourseCredit(String courseCode, double credits) {
			Course newCourse = courseRegisterList.findCourse(courseCode);
			newCourse.setCredits(credits);
	}
		
		
	 //Knappar från WrittenExam-fliken
	 //"Add/remove exam for course:
	 
		
	public String generateCourseCode() {
			Course tmp = new Course("", "", 0);
			String courseCode = tmp.generateCourseCode();
			return courseCode;
		}		
		
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
	  
	 public void removeWrittenExam(String examID) {
	 for(Course c: courseRegisterList.getCourseRegisterList()) {
		/* for (WrittenExam tmp : writtenExam.getExamResult() {
				}
				tmp.removeWrittenExam(examID);
			*/
		 }
			
		}
	 
	 //Fylla ComboBox StudentID och CourseID för Register Exam  for Student
	 public String[] retrieveAllStudents(){
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
	 public String[] retrieveAllCourses() {
		 return courseRegisterList.retrieveAllCourses();
	 }
	 
 
	//Knapp för Register Exam  for Student
	 /*public String addResult(int result, String letterGrade, WrittenExam writtenExam, Student student) {
	 //public String addResult(String studentID, String examID, int result) 
			//Result newResult = new Result(result, letterGrade, writtenExam, student);
			Student student = studentLista.findStudent(studentID);
			Student newRsult = resultlist.
			WrittenExam writtenExam = writtenExamList.findWrittenExam(examID);
			
			
			
			//StudentRegister newStudentRegister = new StudentRegister();
			
			newResult.setWrittenExam(newExam);
			newExam.addResult(newResult);
			//newStudentRegister.addStudent(newStudent);
			newResult.setResult(result);
			newResult.setStudent(newStudent);
			newStudent.addResult(newResult);
			newStudent.addWrittenExam(newExam);
			return newResult.getLetterGrade(); 
	 
	 }*/
	 
	 public String addResult(String studentID, String examID, int result) {
			Result tmpResult = new Result();
			Student tmpStudent = studentLista.findStudent(studentID);
			WrittenExam tmpExam = courseRegisterList.findWrittenExam(examID);
			tmpResult.setWrittenExam(tmpExam);
			tmpExam.addResult(tmpResult);
			//tmpStudent.addStudent(tmpStudent);
			tmpResult.setResult(result);
			tmpResult.setStudent(tmpStudent);
			tmpStudent.addResult(tmpResult);
			tmpStudent.addWrittenExam(tmpExam);
			return tmpResult.getLetterGrade();	
			
	 }
	 
	 public String findExam (String examID) {
		 WrittenExam exam = writtenExamList.findWrittenExam(examID);
		 if (exam == null) {
			 return null;
		 }
		 return exam.getExamID();
	 }
	 
	 public int getExamMaxPoints(String examID) {
			WrittenExam tmpExam = writtenExamList.findWrittenExam(examID);
			if (tmpExam == null){
				return 0;
			}
			
			return tmpExam.getMaxPoints();
		}	 	
	 
	 //Information om Student
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
			return examCourse;					//Returnerar en array av kurser som varje student har resultat på 
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
	 
	 
	 public String getExamDate(String examID) {
			WrittenExam tmpExam = writtenExamList.findWrittenExam(examID);
			if (tmpExam == null){
				return null;
			}
			
			return tmpExam.getDate();
		}
	  

	 
	 
	

 
	
	
	
	 }
	 
	
	
		
