package is;

import java.util.ArrayList;


public class StudentRegister {
	
	private ArrayList <Student> studentRegisterList = new ArrayList <Student>();
	
	//Add, find, remove, validate and update Student
	public void addStudent(Student newStudent) {
		this.studentRegisterList.add(newStudent);
	}

	public Student findStudent(String studentID) { 
		for (Student s : this.studentRegisterList) {
			if (s.getStudentID().equals(studentID)) { 
				return s;
			} 
		}
		return null; 
	}
	
	public String validateStudentID(Student newStudent)	{
		for (Student tmp : studentRegisterList) {
			if (tmp == newStudent) { 			//Skips s
				continue;
			}
			while (tmp.getStudentID().equals(newStudent.getStudentID())){
				String studentID = newStudent.generateStudentID();
				newStudent.setStudentID(studentID);
			}
		}
		return newStudent.getStudentID();				//Validates a studentID. If it is not unique a new one is generated and validated again
	}
	
	
	
	public Student removeStudent(String studentID) {
		Student s = this.findStudent(studentID); 
		if (s != null) {
		this.studentRegisterList.remove(s); }
		return s;
		}	
	
	public void setStudents(ArrayList<Student> studentRegisterList) { 
		this.studentRegisterList = studentRegisterList; 
		
	}
	public ArrayList<Student> getStudents() {
		return this.studentRegisterList;
	}
	
	public void updateStudent(Student newStudent, String newName, String newStudentID) {
		newStudent.setName(newName);
		newStudent.setStudentID(newStudentID);
	}
	
	public void removeResult(Result result) {				//Removes a result for every student that has that result. Not ideal but prevents app from crashing when an exam is removed and the student still has a result
		Result remove = new Result();
		for (Student student : studentRegisterList) {
			remove = result;
			student.getResultList().remove(remove);
		}
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
