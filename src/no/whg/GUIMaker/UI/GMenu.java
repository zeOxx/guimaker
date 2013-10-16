package no.whg.GUIMaker.UI;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 5:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class GMenu extends JMenu {
    /**
     * Constructor for GMenu
     *
     * @param tag The title of this menu
     * @param key The hotkey for this menu
     * @param type The type of menu to create
     */
    public GMenu (String tag, int key, int type){
        super(tag);
        this.setMnemonic(key);
        populateG(type);
    }

    /**
     * Creates content for this menu
     *
     * @param type The type of content to create
     */
    private void populateG(int type){
        switch(type){
            case 0: // File
                // Add items
                this.add(new GMenuItem("New", KeyEvent.VK_N, "Create new layout", 0));
                this.add(new GMenuItem("Load", KeyEvent.VK_L, "Load from file", 1));
                this.add(new GMenuItem("Save", KeyEvent.VK_S, "Save your work", 2));
                this.add(new GMenuItem("Save as", KeyEvent.VK_A, "Save your work", 3));
                this.addSeparator();
                this.add(new GMenuItem("Preview", KeyEvent.VK_P, "Preview the created layout", 4));
                this.add(new GMenuItem("Generate code", KeyEvent.VK_G, "Generate Java code", 5));
                this.addSeparator();
                this.add(new GMenuItem("Exit", KeyEvent.VK_E, "Exit application", 6));
                break;
            case 1: // Edit
                // Add items
                this.add(new GMenuItem("New row", KeyEvent.VK_N, "Create new row", 7));
                this.addSeparator();
                this.add(new GMenuItem("Preferences", KeyEvent.VK_P, "Change settings", 8));
                break;
            case 2: // Help
                // Add items
                this.add(new GMenuItem("Help", KeyEvent.VK_H, "Help", 9));
                this.addSeparator();
                this.add(new GMenuItem("About", KeyEvent.VK_A, "Facts about this program", 10));
                break;
            default:
                /* TODO: Error message(s) */
                break;
        }
    }
}
