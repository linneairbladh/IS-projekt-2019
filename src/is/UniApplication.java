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

public class UniApplication {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UniApplication window = new UniApplication();
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
	public UniApplication() {
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
		
		JPanel Student = new JPanel();
		tabbedPane.addTab("Student", null, Student, null);
		Student.setLayout(null);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(39, 33, 96, 16);
		Student.add(lblStudentName);
		
		textField = new JTextField();
		textField.setBounds(147, 28, 130, 26);
		Student.add(textField);
		textField.setColumns(10);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(39, 66, 82, 16);
		Student.add(lblStudentId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 61, 130, 26);
		Student.add(textField_1);
		textField_1.setColumns(10);
		
		// Knappar för lägg till, ta bort ändra och uppdatera student på studentfliken
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddStudent.setBounds(39, 111, 117, 29);
		Student.add(btnAddStudent);
		
		
		JButton btnRemoveStudent = new JButton("Remove Student");
		btnRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveStudent.setBounds(39, 144, 145, 29);
		Student.add(btnRemoveStudent);
		
		
		
		JButton btnFindStudent = new JButton("Find Student");
		btnFindStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFindStudent.setBounds(39, 177, 117, 29);
		Student.add(btnFindStudent);
		
		
		
		JButton btnUpdateStudent = new JButton("Update Student");
		btnUpdateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdateStudent.setBounds(39, 210, 130, 29);
		Student.add(btnUpdateStudent);
		
		
		
		//
		
		JPanel Course = new JPanel();
		tabbedPane.addTab("Course", null, Course, null);
		Course.setLayout(null);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(42, 39, 101, 16);
		Course.add(lblCourseName);
		
		JLabel lblCourseCode = new JLabel("Course Code");
		lblCourseCode.setBounds(42, 67, 90, 16);
		Course.add(lblCourseCode);
		
		JLabel lblCredit = new JLabel("Credit");
		lblCredit.setBounds(42, 95, 61, 16);
		Course.add(lblCredit);
		
		textField_2 = new JTextField();
		textField_2.setBounds(155, 34, 130, 26);
		Course.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(155, 62, 130, 26);
		Course.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(155, 90, 130, 26);
		Course.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnAddCourse = new JButton("Add Course ");
		btnAddCourse.setBounds(29, 131, 117, 29);
		Course.add(btnAddCourse);
		
		JButton btnRemoveCourse = new JButton("Remove Course");
		btnRemoveCourse.setBounds(29, 160, 130, 29);
		Course.add(btnRemoveCourse);
		
		JButton btnFindCourse = new JButton("Find Course");
		btnFindCourse.setBounds(29, 189, 106, 29);
		Course.add(btnFindCourse);
		
		JButton btnUpdateCourse = new JButton("Update Course");
		btnUpdateCourse.setBounds(29, 218, 117, 29);
		Course.add(btnUpdateCourse);
		
		JPanel WrittenExam = new JPanel();
		tabbedPane.addTab("Written Exam", null, WrittenExam, null);
		WrittenExam.setLayout(null);
		
		JLabel lblExamId = new JLabel("Exam ID");
		lblExamId.setBounds(42, 83, 61, 16);
		WrittenExam.add(lblExamId);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(42, 111, 61, 16);
		WrittenExam.add(lblDate);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(42, 150, 61, 16);
		WrittenExam.add(lblLocation);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(124, 146, 113, 27);
		WrittenExam.add(comboBox_2);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(42, 178, 61, 16);
		WrittenExam.add(lblTime);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(124, 174, 113, 27);
		WrittenExam.add(comboBox_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(124, 78, 130, 26);
		WrittenExam.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(124, 106, 130, 26);
		WrittenExam.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnAddExam = new JButton("Add Exam");
		btnAddExam.setBounds(42, 230, 117, 29);
		WrittenExam.add(btnAddExam);
		
		JButton btnRemoveExam = new JButton("Remove Exam");
		btnRemoveExam.setBounds(42, 258, 117, 29);
		WrittenExam.add(btnRemoveExam);
		
		JLabel lblCourse_1 = new JLabel("Course");
		lblCourse_1.setBounds(42, 39, 61, 16);
		WrittenExam.add(lblCourse_1);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(124, 35, 101, 27);
		WrittenExam.add(comboBox_4);
		
		JPanel Result = new JPanel();
		tabbedPane.addTab("Result", null, Result, null);
		Result.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(130, 30, 130, 41);
		Result.add(comboBox);
		
		JLabel lblStudent = new JLabel("Student");
		lblStudent.setBounds(57, 41, 61, 16);
		Result.add(lblStudent);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(57, 85, 61, 16);
		Result.add(lblCourse);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(130, 81, 130, 27);
		Result.add(comboBox_1);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setBounds(57, 139, 61, 16);
		Result.add(lblGrade);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(130, 135, 110, 27);
		Result.add(comboBox_5);
	}
}
