
package eHealth_GUI;//import java.awt.BorderLayout;
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
import Users.Patient;


@SuppressWarnings("serial")
public class Healthcare_Entry extends JFrame {

	private JPanel contentPane;

	String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Healthcare_Entry frame = new Healthcare_Entry();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Healthcare_Entry(Patient patient) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*Introduction*/

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Welcome to JavaDocs!");
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesTitle.setBounds(194, 11, 286, 45);
		contentPane.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Find a doctor in your area and make an appointment- with a few steps only!");
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewJgoodiesLabel_1.setBounds(113, 226, 513, 58);
		contentPane.add(lblNewJgoodiesLabel_1);


		JLabel lbluser = new JLabel("You are logged in as:" + patient.getUsername());
		lbluser.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbluser.setBounds(268, 30, 164, 58);
		contentPane.add(lbluser);

		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("How can we help you?");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewJgoodiesLabel.setBounds(268, 55, 164, 58);
		contentPane.add(lblNewJgoodiesLabel);

		/*Buttons: Logout, My Profile, Services, Contact, Search*/

		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(587, 11, 88, 30);
		contentPane.add(btnLogout);
		
		JButton btnMyProfile = new JButton("My Profile");
		btnMyProfile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Healthcare_User_Profile userprofile = new Healthcare_User_Profile(patient);
				userprofile.setVisible(true);
			}
		});
		btnMyProfile.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMyProfile.setBounds(50, 143, 143, 39);
		contentPane.add(btnMyProfile);
		
		JButton btnServices = new JButton("Our Services");
		btnServices.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnServices.setBounds(268, 143, 143, 39);
		contentPane.add(btnServices);
		
		JButton btnContactUs = new JButton("Contact Us");
		btnContactUs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnContactUs.setBounds(483, 143, 143, 39);
		contentPane.add(btnContactUs);

		JButton btnSearchDoc = new JButton("Start searching");
		btnSearchDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//�ffne Eingangsfenster
				Healthcare_Search_Doc second = new Healthcare_Search_Doc();
				second.setVisible(true);


			}
		});
		btnSearchDoc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearchDoc.setBounds(219, 295, 237, 45);
		contentPane.add(btnSearchDoc);
	}
}
