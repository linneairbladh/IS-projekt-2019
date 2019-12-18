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
		courseRegisterList.remove(c);
		return c; 
	}
}