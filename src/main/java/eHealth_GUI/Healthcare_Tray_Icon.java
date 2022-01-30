package eHealth_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This is the Class that build the system tray icon to access the eHealth application in sleep mode
 * This makes the whole application able to stay active and keep the reminder running without disturbing the user,
 * while still being able to be managed by the user.
 *
 * @author Can Dechert
 */

public class Healthcare_Tray_Icon {
    ImageIcon icon;
    public void Tray_Icon(){
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        icon = new ImageIcon("resources/emoji-heart.gif");

        //  Initialize the System Tray Icon
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon = new TrayIcon(icon.getImage(), "eHealth", popup);
        final SystemTray tray = SystemTray.getSystemTray();

        //  Add the reopening functionality
        trayIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(true);    // WHICH WINDOW SHOULD OPEN?
            }
        });

        //  Add Label item
        MenuItem aboutItem = new MenuItem("eHealth");
        popup.add(aboutItem);

        //  Add Exit button to completely shut down the application
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        popup.addSeparator(); // Separator for esthetics
        popup.add(exitItem);

        trayIcon.setPopupMenu(popup); // Initialize whole popup menu

        // Finally, initialize the whole tray icon
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
    }
}
