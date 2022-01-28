package eHealth_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;



public class Healthcare_Search_Doc extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	int distance;

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

		/*Introduction*/
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Find the Doctor for you!");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesTitle.setBounds(226, 11, 244, 57);
		contentPane.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("In only a few more steps:");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewJgoodiesLabel.setBounds(236, 61, 216, 39);
		contentPane.add(lblNewJgoodiesLabel);

		/*Write Health Issues into Text field*/

		JLabel lblYourHealthProblems = new JLabel("You need consultations for:");
		lblYourHealthProblems.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYourHealthProblems.setBounds(26, 129, 179, 17);
		contentPane.add(lblYourHealthProblems);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(26, 157, 228, 105);
		contentPane.add(textArea);

		/*--------------------------------Appointment Panel----------------------------------*/




		/*--------------------------------Appointment Panel End----------------------------------*/



		/*
		String Healthproblems[] = {"Cold Symptoms","Exhaustion", "Headache", "Pains",
				"Eye Problems", "Skin Infections", "Teeth Problems", "Ear Problems", "Injuries"};
		
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
		contentPane.add(rdbtnInjuries);*/



		/*Select Distance of Search*/

		JLabel lblDistanceOfSearch = new JLabel("Distance of search:");
		lblDistanceOfSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDistanceOfSearch.setBounds(26, 294, 140, 17);
		contentPane.add(lblDistanceOfSearch);

		String ChooseDistance[] = {"5km", "10km", "15km", "20km"};

		@SuppressWarnings({"unchecked", "rawtypes"})
		JComboBox comboBox = new JComboBox(ChooseDistance);
		comboBox.setBounds(26, 322, 113, 22);
		contentPane.add(comboBox);

		/*Button Search*/
		JButton btnSearchNow = new JButton("Search now");
		btnSearchNow.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearchNow.setBounds(489, 402, 140, 39);
		contentPane.add(btnSearchNow);

		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(comboBox.getSelectedItem().toString().equals("1km"))
				{
					distance = 1;
				}
				else if(comboBox.getSelectedItem().toString().equals("2km"))
				{
					distance = 2;
				}
				else if(comboBox.getSelectedItem().toString().equals("5km"))
				{
					distance = 5;
				}
				else if(comboBox.getSelectedItem().toString().equals("10km"))
				{
					distance = 10;
				}
				else if(comboBox.getSelectedItem().toString().equals("15km"))
				{
					distance = 15;
				}
				else if(comboBox.getSelectedItem().toString().equals("20km"))
				{
					distance = 20;
				}
			}
		});
	}
}
