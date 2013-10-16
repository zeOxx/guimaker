package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.MyFileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class GButton extends JButton {
    /**
     * Constructor for Gbutton
     *
     * @param tooltip The tooltip for this button
     * @param type The type of button to create
     */
    public GButton(String tooltip, int type){
        this.setToolTipText(tooltip);
        populateG(type);
    }

    /**
     * Creates content for this button
     *
     * @param type The type of content to create
     */
    private void populateG(int type){
        switch (type){
            case 0: // New
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        MyFileManager.getInstance().newGUI();
                    }

                });
                break;
            case 1: // Load
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        MyFileManager.getInstance().loadGUI();
                    }

                });
                break;
            case 2: // Save
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        MyFileManager.getInstance().saveGUI(false);
                    }

                });
                break;
            case 3: // Preferences
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //
                    }

                });
                break;
            case 4: //Generate
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //
                    }

                });
                break;
            case 5: // New row
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //
                    }

                });
                break;
            case 6: // Move row up
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //
                    }

                });
                break;
            case 7: // Move row down
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //
                    }

                });
                break;
            case 8: // Help
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //
                    }

                });
                break;
            default:
                /* TODO: Error message(s) */
                break;
        }
    }
}
