package eHealth_GUI;

import JDBC.Connect;
import Users.Doctor;
import Users.Patient;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Healthcare_Login extends JFrame {

	public JFrame frame;
	private JTextField username;
	private JTextField password_field;

	/**
	 * <h1>The Login GUI</h1>
	 * <p>This is the code that creates the Login Window for the Patient user and the Doctor User
	 * at starting the program, first the tables for the Patient, Doctor and Appointments are created
	 * in case they do not exist
	 * @author Sidra Abbasi</p>
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Healthcare_Login window = new Healthcare_Login();
					Connect.createTablePatient();
					Connect.createTableDoctor();
					Connect.createTableAppointment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * <p>The function initialize() displays the login window </p>>
	 */
	public Healthcare_Login() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 531, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblEnterLogin = new JLabel("Enter your Login Data:");
		lblEnterLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterLogin.setBounds(167, 54, 182, 34);
		frame.getContentPane().add(lblEnterLogin);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(109, 132, 81, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPasswort = new JLabel("Password:");
		lblPasswort.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPasswort.setBounds(109, 195, 89, 52);
		frame.getContentPane().add(lblPasswort);
		
		username = new JTextField();
		username.setBounds(200, 132, 152, 34);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password_field = new JPasswordField();
		password_field.setColumns(10);
		password_field.setBounds(200, 206, 152, 34);
		frame.getContentPane().add(password_field);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginButton.setBounds(200, 286, 127, 34);
		frame.getContentPane().add(loginButton);

		JButton registerButton = new JButton("Register");
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		registerButton.setBounds(200, 340, 127, 34);
		frame.getContentPane().add(registerButton);


		/**
		 * <p>When the Login Button is clicked, the Entries from the Patient and Doctor Databases are fetched.</p>
		 * @author Maximilian Rabe
		 */
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				// An der Stelle Daten aus der Datenbank ziehen

				String u_username= username.getText();
				String u_pwd= password_field.getText();
				boolean exists_patient = false;
				boolean exists_doc = false;

				final String sqlFetchHash_patient = "SELECT password FROM Users.patient WHERE patient_username=?";
				final String sqlFetchSalt_patient = "SELECT salt FROM Users.patient WHERE patient_username=?";


				final String sqlFetchHash_doc = "SELECT password FROM Users.doctor WHERE doctor_username=?";
				final String sqlFetchSalt_doc = "SELECT salt FROM Users.doctor WHERE doctor_username=?";

				try
				{
					exists_patient = Connect.validateData(u_username, u_pwd, sqlFetchHash_patient, sqlFetchSalt_patient);
				}
				catch (SQLException ex)
				{
					ex.printStackTrace();
				}
				try {
					exists_doc = Connect.validateData(u_username, u_pwd, sqlFetchHash_doc, sqlFetchSalt_doc);
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				if(exists_patient)
				{
					JOptionPane.showMessageDialog(frame, "Logged in as: patient");


					//oeffne Eingangsfenster
					try {
						ResultSet rs = Connect.getPatient(u_username);
						if(rs.next()) {
							Patient patient = new Patient();
							patient.setFirstName(rs.getString(2));
							patient.setLastName(rs.getString(3));
							patient.setUsername(rs.getString(4));
							patient.setMailAddress(rs.getString(5));
							patient.setBirthday(rs.getString(6));
							patient.setLocation(rs.getString(9));
							patient.setHealthInfo(rs.getString(10));
							patient.setInsurance(rs.getString(11));
							patient.setInsuranceType(rs.getString(12));
							patient.setLongitude(rs.getFloat(13));
							patient.setLatitude(rs.getFloat(14));

							Healthcare_Entry second = new Healthcare_Entry(patient);
							Healthcare_Tray_Icon third = new Healthcare_Tray_Icon();

							third.Tray_Icon(patient);
							second.setVisible(true);
							frame.dispose();
							return;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}


				}
				else if(exists_doc)
				{
					JOptionPane.showMessageDialog(frame, "Logged in as: Doctor");
					try {
					ResultSet rs = Connect.getDoctor(u_username);
					if(rs.next()) {
						Doctor doc = new Doctor();
						doc.setUsername(u_username);
						doc.setMailAddress(rs.getString(7));
						doc.setFirstName(rs.getString(2));
						doc.setLastName(rs.getString(3));
						doc.setOpeningHour(rs.getInt(12));
						doc.setClosingHour(rs.getInt(13));
						Manage_Appointment_doc doctor_profile_page = new Manage_Appointment_doc(doc);

						doctor_profile_page.setVisible(true);
						frame.dispose();
						return;
					}
				}
				catch (SQLException e){
					e.printStackTrace();
				}
				}

				else if(u_username.equals("admin") && u_pwd.equals("admin"))
				{
					JOptionPane.showMessageDialog(frame, "Logged in as: Admin");
					Admin_Page admin = new Admin_Page();
					admin.frame_admin.setVisible(true);
					frame.dispose();
					return;
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Login not possible, try again");
				}
			}
		});

		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Healthcare_Registration third = new Healthcare_Registration();
				third.frame_register.setVisible(true);
			}
		});
	}
}
