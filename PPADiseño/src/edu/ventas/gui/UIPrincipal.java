package edu.ventas.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class UIPrincipal extends WindowAdapter {
    public int numWindows = 0;
    private Point lastLocation = null;
    private int maxX = 500;
    private int maxY = 500;
 
    public UIPrincipal() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        maxX = screenSize.width - 50;
        maxY = screenSize.height - 50;
        makeNewWindow();
    }
 
    public void makeNewWindow() {
        JFrame frame = new Ventana(this);
        numWindows++;
        System.out.println("Number of windows: " + numWindows);
 
        if (lastLocation != null) {
            //Move the window over and down 40 pixels.
            lastLocation.translate(40, 40);
            if ((lastLocation.x > maxX) || (lastLocation.y > maxY)) {
                lastLocation.setLocation(0, 0);
            }
            frame.setLocation(lastLocation);
        } else {
            lastLocation = frame.getLocation();
        }
 
        System.out.println("Frame location: " + lastLocation);
        frame.setVisible(true);
    }
 
    //This method must be evoked from the event-dispatching thread.
    public void quit(JFrame frame) {
        if (quitConfirmed(frame)) {
            System.out.println("Quitting.");
            System.exit(0);
        }
        System.out.println("Quit operation not confirmed; staying alive.");
    }
 
    private boolean quitConfirmed(JFrame frame) {
        String s1 = "Quit";
        String s2 = "Cancel";
        Object[] options = {s1, s2};
        int n = JOptionPane.showOptionDialog(frame,
                "Windows are still open.\nDo you really want to quit?",
                "Quit Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                s1);
        if (n == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
 
    public void windowClosed(WindowEvent e) {
        numWindows--;
        System.out.println("Number of windows = " + numWindows);
        if (numWindows <= 0) {
            System.out.println("All windows gone.  Bye bye!");
            System.exit(0);
        }
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
}
