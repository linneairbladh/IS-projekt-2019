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

	public Course updateCourse(Course c, String newcourseCode, String newname, double newcredits) {
		c.setCourseCode(newcourseCode);
		c.setName(newname);
		c.setCredits(newcredits);
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
		for (Course tmp : courseRegisterList) {
			for (WrittenExam tmpExam : tmp.getWrittenExamList() ) {
				if(tmpExam.getExamID().equals(examID)) {
					return tmpExam;
				}
			}
		}
		return null;
	}

	public String validateCourseCode(Course c)	{
		for (Course tmp : courseRegisterList) {
			if (tmp == c) { 			
				continue;
			}
			while (tmp.getCourseCode().equals(c.getCourseCode())){
				String courseCode = c.generateCourseCode();
				c.setCourseCode(courseCode);;
			}
		}
		return c.getCourseCode();				//Validerar en kurskod. Om den inte är unik skapas en ny och valideras
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

	
