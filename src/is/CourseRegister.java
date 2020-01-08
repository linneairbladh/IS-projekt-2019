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
		Course c = null; 
		for(Course co : courseRegisterList) {
			if(co.getCourseCode().equals(courseCode)) {
				c = co;
			}
		}
		return c;
		
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
		
	
}