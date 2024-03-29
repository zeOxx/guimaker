package no.whg.GUIMaker.UI;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 5:48 PM
 */
public class GMenuBar extends JMenuBar {
    /**
     * Constructor for GMenuBar
     */
    public GMenuBar (){
        populateG();
    }

    /**
     * Creates content for this menubar
     */
    private void populateG(){
        this.add(new GMenu("file", KeyEvent.VK_F, 0));
        this.add(new GMenu("edit", KeyEvent.VK_E, 1));
        this.add(new GMenu("help", KeyEvent.VK_H, 2));
    }
}