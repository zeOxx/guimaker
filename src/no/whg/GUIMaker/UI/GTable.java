package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.Lang;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Inge
 * Date: 10/15/13
 * Time: 5:51 PM
 */
public class GTable {
    private String[] columnNames;
    private JTable table;
    private GTableModel tableModel;
    private JScrollPane scroller;

    /**
     * Constructor
     *
     * @param contentWidth Width of the content
     * @param contentHeight Height of the content
     */
    public GTable(int contentWidth, int contentHeight) {
        initComponent(contentWidth, contentHeight);
    }

    private void initComponent(int contentWidth, int contentHeight) {
        setColumnNames();
        tableModel = new GTableModel(columnNames);
        //tableModel.addTableModelListener(new GTable.GTableModelListener());
        table = new JTable();
        table.setModel(tableModel);
        table.setSurrendersFocusOnKeystroke(true);

        if (!tableModel.hasEmptyRow())
            tableModel.addEmptyRow();

        scroller = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(contentWidth, contentHeight));
    }

    /**
     * This is not an ordinary setter, as it does not have any parameters.
     * Use it before using GTableModel as well as when language is changed
     */
    private void setColumnNames() {
        columnNames = new String[]  {Lang.getInstance().getString("type"), Lang.getInstance().getString("variable"), Lang.getInstance().getString("text"),
                                    Lang.getInstance().getString("row"), Lang.getInstance().getString("column"), Lang.getInstance().getString("rows"),
                                    Lang.getInstance().getString("columns"), Lang.getInstance().getString("fill"), Lang.getInstance().getString("anchor")};
    }

    //private class GTableModelListener implements TableModelListener {
    //}
}
