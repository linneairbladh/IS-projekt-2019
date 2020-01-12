package is;

public class Result {
	
	private int result;
	private String letterGrade;
	private Student student; // Association till student
	private WrittenExam writtenExam;

	/*public Result (int result, String letterGrade, WrittenExam writtenExam, Student student) {
		this.result = result; 
		this.letterGrade = letterGrade;
		this.writtenExam = writtenExam;
		this.student = student;
		
	}*/

	public void setResult(int result) {
		this.result = result; 
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
	
	// metod för att räkna ut betyg baser på poäng
	
	public void calculateGrade(double result) {
		double score = (result / writtenExam.getMaxPoints());
		if(score < 0.5) {
			this.letterGrade = "U";
		}else if(score >= 0.5 && score < 0.55){
			this.letterGrade = "E";
		}else if(score >= 0.55 && score < 0.65) {
			this.letterGrade = "D";
		}else if(score >= 0.65 && score < 0.75) {
			this.letterGrade = "C";
		}else if(score >= 0.75 && score < 0.85) {
			this.letterGrade = "B";
		}else if(score >= 0.85 && score <= 1) {
			this.letterGrade = "A";
		}
	}

}
