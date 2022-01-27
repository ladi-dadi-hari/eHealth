package eHealth_GUI;

import JDBC.Connect;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Healthcare_Login {

	private JFrame frame;
	private JTextField eMail;
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
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 531, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("eMail-Address");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(109, 132, 81, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPasswort = new JLabel("Password:");
		lblPasswort.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPasswort.setBounds(109, 195, 89, 52);
		frame.getContentPane().add(lblPasswort);
		
		eMail = new JTextField();
		eMail.setBounds(200, 132, 152, 34);
		frame.getContentPane().add(eMail);
		eMail.setColumns(10);
		
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
				String u_eMail= eMail.getText();
				String u_pwd= password_field.getText();
				boolean exists_patient = false;
				boolean exists_doc = false;

				try
				{
					exists_patient = Connect.validateData_patient(u_eMail, u_pwd);
				}
				catch (SQLException ex)
				{
					ex.printStackTrace();
				}
				try {
					exists_doc = Connect.validateData_doc(u_eMail, u_pwd);
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				if(exists_patient)
				{
					JOptionPane.showMessageDialog(frame, "Login als Patient erfolgreich");

					//�ffne Eingangsfenster
					Healthcare_Entry second= new Healthcare_Entry();
					second.setVisible(true);
					frame.dispose();
					return;

				}
				else if(exists_doc)
				{
					JOptionPane.showMessageDialog(frame, "Login als Doctor erfolgreich");

					Doctor_Profile_Page doctor_profile_page = new Doctor_Profile_Page();
					doctor_profile_page.frame_doc.setVisible(true);
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
				Healthcare_Register third = new Healthcare_Register();
				third.frame_register.setVisible(true);
			}
		});
	}
}
