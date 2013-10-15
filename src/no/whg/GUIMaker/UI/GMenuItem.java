package no.whg.GUIMaker.UI;

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
    public GMenuItem(String tag, int key, String tooltip, int type){
        super(tag);
        this.setMnemonic(key);
        addActionListener(type);
        this.setToolTipText(tooltip);
    }

    private void addActionListener(int type){
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
                        //saveGUI();
                    }
                });
                break;
            case 2: // Load
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //loadGUI();
                    }
                });
                break;
            case 3: // About
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //help();
                    }
                });
        }
    }
}
