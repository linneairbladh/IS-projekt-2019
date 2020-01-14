package is;

public class Result {
	
	private int result;
	private String letterGrade;
	private Student student; // Association till student
	private WrittenExam writtenExam;


	public void setResult(int result) {
		int maxPoints = 100; //Max points är alltid 100
		//Räknar ut betyget som resultatet ger 
		if (result < (maxPoints*0.5) && result > (maxPoints - maxPoints -1)) {
			letterGrade = "F";
		}
		if (result < (maxPoints*0.55) && result > (maxPoints*0.49)) {
			letterGrade = "E";
		}
		if (result < (maxPoints*0.65) && result > (maxPoints*0.54)) {
			letterGrade = "D";
		}
		if (result < (maxPoints*75) && result > (maxPoints*0.64)) {
			letterGrade = "C";
		}
		if (result < (maxPoints*0.85) && result > (maxPoints*0.74)) {
			letterGrade = "B";
		}
		if (result < (maxPoints+1) && result > (maxPoints*0.84)) {
			letterGrade = "A";
		}
		if (result < 0 || result > maxPoints) { //Felmeddelande om den siffran är mindre än noll eller större än maxpoängen 
			letterGrade = "Wrong input";
		}
	}
	
	public int getResult() {
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
	
	public WrittenExam getWrittenExam() {
		return writtenExam;
	}
	
	public void setWrittenExam(WrittenExam writtenExam) {
		this.writtenExam = writtenExam;
	}
	
}
