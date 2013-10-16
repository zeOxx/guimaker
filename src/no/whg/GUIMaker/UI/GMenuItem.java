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
     * TODO: add functionality to switch cases 4, 5, 7-10
     *
     * @param type The type of content to create
     */
    private void populateG(int type){
        switch(type){
            case 0: // File/New
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        MyFileManager.getInstance().newGUI();
                    }
                });
                break;
            case 1: // File/Load
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        MyFileManager.getInstance().loadGUI();
                    }
                });
                break;
            case 2: // File/Save
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        MyFileManager.getInstance().saveGUI(false);
                    }
                });
                break;
            case 3: // File/Save as
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        MyFileManager.getInstance().saveGUI(true);
                    }
                });
                break;
            case 4: // File/Preview
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //preview();
                    }
                });
                break;
            case 5: // File/Generate code
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //generateCode();
                    }
                });
                break;
            case 6: // File/Exit
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        System.exit(0);
                    }
                });
                break;
            case 7: // Edit/New row
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //newRow();
                    }
                });
                break;
            case 8: // Edit/Preferences
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //preferences();
                    }
                });
                break;
            case 9: // Help/Help
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //help();
                    }
                });
                break;
            case 10: // Help/About
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        GWindowManager.getInstance().createAndRunAboutWindow();
                    }
                });
                break;
            default:
                /* TODO: Error message(s) */
                break;
        }
    }
}
