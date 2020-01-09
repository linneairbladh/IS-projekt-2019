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
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class TestApp {

	private JFrame frame;
	private JTextField textField_StudentName;
	private JTextField textField_StudentID;
	private JTextField textField_CourseName;
	private JTextField textField_CourseCode;
	private JTextField textField_Credit;
	private JTextField textField_MaxPoints;
	private JTextField textField_Date;
	private Controller controller = new Controller();
	private JTextField textField_Points;
	private JComboBox<String> comboBox_ExamID;
	private JComboBox<String> comboBox_StudentID;
	private JTextField textField_Time;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	

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
	
	
	private void fillStudentPicker() {
		String [] allStudentIDs = controller.retrieveAllStudents();
		for (int i = 0; i < allStudentIDs.length; i++ ) {
			comboBox_StudentID.addItem(allStudentIDs[i]);
		}
	}
	
	private void fillExamPicker() {
		String [] allExamID = controller.retrieveAllStudents();
		for (int i = 0; i < allExamID.length; i++ ) {
			comboBox_ExamID.addItem(allExamID[i]);
		}
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
		lblStudentName.setBounds(39, 105, 96, 16);
		Student.add(lblStudentName);
		
		textField_StudentName = new JTextField();
		textField_StudentName.setBounds(147, 98, 130, 26);
		Student.add(textField_StudentName);
		textField_StudentName.setColumns(10);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lblStudentId.setBounds(39, 183, 82, 16);
		Student.add(lblStudentId);
		
		textField_StudentID = new JTextField();
		textField_StudentID.setBounds(147, 178, 130, 26);
		Student.add(textField_StudentID);
		textField_StudentID.setColumns(10);
		
		//Svar på Student
		JTextArea textArea_StudentAnswer = new JTextArea();
		textArea_StudentAnswer.setBackground(SystemColor.window);
		textArea_StudentAnswer.setBounds(33, 136, 367, 35);
		Student.add(textArea_StudentAnswer);
		
		JTextArea textArea_FoundStudent = new JTextArea();
		textArea_FoundStudent.setBackground(SystemColor.window);
		textArea_FoundStudent.setBounds(39, 211, 367, 35);
		Student.add(textArea_FoundStudent);
		
		
		// Knappar på studentfliken
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				if (textField_StudentName.getText().equals("")) {
					textArea_StudentAnswer.setText("Please enter student name");
				}
				
				else { 
		
				String studentID = controller.generateStudentID();
				String sName = textField_StudentName.getText();
				controller.addStudent(sName, studentID);
				
				textArea_StudentAnswer.setText("Student: " + sName + " with student ID: " + studentID + " has been added");
				}
			}
		});
		btnAddStudent.setBounds(283, 96, 117, 29);
		Student.add(btnAddStudent);
		
		
		JButton btnFindStudent = new JButton("Find Student");
		btnFindStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String studentID = textField_StudentID.getText();
				Student newStudent = controller.findStudent(studentID);
				
				if (textField_StudentID.getText().equals("")) {
					textArea_FoundStudent.setText("Please enter student ID");
				}
				
				else if (newStudent!=null) {
					textArea_FoundStudent.setText(newStudent.getName() + " has " + studentID + " as StudentID ");
				
		      } else {
		      	textArea_FoundStudent.setText("Student can not be found");
		
		      }
				
			}});
		btnFindStudent.setBounds(33, 257, 117, 29);
		Student.add(btnFindStudent);
		
		JButton btnRemoveStudent = new JButton("Remove Student");
		btnRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String studentID = textField_StudentID.getText();
				controller.removeStudent(studentID);
				textArea_StudentAnswer.setText("The student has been removed");
		      																											//Deletes found student
			}	
		});
		btnRemoveStudent.setBounds(147, 257, 145, 29);
		Student.add(btnRemoveStudent);
		
		
		JButton btnUpdateStudent = new JButton("Update Name");
		btnUpdateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String studentID = textField_StudentID.getText();
				if (studentID.equals("")) {
					textArea_StudentAnswer.setText("Please enter a studentID");
				}
				else if (controller.findStudent(studentID) == null) {
					textArea_StudentAnswer.setText("No student found");
				}
				else if (textField_StudentName.equals("")) {
					textArea_StudentAnswer.setText("No edits were made");			//Checks if the fields are valid
				}
				else {
					controller.updateStudent(textField_StudentName.getText(), studentID);
					textArea_StudentAnswer.setText("Updated student: " + textField_StudentName.getText() + ", " + studentID);			//Updates a students name
					textField_StudentName.setText("");
					textField_StudentID.setText("");
				}	
				
				
			}
		});
		btnUpdateStudent.setBounds(291, 257, 130, 29);
		Student.add(btnUpdateStudent);
		
		JLabel lblWelcomeToConso = new JLabel("Welcome to Contoso University!");
		lblWelcomeToConso.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblWelcomeToConso.setBounds(80, 20, 273, 26);
		Student.add(lblWelcomeToConso);
		
		JLabel lblRegisterStudentsHere = new JLabel("Register students here:");
		lblRegisterStudentsHere.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lblRegisterStudentsHere.setBounds(39, 45, 153, 26);
		Student.add(lblRegisterStudentsHere);
		
		JLabel lblTheyWillAutomatically = new JLabel("The student will automatically get a student ID when registered");
		lblTheyWillAutomatically.setFont(new Font("Khmer Sangam MN", Font.ITALIC, 11));
		lblTheyWillAutomatically.setBounds(39, 72, 361, 16);
		Student.add(lblTheyWillAutomatically);
		
		
		
		////////////////
		////Kursflik////
		////////////////
		
		//Kursflik bakgrund
		JPanel Course = new JPanel();
		tabbedPane.addTab("Course", null, Course, null);
		Course.setLayout(null);
		
		//Skriva in text för kursnamn
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(42, 66, 101, 16);
		Course.add(lblCourseName);
		
		textField_CourseName = new JTextField();
		textField_CourseName.setBounds(155, 61, 130, 26);
		Course.add(textField_CourseName);
		textField_CourseName.setColumns(10);
		//
		
		//Skriva in text för kurskod
		JLabel lblCourseCode = new JLabel("Course Code");
		lblCourseCode.setBounds(42, 176, 90, 16);
		Course.add(lblCourseCode);
		
		textField_CourseCode = new JTextField();
		textField_CourseCode.setBounds(155, 171, 130, 26);
		Course.add(textField_CourseCode);
		textField_CourseCode.setColumns(10);
		//
		
		//Skriva in poäng för kursen 
		JLabel lblCredit = new JLabel("Credit");
		lblCredit.setBounds(42, 100, 61, 16);
		Course.add(lblCredit);
		
		textField_Credit = new JTextField();
		textField_Credit.setBounds(211, 94, 74, 26);
		Course.add(textField_Credit);
		textField_Credit.setColumns(10);
		//
		
		//Svarsruta kurs
		JTextPane textPane_AnswerCourse = new JTextPane();
		textPane_AnswerCourse.setBackground(SystemColor.window);
		textPane_AnswerCourse.setBounds(42, 130, 320, 34);
		Course.add(textPane_AnswerCourse);
		
		JTextPane textPane_FoundCourse = new JTextPane();
		textPane_FoundCourse.setBackground(SystemColor.window);
		textPane_FoundCourse.setBounds(42, 204, 339, 48);
		Course.add(textPane_FoundCourse);
				
		/// Knappar för kursfliken 
		
		JButton btnAddCourse = new JButton("Add Course ");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if (textField_CourseName.getText().equals("") && textField_Credit.getText().equals("")) {
					textPane_AnswerCourse.setText("Please enter credits and course name");
				}
				else if (textField_Credit.getText().equals("")){
					textPane_AnswerCourse.setText("Please enter credits");
				}
				else if (textField_CourseName.getText().equals("")) {
					textPane_AnswerCourse.setText("Please enter a Course Name");
				}
				
				else { 
					
					String courseCode = controller.generateCourseCode();
					String name = textField_CourseName.getText();
					try {
					double credits = Double.parseDouble(textField_Credit.getText());
					controller.addCourse(courseCode, name, credits);
				
				textPane_AnswerCourse.setText("Course: " + name + " with course code: " + courseCode + " and credits: " + credits + " has been added");
				
				}
				catch (java.lang.NumberFormatException exception) {
					textPane_FoundCourse.setText("Only numbers are allowed in the credits field");
				}
				}
			}
		});
		btnAddCourse.setBounds(297, 61, 117, 29);
		Course.add(btnAddCourse);
		
		JButton btnFindCourse = new JButton("Find Course");
		btnFindCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				String courseCode = textField_CourseCode.getText();
				Course newCourse = controller.findCourse(courseCode);
				Double credits = controller.findCourse(courseCode).getCredits();
				
				if (textField_CourseCode.getText().equals("")) {
					textPane_FoundCourse.setText("Please enter a course code");
				}
				
				else if (newCourse!=null) {
					textPane_FoundCourse.setText("Found course: " + newCourse.getName() + " and has " + credits + " credits" );
				
                } else {
                	textPane_FoundCourse.setText("Course can not be found");

                }
				
			
			
			}});
		btnFindCourse.setBounds(32, 287, 106, 29);
		Course.add(btnFindCourse);
		
		JButton btnRemoveCourse = new JButton("Remove Course");
		btnRemoveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String courseCode = textField_CourseCode.getText();
				controller.removeStudent(courseCode);
				textArea_StudentAnswer.setText("The course has been removed");
				
			}
		});
		btnRemoveCourse.setBounds(32, 257, 130, 29);
		Course.add(btnRemoveCourse);
		
		
		JButton btnUpdateCourse = new JButton("Update Course");
		btnUpdateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdateCourse.setBounds(32, 320, 117, 29);
		Course.add(btnUpdateCourse);
		
		JLabel lblRegisterCourseWith = new JLabel("Register course with name and credit points here:");
		lblRegisterCourseWith.setBounds(42, 27, 320, 16);
		Course.add(lblRegisterCourseWith);
		
		JLabel labelCourseInfo = new JLabel("The student will automatically get a student ID when registered");
		labelCourseInfo.setFont(new Font("Khmer Sangam MN", Font.ITALIC, 11));
		labelCourseInfo.setBounds(42, 6, 361, 16);
		Course.add(labelCourseInfo);
		
		
		
		
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
		
		//Svarsrutor för WE
		JTextPane textPane_AnswerResult = new JTextPane();
		textPane_AnswerResult.setBounds(239, 273, 160, 34);
		WrittenExam.add(textPane_AnswerResult);
						
		JTextPane textPane_AnswerExam = new JTextPane();
		textPane_AnswerExam.setBounds(24, 274, 203, 80);
		WrittenExam.add(textPane_AnswerExam);
		
		//Skriva in kurs på WE
		JLabel lblCourse_WECourse = new JLabel("Course ID");
		lblCourse_WECourse.setBounds(20, 51, 74, 16);
		WrittenExam.add(lblCourse_WECourse);

		//Skriva in Exam ID på WE
		JLabel lblMaxPoints = new JLabel("Max points");
		lblMaxPoints.setBounds(20, 83, 74, 16);
		WrittenExam.add(lblMaxPoints);
		
		textField_MaxPoints = new JTextField();
		textField_MaxPoints.setBounds(154, 78, 61, 26);
		WrittenExam.add(textField_MaxPoints);
		textField_MaxPoints.setColumns(10);
		
		//Skriva in datum på WE
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(20, 122, 61, 16);
		WrittenExam.add(lblDate);
		
		textField_Date = new JTextField();
		textField_Date.setBounds(103, 117, 112, 26);
		WrittenExam.add(textField_Date);
		textField_Date.setColumns(10);
		
		//Välja location på WE
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(20, 154, 61, 16);
		WrittenExam.add(lblLocation);
		
		//Välja time på WE
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(20, 240, 61, 16);
		WrittenExam.add(lblTime);
		
		//Skriva in Student ID
		JLabel lblStudentId_WEStudentID = new JLabel("Student ID");
		lblStudentId_WEStudentID.setBounds(237, 51, 94, 16);
		WrittenExam.add(lblStudentId_WEStudentID);
		
		//Välja registrerad Student ID
		JComboBox<String> comboBox_StudentID = new JComboBox<String>();
		comboBox_StudentID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object selectedItem = comboBox_StudentID.getSelectedItem();
				String selectedStudentID = selectedItem.toString();
				String[] selectedStudent = controller.findStudentArray(selectedStudentID);
				
				if(selectedStudent[2] != "") {
					textPane_AnswerResult.setText(selectedStudent[2]);
				}
				else {
					textPane_AnswerResult.setText("No choosen student");
			}
		}
		
		});
		comboBox_StudentID.setBounds(333, 47, 94, 27);
		WrittenExam.add(comboBox_StudentID);
		
		JLabel lblExamId_1 = new JLabel("Exam ID");
		lblExamId_1.setBounds(237, 88, 61, 16);
		WrittenExam.add(lblExamId_1);
		
		
		JComboBox<String> comboBox_ExamID = new JComboBox<String>();
		comboBox_ExamID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selectedItem = comboBox_ExamID.getSelectedItem();
				String selectedExamID = selectedItem.toString();
				String[] selectedExam = controller.findStudentArray(selectedExamID);
				
				if(selectedExam[2] != "") {
					textPane_AnswerResult.setText(selectedExam[2]);
				}
				else {
					textPane_AnswerResult.setText("No choosen course");
			}
				
			}
		});
	
		
		comboBox_ExamID.setBounds(298, 79, 129, 27);
		WrittenExam.add(comboBox_ExamID);
		
		
		//Skriva in points
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setBounds(237, 122, 61, 16);
		WrittenExam.add(lblPoints);
		
		textField_Points = new JTextField();
		textField_Points.setBounds(315, 117, 94, 26);
		WrittenExam.add(textField_Points);
		textField_Points.setColumns(10);
		
		textField_Time = new JTextField();
		textField_Time.setBounds(98, 240, 130, 26);
		WrittenExam.add(textField_Time);
		textField_Time.setColumns(10);
		
		//Radiobutton för att välja plats
		JRadioButton rdbtnA123 = new JRadioButton("Room A123");
		buttonGroup.add(rdbtnA123);
		rdbtnA123.setBounds(103, 150, 141, 23);
		WrittenExam.add(rdbtnA123);
		
		JRadioButton rdbtnB198 = new JRadioButton("Room B198");
		buttonGroup.add(rdbtnB198);
		rdbtnB198.setBounds(103, 191, 141, 23);
		WrittenExam.add(rdbtnB198);
		
		JRadioButton rdbtnB067 = new JRadioButton("Room B067");
		buttonGroup.add(rdbtnB067);
		rdbtnB067.setBounds(103, 213, 141, 23);
		WrittenExam.add(rdbtnB067);
		
		JRadioButton rdbtnA167 = new JRadioButton("Room A167");
		buttonGroup.add(rdbtnA167);
		rdbtnA167.setBounds(103, 169, 141, 23);
		WrittenExam.add(rdbtnA167);
		
		
		//Knappar på WE
		
		textField = new JTextField();
		textField.setBounds(103, 46, 112, 26);
		WrittenExam.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Find Course");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseCode = textField.getText();
				Course newCourse = controller.findCourse(courseCode);
				Double credits = controller.findCourse(courseCode).getCredits();
				
				if (textField.getText().equals("")) {
					textPane_AnswerResult.setText("Please enter a course code");
				}
				
				else if (newCourse!=null) {
					textPane_AnswerResult.setText("Found course: " + newCourse.getName() + " and has " + credits + " credits" );
				
                } else {
                	textPane_AnswerResult.setText("Course can not be found");

                }
				
			}
		});
		btnNewButton.setBounds(279, 190, 117, 29);
		WrittenExam.add(btnNewButton);
		
		JButton btnAddExam = new JButton("Add Exam");
		btnAddExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String courseCode = textField.getText();
				String location = "";
				String time;
				String date;
				int maxPoints;
				
				try {
					if (controller.findCourse(courseCode) == null) {
						textPane_AnswerExam.setText("Invalid course code");
					}
					else {
						if (textField_Date.getText().equals("") || textField_Time.getText().equals("") || textField_MaxPoints.getText().equals("")) {
							textPane_AnswerExam.setText("Please enter time, max points and a date for the exam.");
						}
						else if (rdbtnA123.isSelected() == false && rdbtnA167.isSelected() == false && rdbtnB198.isSelected() == false && rdbtnB067.isSelected() == false) {
							textPane_AnswerExam.setText("Please enter location");
							}																	//Checks that every field has a value
						else {
							String examID = controller.generateExamID();
							time = textField_Time.getText();
							date = textField_Date.getText();
							maxPoints = Integer.parseInt(textField_MaxPoints.getText());
							if (rdbtnA123.isSelected() == true && rdbtnA167.isSelected() == false && rdbtnB198.isSelected() == false && rdbtnB067.isSelected() == false) {
								location += " Room A123 ";
							}
							if (rdbtnA167.isSelected() == true) {		
								location += " Room A167 ";
							}
							if (rdbtnB198.isSelected() == true) {
								location += " Room B198 ";
							}
							if (rdbtnB067.isSelected() == true) {
								location += " Room B067 ";
							}
							controller.addWrittenExam(courseCode, examID,  time, location, date, maxPoints);				//Creates a new exam
							textPane_AnswerExam.setText("Exam for course " + controller.findCourse(courseCode) + " has been created." +"\n");
							textPane_AnswerExam.setText("ExamID: " + examID + "\n" + "Time: " + time +"\n" + "Location: " + location +"\n" + "Date: " + date + "\n" + "Max points: " + maxPoints);
							textField.setText("");
							textField_Time.setText("");
							textField_Date.setText("");
							textField_MaxPoints.setText("");
							rdbtnA123.setSelected(false);
							rdbtnA167.setSelected(false);
							rdbtnB198.setSelected(false);
							rdbtnB067.setSelected(false);
						}
					}
				}
				catch (java.lang.NumberFormatException exception) {
					textPane_AnswerExam.setText("Only numbers are allowed in the max points field");
				}
			}
				
				/*
				String courseCode = textField_CourseID.getText();
				String examID = controller.generateExamID();
				String time = textField_Time.getText();
				String date = textField_Date.getText();
				//String location = 
				double maxPoints = Double.parseDouble(textField_ExamName.getText());
			
			
				controller.addWrittenExam(courseCode, examID, time, location, date, maxPoints);;
				
				textPane_AnswerExam.setText("Exam:" + examID + " has been added with max Points: " + courseCode + " to course: " + courseCode);
				
				
				
			}*/		
			
		});
		btnAddExam.setBounds(20, 366, 101, 29);
		WrittenExam.add(btnAddExam);
		
		JButton btnRemoveExam = new JButton("Remove Exam");
		btnRemoveExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				String examID = toString().comboBox_ExamID.getSelectedItem();
				if (examID.equals("")) {
					textPane_AnswerExam.setText("Invalid exam-ID");
				}
				else if (controller.getExamDate(examID) == null) {
					textPane_AnswerExam.setText("No exam found");
				}
				else {
					controller.removeExam(examID);
					textPane_AnswerExam.setText("Exam with exam-ID " + examID + " has been removed.");
					textField_ExamID.setText("");
				
			}
			*/
			}
			
		});
		btnRemoveExam.setBounds(121, 366, 117, 29);
		WrittenExam.add(btnRemoveExam);
		
		JButton btnAddResult = new JButton("Register Result ");
		btnAddResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String examID = textField_MaxPoints.getText();
			//String studentID = textField_StudentID.getText();
			
			/*int result = Integer.parseInt(textField_Points.getText());
			
			String studentID = (String) comboBox_StudentName.getSelectedItem();
			
			if (textField_MaxPoints.getText().equals("") || textField_StudentID.getText().equals("") || textField_Points.getText().equals("")) {
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
			}*/
			}	
		});
		btnAddResult.setBounds(242, 315, 136, 29);
		WrittenExam.add(btnAddResult);
		

		
		
		
		
		
		
		
		
		
	
		
		
		
	}	
}
		
		
	
