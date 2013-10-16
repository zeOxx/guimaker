package no.whg.GUIMaker.UI;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 5:48 PM
 * To change this template use File | Settings | File Templates.
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
        GMenu FileMenu = new GMenu("File", KeyEvent.VK_F, 0);
        this.add(FileMenu);
        GMenu HelpMenu = new GMenu("Help", KeyEvent.VK_H, 1);
        this.add(HelpMenu);
    }
}
