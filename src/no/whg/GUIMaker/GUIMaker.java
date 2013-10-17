package no.whg.GUIMaker;

import no.whg.GUIMaker.UI.GWindowManager;

/**
 * Created with IntelliJ IDEA for guimaker.
 * User: snorre
 * Date: 9/24/13
 * Time: 5:56 PM
 */
public class GUIMaker {
    /**
     * main tells GWindowmanager to create the main window.
     *
     * @param args Command line arguments
     */
    public static void main (String[] args){
        GWindowManager.getInstance().createAndRunMainWindow();
    }
}
