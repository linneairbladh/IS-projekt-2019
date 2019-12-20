package is;

public class MainTest {

	public static void main(String[] args) {
		
		Student st1 = new Student("Viktor", "S11111");
		
		Student st2 = new Student("Tove", "S22222");
		
		Course co1 = new Course("C11111", "SYSA21", 15.0);
		
		Course co2 = new Course("C22222", "SYSA12", 30.0);
		
		WrittenExam we1 = new WrittenExam("E11111");
		
		WrittenExam we2 = new WrittenExam("E22222");
		
		Result r1 = new Result(90.0, we1, st1);
		
		Result r2 = new Result(50.0, we2, st2);
		
		CourseRegister cr1 = new CourseRegister();
		StudentRegister sr1 = new StudentRegister();
	
		cr1.addCourse(co1);
		cr1.addCourse(co2);
		co1.setCourseRegister(cr1);
		co2.setCourseRegister(cr1);
		
		sr1.addStudent(st1); 
		sr1.addStudent(st2);
		st1.setStudentRegister(sr1);
		st2.setStudentRegister(sr1);

		st1.addResult(r1);
		st2.addResult(r2);
		r1.setStudent(st1);
		r2.setStudent(st2);
		
		we1.addResult(r1);
		we2.addResult(r2);
		r1.setWrittenExam(we1);
		r2.setWrittenExam(we2);
		
		co1.addWrittenExam(we1);
		co2.addWrittenExam(we2);
		we1.setCourse(co1);
		we2.setCourse(co2);
		
		sr1.removeStudent("S12345");
		sr1.findStudent("S12345");
		sr1.updateStudent(st1, "Amanda", "S34567");
		
		st1.findResult(50.0);
	
		cr1.removeCourse("C11111");
		cr1.findCourse("C11111");
		cr1.updateCourse(co1, "C33333", "SYSA24", 75.0);
		
		co1.addWrittenExam(we1);
		co1.removeWrittenExam("E12345");
		
	} 
	}


