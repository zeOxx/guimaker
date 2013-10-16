package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.GUIMaker;

import javax.swing.*;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 5:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class GToolBar extends JToolBar {
    /**
     * Constructor for GToolbar
     *
     * @param floatable Boolean to set whether or not this toolbar is floatable
     */
    public GToolBar(boolean floatable){
        populateG();
        this.setFloatable(floatable);
    }

    /**
     * Creates content for this toolbar
     */
    private void populateG(){
        this.add(new GButton("New (Ctrl + N)", 0));
        this.add(new GButton("Load (Ctrl + L)", 1));
        this.add(new GButton("Save (Ctrl + S)", 2));
        this.addSeparator();
        this.add(new GButton("Preferences", 3));
        this.add(new GButton("Generate Java code", 4));
        this.addSeparator();
        this.add(new GButton("Create new row", 5));
        this.add(new GButton("Move selected row up", 6));
        this.add(new GButton("Move selected row down", 7));
        this.addSeparator();
        this.add(new GButton("Help", 8));

    }
}
