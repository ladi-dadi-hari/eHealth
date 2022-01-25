package eHealth_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				// An der Stelle Daten aus der Datenbank ziehen
				// Beispiel Werte:
				String u_name= username.getText();
				String u_pwd= password_field.getText();
				
				if(u_name.equals("name") && u_pwd.equals("password"))
				{
					JOptionPane.showMessageDialog(frame, "Login erfolgreich");
					
					//�ffne Eingangsfenster
					Healthcare_Entry second= new Healthcare_Entry();
					second.setVisible(true);
					frame.dispose();
	
				}

				
				else
				{
					JOptionPane.showMessageDialog(frame, "Login fehlgeschlagen");
				}
			}
		});
	}
}
