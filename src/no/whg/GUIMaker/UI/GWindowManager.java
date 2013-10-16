package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.Lang;
import no.whg.GUIMaker.UI.About.AboutFrame;
import no.whg.GUIMaker.UI.Preferences.PreferencesDialog;

import javax.swing.*;
import java.util.Locale;

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
    AboutFrame AboutWindow;
    PreferencesDialog PreferencesWindow;

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
                AboutWindow = new AboutFrame("About GUIMaker");
                AboutWindow.setVisible(true);
            }
        });
    }

    public void createAndRunPreferencesWindow(){
        PreferencesWindow = new PreferencesDialog(Lang.getInstance().getCurrentLocale());
        PreferencesWindow.showInputDialog(MainWindow);
    }
}
