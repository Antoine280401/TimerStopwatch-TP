package gui;

import states.Context;
import states.EventListener;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * @author tommens
 * This class represents a Headless GUI, which is a GUI that is never drawn on the screen,
 * even though it contains real buttons and labels. They are just not visible to the user.
 * Why is this useful? To be able to run automated tests on the GUI in headless mode
 * on remote servers that do not have a screen, without getting a Headless exception error.
 * In order to create a real Swing GUI, use the SwingGUI subclass of HeadlessGUI.
 */
public class HeadlessGUI {

    public JButton b1, b2, b3;
    public JLabel myText1, myText2, myText3;

    protected EventListener observer;

    public HeadlessGUI(EventListener o) {
        observer = o;
        internalInitGUI(); // Call private method
        internalAddEventListener(); // Call private method
    }

    private void internalInitGUI() {
        b1 = new JButton();
        b2 = new JButton();
        b3 = new JButton();
        myText1 = new JLabel();
        myText2 = new JLabel();
        myText3 = new JLabel();
    }

    private void internalAddEventListener() {
        b1.addActionListener(e -> observer.left());
        b2.addActionListener(e -> observer.up());
        b3.addActionListener(e -> observer.right());
    }

    protected void initGUI() {
        internalInitGUI();
    }

    protected void addEventListener() {
        internalAddEventListener();
    }

    public void updateUI(Context c) {
        myText1.setText(c.getDisplayText());
        myText2.setText(c.getModeText());
        myText3.setText(c.getStateText());
        // update the button labels:
        b1.setText(c.getLeftText());
        b2.setText(c.getUpText());
        b3.setText(c.getRightText());
    }

}