package is;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class A {

	private JFrame frame;
	private JTextField textField_StudentName;
	private JTextField textField_StudentID;
	private JTextField textField_CourseName;
	private JTextField textField_CourseCode;
	private JTextField textField_Credit;
	private JTextField textField_ExamID;
	private JTextField textField_Date;
	private Controller controller = new Controller(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A window = new A();
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
	public A() {
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
		lblStudentName.setFont(new Font("Lao MN", Font.PLAIN, 13));
		lblStudentName.setBounds(39, 33, 96, 16);
		Student.add(lblStudentName);
		
		textField_StudentName = new JTextField();
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
		textArea_StudentAnswer.setBounds(39, 125, 266, 35);
		Student.add(textArea_StudentAnswer);
		
		
		// Knappar på studentfliken
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student s = new Student();
				String studentID = textField_StudentID.getText();
				String sName = textField_StudentName.getText();
				s.setStudentID(studentID);
				s.setName(sName);
				 
				controller.addStudent(s);
				
				textArea_StudentAnswer.setText("Student has been added.");
	
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
				
				/*String examID = textField_StudentID.getText();
				Student s = controller.findStudent(studentID); //varför fel?
				
				if (s!=null) {
					textArea_StudentAnswer.setText(s.getName());
				
                } else {
                    textArea_StudentAnswer.setText("Personen kan inte hittas.");

                }   
                }
                */
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
		textField_CourseCode.setBounds(155, 62, 130, 26);
		Course.add(textField_CourseCode);
		textField_CourseCode.setColumns(10);
		//
		
		//Skriva in poäng för kursen 
		JLabel lblCredit = new JLabel("Credit");
		lblCredit.setBounds(42, 95, 61, 16);
		Course.add(lblCredit);
		
		textField_Credit = new JTextField();
		textField_Credit.setBounds(155, 90, 130, 26);
		Course.add(textField_Credit);
		textField_Credit.setColumns(10);
		//
		
		/// Knappar för kursfliken 
		
		JButton btnAddCourse = new JButton("Add Course ");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddCourse.setBounds(42, 226, 117, 29);
		Course.add(btnAddCourse);
		
		JButton btnRemoveCourse = new JButton("Remove Course");
		btnRemoveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveCourse.setBounds(42, 255, 130, 29);
		Course.add(btnRemoveCourse);
		
		JButton btnFindCourse = new JButton("Find Course");
		btnFindCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFindCourse.setBounds(42, 284, 106, 29);
		Course.add(btnFindCourse);
		
		JButton btnUpdateCourse = new JButton("Update Course");
		btnUpdateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdateCourse.setBounds(42, 313, 117, 29);
		Course.add(btnUpdateCourse);
		
		//Svarsruta för uppdatera kurs
		JTextPane textPane_AnswerCourse = new JTextPane();
		textPane_AnswerCourse.setBounds(52, 152, 232, 53);
		Course.add(textPane_AnswerCourse);
		
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
		comboBox_Course.setBounds(104, 47, 101, 27);
		WrittenExam.add(comboBox_Course);

		//Skriva in Exam ID på WE
		JLabel lblExamId = new JLabel("Exam ID");
		lblExamId.setBounds(20, 83, 61, 16);
		WrittenExam.add(lblExamId);
		
		textField_ExamID = new JTextField();
		textField_ExamID.setBounds(107, 78, 107, 26);
		WrittenExam.add(textField_ExamID);
		textField_ExamID.setColumns(10);
		
		//Skriva in datum på WE
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(20, 111, 61, 16);
		WrittenExam.add(lblDate);
		
		textField_Date = new JTextField();
		textField_Date.setBounds(107, 106, 107, 26);
		WrittenExam.add(textField_Date);
		textField_Date.setColumns(10);
		
		//Skriva in location på WE
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(20, 143, 61, 16);
		WrittenExam.add(lblLocation);
		
		JComboBox comboBox_Location = new JComboBox();
		comboBox_Location.setBounds(102, 139, 113, 27);
		WrittenExam.add(comboBox_Location);
		
		//Skriva in time på WE
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(20, 171, 61, 16);
		WrittenExam.add(lblTime);
		
		JComboBox comboBox_Time = new JComboBox();
		comboBox_Time.setBounds(102, 167, 113, 27);
		WrittenExam.add(comboBox_Time);
		
		//Skriva in Student ID
		JLabel lblStudentId_WEStudentID = new JLabel("Student ID");
		lblStudentId_WEStudentID.setBounds(237, 51, 66, 16);
		WrittenExam.add(lblStudentId_WEStudentID);
		
		JComboBox comboBox_StudentiD = new JComboBox();
		comboBox_StudentiD.setBounds(315, 47, 94, 27);
		WrittenExam.add(comboBox_StudentiD);
		
		//Skriva in points
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setBounds(237, 83, 61, 16);
		WrittenExam.add(lblPoints);
		
		JSpinner spinner_Points = new JSpinner();
		spinner_Points.setBounds(325, 78, 61, 27);
		WrittenExam.add(spinner_Points);
		
		
		//Knappar på WE
		JButton btnAddExam = new JButton("Add Exam");
		btnAddExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			}
		});
		btnAddResult.setBounds(237, 263, 136, 29);
		WrittenExam.add(btnAddResult);
		
		
		//Svarsrutor för WE
		JTextPane textPane_AnswerResult = new JTextPane();
		textPane_AnswerResult.setBounds(237, 217, 160, 34);
		WrittenExam.add(textPane_AnswerResult);
		
		JTextPane textPane_AnswerExam = new JTextPane();
		textPane_AnswerExam.setBounds(24, 217, 181, 34);
		WrittenExam.add(textPane_AnswerExam);
	}
}