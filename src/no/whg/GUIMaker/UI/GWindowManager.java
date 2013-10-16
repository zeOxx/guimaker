package no.whg.GUIMaker.UI;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/16/13
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class GWindowManager {
    // This class is a singleton, meaning there can only be one instance of this class.
    // Call Language.getInstance() to use it.
    private static GWindowManager instance = null;
    GFrame MainWindow;

    /**
     * Default constructor.
     * Exists only to defeat instantiation.
     */
    protected GWindowManager() {
        // Exists only to defeat instantiation.
    }

    /**
     * Singleton
     *
     * @return Returns the one instance of the class
     */
    public static GWindowManager getInstance() {
        if(instance == null) {
            instance = new GWindowManager();
        }
        return instance;
    }

    public void createAndRunMainWindow(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainWindow = new GFrame("GUIMaker");
                MainWindow.setVisible(true);
            }
        });
    }

    public void createAndRunHelpWindow(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                /* TODO: create and run help window */
            }
        });
    }

    public void createAndRunAboutWindow(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                /* TODO: create and run about window */
            }
        });
    }
}
