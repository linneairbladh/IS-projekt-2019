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

public class Application {

	private JFrame frame;
	private JTextField textField_StudentName;
	private JTextField textField_StudentID;
	private JTextField textField_CourseName;
	private JTextField textField_CourseCode;
	private JTextField textField_Credit;
	private JTextField textField_5;
	private JTextField textField_6;

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
	 */
	public Application() {
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
		
		// Knappar för på studentfliken
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddStudent.setBounds(39, 172, 117, 29);
		Student.add(btnAddStudent);
		
		
		JButton btnRemoveStudent = new JButton("Remove Student");
		btnRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveStudent.setBounds(39, 205, 145, 29);
		Student.add(btnRemoveStudent);
			
		
		JButton btnFindStudent = new JButton("Find Student");
		btnFindStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFindStudent.setBounds(39, 238, 117, 29);
		Student.add(btnFindStudent);
		
		
		JButton btnUpdateStudent = new JButton("Update Student");
		btnUpdateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdateStudent.setBounds(39, 271, 130, 29);
		Student.add(btnUpdateStudent);
		
		//Svar för om studenten blir registrerad 
		JTextPane textPane_StudentAnswer = new JTextPane();
		textPane_StudentAnswer.setBounds(48, 100, 229, 60);
		Student.add(textPane_StudentAnswer);
		
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
		btnAddCourse.setBounds(42, 226, 117, 29);
		Course.add(btnAddCourse);
		
		JButton btnRemoveCourse = new JButton("Remove Course");
		btnRemoveCourse.setBounds(42, 255, 130, 29);
		Course.add(btnRemoveCourse);
		
		JButton btnFindCourse = new JButton("Find Course");
		btnFindCourse.setBounds(42, 284, 106, 29);
		Course.add(btnFindCourse);
		
		JButton btnUpdateCourse = new JButton("Update Course");
		btnUpdateCourse.setBounds(42, 313, 117, 29);
		Course.add(btnUpdateCourse);
		
		//Svarsruta för uppdatera kurs
		JTextPane textPane_AnswerCourse = new JTextPane();
		textPane_AnswerCourse.setBounds(52, 152, 232, 53);
		Course.add(textPane_AnswerCourse);
		
		//Bakgrund för fliken written exam 
		JPanel WrittenExam = new JPanel();
		tabbedPane.addTab("Written Exam", null, WrittenExam, null);
		WrittenExam.setLayout(null);
		
		
		JLabel lblExamId = new JLabel("Exam ID");
		lblExamId.setBounds(20, 83, 61, 16);
		WrittenExam.add(lblExamId);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(20, 111, 61, 16);
		WrittenExam.add(lblDate);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(20, 143, 61, 16);
		WrittenExam.add(lblLocation);
		
		JComboBox comboBox_Location = new JComboBox();
		comboBox_Location.setBounds(102, 139, 113, 27);
		WrittenExam.add(comboBox_Location);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(20, 171, 61, 16);
		WrittenExam.add(lblTime);
		
		JComboBox comboBox_Time = new JComboBox();
		comboBox_Time.setBounds(102, 167, 113, 27);
		WrittenExam.add(comboBox_Time);
		
		textField_5 = new JTextField();
		textField_5.setBounds(107, 78, 107, 26);
		WrittenExam.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(107, 106, 107, 26);
		WrittenExam.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnAddExam = new JButton("Add Exam");
		btnAddExam.setBounds(20, 263, 101, 29);
		WrittenExam.add(btnAddExam);
		
		JButton btnRemoveExam = new JButton("Remove Exam");
		btnRemoveExam.setBounds(20, 291, 117, 29);
		WrittenExam.add(btnRemoveExam);
		
		JLabel lblCourse_1 = new JLabel("Course");
		lblCourse_1.setBounds(20, 51, 61, 16);
		WrittenExam.add(lblCourse_1);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(104, 47, 101, 27);
		WrittenExam.add(comboBox_4);
		
		JLabel lblRegisterResultFor = new JLabel("Register result for student:");
		lblRegisterResultFor.setBounds(237, 16, 172, 16);
		WrittenExam.add(lblRegisterResultFor);
		
		JLabel lblAddremoveExamFor = new JLabel("Add/remove exam for course:");
		lblAddremoveExamFor.setBounds(20, 16, 195, 16);
		WrittenExam.add(lblAddremoveExamFor);
		
		JComboBox comboBox_StudentiD = new JComboBox();
		comboBox_StudentiD.setBounds(315, 47, 94, 27);
		WrittenExam.add(comboBox_StudentiD);
		
		JLabel lblStudentId_1 = new JLabel("Student ID");
		lblStudentId_1.setBounds(237, 51, 66, 16);
		WrittenExam.add(lblStudentId_1);
		
		JLabel lblResult = new JLabel("Points");
		lblResult.setBounds(237, 83, 61, 16);
		WrittenExam.add(lblResult);
		
		JButton btnAddResult = new JButton("Register Result ");
		btnAddResult.setBounds(237, 263, 136, 29);
		WrittenExam.add(btnAddResult);
		
		JSpinner spinner_Points = new JSpinner();
		spinner_Points.setBounds(325, 78, 61, 27);
		WrittenExam.add(spinner_Points);
		
		JTextPane textPane_AnswerResult = new JTextPane();
		textPane_AnswerResult.setBounds(237, 217, 160, 34);
		WrittenExam.add(textPane_AnswerResult);
		
		JTextPane textPane_AnswerExam = new JTextPane();
		textPane_AnswerExam.setBounds(24, 217, 181, 34);
		WrittenExam.add(textPane_AnswerExam);
	}
}