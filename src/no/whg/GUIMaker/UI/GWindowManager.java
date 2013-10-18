package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.Element;
import no.whg.GUIMaker.Lang;
import no.whg.GUIMaker.UI.About.AboutFrame;
import no.whg.GUIMaker.UI.Help.HelpFrame;
import no.whg.GUIMaker.UI.Preferences.PreferencesDialog;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/16/13
 * Time: 4:02 PM
 */
public class GWindowManager {
    // This class is a singleton, meaning there can only be one instance of this class.
    // Call GWindowManager.getInstance() to use it.
    private static GWindowManager instance = null;
    GFrame MainWindow;
    AboutFrame AboutWindow;
    HelpFrame HelpWindow;
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

    /**
     * Creates and runs the main window
     */
    public void createAndRunMainWindow(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainWindow = new GFrame(Lang.getInstance().getString("title"));
                MainWindow.setVisible(true);
            }
        });
    }

    /**
     * Creates and runs the help window
     */
    public void createAndRunHelpWindow(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelpWindow = new HelpFrame("titlehelp");
                HelpWindow.setVisible(true);
            }
        });
    }

    /**
     * Creates and runs the about window
     */
    public void createAndRunAboutWindow(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AboutWindow = new AboutFrame(Lang.getInstance().getString("titleabout"));
                AboutWindow.setVisible(true);
            }
        });
    }

    /**
     * Creates and runs the preferences dialog
     */
    public void createAndRunPreferencesWindow(){
        PreferencesWindow = new PreferencesDialog(Lang.getInstance().getCurrentLocale());
        PreferencesWindow.showInputDialog(MainWindow);
        GWindowManager.getInstance().MainWindow.getPanel().setColumnNamesInModel();
    }

    public void createAndRunGPanelPreferencesDialog(Element e){
        GDialog prefs = new GDialog(e);
        prefs.showInputDialog(MainWindow);
    }
}
