package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.GUIMaker;
import no.whg.GUIMaker.Lang;
import no.whg.GUIMaker.MyFileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 5:51 PM
 */
public class GButton extends JButton implements Observer {
    ImageIcon icon;
    String key;
    /**
     * Constructor for GButton
     *
     * @param key The tooltip for this button
     * @param type The type of button to create
     */
    public GButton(String key, int type){
        this.key = key;
        this.setToolTipText(Lang.getInstance().getString(key));
        observe(Lang.getInstance());
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
                icon = createImageIcon("res/toolbar_icons/new.png");
                setIcon(icon);
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        MyFileManager.getInstance().newGUI();
                    }
                });
                break;
            case 1: // Load
                icon = createImageIcon("res/toolbar_icons/load.png");
                setIcon(icon);
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        MyFileManager.getInstance().loadGUI();
                    }
                });
                break;
            case 2: // Save
                icon = createImageIcon("res/toolbar_icons/save.png");
                setIcon(icon);
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        MyFileManager.getInstance().saveGUI(false);
                    }
                });
                break;
            case 3: // Preferences
                icon = createImageIcon("res/toolbar_icons/preferences.png");
                setIcon(icon);
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        GWindowManager.getInstance().createAndRunPreferencesWindow();
                    }
                });
                break;
            case 4: //Generate
                icon = createImageIcon("res/toolbar_icons/generate.png");
                setIcon(icon);
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //
                    }
                });
                break;
            case 5: // New row
                icon = createImageIcon("res/toolbar_icons/newrow.png");
                setIcon(icon);
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //
                    }
                });
                break;
            case 6: // Move row up
                icon = createImageIcon("res/toolbar_icons/arrow_up.png");
                setIcon(icon);
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //
                    }
                });
                break;
            case 7: // Move row down
                icon = createImageIcon("res/toolbar_icons/arrow_down.png");
                setIcon(icon);
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //
                    }
                });
                break;
            case 8: // Help
                icon = createImageIcon("res/toolbar_icons/help.png");
                setIcon(icon);
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        GWindowManager.getInstance().createAndRunHelpWindow();
                    }
                });
                break;
            default:
                /* TODO: Error message(s) */
                break;
        }
    }

    /**
     * Creates an icon
     *
     * @param path Where the source image is located
     * @return The icon
     */
    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = GUIMaker.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println(Lang.getInstance().getString("filenotfound") + ": " + path);
            return null;
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
        this.setToolTipText(Lang.getInstance().getString(key));
    }
}
