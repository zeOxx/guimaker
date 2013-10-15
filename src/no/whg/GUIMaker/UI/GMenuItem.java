package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.MyFileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 5:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class GMenuItem extends JMenuItem {
    /**
     * Constructor for GMenuItem
     *
     * @param tag The title of this menu item
     * @param key The hotkey for this menu item
     * @param tooltip The tooltip for this menu item
     * @param type The type of menu item to create
     */
    public GMenuItem(String tag, int key, String tooltip, int type){
        super(tag);
        this.setMnemonic(key);
        populateG(type);
        this.setToolTipText(tooltip);
    }

    /**
     * Creates content for this menu item
     *
     * @param type The type of content to create
     */
    private void populateG(int type){
        switch(type){
            case 0: // Exit
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        System.exit(0);
                    }
                });
                break;
            case 1: // Save
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        MyFileManager.getInstance().saveGUI();
                    }
                });
                break;
            case 2: // Load
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        MyFileManager.getInstance().loadGUI();
                    }
                });
                break;
            case 3: // About
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //help();
                    }
                });
                break;
            default:
                // Error message here
                break;
        }
    }
}
