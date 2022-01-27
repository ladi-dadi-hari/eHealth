package eHealth_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class Healthcare_User_Profile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Healthcare_User_Profile frame = new Healthcare_User_Profile();
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
	public Healthcare_User_Profile() {
		setBounds(100, 100, 517, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Personal Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(159, 27, 185, 25);
		contentPane.add(lblNewLabel);
		
		JLabel firstName_label = new JLabel("First Name:");
		firstName_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstName_label.setBounds(38, 90, 88, 39);
		contentPane.add(firstName_label);
		
		JLabel lastName_label = new JLabel("Last Name:");
		lastName_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastName_label.setBounds(38, 150, 88, 39);
		contentPane.add(lastName_label);
		
		JLabel dateofBirth_label = new JLabel("Date of Birth:");
		dateofBirth_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateofBirth_label.setBounds(38, 210, 100, 39);
		contentPane.add(dateofBirth_label);
		
		JLabel eMail_label = new JLabel("E-Mail Address:");
		eMail_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		eMail_label.setBounds(38, 270, 114, 39);
		contentPane.add(eMail_label);
		
		JLabel insurance_label = new JLabel("Insured at:");
		insurance_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		insurance_label.setBounds(274, 90, 88, 39);
		contentPane.add(insurance_label);
		
		JLabel healthInfo_label = new JLabel("Health Info:");
		healthInfo_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		healthInfo_label.setBounds(274, 150, 88, 39);
		contentPane.add(healthInfo_label);
		
		JButton exportPDFbtn = new JButton("Export Info");
		exportPDFbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Aufruf der Funktion, die für das Exportieren zuständig ist
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
