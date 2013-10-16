package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.GUIMaker;
import no.whg.GUIMaker.MyFileManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class GButton extends JButton {
    ImageIcon icon;
    /**
     * Constructor for GButton
     *
     * @param tooltip The tooltip for this button
     * @param type The type of button to create
     */
    public GButton(String tooltip, int type){
        this.setToolTipText(tooltip);
        populateG(type);
    }

    public GButton(String tooltip, ImageIcon i, int type){
        super(i);
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
                        //
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
                        //
                    }

                });
                break;
            default:
                /* TODO: Error message(s) */
                break;
        }
    }

    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = GUIMaker.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
