package eHealth_GUI;

import Export.PDF_Functionality;
import Users.Patient;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class Healthcare_User_Profile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				Healthcare_User_Profile frame = new Healthcare_User_Profile();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	//}

	/**
	 * Create the frame.
	 */
	public Healthcare_User_Profile(Patient patient) {
		setBounds(100, 100, 517, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Personal Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(159, 27, 185, 25);
		contentPane.add(lblNewLabel);
		
		JLabel firstName_label = new JLabel("First Name: "+ patient.getFirstName());
		firstName_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstName_label.setBounds(38, 90, 250, 39);
		contentPane.add(firstName_label);
		
		JLabel lastName_label = new JLabel("Last Name: "+patient.getLastName());
		lastName_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastName_label.setBounds(38, 150, 250, 39);
		contentPane.add(lastName_label);
		
		JLabel dateofBirth_label = new JLabel("Date of Birth: "+patient.getBirthday());
		dateofBirth_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateofBirth_label.setBounds(38, 210, 250, 39);
		contentPane.add(dateofBirth_label);
		
		JLabel eMail_label = new JLabel("E-Mail Address: "+patient.getMailAddress());
		eMail_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		eMail_label.setBounds(38, 270, 400, 39);
		contentPane.add(eMail_label);
		
		JLabel insurance_label = new JLabel("Insured at: "+patient.getInsurance());
		insurance_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		insurance_label.setBounds(274, 90, 250, 39);
		contentPane.add(insurance_label);
		
		JLabel healthInfo_label = new JLabel("Health Info: "+patient.getHealthInfo());
		healthInfo_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		healthInfo_label.setBounds(274, 150, 250, 39);
		contentPane.add(healthInfo_label);
		
		JButton exportPDFbtn = new JButton("Export Info");
		exportPDFbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Aufruf der Funktion, die für das Exportieren zuständig ist

				PDF_Functionality.CreatePDF(patient.getHealthInfo());
				JOptionPane.showMessageDialog(contentPane,"PDF exported succesfully");

			}
		});

		exportPDFbtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		exportPDFbtn.setBounds(194, 366, 114, 39);
		contentPane.add(exportPDFbtn);
		
		JButton editBtn = new JButton("Edit");
		editBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editBtn.setBounds(194, 439, 114, 39);
		contentPane.add(editBtn);
	}

}
