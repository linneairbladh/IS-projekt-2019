package is;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.text.*;

public class TestApp {

	private JFrame frame;
	private JTextField textField_StudentName;
	private JTextField textField_StudentID;
	private JTextField textField_CourseName;
	private JTextField textField_CourseCode;
	private JTextField textField_Credit;
	private JTextField textField_ExamID;
	private JTextField textField_Date;
	private Controller controller = new Controller();
	private JTextField textField_Points;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestApp window = new TestApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestApp() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 548);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(31, 29, 448, 447);
		frame.getContentPane().add(tabbedPane);
		
		////////////////////
		////Studentflik/////
		////////////////////
		
		//Studentflik: Bakgrund
		JPanel Student = new JPanel();
		tabbedPane.addTab("Student", null, Student, null);
		Student.setLayout(null);
		//
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lblStudentName.setBounds(39, 33, 96, 16);
		Student.add(lblStudentName);
		
		textField_StudentName = new JTextField();
		lblStudentName.setLabelFor(textField_StudentName);
		textField_StudentName.setBounds(147, 28, 130, 26);
		Student.add(textField_StudentName);
		textField_StudentName.setColumns(10);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(39, 66, 82, 16);
		Student.add(lblStudentId);
		
		textField_StudentID = new JTextField();
		textField_StudentID.setBounds(147, 61, 130, 26);
		Student.add(textField_StudentID);
		textField_StudentID.setColumns(10);
		
		//Svar på Student
		JTextArea textArea_StudentAnswer = new JTextArea();
		textArea_StudentAnswer.setBackground(Color.WHITE);
		textArea_StudentAnswer.setBounds(49, 113, 266, 35);
		Student.add(textArea_StudentAnswer);
		
		
		// Knappar på studentfliken
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textField_StudentName.getText().equals("")) {
					textArea_StudentAnswer.setText("Error: Please insert a name.");			//Checks that the field is valid
				}
				else { 
				String studentID = controller.generateStudentID();
				studentID = controller.addStudent(textField_StudentName.getText(), studentID);
				textArea_StudentAnswer.setText(textField_StudentName.getText() +", " + studentID + " added to students.");
				textField_StudentName.setText("");
			}	
				
				
				/*
				String studentID = textField_StudentID.getText();
				String sName = textField_StudentName.getText();
				Student newStudent = new Student();//studentID, sName)
				newStudent.setStudentID(studentID);
				newStudent.setName(sName);
				
				//KAN VARA FEL
				if(sName.trim().equals("")|| studentID.trim().equals("")){
					textArea_StudentAnswer.setText("You did not enter anyting.");
				}
				
				else if (sName.trim().equals("")) {
					textArea_StudentAnswer.setText("You did not enter Student ID.");
					
				}
				
				else if (studentID.trim().equals("")) {
					textArea_StudentAnswer.setText("You did not enter name.");
					
				}
					
				else {
				controller.addStudent(newStudent);
				textArea_StudentAnswer.setText("Student has been added");
				}
				*/
			}
		});
		btnAddStudent.setBounds(39, 172, 117, 29);
		Student.add(btnAddStudent);
		
		
		JButton btnRemoveStudent = new JButton("Remove Student");
		btnRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String studentID = textField_StudentID.getText();
				controller.removeStudent(studentID);
				textArea_StudentAnswer.setText("The student has been removed");
	             }
				
		});
		btnRemoveStudent.setBounds(39, 205, 145, 29);
		Student.add(btnRemoveStudent);
			
		
		JButton btnFindStudent = new JButton("Find Student");
		btnFindStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*String studentID = textField_StudentID.getText();
				Student newStudent = controller.findStudent(studentID);
				
				if (newStudent!=null) {
					textArea_StudentAnswer.setText(newStudent.getName());
				
                } else {
                    textArea_StudentAnswer.setText("Student can not be found");

                }  */
				
				String studentID = textField_StudentID.getText();
				if (studentID.equals("")) {
					textArea_StudentAnswer.setText("Please enter a student-ID.");
				}
				else if (controller.findStudent(studentID) == null) {
					textArea_StudentAnswer.setText("Invalid student-ID.");
				}
				else {
					String[] examIDs = controller.getWrittenExamIDs(studentID);
					if (examIDs.length == 0) {
						textArea_StudentAnswer.append("Student has no results");
					}
					else {
						textArea_StudentAnswer.setText("Student " + controller.findStudent(studentID) +" has written following exams:" + "\n");
					int[] examResults = controller.getWrittenExamResults(studentID, examIDs);
					String[] examGrades = controller.getWrittenExamGrades(studentID, examIDs);
					String[] examCourses = controller.getWrittenExamCourse(studentID, examIDs);
						for (int i = 0; i < examIDs.length; i++) {
							textArea_StudentAnswer.append("\n" + "Course:" + "\t" + "Exam-ID:" + "\t" + "Points" + "\t" + "Grade:" + "\n");
							textArea_StudentAnswer.append("\n" + examCourses[i] + "\t" + examIDs[i] + "\t" + examResults[i] + "\t" + examGrades[i] + "\n");
						}
					}
				}
				
				
     
			
			}});
		btnFindStudent.setBounds(39, 238, 117, 29);
		Student.add(btnFindStudent);
		
		
		JButton btnUpdateStudent = new JButton("Update Student");
		btnUpdateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnUpdateStudent.setBounds(39, 271, 130, 29);
		Student.add(btnUpdateStudent);
		
		JLabel lblUserHelp1 = new JLabel("(Starts with \"S\" followed by 5 numbers)");
		lblUserHelp1.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
		lblUserHelp1.setBounds(39, 85, 251, 16);
		Student.add(lblUserHelp1);
		
		//TEST textfält för max 6 siffror
		JFormattedTextField formattedTextField_StudentID = new JFormattedTextField();		
		MaskFormatter ssnFormatter  = null; 
		JFormattedTextField ssnField  = null; 
		try  {
		    ssnFormatter = new MaskFormatter("A#####");
		    ssnField = new JFormattedTextField(ssnFormatter);
		}
		catch (ParseException e)  {
		    e.printStackTrace();
		}
					
		formattedTextField_StudentID.setBounds(147, 113, 96, 26);
		Student.add(formattedTextField_StudentID);
		
		
		////////////////
		////Kursflik////
		////////////////
		
		//Kursflik bakgrund
		JPanel Course = new JPanel();
		tabbedPane.addTab("Course", null, Course, null);
		Course.setLayout(null);
		
		//Skriva in text för kursnamn
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(42, 39, 101, 16);
		Course.add(lblCourseName);
		
		textField_CourseName = new JTextField();
		textField_CourseName.setBounds(155, 34, 130, 26);
		Course.add(textField_CourseName);
		textField_CourseName.setColumns(10);
		//
		
		//Skriva in text för kurskod
		JLabel lblCourseCode = new JLabel("Course Code");
		lblCourseCode.setBounds(42, 67, 90, 16);
		Course.add(lblCourseCode);
		
		textField_CourseCode = new JTextField();
		   if ((textField_CourseCode.getText().length() > 10)) {   
		   }
		textField_CourseCode.setBounds(155, 62, 130, 26);
		Course.add(textField_CourseCode);
		textField_CourseCode.setColumns(10);
		//
		
		//Skriva in poäng för kursen 
		JLabel lblCredit = new JLabel("Credit");
		lblCredit.setBounds(42, 106, 61, 16);
		Course.add(lblCredit);
		
		textField_Credit = new JTextField();
		textField_Credit.setBounds(155, 100, 130, 26);
		Course.add(textField_Credit);
		textField_Credit.setColumns(10);
		//
		
		//Svarsruta för uppdatera kurs
		JTextPane textPane_AnswerCourse = new JTextPane();
		textPane_AnswerCourse.setBackground(Color.WHITE);
		textPane_AnswerCourse.setBounds(52, 152, 232, 53);
		Course.add(textPane_AnswerCourse);
				
		/// Knappar för kursfliken 
		
		JButton btnAddCourse = new JButton("Add Course ");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseCode = textField_CourseCode.getText();
				String name = textField_CourseName.getText();
				double credits = Double.parseDouble(textField_Credit.getText());
				Course newCourse = new Course();
				newCourse.setCourseCode(courseCode);
				newCourse.setName(name);
				newCourse.setCredits(credits);
				 
				controller.addCourse(newCourse);
				
				textPane_AnswerCourse.setText("Course has been added");
				
				
			}
		});
		btnAddCourse.setBounds(42, 226, 117, 29);
		Course.add(btnAddCourse);
		
		JButton btnRemoveCourse = new JButton("Remove Course");
		btnRemoveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String courseCode = textField_CourseCode.getText();
				controller.removeStudent(courseCode);
				textArea_StudentAnswer.setText("The course has been removed");
				
			}
		});
		btnRemoveCourse.setBounds(42, 255, 130, 29);
		Course.add(btnRemoveCourse);
		
		JButton btnFindCourse = new JButton("Find Course");
		btnFindCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String courseCode = textField_CourseCode.getText();
				Course newCourse = controller.findCourse(courseCode);
				
				if (newCourse!=null) {
					textPane_AnswerCourse.setText(newCourse.getName());
				
                } else {
                	textPane_AnswerCourse.setText("Course can not be found");

                }   
			
			}});
		btnFindCourse.setBounds(42, 284, 106, 29);
		Course.add(btnFindCourse);
		
		JButton btnUpdateCourse = new JButton("Update Course");
		btnUpdateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdateCourse.setBounds(42, 313, 117, 29);
		Course.add(btnUpdateCourse);
		
		JLabel lblUserHelp2 = new JLabel("(Starts with \"C\" followed by 5 numbers)");
		lblUserHelp2.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
		lblUserHelp2.setBounds(42, 84, 266, 16);
		Course.add(lblUserHelp2);
		
		
		
		///////////////////////
		///Written exam flik///
		///////////////////////
		
		//Bakgrund för fliken written exam 
		
		JPanel WrittenExam = new JPanel();
		tabbedPane.addTab("Written Exam", null, WrittenExam, null);
		WrittenExam.setLayout(null);
		
		//Beskrivning av sidan 
		JLabel lblRegisterResultFor = new JLabel("Register result for student:");
		lblRegisterResultFor.setBounds(237, 16, 172, 16);
		WrittenExam.add(lblRegisterResultFor);
		
		JLabel lblAddremoveExamFor = new JLabel("Add/remove exam for course:");
		lblAddremoveExamFor.setBounds(20, 16, 195, 16);
		WrittenExam.add(lblAddremoveExamFor);
		
		//Skriva in kurs på WE
		JLabel lblCourse_WECourse = new JLabel("Course");
		lblCourse_WECourse.setBounds(20, 51, 61, 16);
		WrittenExam.add(lblCourse_WECourse);
		
		JComboBox comboBox_Course = new JComboBox();
		comboBox_Course.setBounds(93, 47, 122, 27);
		WrittenExam.add(comboBox_Course);

		//Skriva in Exam ID på WE
		JLabel lblExamId = new JLabel("Exam ID");
		lblExamId.setBounds(20, 83, 61, 16);
		WrittenExam.add(lblExamId);
		
		textField_ExamID = new JTextField(5);//Accepterar 5 siffror
		textField_ExamID.setBounds(93, 78, 122, 26);
		WrittenExam.add(textField_ExamID);
		textField_ExamID.setColumns(10);
		
		//Skriva in datum på WE
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(20, 122, 61, 16);
		WrittenExam.add(lblDate);
		
		textField_Date = new JTextField();
		textField_Date.setBounds(93, 117, 122, 26);
		WrittenExam.add(textField_Date);
		textField_Date.setColumns(10);
		
		//Välja location på WE
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(20, 154, 61, 16);
		WrittenExam.add(lblLocation);
		
		JComboBox comboBox_Location = new JComboBox();
		comboBox_Location.setModel(new DefaultComboBoxModel(new String[] {"Room A123", "Room A167", "Room B198", "Room B067"}));
		comboBox_Location.setBounds(93, 150, 129, 27);
		WrittenExam.add(comboBox_Location);
		
		//Välja time på WE
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(20, 189, 61, 16);
		WrittenExam.add(lblTime);
		
		JComboBox comboBox_Time = new JComboBox();
		comboBox_Time.setModel(new DefaultComboBoxModel(new String[] {"07:00", "08:00", "09:00"}));
		//comboBox_Time.setSelectedItem(""); //vet inte varför?
		comboBox_Time.setBounds(93, 185, 129, 27);
		WrittenExam.add(comboBox_Time);
		
		//Skriva in Student ID
		JLabel lblStudentId_WEStudentID = new JLabel("Student ID");
		lblStudentId_WEStudentID.setBounds(237, 51, 66, 16);
		WrittenExam.add(lblStudentId_WEStudentID);
		
		//Välja registrerat Student ID
		JComboBox comboBox_StudentiD = new JComboBox();
		
		//comboBox_StudentiD.addActionListener(new Action Listener() {
			
		
		
		/*private void fillComboBox_StudentID() {
			String[] allStudentIDs = controller.retrieveAllStudents();
			
			for(int i = 0; i < allStudentIDs.length; i++) {
				comboBox_StudentiD.addItem(allStudentIDs[i]);
			}
		*/
		
		comboBox_StudentiD.setBounds(315, 47, 94, 27);
		WrittenExam.add(comboBox_StudentiD);
		
		//Skriva in points
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setBounds(237, 122, 61, 16);
		WrittenExam.add(lblPoints);
		
		textField_Points = new JTextField();
		textField_Points.setBounds(315, 117, 94, 26);
		WrittenExam.add(textField_Points);
		textField_Points.setColumns(10);
		
		//Svarsrutor för WE
		JTextPane textPane_AnswerResult = new JTextPane();
		textPane_AnswerResult.setBounds(237, 217, 160, 34);
		WrittenExam.add(textPane_AnswerResult);
				
		JTextPane textPane_AnswerExam = new JTextPane();
		textPane_AnswerExam.setBounds(24, 217, 181, 34);
		WrittenExam.add(textPane_AnswerExam);
		
		
		//Knappar på WE
		JButton btnAddExam = new JButton("Add Exam");
		btnAddExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseCode = textField_CourseCode.getText();
				String location = "";
				String time;
				String date;
				int maxPoints;
				try {
					if (controller.findCourse(courseCode) == null) {
						textPane_AnswerExam.setText("Invalid course code");
					}
					else {
						if (textField_Date.getText().equals("")) {
							textPane_AnswerExam.setText("Please enter date for the exam");
						}
						//Checks that every field has a value
						
						String examID = controller.generateExamID();
						date = textField_Date.getText();
						
					}
				}
					
					catch (java.lang.NumberFormatException exception) {
						textPane_AnswerExam.setText("Only numbers are allowed in the max points field");
				}
			}
			
		});
		btnAddExam.setBounds(20, 263, 101, 29);
		WrittenExam.add(btnAddExam);
		
		JButton btnRemoveExam = new JButton("Remove Exam");
		btnRemoveExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveExam.setBounds(20, 291, 117, 29);
		WrittenExam.add(btnRemoveExam);
		
		JButton btnAddResult = new JButton("Register Result ");
		btnAddResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String examID = textField_ExamID.getText();
			//String studentID = textField_StudentID.getText();
			
			int result = Integer.parseInt(textField_Points.getText());
			
			String studentID = comboBox_StudentiD.getSelectedItem();
			
			if (textField_ExamID.getText().equals("") || textField_StudentID.getText().equals("") || textField_Points.getText().equals("")) {
				textPane_AnswerResult.setText("Please enter an Exam-ID, a Student-ID and a score");
			}
			else if (controller.getExamDate(examID) == null) {
				textPane_AnswerResult.setText("Invalid Exam-ID");
			}
			else if (controller.findStudent(studentID) == null) {
				textPane_AnswerResult.setText("Invalid Student -ID");
			}
			else if (result > controller.getExamMaxPoints(examID) || result < 0) {
				textPane_AnswerResult.setText("Invalid amount of points");								//Checks that every field is valid
			}
			else {
				String letterGrade = controller.addResult(studentID, examID, result);
				textPane_AnswerResult.setText("Added result for student: " + controller.findStudent(studentID) + " on exam " + examID + "\n");
				textPane_AnswerResult.setText("Points: " + result + "\t" + "Grade: " + letterGrade);
				textField_StudentID.setText("");
				textPane_AnswerResult.setText("");													//Register results for a student on an exam
			}
			}	
		});
		btnAddResult.setBounds(237, 263, 136, 29);
		WrittenExam.add(btnAddResult);
		
		JLabel lblStartsWith = new JLabel("(Starts with \"E\" followed by 5 numbers)");
		lblStartsWith.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
		lblStartsWith.setBounds(20, 100, 202, 16);
		WrittenExam.add(lblStartsWith);
		
		JLabel lblExamId_1 = new JLabel("Exam ID");
		lblExamId_1.setBounds(237, 88, 61, 16);
		WrittenExam.add(lblExamId_1);
		
		JComboBox comboBox_ExamID = new JComboBox();
		comboBox_ExamID.setBounds(315, 83, 94, 27);
		WrittenExam.add(comboBox_ExamID);
		
		
		
	}	
}
		
		
	
