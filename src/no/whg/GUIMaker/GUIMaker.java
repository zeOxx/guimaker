package no.whg.GUIMaker;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * Created with IntelliJ IDEA for ${PROJECT_NAME}.
 * User: snorre
 * Date: 9/24/13
 * Time: 5:56 PM
 */
public class GUIMaker extends JFrame {
    private ArrayList rowList = new ArrayList<RowElement>();
    protected FileChooser fc = new FileChooser();
    static GUIMaker guim;

    public GUIMaker (){
        createMenu();
        setTitle("GUIMaker");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main (String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createUI();
            }
        });
    }

    static void createUI (){
        guim = new GUIMaker();
        guim.setVisible(true);
    }

    private void createMenu(){
        // Menu bar
        JMenuBar menu = new JMenuBar();
        // "File" menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem fileMenuExit = new JMenuItem("Exit");
        fileMenuExit.setMnemonic(KeyEvent.VK_E);
        fileMenuExit.setToolTipText("Exit application");
        fileMenuExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        JMenuItem fileMenuSave = new JMenuItem("Save");
        fileMenuSave.setMnemonic(KeyEvent.VK_S);
        fileMenuSave.setToolTipText("Save your work");
        fileMenuSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                saveGUI();
            }
        });

        JMenuItem fileMenuLoad = new JMenuItem("Load");
        fileMenuLoad.setMnemonic(KeyEvent.VK_L);
        fileMenuLoad.setToolTipText("Load from file");
        fileMenuLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                loadGUI();
            }
        });

        fileMenu.add(fileMenuSave);
        fileMenu.add(fileMenuLoad);
        fileMenu.addSeparator();
        fileMenu.add(fileMenuExit);
        menu.add(fileMenu);

        // "About" menu
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

        JMenuItem helpMenuAbout = new JMenuItem("About");
        helpMenuAbout.setMnemonic(KeyEvent.VK_A);
        helpMenuAbout.setToolTipText("Facts about this program");
        helpMenuAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //help();
            }
        });

        helpMenu.add(helpMenuAbout);
        menu.add(helpMenu);

        setJMenuBar(menu);

        // Toolbar
        JToolBar toolbar = new JToolBar();

        JButton rowUpButton = new JButton();
        toolbar.add(rowUpButton);
        rowUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                moveRow();
            }

        });

        toolbar.setFloatable(false);
        
        add(toolbar, BorderLayout.NORTH);

        // Contents
        JTable table = new JTable(new ComponentTable());
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.getModel().addTableModelListener(table);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    private void moveRow(){
        // TODO: something
    }

    public void loadGUI (){
        setRowList(fc.loadGUI());
    }

    public void saveGUI (){
        fc.saveGUI(getRowList());
    }

    public void previewGUI (){

    }

    public void saveSource (){

    }

    public ArrayList getRowList(){
        return this.rowList;
    }

    private void setRowList(ArrayList arg){
        this.rowList = arg;
    }

    public void addToRowList(RowElement arg){
        this.rowList.add(arg);
    }

    public void removeIndexFromRowList(int arg){
        this.rowList.remove(arg);
    }

    public void removeObjectFromRowList(RowElement arg){
        this.rowList.remove(arg);
    }
}
