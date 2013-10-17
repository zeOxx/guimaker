package no.whg.GUIMaker;

import no.whg.GUIMaker.UI.GWindowManager;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA for guimaker.
 * User: snorre
 * Date: 9/24/13
 * Time: 5:56 PM
 */
public class GUIMaker {
    /**
     * Main
     *
     * @param args Command line arguments
     */
    public static void main (String[] args){
        GWindowManager.getInstance().createAndRunMainWindow();
    }
}
