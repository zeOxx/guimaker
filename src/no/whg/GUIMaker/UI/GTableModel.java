package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.CoreElement;
import no.whg.GUIMaker.Lang;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

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
    private Vector data;

    /**
     *
     * @return
     */
    public int getColumnCount(){
        return columnNames.length;
    }

    /**
     *
     * @return
     */
    public int getRowCount(){
        return data.size();
    }

    /**
     * Since every cell in the table is editable, this function will always return true.
     * The parameters are useless
     *
     * @param row
     * @param column
     * @return Will always return true
     */
    public boolean isCellEditable(int row, int column) {
        return true;
    }

    /**
     * Returns the value at a given cell
     *
     * @param row Which row the cell is in
     * @param column Which column the cell is in
     * @return Returns the value of a desired cell
     */
    public Object getValueAt(int row, int column) {
        CoreElement element = (CoreElement)data.get(row);
        switch (column) {
            case 0:
                return element.getType();
            case 1:
                return element.getVarName();
            case 2:
                return element.getText();
            case 3:
                return element.getRow();
            case 4:
                return element.getColumn();
            case 5:
                return element.getX();
            case 6:
                return element.getY();
            case 7:
                return element.getFill();
            case 8:
                return element.getAnchor();
            default:
                return new Object();
        }
    }

    /**
     * Sets the value of a given cell
     *
     * @param value
     * @param row
     * @param column
     */
    public void setValueAt(Object value, int row, int column) {
        CoreElement element = (CoreElement)data.get(row);
        switch (column) {
            case 0:
                element.setType((String)value);
                break;
            case 1:
                element.setVarName((String)value);
                break;
            case 2:
                element.setText((String)value);
                break;
            case 3:
                element.setRow((String)value);
                break;
            case 4:
                element.setColumn((String)value);
                break;
            case 5:
                element.setX((String)value);
                break;
            case 6:
                element.setY((String)value);
                break;
            case 7:
                element.setFill((String)value);
                break;
            case 8:
                element.setAnchor((String)value);
                break;
            default:
                System.out.println("invalid index");
                break;
        }
        fireTableCellUpdated(row, column);
    }

    /**
     * Returns the name of a column
     *
     * @param col
     * @return Returns the name of the column
     */
    public String columnName(int col) {
        return columnNames[col];
    }

    /**
     * Adds an empty row
     */
    public void addEmptyRow() {
        data.add(new CoreElement(data.size()));
        fireTableRowsInserted(
                data.size() - 1,
                data.size() - 1);
    }
}
