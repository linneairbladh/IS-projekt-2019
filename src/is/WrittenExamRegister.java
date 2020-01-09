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
	
	public String validateExamID(WrittenExam newExam) {
			for (WrittenExam exam : writtenExamList) {
				if (exam == newExam) { 			//Skips e
					continue;
				}
				while (exam.getExamID().equals(newExam.getExamID())){
					String examID = newExam.generateExamID();
					newExam.setExamID(examID);
				}
			}
		return null;
	}
}

	
	
