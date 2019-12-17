package isprojekt;

import java.util.ArrayList;

public class StudentRegister {
	
	private ArrayList <Student> studentRegisterList = new ArrayList <Student>();
	
	public ArrayList<Student> getStudents() {
		return this.studentRegisterList;
	}
	
	public void addStudent(Student a) {
		studentRegisterList.add(a);
	}

	public void removeStudent(String studentID) {
		Student s = this.findStudent(studentID); 
		if (s != null) {
		this.studentRegisterList.remove(s); }
		}		

	public Student findStudent(String studentID) { 
		for (Student s : this.studentRegisterList) {
		if (s.getStudentID().equals(studentID)) { 
			return s;
		} }
		return null; }
}
