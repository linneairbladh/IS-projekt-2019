package is;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Application {

	private JFrame frame;
	private JTextField textField_StudentName;
	private JTextField textField_StudentID;
	private JTextField textField_CourseName;
	private JTextField textField_CourseCode;
	private JTextField textField_Credit;
	private JTextField textField_WEdate;
	private Controller controller = new Controller();
	private JTextField textField_WEpoints;
	private JTextField textField_WEtime;
	private JTextField textField_WEcourseID;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_WEsearchForExamID;
	private JTextField textField_WEstudentID;
	private JTextField textField_WEexamID;
	private JLabel lbl_WEstudentID;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param controller 
	 */
	public Application() {
		initialize();
	}
	
	public Application(Controller controller) {
		this.controller = controller; 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 548);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane applicationArea = new JTabbedPane(JTabbedPane.TOP);
		applicationArea.setBounds(26, 29, 453, 491);
		frame.getContentPane().add(applicationArea);
		
				////////////////////
				////Studentflik/////
				////////////////////
				
				//Studentflik: Bakgrund
				JPanel JPanelStudentArea = new JPanel();
				applicationArea.addTab("Student", null, JPanelStudentArea, null);
				JPanelStudentArea.setLayout(null);
				
				
				JLabel lblStudentName = new JLabel("Student Name");
				lblStudentName.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
				lblStudentName.setBounds(39, 117, 96, 16);
				JPanelStudentArea.add(lblStudentName);
				
				textField_StudentName = new JTextField();
				textField_StudentName.setBounds(148, 110, 130, 26);
				JPanelStudentArea.add(textField_StudentName);
				textField_StudentName.setColumns(10);
				
				JLabel lblStudentId = new JLabel("Search for student ID");
				lblStudentId.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
				lblStudentId.setBounds(47, 275, 145, 16);
				JPanelStudentArea.add(lblStudentId);
				
				textField_StudentID = new JTextField();
				textField_StudentID.setBounds(221, 268, 130, 26);
				JPanelStudentArea.add(textField_StudentID);
				textField_StudentID.setColumns(10);
				
				//Svar på Student
				JTextArea textArea_StudentAnswer = new JTextArea();
				textArea_StudentAnswer.setEditable(false);
				textArea_StudentAnswer.setBackground(SystemColor.window);
				textArea_StudentAnswer.setBounds(39, 190, 367, 35);
				JPanelStudentArea.add(textArea_StudentAnswer);
				
				JTextArea textArea_FoundStudent = new JTextArea();
				textArea_FoundStudent.setEditable(false);
				textArea_FoundStudent.setBackground(SystemColor.window);
				textArea_FoundStudent.setBounds(39, 302, 367, 35);
				JPanelStudentArea.add(textArea_FoundStudent);
				
				
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
						
						textArea_StudentAnswer.setText("Added student: " + sName + " with studentID: " + studentID);
						textField_StudentName.setText("");
						}
					}
				});
				btnAddStudent.setBounds(283, 110, 117, 29);
				JPanelStudentArea.add(btnAddStudent);
				
				
				JButton btnFindStudent = new JButton("Find Student");
				btnFindStudent.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String studentID = textField_StudentID.getText();
						String studentName = controller.findStudent(studentID);
						
						if (textField_StudentID.getText().equals("")) {
							textArea_FoundStudent.setText("Please enter student ID");
						}
						
						else if (studentName!=null) {
							textArea_FoundStudent.setText("Found student: " + studentName + " with studentID: " + studentID);
						
				      } else {
				      	textArea_FoundStudent.setText("Student can not be found");
				
				      }
						
					}});
				btnFindStudent.setBounds(39, 349, 117, 29);
				JPanelStudentArea.add(btnFindStudent);
				
				JButton btnRemoveStudent = new JButton("Remove Student");
				btnRemoveStudent.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String name = controller.findStudent(textField_StudentID.getText());
						
						if (textField_StudentID.getText().equals("")) {
							textArea_FoundStudent.setText("Please input a studentID");
						}		
						if (name == null) {
							textArea_FoundStudent.setText("No existing student found");
						}
						else {
							String studentID = textField_StudentID.getText();
							controller.removeStudent(studentID);
							textArea_FoundStudent.setText("Removed student: " + name);
							}
							//Raderar hittad student
						}
				});
				btnRemoveStudent.setBounds(153, 349, 145, 29);
				JPanelStudentArea.add(btnRemoveStudent);
				
				
				JButton btnUpdateStudent = new JButton("Update Name");
				btnUpdateStudent.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						if (textField_StudentName.getText().equals("")){
							textArea_StudentAnswer.setText("Please enter name");
						}
						else if (controller.findStudent(textField_StudentID.getText()) == null) {
							textArea_StudentAnswer.setText("No existing student found");
						}
						else {
							controller.updateStudent(textField_StudentName.getText(), textField_StudentID.getText());
							textArea_StudentAnswer.setText("Updated student: " + textField_StudentName.getText() + " (" + textField_StudentID.getText() + ")");			//Updates a students name
							textField_StudentName.setText("");
							textField_StudentID.setText("");
						}	
						
						
					}
				});
				btnUpdateStudent.setBounds(283, 138, 130, 29);
				JPanelStudentArea.add(btnUpdateStudent);
				
				//Siddesign och info-text
				JLabel lblWelcomeToConsoUni = new JLabel("Welcome to Contoso University!");
				lblWelcomeToConsoUni.setFont(new Font("Rockwell", Font.PLAIN, 16));
				lblWelcomeToConsoUni.setBounds(86, 20, 273, 26);
				JPanelStudentArea.add(lblWelcomeToConsoUni);
				
				JLabel lbl_RegisterStudentsHere = new JLabel("Register students here:");
				lbl_RegisterStudentsHere.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
				lbl_RegisterStudentsHere.setBounds(39, 43, 153, 26);
				JPanelStudentArea.add(lbl_RegisterStudentsHere);
				
				JLabel lblTheyWillAutomatically = new JLabel("The student will automatically get a student ID when registered");
				lblTheyWillAutomatically.setFont(new Font("Khmer Sangam MN", Font.ITALIC, 11));
				lblTheyWillAutomatically.setBounds(39, 89, 361, 16);
				JPanelStudentArea.add(lblTheyWillAutomatically);
				
				JLabel lbl_MandatoryFieldsStudents = new JLabel("Fields marked with * are mandatory to fill in.");
				lbl_MandatoryFieldsStudents.setBounds(39, 62, 320, 26);
				JPanelStudentArea.add(lbl_MandatoryFieldsStudents);
				
				JLabel lbl_Star1Student = new JLabel("*");
				lbl_Star1Student.setForeground(Color.BLACK);
				lbl_Star1Student.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lbl_Star1Student.setBounds(134, 115, 19, 16);
				JPanelStudentArea.add(lbl_Star1Student);
				
				JLabel lbl_Star2Student = new JLabel("*");
				lbl_Star2Student.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lbl_Star2Student.setBounds(188, 275, 19, 16);
				JPanelStudentArea.add(lbl_Star2Student);
				
				JTextArea textArea_SeperatorLineStudent = new JTextArea();
				textArea_SeperatorLineStudent.setForeground(SystemColor.inactiveCaptionText);
				textArea_SeperatorLineStudent.setEditable(false);
				textArea_SeperatorLineStudent.setBackground(SystemColor.window);
				textArea_SeperatorLineStudent.setText("_____________________________________________________________________________");
				textArea_SeperatorLineStudent.setBounds(26, 237, 381, 26);
				JPanelStudentArea.add(textArea_SeperatorLineStudent);
				
		
		
		
		////////////////
		////Kursflik////
		////////////////
		
		//Kursflik bakgrund
		JPanel JPanelCourseArea = new JPanel();
		applicationArea.addTab("Course", null, JPanelCourseArea, null);
		JPanelCourseArea.setLayout(null);
		
		JTextArea textArea_SeperatorLineCourse = new JTextArea();
		textArea_SeperatorLineCourse.setForeground(SystemColor.inactiveCaptionText);
		textArea_SeperatorLineCourse.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		textArea_SeperatorLineCourse.setBackground(SystemColor.window);
		textArea_SeperatorLineCourse.setText("___________________________________________________________________");
		textArea_SeperatorLineCourse.setBounds(28, 233, 385, 16);
		JPanelCourseArea.add(textArea_SeperatorLineCourse);
		
		//Skriva in text för kursnamn
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lblCourseName.setBounds(53, 100, 101, 16);
		JPanelCourseArea.add(lblCourseName);
		
		textField_CourseName = new JTextField();
		textField_CourseName.setBounds(166, 95, 130, 26);
		JPanelCourseArea.add(textField_CourseName);
		textField_CourseName.setColumns(10);
		
		//Skriva in text för kurskod
		JLabel lblCourseCode = new JLabel("Course Code");
		lblCourseCode.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lblCourseCode.setBounds(53, 275, 90, 16);
		JPanelCourseArea.add(lblCourseCode);
		
		textField_CourseCode = new JTextField();
		textField_CourseCode.setBounds(166, 270, 130, 26);
		JPanelCourseArea.add(textField_CourseCode);
		textField_CourseCode.setColumns(10);
		
		//Skriva in poäng för kursen 
		JLabel lblCredit = new JLabel("Credit points");
		lblCredit.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lblCredit.setBounds(53, 135, 90, 16);
		JPanelCourseArea.add(lblCredit);
		
		textField_Credit = new JTextField();
		textField_Credit.setBounds(221, 130, 74, 26);
		JPanelCourseArea.add(textField_Credit);
		textField_Credit.setColumns(10);
		
		//Svarsruta kurs
		JTextPane textPane_AnswerCourse = new JTextPane();
		textPane_AnswerCourse.setEditable(false);
		textPane_AnswerCourse.setBackground(SystemColor.window);
		textPane_AnswerCourse.setBounds(53, 187, 320, 34);
		JPanelCourseArea.add(textPane_AnswerCourse);
		
		JTextPane textPane_FoundCourse = new JTextPane();
		textPane_FoundCourse.setEditable(false);
		textPane_FoundCourse.setBackground(SystemColor.window);
		textPane_FoundCourse.setBounds(53, 303, 329, 48);
		JPanelCourseArea.add(textPane_FoundCourse);
		
		/// Knappar för kursfliken 
		JButton btnAddCourse = new JButton("Add Course");
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
				
				textPane_AnswerCourse.setText("Added course: " + name + " with course code: " + courseCode + " and credits: " + credits);
				
				}
				catch (java.lang.NumberFormatException exception) {
					textPane_AnswerCourse.setText("Only numbers are allowed in the credits field");
				}
				}
			}
		});
		btnAddCourse.setBounds(296, 95, 117, 29);
		JPanelCourseArea.add(btnAddCourse);
		
		JButton btnFindCourse = new JButton("Find Course");
		btnFindCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String courseCode = textField_CourseCode.getText();
				String courseName = controller.findCourse(courseCode);
				double credits = controller.getCourseCredit(courseCode);
				
				if (textField_CourseCode.getText().equals("")) {
					textPane_FoundCourse.setText("Please enter a coursecode");
				}
				
				else if (courseName!=null) {
					textPane_FoundCourse.setText("Found course: " + courseName + " and has " + credits + " credits" );
				
                } else {
                	textPane_FoundCourse.setText("Course can not be found");

                }
			}});
		btnFindCourse.setBounds(42, 352, 106, 29);
		JPanelCourseArea.add(btnFindCourse);
		
		JButton btnRemoveCourse = new JButton("Remove Course");
		btnRemoveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String courseName = controller.findCourse(textField_CourseCode.getText());
				
				if (textField_CourseCode.getText().equals("") || textPane_FoundCourse.getText().equals("")) {
					textPane_FoundCourse.setText("Please enter a coursecode");
				}
				else {
					String courseCode = textField_CourseCode.getText();
				if (controller.findCourse(courseCode) == null) {
					textPane_FoundCourse.setText("No course found");
				}
				else {
					
					double credits = controller.getCourseCredit(courseCode); 
				
					controller.removeCourse(courseCode);
					textPane_FoundCourse.setText("The course " + courseName + " with coursecode " + courseCode + " and credits: " + credits + " has been removed");
				
					}
				}	
				
			}
		});
		btnRemoveCourse.setBounds(154, 352, 130, 29);
		JPanelCourseArea.add(btnRemoveCourse);
		
		JButton btnUpdateCourse = new JButton("Update Course");
		btnUpdateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					String courseCode = textField_CourseCode.getText();
					try {
					if (courseCode.equals(""))  {
						textPane_FoundCourse.setText("Please enter a coursecode");
					}
					else if (textField_CourseName.getText().equals("")) {
						textPane_AnswerCourse.setText("No edits were made");			//Checks if the fields are valid
					}
					else if (textField_Credit.getText().equals("")) {
						textPane_AnswerCourse.setText("Please enter credits");
					}
					else if (controller.findCourse(courseCode) == null) {
						textPane_FoundCourse.setText("No course found");
					}
				
					else {
						String courseName = textField_CourseName.getText();
						double credit = Double.parseDouble(textField_Credit.getText());
						controller.updateCourseName(courseCode, courseName);
						controller.updateCourseCredit(courseCode, credit);
						textPane_AnswerCourse.setText("Updated course: " + courseName + " (" + courseCode + ") with credits: " + credit);			//Updates a students name
						//textField_CourseCode.setText("");
						textField_CourseName.setText("");
						textField_Credit.setText("");
					}
					}
					catch (java.lang.NumberFormatException exception) {
						textPane_AnswerCourse.setText("Only numbers are allowed in the credits field");
					}
			}
				
			
		});
		btnUpdateCourse.setBounds(285, 352, 117, 29);
		JPanelCourseArea.add(btnUpdateCourse);
		
		//Infotext
		JLabel lblRegisterCourseWith = new JLabel("Register course with name and credit points here:");
		lblRegisterCourseWith.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lblRegisterCourseWith.setBounds(53, 18, 320, 26);
		JPanelCourseArea.add(lblRegisterCourseWith);
		
		JLabel labelCourseInfo = new JLabel("The course will automatically get a student ID when registered");
		labelCourseInfo.setFont(new Font("Khmer Sangam MN", Font.ITALIC, 11));
		labelCourseInfo.setBounds(52, 67, 361, 16);
		JPanelCourseArea.add(labelCourseInfo);
		
		//* Markerinngar att fält är obligatoriska
		JLabel lbl_Star2Course = new JLabel("*");
		lbl_Star2Course.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbl_Star2Course.setForeground(SystemColor.activeCaptionText);
		lbl_Star2Course.setBounds(140, 133, 19, 16);
		JPanelCourseArea.add(lbl_Star2Course);
		
		JLabel lbl_Star1Course = new JLabel("*");
		lbl_Star1Course.setForeground(Color.BLACK);
		lbl_Star1Course.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbl_Star1Course.setBounds(140, 100, 19, 16);
		JPanelCourseArea.add(lbl_Star1Course);
		
		JLabel lbl_MandatoryFieldsCourse = new JLabel("Fields marked with * are mandatory to fill in.");
		lbl_MandatoryFieldsCourse.setFont(new Font("PT Sans Caption", Font.PLAIN, 12));
		lbl_MandatoryFieldsCourse.setBounds(53, 39, 320, 26);
		JPanelCourseArea.add(lbl_MandatoryFieldsCourse);
		
		JLabel lbl_Star3Course = new JLabel("*");
		lbl_Star3Course.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbl_Star3Course.setBounds(135, 275, 19, 16);
		JPanelCourseArea.add(lbl_Star3Course);
		
	
		///////////////////////
		///Written exam flik///
		///////////////////////
		
		//Bakgrund för fliken written exam 
		JPanel JPanelWrittenExamArea = new JPanel();
		applicationArea.addTab("Written Exam", null, JPanelWrittenExamArea, null);
		JPanelWrittenExamArea.setLayout(null);
		
		//Beskrivning av sidan 
		JLabel lblRegisterResultFor = new JLabel("Register result for student:");
		lblRegisterResultFor.setFont(new Font("PT Sans Caption", Font.PLAIN, 12));
		lblRegisterResultFor.setBounds(236, 50, 172, 16);
		JPanelWrittenExamArea.add(lblRegisterResultFor);
		
		JLabel lblAddremoveExamFor = new JLabel("Add/remove exam for course:");
		lblAddremoveExamFor.setFont(new Font("PT Sans Caption", Font.PLAIN, 12));
		lblAddremoveExamFor.setBounds(19, 50, 195, 16);
		JPanelWrittenExamArea.add(lblAddremoveExamFor);
		
		//Skriva in kurs på WE
		textField_WEcourseID = new JTextField();
		textField_WEcourseID.setBounds(102, 80, 112, 26);
		JPanelWrittenExamArea.add(textField_WEcourseID);
		textField_WEcourseID.setColumns(10);
		
		JLabel lblCourse_WEcourse = new JLabel("Course ID ");
		lblCourse_WEcourse.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lblCourse_WEcourse.setBounds(19, 85, 74, 16);
		JPanelWrittenExamArea.add(lblCourse_WEcourse);
		
		//Skriva in datum på WE
		JLabel lbl_WEdate = new JLabel("Date");
		lbl_WEdate.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lbl_WEdate.setBounds(19, 118, 35, 16);
		JPanelWrittenExamArea.add(lbl_WEdate);
		
		textField_WEdate = new JTextField();
		textField_WEdate.setBounds(102, 113, 112, 26);
		JPanelWrittenExamArea.add(textField_WEdate);
		textField_WEdate.setColumns(10);
		
		//Välja time på WE
		JLabel lbl_WEtime = new JLabel("Time");
		lbl_WEtime.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lbl_WEtime.setBounds(19, 243, 35, 16);
		JPanelWrittenExamArea.add(lbl_WEtime);
		
		textField_WEtime = new JTextField();
		textField_WEtime.setBounds(97, 236, 130, 26);
		JPanelWrittenExamArea.add(textField_WEtime);
		textField_WEtime.setColumns(10);
		
		//Skriva in Student ID
		lbl_WEstudentID = new JLabel("Student ID");
		lbl_WEstudentID.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lbl_WEstudentID.setBounds(236, 85, 74, 16);
		JPanelWrittenExamArea.add(lbl_WEstudentID);
		
		JLabel lbl_WEexamID = new JLabel("Exam ID");
		lbl_WEexamID.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lbl_WEexamID.setBounds(236, 122, 61, 16);
		JPanelWrittenExamArea.add(lbl_WEexamID);
		
		//Skriva in points
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lblPoints.setBounds(236, 156, 44, 16);
		JPanelWrittenExamArea.add(lblPoints);
		
		textField_WEpoints = new JTextField();
		textField_WEpoints.setBounds(353, 151, 55, 26);
		JPanelWrittenExamArea.add(textField_WEpoints);
		textField_WEpoints.setColumns(10);
		
		//Välja location etikett på WE
		JLabel lbl_WElocation = new JLabel("Location");
		lbl_WElocation.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lbl_WElocation.setBounds(19, 150, 61, 16);
		JPanelWrittenExamArea.add(lbl_WElocation);
				
		//Radiobutton för att välja plats
		JRadioButton rdbtnA123 = new JRadioButton("Room A123");
		rdbtnA123.setFont(new Font("Monaco", Font.PLAIN, 13));
		buttonGroup.add(rdbtnA123);
		rdbtnA123.setBounds(102, 146, 141, 23);
		JPanelWrittenExamArea.add(rdbtnA123);
		
		JRadioButton rdbtnB198 = new JRadioButton("Room B198");
		rdbtnB198.setFont(new Font("Monaco", Font.PLAIN, 13));
		buttonGroup.add(rdbtnB198);
		rdbtnB198.setBounds(102, 184, 141, 23);
		JPanelWrittenExamArea.add(rdbtnB198);
		
		JRadioButton rdbtnB067 = new JRadioButton("Room B067");
		rdbtnB067.setFont(new Font("Monaco", Font.PLAIN, 13));
		buttonGroup.add(rdbtnB067);
		rdbtnB067.setBounds(102, 203, 141, 23);
		JPanelWrittenExamArea.add(rdbtnB067);
		
		JRadioButton rdbtnA167 = new JRadioButton("Room A167");
		rdbtnA167.setFont(new Font("Monaco", Font.PLAIN, 13));
		buttonGroup.add(rdbtnA167);
		rdbtnA167.setBounds(102, 165, 141, 23);
		JPanelWrittenExamArea.add(rdbtnA167);
		
		//Svar på WE
		JTextArea textArea_AnswerWrittenExam = new JTextArea();
		textArea_AnswerWrittenExam.setEditable(false);
		textArea_AnswerWrittenExam.setBackground(SystemColor.window);
		textArea_AnswerWrittenExam.setBounds(29, 301, 379, 87);
		JPanelWrittenExamArea.add(textArea_AnswerWrittenExam);
		
		//Knappar på WE
		JButton btnAddExam = new JButton("Add Exam");
		btnAddExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String courseCode = textField_WEcourseID.getText();
				String location = "";
				String time;
				String date;
				
				try {
					if (controller.findCourse(courseCode) == null) { 
						textArea_AnswerWrittenExam.setText("Invalid course code"); //Om kursen inte finns returneras "Invalid course code"
					}
					
					else {
						if (textField_WEdate.getText().equals("") || textField_WEtime.getText().equals("")) { 
							textArea_AnswerWrittenExam.setText("Please enter time and a date for the exam");
						}
						else if (rdbtnA123.isSelected() == false && rdbtnA167.isSelected() == false && rdbtnB198.isSelected() == false && rdbtnB067.isSelected() == false) {
							textArea_AnswerWrittenExam.setText("Please enter location");
							}
				
						else {
							String examID = controller.generateExamID();
							time = textField_WEtime.getText();
							date = textField_WEdate.getText();
							if (rdbtnA123.isSelected() == true) {
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
							controller.addWrittenExam(courseCode, examID,  time, location, date);				//Skapar ett nytt exam
							int maxPoints = controller.getExamMaxPoints(examID);
							textArea_AnswerWrittenExam.setText("Exam for course " + controller.findCourse(courseCode) + " has been created" +"\n");
							textArea_AnswerWrittenExam.append("ExamID: " + examID + " Time: " + time +"\n" + "Location: " + location + " Date: " + date + "\n" + "Max points: " + maxPoints);
							//Sätter text och radiobuttons till startläge
							textField_WEcourseID.setText("");
							textField_WEtime.setText("");
							textField_WEdate.setText("");
							rdbtnA123.setSelected(false);
							rdbtnA167.setSelected(false);
							rdbtnB198.setSelected(false);
							rdbtnB067.setSelected(false);
						}
					}
				}
				catch (java.lang.NumberFormatException exception) {
					textArea_AnswerWrittenExam.setText("Only numbers are allowed in the max points field");
				}
			}
					
		});
		btnAddExam.setBounds(127, 271, 101, 29);
		JPanelWrittenExamArea.add(btnAddExam);
		
		//Skriva in för att remove exam
		textField_WEsearchForExamID = new JTextField();
		textField_WEsearchForExamID.setBounds(140, 411, 87, 26);
		JPanelWrittenExamArea.add(textField_WEsearchForExamID);
		textField_WEsearchForExamID.setColumns(10);
		
		textField_WEstudentID = new JTextField();
		textField_WEstudentID.setBounds(316, 78, 92, 26);
		JPanelWrittenExamArea.add(textField_WEstudentID);
		textField_WEstudentID.setColumns(10);
		
		textField_WEexamID = new JTextField();
		textField_WEexamID.setBounds(316, 115, 92, 26);
		JPanelWrittenExamArea.add(textField_WEexamID);
		textField_WEexamID.setColumns(10);
		
		JButton btnRemoveExam = new JButton("Remove Exam");
		btnRemoveExam.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		btnRemoveExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String examID = textField_WEsearchForExamID.getText();
				if (examID.equals("")) {
					textArea_AnswerWrittenExam.setText("Invalid exam-ID");
				}
				else if (controller.findExam(examID) == null) {
					textArea_AnswerWrittenExam.setText("No exam found");
				}
				else {
					controller.removeWrittenExam(examID);
					textArea_AnswerWrittenExam.setText("Exam with exam-ID " + examID + " has been removed");
					//Sätter text till startläge
					textField_WEsearchForExamID.setText("");
				
			}
			
			}
			
		});
		btnRemoveExam.setBounds(227, 411, 112, 29);
		JPanelWrittenExamArea.add(btnRemoveExam);
		
		JButton btnFindExam = new JButton("Find Exam");
		btnFindExam.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		btnFindExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String examID = textField_WEsearchForExamID.getText();
				String exam = controller.findExam(examID);
				
				if (examID.equals("")) {
					textArea_AnswerWrittenExam.setText("Please enter a examID");
				}
				
				else if (exam!=null) {
					textArea_AnswerWrittenExam.setText("Found exam: " + exam);
				
                } else {
                	textArea_AnswerWrittenExam.setText("Exam can not be found");

                }
				
			}
		});
		btnFindExam.setBounds(330, 411, 87, 29);
		JPanelWrittenExamArea.add(btnFindExam);
		
		JButton btnAddResult = new JButton("Register Result");
		btnAddResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					if (textField_WEexamID.getText().equals("") || textField_WEstudentID.getText().equals("") || textField_WEpoints.getText().equals("")) {
						textArea_AnswerWrittenExam.setText("Please enter Exam-ID, Student-ID and points");
					}
					else if (controller.findExam(textField_WEexamID.getText()) == null) {
						textArea_AnswerWrittenExam.setText("Invalid values");
					}
					else if (controller.findStudent(textField_WEstudentID.getText()) == null) {
						textArea_AnswerWrittenExam.setText("Invalid Student -ID");
					}
					else if (Integer.parseInt(textField_WEpoints.getText()) > controller.getExamMaxPoints(textField_WEexamID.getText()) || Integer.parseInt(textField_WEpoints.getText()) < 0) {
						textArea_AnswerWrittenExam.setText("Invalid amount of points");						
					}
					else {
						String examID = textField_WEexamID.getText();
						String studentID = textField_WEstudentID.getText();
						int result = Integer.parseInt(textField_WEpoints.getText());
						String letterGrade = controller.addResult(studentID, examID, result);
						textArea_AnswerWrittenExam.setText("Added result for student: " + controller.findStudent(studentID) + "\n" + "on exam " + examID + "\n" + "with grade: " + letterGrade);
						//Sätter text till startläge
						textField_WEexamID.setText("");
						textField_WEstudentID.setText("");	
						textField_WEpoints.setText("");
					
					}
				}
				catch (java.lang.NumberFormatException exception) {
					textArea_AnswerWrittenExam.setText("Please put in all values correctly");
				}
			}

		});
		btnAddResult.setBounds(272, 201, 136, 29);
		JPanelWrittenExamArea.add(btnAddResult);
		
		//Design, lägger till stjärnor efter text-etiketterna 
		JLabel lbl_Star1Exam = new JLabel("*");
		lbl_Star1Exam.setForeground(Color.BLACK);
		lbl_Star1Exam.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbl_Star1Exam.setBounds(84, 85, 19, 16);
		JPanelWrittenExamArea.add(lbl_Star1Exam);
		
		JLabel lbl_Star3Exam = new JLabel("*");
		lbl_Star3Exam.setForeground(Color.BLACK);
		lbl_Star3Exam.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbl_Star3Exam.setBounds(80, 151, 19, 16);
		JPanelWrittenExamArea.add(lbl_Star3Exam);
		
		JLabel lbl_Star2Exam = new JLabel("*");
		lbl_Star2Exam.setForeground(Color.BLACK);
		lbl_Star2Exam.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbl_Star2Exam.setBounds(52, 118, 19, 16);
		JPanelWrittenExamArea.add(lbl_Star2Exam);
		
		JLabel lbl_Star4Exam = new JLabel("*");
		lbl_Star4Exam.setForeground(Color.BLACK);
		lbl_Star4Exam.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbl_Star4Exam.setBounds(59, 240, 12, 16);
		JPanelWrittenExamArea.add(lbl_Star4Exam);
		
		JLabel lbl_Star1Result = new JLabel("*");
		lbl_Star1Result.setForeground(Color.BLACK);
		lbl_Star1Result.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbl_Star1Result.setBounds(306, 85, 19, 16);
		JPanelWrittenExamArea.add(lbl_Star1Result);
		
		JLabel lbl_Star2Result = new JLabel("*");
		lbl_Star2Result.setForeground(Color.BLACK);
		lbl_Star2Result.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbl_Star2Result.setBounds(291, 122, 19, 16);
		JPanelWrittenExamArea.add(lbl_Star2Result);
		
		JLabel lbl_Star3Result = new JLabel("*");
		lbl_Star3Result.setForeground(Color.BLACK);
		lbl_Star3Result.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbl_Star3Result.setBounds(278, 155, 19, 16);
		JPanelWrittenExamArea.add(lbl_Star3Result);
		

		JLabel lbl_Star1FindExamID = new JLabel("*");
		lbl_Star1FindExamID.setForeground(Color.BLACK);
		lbl_Star1FindExamID.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbl_Star1FindExamID.setBounds(133, 415, 19, 16);
		JPanelWrittenExamArea.add(lbl_Star1FindExamID);
		
		//Övrig infotext
		JLabel lbl_MandatoryFieldsWrittenExam = new JLabel("Fields marked with * are mandatory to fill in.");
		lbl_MandatoryFieldsWrittenExam.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lbl_MandatoryFieldsWrittenExam.setBounds(19, 12, 320, 26);
		JPanelWrittenExamArea.add(lbl_MandatoryFieldsWrittenExam);
		
		JLabel lbl_WEsearchForExamID = new JLabel("Search for Exam ID");
		lbl_WEsearchForExamID.setFont(new Font("PT Sans Caption", Font.PLAIN, 12));
		lbl_WEsearchForExamID.setBounds(19, 416, 119, 16);
		JPanelWrittenExamArea.add(lbl_WEsearchForExamID);
		
		JLabel label_SeperatorLineWrittenExam = new JLabel("______________________________________________________");
		label_SeperatorLineWrittenExam.setForeground(SystemColor.inactiveCaptionText);
		label_SeperatorLineWrittenExam.setBounds(19, 388, 389, 16);
		JPanelWrittenExamArea.add(label_SeperatorLineWrittenExam);
		
		JLabel lbl_WrittenExamMaxPoints = new JLabel("Max points is 100p");
		lbl_WrittenExamMaxPoints.setFont(new Font("Lao Sangam MN", Font.PLAIN, 11));
		lbl_WrittenExamMaxPoints.setBounds(236, 169, 105, 16);
		JPanelWrittenExamArea.add(lbl_WrittenExamMaxPoints);
		
		
		
	
	}
}
		
		
	
