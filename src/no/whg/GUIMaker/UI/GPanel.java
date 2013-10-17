package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.Lang;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Inge
 * Date: 10/15/13
 * Time: 5:51 PM
 */
public class GPanel extends JPanel{
    private String[] columnNames;
    private JTable table;
    private GTableModel tableModel = null;
    private JScrollPane scroller;

    /**
     * Constructor
     *
     * @param contentWidth Width of the content
     * @param contentHeight Height of the content
     */
    public GPanel(int contentWidth, int contentHeight) {
        initComponent(contentWidth, contentHeight);
    }

    /**
     * Initializes the componentsin the JPanel
     *
     * @param contentWidth Width of the content
     * @param contentHeight Height of the content
     */
    private void initComponent(int contentWidth, int contentHeight) {
        setColumnNames();
        tableModel = new GTableModel(columnNames);
        tableModel.addTableModelListener(new GPanel.GTableModelListener());
        table = new JTable();
        table.setModel(tableModel);
        table.setSurrendersFocusOnKeystroke(true);

        if (!tableModel.hasEmptyRow())
           tableModel.addEmptyRow();

        scroller = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(contentWidth, contentHeight));

        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);

        // Add a combobox to the first column, letting the user choose the type of the element
        TableColumn typeColumn = table.getColumnModel().getColumn(0);
        JComboBox typeBox = new JComboBox();
        typeBox.setName("typeBox");
        typeBox.addItem("JLabel");
        typeBox.addItem("JButton");
        typeBox.addItem("JTextArea");
        typeBox.addItem("JTextField");
        typeBox.addActionListener(new comboBoxListener());
        typeColumn.setCellEditor(new DefaultCellEditor(typeBox));
    }

    /**
     *
     * @param row
     */
    public void highlightLastRow(int row) {
        int lastrow = tableModel.getRowCount();

        if (row == lastrow - 1)
            table.setRowSelectionInterval(lastrow - 1, lastrow - 1);
        else
            table.setRowSelectionInterval(row + 1, row + 1);

        table.setColumnSelectionInterval(0, 0);
    }

    /**
     * This is not an ordinary setter, as it does not have any parameters.
     * Use it before using GTableModel as well as when language is changed
     */
    private void setColumnNames() {
        columnNames = new String[] {Lang.getInstance().getString("type"), Lang.getInstance().getString("variable"), Lang.getInstance().getString("text"),
                                    Lang.getInstance().getString("row"), Lang.getInstance().getString("column"), Lang.getInstance().getString("rows"),
                                    Lang.getInstance().getString("columns"), Lang.getInstance().getString("fill"), Lang.getInstance().getString("anchor")};
    }

    /**
     * Inner class which implements TableModelListener.
     */
    private class GTableModelListener implements TableModelListener {

        /**
         * Listener mostly for debug purposes.
         * Prints line to console of which cell is currently in focus
         *
         * @param event event fired by user moving around in the table
         */
        public void tableChanged(TableModelEvent event) {
            if (event.getType() == TableModelEvent.UPDATE) {
                int column = event.getColumn();
                int row = event.getFirstRow();

                System.out.println("row: " + row + " column: " + column);

                table.setColumnSelectionInterval(column + 1, column + 1);
                table.setRowSelectionInterval(row, row);
            }
        }
    }

    /**
     * Adds an empty row in the model
     */
    public void addEmptyRow() {
        tableModel.addEmptyRow();
    }

    private class comboBoxListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox)e.getSource();

            if (cb.getName().equals("typeBox")) {

            }
        }
    }
}
