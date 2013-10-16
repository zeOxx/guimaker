package no.whg.GUIMaker.UI;

import javax.swing.table.AbstractTableModel;

/**
 * Created with IntelliJ IDEA.
 * Package: no.whg.GUIMaker.UI
 * User: Inge
 * Date: 16.10.13
 * Time: 17:10
 */
public class GTableModel extends AbstractTableModel {
    private String[] columnNames;
    private Object[][] data;

    public int getColumnCount(){
        return columnNames.length;
    }

    public int getRowCount(){
        return data.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
}
