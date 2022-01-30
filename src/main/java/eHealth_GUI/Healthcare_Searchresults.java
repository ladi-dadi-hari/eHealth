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
	 * Launch the application.
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
		String docMail = null;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 381, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] neu = new String[doctors.size()];
		neu[1] = String.valueOf(doctors.get(1));
		System.out.println(neu[1]);

		JList list = new JList(neu);
		list.setBounds(71, 71, 225, 211);
		contentPane.add(list);

		JLabel lblResults = new JLabel("Search Results:");
		lblResults.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResults.setBounds(124, 33, 104, 30);
		contentPane.add(lblResults);


		JButton btnNewButton = new JButton("Make Appointment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = list.getAnchorSelectionIndex(); //doctor_mailAddress
				AppointmentGUI appointment= new AppointmentGUI(patient, docMail);
				appointment.frmAppointment.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(108, 351, 150, 30);
		contentPane.add(btnNewButton);


	}
}
