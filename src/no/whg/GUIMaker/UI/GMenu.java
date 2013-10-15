package no.whg.GUIMaker.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 5:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class GMenu extends JMenu {
    public GMenu (String tag, int key, int type){
        super(tag);
        this.setMnemonic(key);
        populateG(type);
    }

    private void populateG(int type){
        switch(type){
            case 0: // File
                GMenuItem FileMenuExit = new GMenuItem("Exit", KeyEvent.VK_E, "Exit application", 0);
                GMenuItem FileMenuSave = new GMenuItem("Save", KeyEvent.VK_S, "Save your work", 1);
                GMenuItem FileMenuLoad = new GMenuItem("Load", KeyEvent.VK_L, "Load from file", 2);
                this.add(FileMenuSave);
                this.add(FileMenuLoad);
                this.addSeparator();
                this.add(FileMenuExit);
                break;
            case 1: // Help
                GMenuItem HelpMenuAbout = new GMenuItem("About", KeyEvent.VK_A, "Facts about this program", 3);
                this.add(HelpMenuAbout);
                break;
            case 2:
                //this.add();
                break;
            default:
                //Error message here
                break;
        }
    }
}
