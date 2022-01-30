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

public class Healthcare_Login {

	private JFrame frame;
	private JTextField username;
	private JTextField password_field;

	/**
	 * Launch the application.
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
	 * Create the application.
	 */
	public Healthcare_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/*
		Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    SendEmail("can.dechert@gmx.de", "Appointment Reminder", "You have an Appointment one the " + _appDate + " at ");
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                this.cancel();
            }
        };

        timer.schedule(task, delay);
	 */


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 531, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				// An der Stelle Daten aus der Datenbank ziehen
				// Beispiel Werte:
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
					JOptionPane.showMessageDialog(frame, "Login als Patient erfolgreich");

					//�ffne Eingangsfenster
					try {
						ResultSet rs = Connect.getPatient(u_username);
						if(rs.next()) {
							Patient patient = new Patient();
							patient.setUsername(rs.getString(4));
							patient.setMailAddress(rs.getString(5));
							patient.setLatitude(rs.getFloat(14));
							patient.setLongitude(rs.getFloat(13));
							patient.setHealthInfo(rs.getString(10));
							patient.setFirstName(rs.getString(2));
							patient.setLastName(rs.getString(3));

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
				{	try {
					JOptionPane.showMessageDialog(frame, "Login als Doctor erfolgreich");


					ResultSet rs = Connect.getDoctor(u_username);
					if(rs.next()) {
						Doctor doc = new Doctor();
						doc.setUsername(rs.getString(4));
						doc.setMailAdd(rs.getString(7));
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
					JOptionPane.showMessageDialog(frame, "Login als Admin erfolgreich");
					Admin_Page admin = new Admin_Page();
					admin.frame_admin.setVisible(true);
					frame.dispose();
					return;
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Login fehlgeschlagen");
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
