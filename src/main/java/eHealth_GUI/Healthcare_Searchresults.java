package eHealth_GUI;


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

@SuppressWarnings("serial")
public class Healthcare_Searchresults extends JFrame {

	private JPanel contentPane;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Healthcare_Searchresults() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hier kann ein Ausschnitt aus Google Maps rein?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(73, 42, 380, 121);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Praxis_1, Adresse_1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(29, 343, 343, 23);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Praxis_1, Adresse_1");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(29, 392, 343, 23);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Praxis_1, Adresse_1");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(29, 439, 343, 23);
		contentPane.add(lblNewLabel_1_2);

		JButton btnNewButton_1 = new JButton("Select");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//AppointmentGUI window1 = new AppointmentGUI();


				//window1.frmAppointment.setVisible(true);


			}});
/*
				int confirm_question = JOptionPane.showConfirmDialog(null, "Do you want to confirm this appointment?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if (confirm_question == JOptionPane.YES_OPTION) {
					//TODO:
					//An dieser Stelle Kalenderfunktion einf�gen:
					//Neues Frame �ffnen
					//Termin ausw�hlen
					//Wenn Termin ausgew�hlt:

					JOptionPane.showMessageDialog(frame, "Appointment confirmed!");
				} else if (confirm_question == JOptionPane.NO_OPTION) {
					// Do nothing
				}
			}
		});*/
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(402, 343, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Select");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppointmentGUI window2 = new AppointmentGUI();


				window2.frmAppointment.setVisible(true);

			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setBounds(402, 393, 89, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Select 3");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppointmentGUI window3 = new AppointmentGUI();


				window3.frmAppointment.setVisible(true);

			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.setBounds(402, 440, 89, 23);
		contentPane.add(btnNewButton_3);

	}
}
