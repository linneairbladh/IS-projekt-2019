package is;

import java.util.ArrayList;

public class StudentRegister {
	
	private ArrayList <Student> studentRegisterList = new ArrayList <Student>();
	
	public void setStudents(ArrayList<Student> studentRegisterList) { 
		this.studentRegisterList = studentRegisterList; 
		
	}
	public ArrayList<Student> getStudents() {
		return this.studentRegisterList;
	}
	
	
	//Add,find, remove and update Student
	public void addStudent(Student newStudent) {
		this.studentRegisterList.add(newStudent);
	}

	public Student findStudent(String studentID) { 
		Student a = null;
		for (Student s : this.studentRegisterList) {
			if (s.getStudentID().equals(studentID)) { 
				a = s;
			} 
		}
		return a; 
	}
	
	
	public Student removeStudent(String studentID) {
		Student s = this.findStudent(studentID); 
		if (s != null) {
		this.studentRegisterList.remove(s); }
		return s;
		}	
	
	public void updateStudent(Student newStudent, String newName, String newStudentID) {
		newStudent.setName(newName);
		newStudent.setStudentID(newStudentID);
	}
	
	
	//metod för att fylla Combobox med ArrayList
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
