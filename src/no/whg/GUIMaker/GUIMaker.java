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

    /**
     * Main
     *
     * @param args Command line arguments
     */
    public static void main (String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createUI();
            }
        });
    }

    /**
     * Creates the user interface and sets it as visible
     */
    static void createUI (){
        guim = new GFrame("GUIMaker");
        guim.setVisible(true);
    }
}
