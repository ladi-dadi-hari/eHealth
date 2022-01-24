package eHealth_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

@SuppressWarnings("serial")

public class Healthcare_Search_Doc extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Healthcare_Search_Doc frame = new Healthcare_Search_Doc();
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
	public Healthcare_Search_Doc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Find the Doctor for you!");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesTitle.setBounds(226, 11, 244, 57);
		contentPane.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("In only a few more steps:");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewJgoodiesLabel.setBounds(236, 61, 216, 39);
		contentPane.add(lblNewJgoodiesLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Public");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBounds(47, 153, 61, 25);
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel = new JLabel("Your insurance type:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(37, 129, 140, 17);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnPrivats = new JRadioButton("Private");
		rdbtnPrivats.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnPrivats.setBounds(127, 153, 67, 25);
		contentPane.add(rdbtnPrivats);
		
		textField = new JTextField();
		textField.setBounds(37, 226, 130, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTheNameOf = new JLabel("Name of your Insurance:");
		lblTheNameOf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTheNameOf.setBounds(37, 198, 216, 17);
		contentPane.add(lblTheNameOf);
		
		JLabel lblYourHealthProblems = new JLabel("You need consultations for:");
		lblYourHealthProblems.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYourHealthProblems.setBounds(37, 275, 179, 17);
		contentPane.add(lblYourHealthProblems);
		
		JRadioButton rdbtnColdSymptoms = new JRadioButton("Cold Symptoms");
		rdbtnColdSymptoms.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnColdSymptoms.setBounds(37, 304, 130, 25);
		contentPane.add(rdbtnColdSymptoms);
		
		JRadioButton rdbtnExhaustion = new JRadioButton("Exhaustion");
		rdbtnExhaustion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnExhaustion.setBounds(37, 332, 91, 25);
		contentPane.add(rdbtnExhaustion);
		
		JRadioButton rdbtnHeadache = new JRadioButton("Headache");
		rdbtnHeadache.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnHeadache.setBounds(37, 360, 91, 25);
		contentPane.add(rdbtnHeadache);
		
		JRadioButton rdbtnPains = new JRadioButton("Pains");
		rdbtnPains.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnPains.setBounds(37, 388, 61, 25);
		contentPane.add(rdbtnPains);
		
		JRadioButton rdbtnEyeProblems = new JRadioButton("Eye Problems");
		rdbtnEyeProblems.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnEyeProblems.setBounds(37, 416, 105, 25);
		contentPane.add(rdbtnEyeProblems);
		
		JLabel lblDistanceOfSearch = new JLabel("Distance of search:");
		lblDistanceOfSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDistanceOfSearch.setBounds(374, 129, 140, 17);
		contentPane.add(lblDistanceOfSearch);
		
		String ChooseDistance[] = {"5km", "10km", "15km", "20km"};
		
		@SuppressWarnings({"unchecked", "rawtypes"})
		JComboBox comboBox = new JComboBox(ChooseDistance);
		comboBox.setBounds(374, 155, 113, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Search now");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(489, 402, 140, 39);
		contentPane.add(btnNewButton);
		
		JRadioButton rdbtnAllergicReaction = new JRadioButton("Skin Infections");
		rdbtnAllergicReaction.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnAllergicReaction.setBounds(169, 304, 130, 25);
		contentPane.add(rdbtnAllergicReaction);
		
		JRadioButton rdbtnTeethProblems = new JRadioButton("Teeth Problems");
		rdbtnTeethProblems.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnTeethProblems.setBounds(169, 334, 130, 25);
		contentPane.add(rdbtnTeethProblems);
		
		JRadioButton rdbtnEarProblems = new JRadioButton("Ear Problems");
		rdbtnEarProblems.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnEarProblems.setBounds(169, 362, 130, 25);
		contentPane.add(rdbtnEarProblems);
		
		JRadioButton rdbtnInjuries = new JRadioButton("Injuries");
		rdbtnInjuries.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnInjuries.setBounds(169, 390, 130, 25);
		contentPane.add(rdbtnInjuries);
	}
}
