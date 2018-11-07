package at.uastw.swt;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import java.awt.BorderLayout;
import javax.swing.JSpinner;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Label;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Customer_widow {

	private JFrame frame;
	private JTextField firstName;
	private JTextField lastName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_widow window = new Customer_widow();
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
	public Customer_widow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 624, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		firstName = new JTextField();
		firstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if (Character.isLowerCase(keyChar)) {
					e.setKeyChar(Character.toUpperCase(keyChar));
				}
				//checking for aphabetical letters--alerts but the number stays
				if (!(Character.isAlphabetic(keyChar))) {
					JOptionPane.showMessageDialog(null, "Please only enter letters A-Z", "ALERT MESSAGE",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		});
		firstName.setBounds(117, 110, 130, 26);
		firstName.addMouseListener(new MouseAdapter() {
		});
		firstName.setColumns(10);

		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setBounds(34, 115, 76, 16);

		lastName = new JTextField();
		lastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if (Character.isLowerCase(keyChar)) {
					e.setKeyChar(Character.toUpperCase(keyChar));
				}
				
				//checking for aphabetical letters-- alerst but numbers stays
				if (Character.isDigit(keyChar)) {
					JOptionPane.showMessageDialog(null, "WRONG!");
					lastName.setText("");
				}
			}
		});
		lastName.setBounds(117, 143, 130, 26);
		lastName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(34, 143, 71, 16);

		final JSpinField daySpinField = new JSpinField();
		daySpinField.getSpinner().addFocusListener(new FocusAdapter() {
		});
		daySpinField.setValue(1);
		daySpinField.setMaximum(31);
		daySpinField.setMinimum(1);
		daySpinField.setBounds(117, 181, 33, 26);
		frame.getContentPane().add(daySpinField);

		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setMonth(0);
		monthChooser.setBounds(159, 181, 123, 26);
		frame.getContentPane().add(monthChooser);

		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setMaximum(2018);
		yearChooser.setMinimum(1910);
		yearChooser.setStartYear(1910);
		yearChooser.setEndYear(2018);
		yearChooser.setBounds(286, 181, 47, 26);
		frame.getContentPane().add(yearChooser);

		JButton btnSignUp = new JButton("Check-In");
		btnSignUp.setBounds(209, 224, 117, 29);
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (firstName.getText().isEmpty() || lastName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "PLease enter first and last name", "ALERT MESSAGE",
							JOptionPane.WARNING_MESSAGE);
				}

				int day = daySpinField.getValue();
				int month = monthChooser.getMonth();
				int year = yearChooser.getValue();

				dateConcat(day, month, year);
			}
		});

		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setBounds(34, 181, 83, 26);

		JLabel lblLengthOfStay = new JLabel("Length of stay:");
		lblLengthOfStay.setBounds(34, 224, 94, 26);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblFirstName);
		frame.getContentPane().add(firstName);
		frame.getContentPane().add(lblLastName);
		frame.getContentPane().add(lastName);
		frame.getContentPane().add(lblDateOfBirth);
		frame.getContentPane().add(lblLengthOfStay);
		frame.getContentPane().add(btnSignUp);

		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/check-in.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(170, 6, 355, 92);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblUploadId = new JLabel("Upload ID:");
		lblUploadId.setBounds(377, 115, 83, 16);
		frame.getContentPane().add(lblUploadId);

		JLabel lblPath_imagPath = new JLabel("");
		lblPath_imagPath.setBounds(359, 147, 241, 193);
		frame.getContentPane().add(lblPath_imagPath);

		JButton btnUpload_upload = new JButton("Upload");
		btnUpload_upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String fileName = f.getAbsolutePath();
				lblPath_imagPath.setText(fileName);
				ImageIcon photoID = new ImageIcon(
						new ImageIcon(fileName).getImage().getScaledInstance(241, 193, Image.SCALE_DEFAULT));
				lblPath_imagPath.setIcon(photoID);
			}
		});
		btnUpload_upload.setBounds(483, 110, 117, 29);
		frame.getContentPane().add(btnUpload_upload);

		JSpinField spinField = new JSpinField();
		spinField.setMinimum(0);
		spinField.setMaximum(30);
		spinField.setBounds(144, 224, 33, 26);
		frame.getContentPane().add(spinField);

	}

	public void dateConcat(int day, int month, int year) {
		System.out.println(day + "-" + month + "-" + year);
	
	}
}
