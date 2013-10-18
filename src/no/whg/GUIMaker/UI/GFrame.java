package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.CodeGenerator;
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
    private GPanel panel;

    /**
     * KeyEventDispatcher to handle global key bindings
     */
    private class MyDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
                    switch (e.getKeyCode()){
                        case KeyEvent.VK_N:
                            MyFileManager.getInstance().newGUI();
                            GWindowManager.getInstance().MainWindow.getPanel().resetData();
                            break;
                        case KeyEvent.VK_L:
                            MyFileManager.getInstance().loadGUI();
                            GWindowManager.getInstance().MainWindow.getPanel().setData(MyFileManager.getInstance().getRowList());
                            break;
                        case KeyEvent.VK_S:
                            MyFileManager.getInstance().saveGUI(false, GWindowManager.getInstance().MainWindow.getPanel().getData());
                            break;
                        case KeyEvent.VK_P:
                            GWindowManager.getInstance().createAndRunPreferencesWindow();
                            break;
                        case KeyEvent.VK_G:
                            CodeGenerator.getInstance().assembleAndPrintFile(GWindowManager.getInstance().MainWindow.getPanel().getData());
                            break;
                        case KeyEvent.VK_R:
                            GWindowManager.getInstance().MainWindow.getPanel().addEmptyRow();
                            break;
                        // These two buttons have the same functionality (+)
                        case KeyEvent.VK_ADD:
                        case KeyEvent.VK_PLUS:
                            GWindowManager.getInstance().MainWindow.getPanel().moveRowUp();
                            break;
                        // These two buttons have the same functionality (-)
                        case KeyEvent.VK_SUBTRACT:
                        case KeyEvent.VK_MINUS:
                            GWindowManager.getInstance().MainWindow.getPanel().moveRowDown();
                            break;
                        case KeyEvent.VK_H:
                            GWindowManager.getInstance().createAndRunHelpWindow();
                            break;
                        default:
                            break;
                    }
                }
            }
            return false;
        }
    }

    /**
     * Constructor for GFrame
     *
     * @param tag The title of this GFrame
     */
    public GFrame (String tag){
        populateG();
        setTitle(tag);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
    }

    /**
     * Adds content to this GFrame
     */
    private void populateG(){
        // Navigation bars
        setJMenuBar(new GMenuBar());
        add(new GToolBar(false), BorderLayout.NORTH);

        panel = new GPanel(700, 300);
        this.getContentPane().add(panel);


        // Contents
        /* TODO: Add panel */
        //GPanel Table = new GPanel(new ComponentTable());
        //panel.setPreferredScrollableViewportSize(new Dimension(500, 70));
        //panel.setFillsViewportHeight(true);
        //panel.getModel().addTableModelListener(panel);

        //Create the scroll pane and add the panel to it.
        //JScrollPane scrollPane = new JScrollPane(panel);

        //Add the scroll pane to this panel.
        //add(scrollPane);
    }

    public GPanel getPanel() {
        return panel;
    }

}
