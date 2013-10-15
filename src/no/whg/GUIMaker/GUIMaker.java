package no.whg.GUIMaker;

import no.whg.GUIMaker.UI.GFrame;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA for ${PROJECT_NAME}.
 * User: snorre
 * Date: 9/24/13
 * Time: 5:56 PM
 */
public class GUIMaker extends JFrame {
    static GFrame guim;

    public static void main (String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createUI();
            }
        });
    }

    static void createUI (){
        guim = new GFrame();
        guim.setVisible(true);
    }
}
