package eHealth_GUI;
//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Healthcare_Entry extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Healthcare_Entry frame = new Healthcare_Entry();
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
	public Healthcare_Entry(String usermail) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Welcome to JavaDocs!");
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesTitle.setBounds(194, 11, 286, 45);
		contentPane.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Find a doctor in your area and make an appointment- with a few steps only!");
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewJgoodiesLabel_1.setBounds(113, 226, 513, 58);
		contentPane.add(lblNewJgoodiesLabel_1);

		JButton startSearchingBtn = new JButton("Start searching");
		startSearchingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Öffne Eingangsfenster
				Healthcare_Search_Doc second= new Healthcare_Search_Doc();
				second.setVisible(true);


			}
		});
		startSearchingBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		startSearchingBtn.setBounds(220, 320, 237, 45);
		contentPane.add(startSearchingBtn);

		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("How can we help you?");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewJgoodiesLabel.setBounds(268, 42, 164, 58);
		contentPane.add(lblNewJgoodiesLabel);

		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logoutBtn.setBounds(23, 22, 88, 30);
		contentPane.add(logoutBtn);

		JButton myProfileBtn = new JButton("My Profile");
		myProfileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Oeffne User- Profile page
				Healthcare_User_Profile userprofile= new Healthcare_User_Profile();
				userprofile.setVisible(true);

			}
		});
		myProfileBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		myProfileBtn.setBounds(52, 143, 143, 39);
		contentPane.add(myProfileBtn);

		JButton ourServicesBtn = new JButton("Our Services");
		ourServicesBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ourServicesBtn.setBounds(271, 143, 143, 39);
		contentPane.add(ourServicesBtn);

		JButton ContactUsBtn = new JButton("Contact Us");
		ContactUsBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ContactUsBtn.setBounds(483, 143, 143, 39);
		contentPane.add(ContactUsBtn);
	}
}
