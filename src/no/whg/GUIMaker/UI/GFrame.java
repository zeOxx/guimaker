package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.MyFileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 5:53 PM
 */
public class GFrame extends JFrame {
    /**
     * KeyEventDispatcher to handle global key bindings
     */
    private class MyDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                // New
                if ((e.getKeyCode() == KeyEvent.VK_N)){
                    if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
                        MyFileManager.getInstance().newGUI();
                    }
                }
                // Load
                else if ((e.getKeyCode() == KeyEvent.VK_L)){
                    if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
                        MyFileManager.getInstance().loadGUI();
                    }
                }
                // Save
                else if ((e.getKeyCode() == KeyEvent.VK_S)){
                    if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
                        MyFileManager.getInstance().saveGUI(false);
                    }
                }
            }
            return false;
        }
    }

    public GFrame (String tag){
        populateG();
        setTitle(tag);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
    }

    private void populateG(){
        // Navigation bars
        setJMenuBar(new GMenuBar());
        add(new GToolBar(false), BorderLayout.NORTH);

        // Contents
        /* TODO: Add table */
        //GTable Table = new GTable(new ComponentTable());
        //table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        //table.setFillsViewportHeight(true);
        //table.getModel().addTableModelListener(table);

        //Create the scroll pane and add the table to it.
        //JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        //add(scrollPane);
    }
}
