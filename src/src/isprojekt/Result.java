package src.isprojekt;

public class Result {
	
	private String result;
	private String letterGrade;
	
	private Student student; // Association till student
	
	public Result(String result, String letterGrade) {
		this.result = result; 
		this.letterGrade = letterGrade;
	}

	public void setResult(String result) {
		this.result = result; 
	}
	
	public String getResult() {
		return result; 
	}
	
	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade; 
	}
	
	public String getLetterGrade() {
		return letterGrade;
	}

	// Metoder för att sätta associationen 
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
