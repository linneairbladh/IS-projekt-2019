package is;

import java.util.ArrayList;


public class StudentRegister {
	
	private ArrayList <Student> studentRegisterList = new ArrayList <Student>();
	
	//Lägg till, hitta, ta bort, validera och uppdatera student
	public void addStudent(Student newStudent) {
		this.studentRegisterList.add(newStudent); //Lägger till en student i studentregisterlistan
	}

	public Student findStudent(String studentID) { 
		for (Student s : this.studentRegisterList) {
			if (s.getStudentID().equals(studentID)) { 
				return s;
			} 
		}
		return null; 
	}
	
	public String validateStudentID(Student newStudent)	{ //Validerar studentID och om det inte är validerat så görs ett nytt id och valideras igen
		for (Student student : studentRegisterList) {
			if (student == newStudent) { 			
				continue;
			}
			while (student.getStudentID().equals(newStudent.getStudentID())){
				String studentID = newStudent.generateStudentID();
				newStudent.setStudentID(studentID);
			}
		}
		return newStudent.getStudentID();				
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
	
	public void removeResult(Result result) { //Tar bort resultet från student				
		Result remove = new Result();
		for (Student student : studentRegisterList) {
			remove = result;
			student.getResultList().remove(remove);
		}
	}	
}
