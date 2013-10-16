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
    public GFrame (String tag){
        populateG();
        setTitle(tag);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
