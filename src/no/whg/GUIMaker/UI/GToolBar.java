package no.whg.GUIMaker.UI;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 5:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class GToolBar extends JToolBar {
    public GToolBar(boolean floatable){

        populateG();
        this.setFloatable(floatable);
    }

    private void populateG(){
        GButton MoveRowUpButton = new GButton("Move selected row up", 0);
        this.add(MoveRowUpButton);
    }
}
