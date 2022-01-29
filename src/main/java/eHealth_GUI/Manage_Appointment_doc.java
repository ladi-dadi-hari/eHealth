package eHealth_GUI;

import JDBC.Connect;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.table.TableModel;

public class Manage_Appointment_doc extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Manage_Appointment_doc frame = new Manage_Appointment_doc("mailaddres@xy.com");
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
    public Manage_Appointment_doc(String doctorMail) throws SQLException {
        ResultSet appointments = JDBC.Connect.getAppointments("doctormailing");
        JTable resTab =  new JTable();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 684, 421);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        if(appointments.next()){
        table = new JTable();
        table.setEnabled(false);
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, appointments.getString(4), null, null, null, appointments.getBoolean(1)},
                        {null, null, null, null, null, null, null},
                        {"", "", null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                },
                new String[] {
                        "Date", "Time", "Name", "Last name", "First Name", "Health Problems", "Confirmed"
                }
        ) {
            Class[] columnTypes = new Class[] {
                    Object.class, Object.class, String.class, String.class, String.class, Object.class, Boolean.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        table.getColumnModel().getColumn(4).setPreferredWidth(77);
        table.getColumnModel().getColumn(4).setMinWidth(16);
        table.getColumnModel().getColumn(5).setPreferredWidth(87);
        table.setRowHeight(70);
        table.setFont(new Font("Serif", Font.PLAIN, 7));
        table.setBounds(10, 35, 414, 280);
        contentPane.add(table);

        JButton btnOK1 = new JButton("Confirm");
        btnOK1.setBounds(442, 59, 85, 21);
        contentPane.add(btnOK1);

        JButton btnCancel1 = new JButton("Cancel");
        btnCancel1.setBounds(548, 59, 85, 21);
        contentPane.add(btnCancel1);

        JButton btnOK2 = new JButton("Confirm");
        btnOK2.setBounds(442, 125, 85, 21);
        contentPane.add(btnOK2);

        JButton btnCancel2 = new JButton("Cancel");
        btnCancel2.setBounds(548, 125, 85, 21);
        contentPane.add(btnCancel2);

        JButton btnOK3 = new JButton("Confirm");
        btnOK3.setBounds(442, 198, 85, 21);
        contentPane.add(btnOK3);

        JButton btnCancel3 = new JButton("Cancel");
        btnCancel3.setBounds(548, 198, 85, 21);
        contentPane.add(btnCancel3);

        JButton btnOK4 = new JButton("Confirm");
        btnOK4.setBounds(442, 273, 85, 21);
        contentPane.add(btnOK4);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(548, 273, 85, 21);
        contentPane.add(btnCancel);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(548, 333, 85, 21);
        contentPane.add(btnExit);
    }
    else{
        int i = 1+1;
    }


    }
}
