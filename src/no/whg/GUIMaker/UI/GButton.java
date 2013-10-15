package no.whg.GUIMaker.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class GButton extends JButton {
    public GButton(String tooltip, int type){
        this.setToolTipText(tooltip);
        populateG(type);
    }

    private void populateG(int type){
        switch (type){
            case 0: // Move a row up
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        // moveRow();
                    }

                });
                break;
            default:
                // Error message goes here
                break;
        }
    }
}
