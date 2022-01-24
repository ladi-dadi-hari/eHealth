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
	 */
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

	/**
	 * Create the frame.
	 */
	public Healthcare_Entry() {
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
		
		JButton btnNewButton = new JButton("Start searching");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Öffne Eingangsfenster
				Healthcare_Search_Doc second= new Healthcare_Search_Doc();
				second.setVisible(true);

				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(219, 295, 237, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("How can we help you?");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewJgoodiesLabel.setBounds(268, 42, 164, 58);
		contentPane.add(lblNewJgoodiesLabel);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBounds(587, 11, 88, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("My Profile");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setBounds(50, 143, 143, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Our Services");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2_1.setBounds(268, 143, 143, 39);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Contact Us");
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2_2.setBounds(483, 143, 143, 39);
		contentPane.add(btnNewButton_2_2);
	}
}
