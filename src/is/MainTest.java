package is;

public class MainTest {

	public static void main(String[] args) {
		
		CourseRegister courseRegister = new CourseRegister(); 
		StudentRegister studentRegister = new StudentRegister();
		WrittenExamRegister writtenExamRegister = new WrittenExamRegister(); 
		Controller controller = new Controller(); 
		TestAp frame = new TestAp(new Controller(studentRegister, courseRegister, writtenExamRegister));
		
		System.out.println(controller.generateStudentID());
		System.out.println(controller.generateStudentID());
		System.out.println(controller.generateExamID());
		System.out.println("");
		
		//Lägger till studenter
		Student s1 = new Student ("Jonas", "S87299");
		Student s2 = new Student ("Lisa", "S78672");
		Student s3 = new Student ("Olof", "S25436");
		Student s4 = new Student ("Johanna", "S35267");
		
		//Lägger till kurser 
		Course c1 = new Course("C56579", "Design", 30);
		Course c2 = new Course("C27683", "Math", 60);
		Course c3 = new Course("C10928", "Organisation", 15);
		Course c4 = new Course("C67890", "Entrepreneurship", 30);
		
		//Lägger till Exams
		WrittenExam wr1 = new WrittenExam();
		//Association rill kurs
		wr1.setCourse(c1);
		wr1.setDate("02/03-20");
		wr1.setExamID("E02863");
		wr1.setLocation("Room A123");
		wr1.setTime("08:00");
		wr1.setMaxPoints(100);
		
		WrittenExam wr2 = new WrittenExam();
		wr2.setCourse(c2);
		wr2.setDate("02/15-20");
		wr2.setExamID("E97263");
		wr2.setLocation("Room A167");
		wr2.setTime("09:00");
		wr2.setMaxPoints(100);
		
		//GAMMAL TEST, funkade ej vid Update Student
		/*String studentID = controller.addStudent("Jonas", controller.generateStudentID());
		String studentName = controller.findStudent(studentID); 
		System.out.println(studentName + " " + studentID);*/
		
		//Testar om det går att lägga till en student med ett genererat student-id och sedan hitta studenten
		String studentID = controller.addStudent("Lisa", "S78672");
		String studentName = controller.findStudent("S78672");
		System.out.println(studentName + studentID);
		
		//Testar om det går att uppdatera student
		controller.updateStudent("Jonass","S78672");
		System.out.println("Nytt namn är " + controller.findStudent("S78672"));
			
		
		//GAMMAL TEST
		/*String courseCode = controller.addCourse("Design", controller.generateCourseCode(), 30);
		String courseName = controller.findCourse(courseCode); 
		System.out.println(courseName + " " + courseCode + ", " + courseCredits);
		*/
	
		//Testar om det går att lägga till en kurs med ett genererat kurs-id och sedan hitta kursen
		String courseCode = controller.addCourse("C56579", "Design", 30);
		String courseName = controller.findCourse("C56579"); 
		double courseCredits = controller.getCourseCredit("C56579");
		System.out.println(courseName + " " + courseCode + ", " + courseCredits);
		
		
		controller.updateCourseCredit("C56579", 40);
		System.out.println("Ny credit är " + controller.getCourseCredit("C56579")); 

		//denna metod finns ej i Controller än Sol!
		//controller.updateCourseName("Code", "C56579"); 	
		
		
		//Testar om det går att lägga till ett prov
		String exam = controller.addWrittenExam("C56579", "E02863", "09:00", "Room A123", "02/03-20", 100);
		System.out.println(exam);
			
		//Registrera result för student på prov
		controller.addResult("S78672", "E02863", 50);
		
		
		//Testar att ta bort ett prov
		controller.removeWrittenExam("E02863");
		
		String findExam = controller.findExam("E02863");
		
		if (findExam == null) {
			System.out.println("Ta bort prov funkar :)");
			}
			else {
			System.out.println("Ta bort prov funkar inte :(");
		}
		//Testar om det går att ta bort kurs
		controller.removeCourse(courseCode);
		String findCourse = controller.findCourse(courseCode); 
		if (findCourse == null) {
			System.out.println("Ta bort kurs funkar :)");
			}
			else {
			System.out.println("Funkar inte :(");
		}
		
		
		//Testar om det går att ta bort student
		controller.removeStudent(studentID);
		String findStudent = controller.findStudent(studentID); 
		if (findStudent == null) {
			System.out.println("Ta bort student funkar :)");
		}
		else {
			System.out.println("Funkar inte :(");
		}
	
		
		
		
		
		
	
	}
	}


