package is;

import java.util.ArrayList;

public class WrittenExamRegister {

private ArrayList <WrittenExam> writtenExamList = new ArrayList <WrittenExam>();

	public void setWrittenExamList(ArrayList<WrittenExam> writtenExamList) {
		this.writtenExamList = writtenExamList;
	}
	
	public ArrayList<WrittenExam> getWrittenExamList(){
		return this.writtenExamList;
	}
	
	public void addWrittenExam(WrittenExam a) {
		writtenExamList.add(a);
	}
	
	public WrittenExam findWrittenExam(String examID) {
		WrittenExam a1 = null;
		for(WrittenExam a : writtenExamList) {
			if(a.getExamID().equals(examID)) {
				a1=a;
			}
		}
		return a1;
	}
	
	public void removeWrittenExam(String examID) {
		WrittenExam a = findWrittenExam(examID);
		writtenExamList.remove(a);
	}
}

	
	
