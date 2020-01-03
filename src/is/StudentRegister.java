package is;

import java.util.ArrayList;

public class StudentRegister {
	
	private ArrayList <Student> studentRegisterList = new ArrayList <Student>();
	
	public ArrayList<Student> getStudentRegisterlIst() {
		return this.studentRegisterList;
	}
	
	public void setStudentRegisterList(ArrayList <Student> studentRegisterList) {
	this.studentRegisterList = studentRegisterList;
	}
	
	public void addStudent(Student a) {
		this.studentRegisterList.add(a);
	}

	
	public void removeStudent(String studentID) {
		Student s = this.findStudent(studentID); 
		if (s != null) {
		this.studentRegisterList.remove(s); }
		}		

	public Student findStudent(String studentID) { 
		//Student s = null;
		for (Student a : this.studentRegisterList) {
		if (a.getStudentID().equals(studentID)) { 
			return a;
		} 
		}
		return null; 
		}
	
	public void updateStudent(Student newStudent, String newName, String newStudentID) {
		newStudent.setName(newName);
		newStudent.setStudentID(newStudentID);
	}
	
	//metod för Combobox
	public String[] retrieveAllStudents() {
		String [] allStudents = new String[studentRegisterList.size()];
		int i = 0;
		
		for(Student a: studentRegisterList) {
			allStudents[i] = a.getName();
			i++;
		}
		return allStudents;
	}
	
}
