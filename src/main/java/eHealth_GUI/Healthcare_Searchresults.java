package eHealth_GUI;


import Users.Patient;
import calendar.*;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JList;
import java.sql.ResultSet;
import java.util.List;

@SuppressWarnings("serial")
public class Healthcare_Searchresults extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	int i = 0;

	/**
	 *
	 * <p>In this GUI, the search results of the doctor search are displayed as a list</p>
	 * @author GUI: Sidra Abbasi
	 * @author functions: Max Endres, Maximilian Rabe
	 */

/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Healthcare_Searchresults frame = new Healthcare_Searchresults();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public Healthcare_Searchresults(Patient patient, List<List<String>> doctors) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int i = 0;
		String[] neu = new String[doctors.size()];

		for (i = 0; i < doctors.size(); i++){
			String docResult = String.valueOf(doctors.get(i));
			
			//remove brackets:
			docResult = docResult.replace("[", "");
			docResult = docResult.replace("]", "");
			neu[i] = String.valueOf(docResult);
		}
		

		JList list = new JList(neu);
		list.setBounds(71, 71, 300, 211);
		contentPane.add(list);

		JLabel lblResults = new JLabel("Search Results:");
		lblResults.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResults.setBounds(166, 33, 104, 30);
		contentPane.add(lblResults);


		JButton btnNewButton = new JButton("Make Appointment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chosenDocMail = list.getSelectedValue().toString();
				chosenDocMail = chosenDocMail.substring(chosenDocMail.indexOf(",")+1);
				chosenDocMail = chosenDocMail.substring(chosenDocMail.indexOf(",")+1);
				chosenDocMail =chosenDocMail.trim();
				try {
					AppointmentGUI appointment = new AppointmentGUI(patient, chosenDocMail);
					appointment.frmAppointment.setVisible(true);
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(143, 351, 150, 30);
		contentPane.add(btnNewButton);


	}
}
