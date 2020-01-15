package is;

import java.util.ArrayList;
import javax.swing.JFrame;

public class Controller {
	
	JFrame frame; //Refererar till det grafiska gränssnittet
	
	StudentRegister studentList = new StudentRegister(); //Refererar till StudentRegister
	CourseRegister courseRegisterList = new CourseRegister(); //Refererar till CourseRegister
	Result newResult = new Result (); //Refererar till Result
	WrittenExam writtenExam = new WrittenExam();
	
	public Controller() {

	Student s1 = new Student("Sol Grip Rösth","S11111"); //Skapar studenter och tilldelar attribut på värden genom constructorn 
	Student s2 = new Student("Linnea Irbladh","S22222");
	Student s3 = new Student ("Erik Risberg","S33333");
	
	studentList.addStudent(s1);//Lägger till studenterna i studentregisterlistan
	studentList.addStudent(s2); 
	studentList.addStudent(s3);
	
	Course c1 = new Course("C11111", "Design", 30); //Skapar kurser och tilldelar värden attribut genom constructorn
	Course c2 = new Course("C22222", "Mathematics", 60);
	Course c3 = new Course("C33333", "English", 30);
	
	courseRegisterList.addCourse(c1);//Lägger till kurserna i kursregisterlistan
	courseRegisterList.addCourse(c2);
	courseRegisterList.addCourse(c3);
	
	//Skapar written exam 
	WrittenExam wr1 = new WrittenExam();
	
	wr1.setExamID("E11111");    //Tilldelar värden på attributen 
	wr1.setDate("04/03-20");
	wr1.setLocation("Room A123");
	wr1.setTime("08:00");
	wr1.addStudent(s1); //Association written exam -> student
	s1.addWrittenExam(wr1); //Association student -> written exam
	
	WrittenExam wr2 = new WrittenExam();
	wr2.setExamID("E22222");    //Tilldelar värden på attributen 
	wr2.setDate("04/03-20");
	wr2.setLocation("Room A123");
	wr2.setTime("09:00");
	wr2.addStudent(s2); //Association written exam -> student
	s2.addWrittenExam(wr2); //Association student -> written exam
	
	WrittenExam wr3 = new WrittenExam();
	wr3.setExamID("E33333");    //Tilldelar värden på attributen 
	wr3.setDate("04/03-20");
	wr3.setLocation("Room A123");
	wr3.setTime("13:00");
	wr3.addStudent(s3); //Association written exam -> student
	s3.addWrittenExam(wr3); 
	
	c1.addWrittenExam(wr1);//Lägger till exam på kurs
	c1.addWrittenExam(wr2);//Lägger till exam på kurs
	c1.addWrittenExam(wr3);//Lägger till exam på kurs
	
	Result r1 = new Result(); //Skapar resultat
	r1.setResult(80);
	r1.setStudent(s1);
	r1.setWrittenExam(wr1);
	s1.addResult(r1);//Association student -> resultat
	wr1.addResult(r1); //Association written exam -> resultat
	}
	
	//Knappar på studentfliken
	
	public String addStudent(String name, String studentID) {
		Student newStudent = new Student(name, studentID);
		studentList.addStudent(newStudent);
		return studentList.validateStudentID(newStudent);			//lägger till student på studentlista och returnerar ett validerat studentID
	}
	
	public String generateStudentID() {
		Student newStudent = new Student("", ""); 
		String studentID = newStudent.generateStudentID();
		return studentID; //Returnerar ett genererat studentID
	}
	
	public String findStudent(String studentID) {
		 Student student = studentList.findStudent(studentID);
		 if (student == null) {
			 return null;
		 }
		 return student.getName();
	 } 
	 public void removeStudent(String studentID) { 
		 studentList.removeStudent(studentID);	
	 }

	 public void updateStudent(String sName, String studentID) {
			Student newStudent = studentList.findStudent(studentID);
			newStudent.setName(sName);
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
	 
	 public String findCourse(String courseCode) {
		 Course findCourse = courseRegisterList.findCourse(courseCode);
		if (findCourse == null) {
			return null;
		}
		return findCourse.getName();
	}
	 
	 public double getCourseCredit(String courseCode) {
		 Course courseCredit = courseRegisterList.findCourse(courseCode);
		if (courseCredit == null) {
			return 0;
		}
		return courseCredit.getCredits();
	}
	  
	public String generateExamID() {
			WrittenExam generatedExamID = new WrittenExam();
			String examID = generatedExamID.generateExamID();
			return examID;
	}

	public void updateCourseCredit(String courseCode, double credits) {
			Course newCourse = courseRegisterList.findCourse(courseCode);
			newCourse.setCredits(credits); //Uppdaterar credit på en kurs 
	}
	
	public void updateCourseName(String courseCode, String name) {
		Course newCourse = courseRegisterList.findCourse(courseCode);
		newCourse.setName(name);   //Uppdaterar namnet på en kurs 
		
	}
	public String getCourseName(String courseCode) {
		 Course courseName = courseRegisterList.findCourse(courseCode);
		if (courseName == null) {
			return null;
		}
		return courseName.getName();   //Returnerar kursnamnet 
	}
	
	public String generateCourseCode() {
			Course generatedCourseCode = new Course("", "", 0);
			String courseCode = generatedCourseCode.generateCourseCode();
			return courseCode;
		}
		
	 //Knappar från WrittenExam-fliken
	 //Lägg till/ta bort prov för kurs:
	 public String addWrittenExam(String courseCode, String examID, String time, String location, String date) {
		WrittenExam newExam = new WrittenExam();
		Course course = courseRegisterList.findCourse(courseCode);
		newExam.setCourse(course);
		newExam.setExamID(examID);
		newExam.setDate(date);
		newExam.setTime(time);
		newExam.setLocation(location);
		course.addWrittenExam(newExam);
		return courseRegisterList.validateExamID(newExam); //Lägger till och returnerar ett validerat ExamID
		}
	 
	 public String findExam (String examID) {
		 WrittenExam exam = courseRegisterList.findWrittenExam(examID);
		 if (exam == null) {
			 return null;
		 }
		 return exam.getExamID();
	 }
	 
	 
	 public void removeWrittenExam(String examID) {
			for (Course course : courseRegisterList.getCourseRegisterList()) {
				for (WrittenExam exam : course.getWrittenExamList()) {
					if (exam.getExamID().equals(examID)) {
						for (Result result : exam.getExamResult()) {
							studentList.removeResult(result);
						}
						for (Student student : studentList.getStudents()) {
							student.removeWrittenExam(examID);
						}
					}
				}
				course.removeWrittenExam(examID);
			}
		}
	 
	 public int getExamMaxPoints(String examID) {
			WrittenExam exam = courseRegisterList.findWrittenExam(examID);
			if (exam == null){
				return 0;
			}
			return exam.getMaxPoints();
			
		}	

	 
	//Knapp för Register Exam  for Student
	 public String addResult(String studentID, String examID, int result) {
			Result newResult = new Result();
			WrittenExam writtenExam = courseRegisterList.findWrittenExam(examID);
			Student student = studentList.findStudent(studentID);
			newResult.setStudent(student);
			newResult.setWrittenExam(writtenExam);
			newResult.setResult(result);
			student.addResult(newResult);
			writtenExam.addResult(newResult);
			return newResult.getLetterGrade();
			}	 
	 
}

	
		
