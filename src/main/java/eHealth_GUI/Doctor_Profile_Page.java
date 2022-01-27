package eHealth_GUI;

import JDBC.Connect;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Doctor_Profile_Page extends JFrame{

    public JFrame frame_doc;
    private JTextField appointment;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Doctor_Profile_Page window = new Doctor_Profile_Page();
                    window.frame_doc.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Doctor_Profile_Page() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame_doc = new JFrame();
        frame_doc.setBounds(100, 100, 800, 800);
        frame_doc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_doc.getContentPane().setLayout(null);



    }
}
