package no.whg.GUIMaker;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 * Created with IntelliJ IDEA for guimaker
 * User: Snorre
 * Date: 10/2/13
 * Time: 11:16 PM
 */
public class ComponentTable extends AbstractTableModel implements TableModelListener {
    private String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};
    /*private String[] columnNames = {"Type",
            "Variable Name",
            "Text",
            "Row",
            "Column",
            "Rows",
            "Columns",
            "Fill",
            "Anchor"};*/
    private Object[][] data = {
            {"Kathy", "Smith",
                    "Snowboarding", new Integer(5), new Boolean(false)},
            {"John", "Doe",
                    "Rowing", new Integer(3), new Boolean(true)},
            {"Sue", "Black",
                    "Knitting", new Integer(2), new Boolean(false)},
            {"Jane", "White",
                    "Speed reading", new Integer(20), new Boolean(true)},
            {"Joe", "Brown",
                    "Pool", new Integer(10), new Boolean(false)}
    };

    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);

        // Do something with the coreElement...
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the coreElement/cell address is constant,
        //no matter where the cell appears onscreen.
        /*if (col < 2) {
            return false;
        } else {
            return true;
        }*/
        return true;
    }

    /*
     * Don't need to implement this method unless your table's
     * coreElement can change.
     */
    public void setValueAt(Object value, int row, int col) {
        /*if (DEBUG) {
            System.out.println("Setting value at " + row + "," + col
                    + " to " + value
                    + " (an instance of "
                    + value.getClass() + ")");
        }*/

        data[row][col] = value;
        fireTableCellUpdated(row, col);

        /*if (DEBUG) {
            System.out.println("New value of coreElement:");
            printDebugData();
        }*/
    }

    private void printDebugData() {
        int numRows = getRowCount();
        int numCols = getColumnCount();

        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + data[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

}
