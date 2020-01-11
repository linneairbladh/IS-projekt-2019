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
		tabbedPane.setBounds(26, 29, 453, 491);
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
				lblStudentName.setBounds(39, 117, 96, 16);
				Student.add(lblStudentName);
				
				textField_StudentName = new JTextField();
				textField_StudentName.setBounds(148, 110, 130, 26);
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
				btnAddStudent.setBounds(283, 110, 117, 29);
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
						
						String name = controller.findStudent(textField_StudentID.getText());
						if (textField_StudentID.getText().equals("")) {
							textArea_FoundStudent.setText("Error: Please input a studentID");
						}		
						if (name == null) {
							textArea_FoundStudent.setText("No student found");
						}
						else {
							String studentID = textField_StudentID.getText();
							controller.removeStudent(studentID);
							textArea_FoundStudent.setText("Removed student: " + name +", " + textField.getText());
							}
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
							textArea_StudentAnswer.setText("Please enter a Student ID");
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
				lblWelcomeToConso.setBounds(86, 20, 273, 26);
				Student.add(lblWelcomeToConso);
				
				JLabel lblRegisterStudentsHere = new JLabel("Register students here:");
				lblRegisterStudentsHere.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
				lblRegisterStudentsHere.setBounds(39, 43, 153, 26);
				Student.add(lblRegisterStudentsHere);
				
				JLabel lblTheyWillAutomatically = new JLabel("The student will automatically get a student ID when registered");
				lblTheyWillAutomatically.setFont(new Font("Khmer Sangam MN", Font.ITALIC, 11));
				lblTheyWillAutomatically.setBounds(39, 89, 361, 16);
				Student.add(lblTheyWillAutomatically);
				
				JLabel label_2 = new JLabel("Fields marked with * are mandatory to fill in.");
				label_2.setBounds(39, 62, 320, 26);
				Student.add(label_2);
				
				JLabel label_3 = new JLabel("*");
				label_3.setForeground(Color.BLACK);
				label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				label_3.setBounds(134, 115, 19, 16);
				Student.add(label_3);
		
		
		
		////////////////
		////Kursflik////
		////////////////
		
		//Kursflik bakgrund
		JPanel Course = new JPanel();
		tabbedPane.addTab("Course", null, Course, null);
		Course.setLayout(null);
		
		//Skriva in text för kursnamn
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(53, 100, 101, 16);
		Course.add(lblCourseName);
		
		textField_CourseName = new JTextField();
		textField_CourseName.setBounds(166, 95, 130, 26);
		Course.add(textField_CourseName);
		textField_CourseName.setColumns(10);
		//
		
		//Skriva in text för kurskod
		JLabel lblCourseCode = new JLabel("Course Code");
		lblCourseCode.setBounds(53, 210, 90, 16);
		Course.add(lblCourseCode);
		
		textField_CourseCode = new JTextField();
		textField_CourseCode.setBounds(166, 205, 130, 26);
		Course.add(textField_CourseCode);
		textField_CourseCode.setColumns(10);
		//
		
		//Skriva in poäng för kursen 
		JLabel lblCredit = new JLabel(" Credit points");
		lblCredit.setBounds(53, 134, 90, 16);
		Course.add(lblCredit);
		
		textField_Credit = new JTextField();
		textField_Credit.setBounds(221, 130, 74, 26);
		Course.add(textField_Credit);
		textField_Credit.setColumns(10);
		//
		
		//Svarsruta kurs
		JTextPane textPane_AnswerCourse = new JTextPane();
		textPane_AnswerCourse.setBackground(SystemColor.window);
		textPane_AnswerCourse.setBounds(53, 164, 320, 34);
		Course.add(textPane_AnswerCourse);
		
		JTextPane textPane_FoundCourse = new JTextPane();
		textPane_FoundCourse.setBackground(SystemColor.window);
		textPane_FoundCourse.setBounds(53, 238, 339, 48);
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
		btnAddCourse.setBounds(296, 95, 117, 29);
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
		btnFindCourse.setBounds(42, 287, 106, 29);
		Course.add(btnFindCourse);
		
		JButton btnRemoveCourse = new JButton("Remove Course");
		btnRemoveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (textField_CourseCode.getText().equals("") || textPane_FoundCourse.getText().equals("")) {
					textPane_FoundCourse.setText("Please enter a coursecode.");
				}
				else {
					String courseCode = textField_CourseCode.getText();
				if (controller.findCourse(courseCode) == null) 
					textPane_FoundCourse.setText("No course found");
				}
				else {
					String courseCode = textField_CourseCode.getText();
					//String name = controller.findCourse(courseCode);
					double credits = controller.get
							controller.getCourseCredits(courseCode);
				
					controller.removeCourse(courseCode);
					textPane_FoundCourse.setText("The course " + name + "with courseCode " + courseCode + "and number of credits " + credits + "has been removed");
				}	
				
			}
		});
		btnRemoveCourse.setBounds(160, 287, 130, 29);
		Course.add(btnRemoveCourse);
		
		JButton btnUpdateCourse = new JButton("Update Course");
		btnUpdateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseCode = textField_CourseCode.getText();
				if (courseCode.equals("")) {
					textPane_FoundCourse.setText("Please enter a student ID");
				}
				/*else if (controller.findCourse(courseCode) == null) {
					textPane_FoundCourse.setText("No course found");
				}
				else if (controller.findCourse(courseCode) != null && textField_Name.isEditable() == false && textField_Credits.isEditable() == false) {		//Checks that all fields are valid
					textPane_FoundCourse.setText("No edit has been made");
				}
				else if (controller.findCourse(courseCode) != null && textField_Name.isEditable() == true && textField_Credits.isEditable() == false) {
					controller.updateCourseName(textField_Name.getText(), courseCode);
					textPane_FoundCourse.setText("Course has been updated: " + textField_Name.getText() + ", " + courseCode + ", number of credits: " + controller.getCourseCredits(courseCode));
				}
				else if (controller.findCourse(courseCode) != null && textField_Name.isEditable() == false && textField_Credits.isEditable() == true) {
					int credits = Integer.parseInt(textField_Credits.getText());
					controller.updateCourseCredit(courseCode, credits);
					textPane_FoundCourse.setText("Course has been updated: " + controller.findCourse(courseCode) +", " + courseCode + ", number of credits: " + credits);
				}
				else if (controller.findCourse(courseCode) != null && textField_Name.isEditable() == true && textField_Credits.isEditable() == true) {
					int credits = Integer.parseInt(textField_Credits.getText());
					controller.updateCourseCredit(courseCode, credits); 
					controller.updateCourseName(courseCode, name);
					
				
					controller.updateCourseName(textField_Name.getText(), courseCode);
					textPane_FoundCourse.setText("Course has been updated: " + controller.findCourse(courseCode) + ", " + courseCode + ", number of credits: " + credits);		//Checks if it's the credits, name or both that is edited and edits it
				}
				else if (controller.findCourse(courseCode) != null && textField_Credits.isEditable() == true && textField_Credits.getText().equals("")) {
					textPane_FoundCourse.setText("No edit has been made");
				}
				else if (controller.findCourse(courseCode) != null && textField_Name.isEditable() == true && textField_Name.getText().equals("")) {
					textPane_FoundCourse.setText("No edit has been made");
				}
			*/
			
			}
		});
		btnUpdateCourse.setBounds(296, 287, 117, 29);
		Course.add(btnUpdateCourse);
		
		JLabel lblRegisterCourseWith = new JLabel("Register course with name and credit points here:");
		lblRegisterCourseWith.setBounds(53, 18, 320, 26);
		Course.add(lblRegisterCourseWith);
		
		JLabel labelCourseInfo = new JLabel("The course will automatically get a student ID when registered");
		labelCourseInfo.setFont(new Font("Khmer Sangam MN", Font.ITALIC, 11));
		labelCourseInfo.setBounds(52, 67, 361, 16);
		Course.add(labelCourseInfo);
		
		JLabel label = new JLabel("*");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label.setForeground(SystemColor.activeCaptionText);
		label.setBounds(140, 133, 19, 16);
		Course.add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_1.setBounds(140, 100, 19, 16);
		Course.add(label_1);
		
		JLabel lblFieldsMarkedWith = new JLabel("Fields marked with * are mandatory to fill in.");
		lblFieldsMarkedWith.setBounds(53, 39, 320, 26);
		Course.add(lblFieldsMarkedWith);
		
		
		
		
		///////////////////////
		///Written exam flik///
		///////////////////////
		
		//Bakgrund för fliken written exam 
		JPanel WrittenExam = new JPanel();
		tabbedPane.addTab("Written Exam", null, WrittenExam, null);
		WrittenExam.setLayout(null);
		
		//Beskrivning av sidan 
		JLabel lblRegisterResultFor = new JLabel("Register result for student:");
		lblRegisterResultFor.setBounds(236, 50, 172, 16);
		WrittenExam.add(lblRegisterResultFor);
		
		JLabel lblAddremoveExamFor = new JLabel("Add/remove exam for course:");
		lblAddremoveExamFor.setBounds(19, 50, 195, 16);
		WrittenExam.add(lblAddremoveExamFor);
		
		//Svarsrutor för WE
		JTextPane textPane_AnswerResult = new JTextPane();
		textPane_AnswerResult.setBounds(238, 307, 160, 34);
		WrittenExam.add(textPane_AnswerResult);
						
		JTextPane textPane_AnswerExam = new JTextPane();
		textPane_AnswerExam.setBounds(23, 308, 203, 80);
		WrittenExam.add(textPane_AnswerExam);
		
		//Skriva in kurs på WE
		JLabel lblCourse_WECourse = new JLabel("Course ID");
		lblCourse_WECourse.setBounds(19, 85, 74, 16);
		WrittenExam.add(lblCourse_WECourse);

		//Skriva in Exam ID på WE
		JLabel lblMaxPoints = new JLabel("Max points");
		lblMaxPoints.setBounds(19, 117, 74, 16);
		WrittenExam.add(lblMaxPoints);
		
		textField_MaxPoints = new JTextField();
		textField_MaxPoints.setBounds(153, 112, 61, 26);
		WrittenExam.add(textField_MaxPoints);
		textField_MaxPoints.setColumns(10);
		
		//Skriva in datum på WE
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(19, 156, 35, 16);
		WrittenExam.add(lblDate);
		
		textField_Date = new JTextField();
		textField_Date.setBounds(102, 151, 112, 26);
		WrittenExam.add(textField_Date);
		textField_Date.setColumns(10);
		
		//Välja location på WE
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(19, 188, 61, 16);
		WrittenExam.add(lblLocation);
		
		//Välja time på WE
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(19, 274, 61, 16);
		WrittenExam.add(lblTime);
		
		//Skriva in Student ID
		JLabel lblStudentId_WEStudentID = new JLabel("Student ID");
		lblStudentId_WEStudentID.setBounds(236, 85, 66, 16);
		WrittenExam.add(lblStudentId_WEStudentID);
		
		//Välja registrerad Student ID
		// välj add student knapp för att koden ska köras eller annan knapp
		JComboBox<String> comboBox_StudentID = new JComboBox<String>();
		comboBox_StudentID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		comboBox_StudentID.setBounds(314, 81, 94, 27);
		WrittenExam.add(comboBox_StudentID);
		
		JLabel lblExamId_1 = new JLabel("Exam ID");
		lblExamId_1.setBounds(236, 122, 61, 16);
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
	
		
		comboBox_ExamID.setBounds(314, 113, 94, 27);
		WrittenExam.add(comboBox_ExamID);
		
		
		//Skriva in points
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setBounds(236, 156, 44, 16);
		WrittenExam.add(lblPoints);
		
		textField_Points = new JTextField();
		textField_Points.setBounds(314, 151, 94, 26);
		WrittenExam.add(textField_Points);
		textField_Points.setColumns(10);
		
		textField_Time = new JTextField();
		textField_Time.setBounds(97, 274, 130, 26);
		WrittenExam.add(textField_Time);
		textField_Time.setColumns(10);
		
		//Radiobutton för att välja plats
		JRadioButton rdbtnA123 = new JRadioButton("Room A123");
		buttonGroup.add(rdbtnA123);
		rdbtnA123.setBounds(102, 184, 141, 23);
		WrittenExam.add(rdbtnA123);
		
		JRadioButton rdbtnB198 = new JRadioButton("Room B198");
		buttonGroup.add(rdbtnB198);
		rdbtnB198.setBounds(102, 225, 141, 23);
		WrittenExam.add(rdbtnB198);
		
		JRadioButton rdbtnB067 = new JRadioButton("Room B067");
		buttonGroup.add(rdbtnB067);
		rdbtnB067.setBounds(102, 247, 141, 23);
		WrittenExam.add(rdbtnB067);
		
		JRadioButton rdbtnA167 = new JRadioButton("Room A167");
		buttonGroup.add(rdbtnA167);
		rdbtnA167.setBounds(102, 203, 141, 23);
		WrittenExam.add(rdbtnA167);
		
		
		//Knappar på WE
		
		textField = new JTextField();
		textField.setBounds(102, 80, 112, 26);
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
		btnNewButton.setBounds(278, 224, 117, 29);
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
					
			
		});
		btnAddExam.setBounds(19, 400, 101, 29);
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
		btnRemoveExam.setBounds(120, 400, 117, 29);
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
		btnAddResult.setBounds(241, 349, 136, 29);
		WrittenExam.add(btnAddResult);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_4.setBounds(84, 85, 19, 16);
		WrittenExam.add(label_4);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_5.setBounds(94, 117, 19, 16);
		WrittenExam.add(label_5);
		
		JLabel label_6 = new JLabel("*");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_6.setBounds(52, 156, 19, 16);
		WrittenExam.add(label_6);
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_7.setBounds(77, 188, 19, 16);
		WrittenExam.add(label_7);
		
		JLabel label_8 = new JLabel("*");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_8.setBounds(52, 274, 19, 16);
		WrittenExam.add(label_8);
		
		JLabel label_9 = new JLabel("*");
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_9.setBounds(3302, 50, 19, 16);
		WrittenExam.add(label_9);
		
		JLabel label_10 = new JLabel("*");
		label_10.setForeground(Color.BLACK);
		label_10.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_10.setBounds(306, 85, 19, 16);
		WrittenExam.add(label_10);
		
		JLabel label_11 = new JLabel("*");
		label_11.setForeground(Color.BLACK);
		label_11.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_11.setBounds(291, 122, 19, 16);
		WrittenExam.add(label_11);
		
		JLabel label_12 = new JLabel("*");
		label_12.setForeground(Color.BLACK);
		label_12.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_12.setBounds(278, 155, 19, 16);
		WrittenExam.add(label_12);
		
		JLabel label_13 = new JLabel("Fields marked with * are mandatory to fill in.");
		label_13.setBounds(19, 12, 320, 26);
		WrittenExam.add(label_13);
		

		
		
		
		
		
		
		
		
		
	
		
		
		
	}	
}
		
		
	
