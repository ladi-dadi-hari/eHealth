package eHealth_GUI;


import Users.Patient;
import calendar.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JList;

@SuppressWarnings("serial")
public class Healthcare_Searchresults extends JFrame {

	private JPanel contentPane;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
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
	public Healthcare_Searchresults(Patient patient, List<List<String>> docResult) {

		String docMail = null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JList list = new JList();
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
