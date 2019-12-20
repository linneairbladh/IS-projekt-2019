package is;

public class StartVarde {

	//osäker om denna klass behövs
	
	public void RunStartValues(StudentRegister studentRegister, CourseRegister courseRegister, WrittenExamRegister writtenExamRegister) {
		CourseRegister cr1 = courseRegister;
		StudentRegister sr1 = studentRegister;
		WrittenExamRegister er1 = writtenExamRegister;
		
		Student st1 = new Student("S00001","Viktor");
		Student st2 = new Student("S00002","Tove");
		sr1.addStudent(st1);
		sr1.addStudent(st2);
		
		Course co1 = new Course("C00001", "SYSA21", 15.0);
		Course co2 = new Course("C00002", "SYSA12", 30.0);
		cr1.addCourse(co1);
		cr1.addCourse(co2);
		
		WrittenExam we1 = new WrittenExam();
		we1.setLocation("Room A123");
		we1.setDate("2019-01-30");
		we1.setMaxPoints(100);
		we1.setTime("08:00");		
		er1.addWrittenExam(we1);
		co1.addWrittenExam(we1);

		WrittenExam we2 = new WrittenExam("E00002");

		we2.setLocation("Room B067");
		we2.setDate("2019-01-31");
		we2.setMaxPoints(120);
		we2.setTime("10:00");
		er1.addWrittenExam(we2);
		co2.addWrittenExam(we2);

		Result r1 = new Result(100, we1, st1);
		we1.addResult(r1);
		st1.addResult(r1);
		r1.calculateGrade(100);	

		Result r2 = new Result(90, we2, st2);
		we2.addResult(r2);
		st2.addResult(r2);
		r2.calculateGrade(90);

	}
}

