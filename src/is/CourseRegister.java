package is;

import java.util.ArrayList;

public class CourseRegister {
	
	private ArrayList<Course>courseRegisterList = new ArrayList<Course>();

	public ArrayList<Course> getCourseRegisterList() {
		return courseRegisterList;
	}
	public void setCourseRegisterList(ArrayList<Course> courseRegisterList) {
		this.courseRegisterList = courseRegisterList;
	} 
	
	public void addCourse(Course c) {
		courseRegisterList.add(c);
	}
	
	public Course findCourse(String courseCode) { 
		for(Course co : courseRegisterList) {
			if(co.getCourseCode().equals(courseCode)) {
				return co;
			}
		}
		return null;
	}
	
	public Course updateCourse(Course c, String newCourseCode, String newName, double newCredits) {
		c.setCourseCode(newCourseCode);
		c.setName(newName);
		c.setCredits(newCredits);
			return c;
	}
	
	public Course removeCourse(String courseCode) {
		Course c = findCourse(courseCode);
		if(c != null) {
		courseRegisterList.remove(c);
		}
		return c; 
	}
	
	public WrittenExam findWrittenExam(String examID) {
		for (Course course : courseRegisterList) {
			for (WrittenExam exam : course.getWrittenExamList() ) {
				if(exam.getExamID().equals(examID)) {
					return exam;
				}
			}
		}
		return null;
	}
	
	public String validateCourseCode(Course c)	{ //Denna validerar en kurskod och m den inte är unik skapas en ny och den valideras
		for (Course course : courseRegisterList) {
			if (course == c) { 			
				continue;
			}
			while (course.getCourseCode().equals(c.getCourseCode())){
				String courseCode = c.generateCourseCode();
				c.setCourseCode(courseCode);;
			}
		}
		return c.getCourseCode();				
	}

	public String validateExamID(WrittenExam newExam) {
		for (Course course : courseRegisterList) {	
		for (WrittenExam exam : course.getWrittenExamList()) {
				if (exam == newExam) { 		
					continue;
				}
				while (exam.getExamID().equals(newExam.getExamID())){
					String examID = newExam.generateExamID();
					newExam.setExamID(examID);
				}
			}
		}
		return newExam.getExamID();
	}
	
}

	
