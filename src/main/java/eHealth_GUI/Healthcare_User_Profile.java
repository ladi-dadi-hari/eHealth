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

	/**<h1>The User Profile GUI</h1>
	 * <p>This is the GUI in which the user who is logged in can see the information that they entered at registering
	 * @author GUI: Sidra Abbasi</p>>
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
	 * <p>The function takes the parameter patient from the object Patient which is created at login</p>>
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

		JButton cancelbutton = new JButton("Cancel");
		cancelbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelbutton.setBounds(194, 439, 114, 39);
		contentPane.add(cancelbutton);


		cancelbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Healthcare_User_Profile.this.dispose();

				Healthcare_Entry entry = new Healthcare_Entry(patient);
				entry.setVisible(true);

			}
		});

/**
 * <p>If the user presses the button Export, his profile information will be exported as PDF
 * @author Can Dechert</p>
 */
		
		JButton exportPDFbtn = new JButton("Export Info");
		exportPDFbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Aufruf der Funktion, die für das Exportieren zuständig ist

				PDF_Functionality.CreatePDF("Your health information:\n" + patient.getHealthInfo());
				JOptionPane.showMessageDialog(contentPane,"PDF exported succesfully");

			}
		});

		exportPDFbtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		exportPDFbtn.setBounds(194, 365, 114, 39);
		contentPane.add(exportPDFbtn);


		/**
		 * Pressing the Edit button will lead to a frame where the patient can edit his account data.
		 * The function executes the SQL statements and writes the changes in the database.
		 *
		 * @author: Harris Nuhanovic
		 *
		 */
		JButton editBtn = new JButton("Edit");
		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Healthcare_User_Profile.this.dispose();

				Edit_Profile edit = new Edit_Profile(patient);
				edit.frame_edit.setVisible(true);

			}
		});
		editBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editBtn.setBounds(194, 402, 114, 39);
		contentPane.add(editBtn);
	}

}
