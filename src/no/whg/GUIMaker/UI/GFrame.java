package no.whg.GUIMaker.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 5:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class GFrame extends JFrame {
    public GFrame (){
        populateG();
        setTitle("GUIMaker");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void populateG(){
        // Menu bar
        GMenuBar MainMenu = new GMenuBar();
        GToolBar Toolbar = new GToolBar(false);

        setJMenuBar(MainMenu);
        add(Toolbar, BorderLayout.NORTH);

        // Contents
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
