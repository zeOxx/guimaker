package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.CodeGenerator;
import no.whg.GUIMaker.Lang;
import no.whg.GUIMaker.MyFileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 5:49 PM
 */
public class GMenuItem extends JMenuItem implements Observer {
    String text;
    String tooltip;
    /**
     * Constructor for GMenuItem
     *
     * @param tag The title of this menu item
     * @param key The hotkey for this menu item
     * @param tooltip The tooltip for this menu item
     * @param type The type of menu item to create
     */
    public GMenuItem(String tag, int key, String tooltip, int type){
        this.text = tag;
        this.tooltip = tooltip;
        this.setMnemonic(key);
        this.setText(Lang.getInstance().getString(tag));
        this.setToolTipText(Lang.getInstance().getString(tooltip));
        populateG(type);
        observe(Lang.getInstance());
    }

    /**
     * Creates content for this menu item
     *
     * @param type The type of content to create
     */
    private void populateG(int type){
        switch(type){
            case 0: // File/New
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        MyFileManager.getInstance().newGUI();
                        GWindowManager.getInstance().MainWindow.getPanel().resetData();
                    }
                });
                break;
            case 1: // File/Load
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        MyFileManager.getInstance().loadGUI();
                        GWindowManager.getInstance().MainWindow.getPanel().setData(MyFileManager.getInstance().getRowList());
                    }
                });

                break;
            case 2: // File/Save
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        MyFileManager.getInstance().saveGUI(false, GWindowManager.getInstance().MainWindow.getPanel().getData());
                    }
                });
                break;
            case 3: // File/Save as
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        MyFileManager.getInstance().saveGUI(true, GWindowManager.getInstance().MainWindow.getPanel().getData());
                    }
                });
                break;
            case 4: // File/Preview
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //preview();
                    }
                });
                break;
            case 5: // File/Generate code
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        CodeGenerator.getInstance().assembleAndPrintFile(GWindowManager.getInstance().MainWindow.getPanel().getData());
                    }
                });
                break;
            case 6: // File/Exit
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        System.exit(0);
                    }
                });
                break;
            case 7: // Edit/New row
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        GWindowManager.getInstance().MainWindow.getPanel().addEmptyRow();
                    }
                });
                break;
            case 8: // Edit/Preferences
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        GWindowManager.getInstance().createAndRunPreferencesWindow();
                    }
                });
                break;
            case 9: // Help/Help
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        GWindowManager.getInstance().createAndRunHelpWindow();
                    }
                });
                break;
            case 10: // Help/About
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        GWindowManager.getInstance().createAndRunAboutWindow();
                    }
                });
                break;
            default:
                /* TODO: Error message(s) */
                break;
        }
    }

    /**
     * Starts observing an Observable
     *
     * @param o The Observable to observe
     */
    public void observe(Observable o) {
        o.addObserver(this);
    }

    /**
     * Called when notified by the observable. Updates content to reflect the change
     *
     * @param o The Observable being observed
     * @param arg The argument passed to the observer
     */
    @Override
    public void update(Observable o, Object arg) {
        this.setToolTipText(Lang.getInstance().getString(tooltip));
        this.setText(Lang.getInstance().getString(text));
    }
}
