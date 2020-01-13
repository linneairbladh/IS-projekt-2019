package is;

import java.util.ArrayList;
import java.util.Random;

import is.Result;
import is.StudentRegister;
import is.WrittenExam;

public class Student {
	
	private String studentID;
	private String sName;
	//private StudentRegister studentRegister;
	private ArrayList<Result>resultList = new ArrayList<Result>();
	private ArrayList<WrittenExam> writtenExams = new ArrayList<WrittenExam>();
	
	//Constructor för Student
	public Student(String sName, String studentID) {
		this.setStudentID(studentID);
		this.setName(sName);
		}


		//Skapa ett studentID
		public String generateStudentID() {
			Random random = new Random(); //Man importerar denna 
			int randomInt = random.nextInt(90000) + 10000; // Gör ett random nummer mellan 10000 and 99999
			String studentID = "S" + randomInt;
			return studentID;
		}
	
	//Set + get
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return sName;
	}
	public void setName(String sName) {
		this.sName = sName;
	}
	/*public StudentRegister getStudentRegister() {
		return studentRegister;
	}
	public void setStudentRegister(StudentRegister studentRegister) {
		this.studentRegister = studentRegister;
	}*/
	public ArrayList<Result> getResultList() {
		return resultList;
	}
	public void setResultList(ArrayList<Result> resultList) {
		this.resultList = resultList;
	}
	
	public ArrayList<WrittenExam> getWrittenExams() {
		return writtenExams;
	}

	public void setWrittenExams(ArrayList<WrittenExam> writtenExams) {
		this.writtenExams = writtenExams;
	}
	
	
	
	//Metoder för add & find result
	public void addResult(Result r) {
		resultList.add(r);
	}

	public Result findResult(double result) {
		for(Result a: resultList) {
			if(a.getResult()==(result)) {
				return a;
			}
		}
		return null;
	}
	
	//Metoder för add & find exam
	public void addWrittenExam(WrittenExam exam) {
		writtenExams.add(exam);
	}
	public void AddWrittenExam(WrittenExam e, double resultNr) {
		Result a = findResult(resultNr);
		if(a!=null) {
			a.setWrittenExam(e);
		}
		
	}
	
	public void removeWrittenExam(String examID) {
		WrittenExam remove = new WrittenExam();
		for (WrittenExam tmpExam : writtenExams) {
			if (tmpExam.getExamID().equals(examID)) {
				remove = tmpExam;
			}
		}
		writtenExams.remove(remove);
	}

	public WrittenExam findWrittenExam(String examID) {
			for(WrittenExam a: writtenExams) {
				if(a.getExamID().equals(examID)) {
					return a;
				}
			}
			return null;
		}


	
}

