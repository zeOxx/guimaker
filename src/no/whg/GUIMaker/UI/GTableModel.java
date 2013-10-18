package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.Element;

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
    protected String[] columnNames;
    private Vector<Element> data;

    /**
     * Constructor
     * @param columnNames Names of the individual columns
     */
    public GTableModel(String[] columnNames){
        this.columnNames = columnNames;
        data = new Vector<Element>();
    }

    /**
     *
     * @return Returns the amount of columns
     */
    public int getColumnCount(){
        return columnNames.length;
    }

    /**
     *
     * @return Returns the amount of rows
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
        Element element = (Element)data.get(row);
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
                return element.getRows();
            case 6:
                return element.getColumns();
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
    @Override
    public void setValueAt(Object value, int row, int column) {
        Element element = (Element)data.get(row);
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
                element.setRows((String) value);
                break;
            case 6:
                element.setColumns((String) value);
                break;
            case 7:
                element.setFill(value.toString());
                break;
            case 8:
                element.setAnchor(value.toString());
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
    public String getColumnName(int col) {
            return columnNames[col];
    }

    /**
     *
     * @return Returns wether the table has an empty row
     */
    public boolean hasEmptyRow() {
        if (data.size() == 0)
            return false;

        Element element = (Element)data.get(data.size() - 1);

        if (element.getType().trim().equals("") &&
            element.getVarName().trim().equals("") &&
            element.getText().trim().equals("") &&
            element.getRow().trim().equals("") &&
            element.getColumn().trim().equals("") &&
            element.getRows().trim().equals("") &&
            element.getColumns().trim().equals("") &&
            element.getFill().trim().equals("") &&
            element.getAnchor().trim().equals(""))
        {
            return true;
        }
        else return false;
    }

    /**
     * Adds an empty row
     */
    public void addEmptyRow() {
        data.add(new Element(data.size()));
        fireTableRowsInserted(
                data.size() - 1,
                data.size() - 1);
    }

    public void deleteRow(int row) {
        if (row >= 0 && row < getRowCount()) {
            data.remove(row);
            fireTableRowsDeleted(row, row);
        }
    }

    public Vector<Element> getData() {
        return data;
    }

    public void setData(Vector<Element> data) {
        this.data = data;
    }

    public void resetData() {
        this.data = new Vector<Element>();
        fireTableDataChanged();
    }
}
