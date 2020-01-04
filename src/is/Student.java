package is;

import java.util.ArrayList;

public class Student {
	
	private String studentID;
	private String sName;
	private StudentRegister studentRegister;
	private ArrayList<Result>resultList = new ArrayList<Result>();
	
	public Student() {
		this.setStudentID(studentID);
		this.setName(sName);
	}
	
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
	public StudentRegister getStudentRegister() {
		return studentRegister;
	}
	public void setStudentRegister(StudentRegister studentRegister) {
		this.studentRegister = studentRegister;
	}
	public ArrayList<Result> getResultList() {
		return resultList;
	}
	public void setResultList(ArrayList<Result> resultList) {
		this.resultList = resultList;
	}
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
	
	public void AddWrittenExam(WrittenExam e, double resultNr) {
		Result a = findResult(resultNr);
		if(a!=null) {
			a.setWrittenExam(e);
		}
		
	}
}

