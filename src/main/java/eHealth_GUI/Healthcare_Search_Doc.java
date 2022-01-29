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

/*imports for the appointment gui*/

import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JCalendar;
import java.sql.Time;
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
				{"Cold", "Sickness", "Flu", "Migraines", "Head Ache", "Fever",
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
				{"Akne", "Rashes", "Itches", "Skin Disease", "Moles"
				};

		skinIssuesdropDown = new JComboBox(skinIssues);
		skinIssuesdropDown.setBounds(150, 178, 113, 25);
		getContentPane().add(skinIssuesdropDown);

		skinIssuesdropDown.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dropDownIndex =	skinIssuesdropDown.getSelectedIndex();
				System.out.println(dropDownIndex);
			}
		});
		/*Joint Issues*/

		JLabel lblJointIssues = new JLabel("Joint Issues:");
		lblJointIssues.setBounds(26, 210, 179, 17);
		contentPane.add(lblJointIssues);

		String[] jointIssues =
				{"Back Pain", "Knee Pain", "Neck Pain", "Joint Pain"
				};

		jointIssuesdropDown = new JComboBox(jointIssues);
		jointIssuesdropDown.setBounds(26, 231, 113, 25);
		getContentPane().add(jointIssuesdropDown);

		jointIssuesdropDown.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dropDownIndex =	jointIssuesdropDown.getSelectedIndex();
				System.out.println(dropDownIndex);
			}
		});

		/*Chronic Issues*/

		JLabel lblchronicIssues = new JLabel("Chronic Issues:");
		lblchronicIssues.setBounds(150, 210, 113, 25);
		contentPane.add(lblchronicIssues);

		String[] chronicIssues =
				{"Asthma", "Blood Pressure", "Hay Fever", "Diabetes"
				};

		chronicIssuesdropDown = new JComboBox(chronicIssues);
		chronicIssuesdropDown.setBounds(150, 231, 113, 25);
		getContentPane().add(chronicIssuesdropDown);

		chronicIssuesdropDown.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dropDownIndex =	chronicIssuesdropDown.getSelectedIndex();
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

		/*--------------------------------Appointment Panel----------------------------------*/


			/*Date picker*/
		Date heute = new Date();
		JLabel lbChooseDate = new JLabel("Date:");
		lbChooseDate.setBounds(420, 129, 179, 25);
		getContentPane().add(lbChooseDate);

		dateChooser = new JDateChooser(heute);
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


			}

		});
		dateChooser.setBounds(420, 150, 129, 25);
		getContentPane().add(dateChooser);

		/*Time pickers*/

		lbTime = new JLabel("Time:");
		lbTime.setBounds(420, 180, 50, 19);
		getContentPane().add(lbTime);

		hour = new JSpinField();
		hour.setBounds(420, 200, 50, 22);
		getContentPane().add(hour);

		lbHour = new JLabel("Hours");
		lbHour.setFont(new Font("Tahoma", Font.ITALIC, 8));
		lbHour.setBounds(420, 218, 129, 19);
		getContentPane().add(lbHour);

		minute = new JSpinField();
		minute.setBounds(470, 200, 50, 22);
		getContentPane().add(minute);

		lblNewLabel = new JLabel("Minutes");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 8));
		lblNewLabel.setBounds(470, 218, 50, 19);
		getContentPane().add(lblNewLabel);

		/*Reminder Dropdown*/

		JLabel lbReminder = new JLabel("Reminder:");
		lbReminder.setBounds(420, 240, 70, 19);
		getContentPane().add(lbReminder);

		String[] reminderList = {"1 week", "3 days", "1 hour", "10 minutes"};

		reminderdropDown = new JComboBox(reminderList);
		reminderdropDown.setBounds(420, 260, 100, 25);
		getContentPane().add(reminderdropDown);

		reminderdropDown.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dropDownIndex =	reminderdropDown.getSelectedIndex();
				System.out.println(dropDownIndex);
			}
		});

		setHourMaximum(20);
		setHourMinimum(10);

		setMinuteMaximum(59);
		setMinuteMinimum(00);

		setDropDownMaximumRowCount(3);




		/*--------------------------------Appointment Panel End----------------------------------*/


	}

	/*Get and set methods for the appointment function*/


	/**
	 * @return String This returns the Date as String
	 */
	public String getDateChooserDateFormatString() {

		return dateChooser.getDateFormatString();
	}

	/**
	 * Set the initial date displayed when opening the window first.
	 * In this application it shows the date of today.
	 */
	public void setDateChooserDateFormatString(String dateFormatString) {

		dateChooser.setDateFormatString(dateFormatString);
	}

	/**
	 * get the Hour entered into the JSpinField
	 * @return Integer Returns the hour
	 */
	public int getHourMaximum() {

		return hour.getMaximum();
	}

	/**
	 * sets the maximum value of the JSpinField "Hour".
	 * In this application, it represents the hour when the doctor is closing.
	 * @param maximum
	 */
	public void setHourMaximum(int maximum) {
		hour.setMaximum(maximum);
	}

	/**
	 * get the minute entered into the JSpinField
	 * @return int Returns the minute
	 */
	public int getMinuteMaximum() {
		return minute.getMaximum();
	}

	/**
	 * sets the maximum value of the JSpinField "Minute".
	 * In this application, it represents the hour when the doctor is closing.
	 * @param maximum_1
	 */
	public void setMinuteMaximum(int maximum_1) {
		minute.setMaximum(maximum_1);
	}

	/**
	 *
	 * @return Integer Minute
	 */
	public int getMinuteMinimum() {
		return minute.getMinimum();
	}

	/**
	 * Minimum is set to 0 in this application.
	 * @param minimum
	 */
	public void setMinuteMinimum(int minimum) {
		minute.setMinimum(minimum);
	}
	public int getHourMinimum() {
		return hour.getMinimum();
	}

	/**
	 * Minimum represents the time when doctor is opening.
	 * @param minimum_1
	 */
	public void setHourMinimum(int minimum_1) {
		hour.setMinimum(minimum_1);
	}

	/**
	 * Returned index is used to calculate the reminder time.
	 * @return Integer Index of chosen element.
	 */
	public int getDropDownMaximumRowCount() {
		return reminderdropDown.getMaximumRowCount();
	}
	public void setDropDownMaximumRowCount(int maximumRowCount) {
		reminderdropDown.setMaximumRowCount(maximumRowCount);
	}

}


