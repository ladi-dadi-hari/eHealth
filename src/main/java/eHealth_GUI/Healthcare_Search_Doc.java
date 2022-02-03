package eHealth_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JDBC.Connect;
import Users.Patient;
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

/*imports for the appointment gui*/

import com.toedter.calendar.JDateChooser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JCalendar;
import java.sql.Time;
import java.util.List;
import java.util.Timer;
import Users.Doctor;
import com.toedter.components.JSpinField;

import javax.swing.JComboBox;



public class Healthcare_Search_Doc extends JFrame {


	private JPanel contentPane;
	private JTextField textField;

	/*For the reminder*/
	int dropDownIndex;
	JComboBox generalIssuesdropDown;
	JComboBox skinIssuesdropDown;
	JComboBox jointIssuesdropDown;
	JComboBox chronicIssuesdropDown;
	JComboBox reminderdropDown;
	int distance;
	JDateChooser dateChooser;
	JSpinField hour;
	JSpinField minute;
	JLabel lbTime;
	JLabel lbHour;
	JLabel lblNewLabel;
	Date date;
	LocalTime time;
	LocalDateTime pickedDateTime;
	String specF;

	/**
	 * <h1>The search GUI </h1>
	 * <p>This is the code for the GUI in which the patient enters their health problems to find a doctor in the
	 * selected distance of search<p/>
	 * @author Sidra Abbasi
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 *  <p>@param patients takes the object Patient that was created at login</p>
	 */

	public Healthcare_Search_Doc(Patient patient) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 331, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*Introduction*/
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Find the Doctor for you!");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesTitle.setBounds(44, 11, 228, 57);
		contentPane.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("In only a few more steps:");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewJgoodiesLabel.setBounds(64, 59, 188, 39);
		contentPane.add(lblNewJgoodiesLabel);

		/*Choose Health Issues from dropdown menus*/

		JLabel lblYourHealthProblems = new JLabel("You need consultations for:");
		lblYourHealthProblems.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYourHealthProblems.setBounds(26, 129, 179, 17);
		contentPane.add(lblYourHealthProblems);

		/*General Issues*/

		JLabel lblGeneralIssues = new JLabel("General Issues:");
		lblGeneralIssues.setBounds(26, 157, 179, 17);
		contentPane.add(lblGeneralIssues);

		String[] generalIssues =
				{"-", "Cold", "Sickness", "Flu", "Migraines", "Head Ache", "Fever",
						"Stomach Pain", "Covid", "Allergies", "Obesity"

		};

		generalIssuesdropDown = new JComboBox(generalIssues);
		generalIssuesdropDown.setBounds(26, 178, 113, 25);
		getContentPane().add(generalIssuesdropDown);

		generalIssuesdropDown.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dropDownIndex =	generalIssuesdropDown.getSelectedIndex();
				System.out.println(dropDownIndex);
			}
		});
		/*Skin Issues*/

		JLabel lblSkinIssues = new JLabel("Skin Issues:");
		lblSkinIssues.setBounds(150, 157, 179, 17);
		contentPane.add(lblSkinIssues);

		String[] skinIssues =
				{"-", "Akne", "Rashes", "Itches", "Skin Disease", "Moles"
				};

		skinIssuesdropDown = new JComboBox(skinIssues);
		skinIssuesdropDown.setBounds(150, 178, 113, 25);
		getContentPane().add(skinIssuesdropDown);

		skinIssuesdropDown.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dropDownIndex = generalIssues.length + skinIssuesdropDown.getSelectedIndex();
				System.out.println(dropDownIndex);
			}
		});
		/*Joint Issues*/

		JLabel lblJointIssues = new JLabel("Joint Issues:");
		lblJointIssues.setBounds(26, 210, 179, 17);
		contentPane.add(lblJointIssues);

		String[] jointIssues =
				{"-", "Back Pain", "Knee Pain", "Neck Pain", "Joint Pain"
				};

		jointIssuesdropDown = new JComboBox(jointIssues);
		jointIssuesdropDown.setBounds(26, 231, 113, 25);
		getContentPane().add(jointIssuesdropDown);

		jointIssuesdropDown.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dropDownIndex =	generalIssues.length + skinIssues.length + jointIssuesdropDown.getSelectedIndex();
				System.out.println(dropDownIndex);
			}
		});

		/*Chronic Issues*/

		JLabel lblchronicIssues = new JLabel("Chronic Issues:");
		lblchronicIssues.setBounds(150, 210, 113, 25);
		contentPane.add(lblchronicIssues);

		String[] chronicIssues =
				{"-", "Asthma", "Blood Pressure", "Hay Fever", "Diabetes"
				};

		chronicIssuesdropDown = new JComboBox(chronicIssues);
		chronicIssuesdropDown.setBounds(150, 231, 113, 25);
		getContentPane().add(chronicIssuesdropDown);

		chronicIssuesdropDown.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dropDownIndex = generalIssues.length + skinIssues.length + jointIssues.length + chronicIssuesdropDown.getSelectedIndex();
				System.out.println(dropDownIndex);
			}
		});


		/*Select Distance of Search*/

		JLabel lblDistanceOfSearch = new JLabel("Distance of search:");
		lblDistanceOfSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDistanceOfSearch.setBounds(26, 294, 140, 25);
		contentPane.add(lblDistanceOfSearch);

		String ChooseDistance[] = {"1km", "2km", "5km", "10km", "15km", "20km"};

		@SuppressWarnings({"unchecked", "rawtypes"})
		JComboBox comboBox = new JComboBox(ChooseDistance);
		comboBox.setBounds(26, 322, 113, 22);
		contentPane.add(comboBox);

		/*Button Search*/
		JButton btnSearchNow = new JButton("Search now");
		btnSearchNow.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearchNow.setBounds(88, 405, 140, 39);
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

		btnSearchNow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				if(dropDownIndex<= generalIssues.length)
				{
					specF = "General";
				}
				else if(dropDownIndex>generalIssues.length && dropDownIndex<= (generalIssues.length + skinIssues.length)){
					specF="Dermatologist";
				}
				else if(dropDownIndex > (generalIssues.length+ skinIssues.length) && dropDownIndex<= (generalIssues.length + skinIssues.length + jointIssues.length)){
					specF="Orthopedist";
				}
				else {
					specF="Allergist";
				}
				try {
					List<List<String>> doctors = Connect.AvailDoc(specF, distance, patient.getLatitude(), patient.getLongitude());
					Healthcare_Searchresults results = new Healthcare_Searchresults(patient, doctors);
					results.setVisible(true);
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		/*--------------------------------Appointment Panel----------------------------------

		/*--------------------------------Appointment Panel End----------------------------------*/


	}

}


