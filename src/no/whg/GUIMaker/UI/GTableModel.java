package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.Lang;

import javax.swing.table.AbstractTableModel;

/**
 * Created with IntelliJ IDEA.
 * Package: no.whg.GUIMaker.UI
 * User: Inge
 * Date: 16.10.13
 * Time: 17:10
 */
public class GTableModel extends AbstractTableModel {
    private String[] columnNames = {Lang.getInstance().getString("type"), Lang.getInstance().getString("variable"), Lang.getInstance().getString("text"),
                                    Lang.getInstance().getString("row"), Lang.getInstance().getString("column"), Lang.getInstance().getString("rows"),
                                    Lang.getInstance().getString("columns"), Lang.getInstance().getString("fill"), Lang.getInstance().getString("anchor")};
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

    public String columnName(int col) {
        return columnNames[col];
    }
}
