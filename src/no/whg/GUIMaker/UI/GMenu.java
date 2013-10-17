package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.Lang;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 5:49 PM
 */
public class GMenu extends JMenu implements Observer {
    String text;
    /**
     * Constructor for GMenu
     *
     * @param text The title of this menu
     * @param key The hotkey for this menu
     * @param type The type of menu to create
     */
    public GMenu (String text, int key, int type){
        this.text = text;
        this.setText(Lang.getInstance().getString(text));
        this.setMnemonic(key);
        populateG(type);
        observe(Lang.getInstance());
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
                this.add(new GMenuItem("new", KeyEvent.VK_N, "newlong", 0));
                this.add(new GMenuItem("load", KeyEvent.VK_L, "loadlong", 1));
                this.add(new GMenuItem("save", KeyEvent.VK_S, "savelong", 2));
                this.add(new GMenuItem("saveas", KeyEvent.VK_A, "saveaslong", 3));
                this.addSeparator();
                this.add(new GMenuItem("preview", KeyEvent.VK_P, "previewlong", 4));
                this.add(new GMenuItem("generate", KeyEvent.VK_G, "generatelong", 5));
                this.addSeparator();
                this.add(new GMenuItem("exit", KeyEvent.VK_E, "exitlong", 6));
                break;
            case 1: // Edit
                // Add items
                this.add(new GMenuItem("newrow", KeyEvent.VK_N, "newrowlong", 7));
                this.addSeparator();
                this.add(new GMenuItem("preferences", KeyEvent.VK_P, "preferenceslong", 8));
                break;
            case 2: // Help
                // Add items
                this.add(new GMenuItem("help", KeyEvent.VK_H, "help", 9));
                this.addSeparator();
                this.add(new GMenuItem("about", KeyEvent.VK_A, "aboutlong", 10));
                break;
            default:
                /* TODO: Error message(s) */
                break;
        }
    }

    /**
     * Starts observing an Observable
     *
     * @param o The Observable to observe
     */
    public void observe(Observable o) {
        o.addObserver(this);
    }

    /**
     * Called when notified by the observable. Updates content to reflect the change
     *
     * @param o The Observable being observed
     * @param arg The argument passed to the observer
     */
    @Override
    public void update(Observable o, Object arg) {
        this.setText(Lang.getInstance().getString(text));
    }
}
