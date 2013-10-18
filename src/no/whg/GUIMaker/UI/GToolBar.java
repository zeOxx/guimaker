package no.whg.GUIMaker.UI;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 5:50 PM
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
        this.add(new GButton("newtip", 0));
        this.add(new GButton("loadtip", 1));
        this.add(new GButton("savetip", 2));
        this.addSeparator();
        this.add(new GButton("preferencestip", 3));
        this.add(new GButton("generatetip", 4));
        this.addSeparator();
        this.add(new GButton("newrowtip", 5));
        this.add(new GButton("moverowuptip", 6));
        this.add(new GButton("moverowdowntip", 7));
        this.addSeparator();
        this.add(new GButton("helptip", 8));
    }
}