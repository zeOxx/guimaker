package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.Element;
import no.whg.GUIMaker.GUIMaker;
import no.whg.GUIMaker.Lang;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    private JPopupMenu mousePop;

    private ImageIcon[] fillImages;
    private String[] fillStrings = { "none", "all", "vert", "hori" };

    private ImageIcon[] anchorImages;
    private String[] anchorStrings = { "C", "Cs", "E", "Es", "N", "Ns", "NE", "NEs", "NW", "S", "Ss", "SE", "SEs", "SW", "W" };

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
        mousePop = new JPopupMenu();
        JMenuItem propItem = new JMenuItem(Lang.getInstance().getString("properties"));
        propItem.addActionListener(new ActionListenerPopup());
        JMenuItem deleteItem = new JMenuItem(Lang.getInstance().getString("delete"));
        deleteItem.addActionListener(new ActionListenerPopup());
        mousePop.add(propItem);
        mousePop.add(deleteItem);

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

        /**
         * Add a combobox to the first column, letting the user choose the type of the element
         */
        TableColumn typeColumn = table.getColumnModel().getColumn(0);
        JComboBox typeBox = new JComboBox();
        typeBox.setName("typeBox");

        /**
         * Adds all types
         */
        for (int i = 0; i < Element.types.length; i++)
            typeBox.addItem(Element.types[i]);

        typeColumn.setCellEditor(new DefaultCellEditor(typeBox));

        setupImages();
        changeColumnSize();

        table.addMouseListener(new PopupListener());
    }

    /**
     * Sets up the images
     */
    private void setupImages() {
        /**
         * Adds a combobox to the eigth column, letting the user select fill
         */
        TableColumn fillColumn = table.getColumnModel().getColumn(7);

        /**
         * Sets up the fillImages array
         */
        fillImages = new ImageIcon[fillStrings.length];
        Integer[] imageIndex = new Integer[fillStrings.length];

        for (int i = 0; i < fillStrings.length; i++) {
            imageIndex[i] = new Integer(i);
            fillImages[i] = createImageIcon("res/table_icons/fill_" + fillStrings[i] + ".png");
        }

        JComboBox fillBox = new JComboBox(imageIndex);
        fillBox.setName("fillBox");

        FillBoxRenderer fillRenderer = new FillBoxRenderer();
        fillRenderer.setPreferredSize(new Dimension(100, 20));
        fillBox.setRenderer(fillRenderer);
        fillBox.setMaximumRowCount(4);
        fillColumn.setCellEditor(new DefaultCellEditor(fillBox));

        /**
         * Adds a combobox to the ninth column, letting the user select the anchor point
         */
        TableColumn anchorColumn = table.getColumnModel().getColumn(8);

        /**
         * Sets up teh anchorImages array
         */
        anchorImages = new ImageIcon[anchorStrings.length];
        imageIndex = new Integer[anchorStrings.length];

        for (int i = 0; i < anchorStrings.length; i++) {
            imageIndex[i] = new Integer(i);
            anchorImages[i] = createImageIcon("res/table_icons/anchor_" + anchorStrings[i] + ".png");
        }

        JComboBox anchorBox = new JComboBox(imageIndex);
        anchorBox.setName("anchorBox");

        AnchorBoxRenderer anchorRenderer = new AnchorBoxRenderer();
        anchorRenderer.setPreferredSize(new Dimension(100, 20));
        anchorBox.setRenderer(anchorRenderer);
        anchorBox.setMaximumRowCount(4);
        anchorColumn.setCellEditor(new DefaultCellEditor(anchorBox));
    }

    /**
     * Sets size of the columns
     */
    private void changeColumnSize() {
        TableColumn col = null;

        for (int i = 0; i < table.getModel().getColumnCount(); i++) {
            col = table.getColumnModel().getColumn(i);

            if (i == 0 || i == 1 || i == 2 || i == 7 || i == 8)
                col.setPreferredWidth(100);
            else
                col.setPreferredWidth(50);
        }
    }

    /**
     * Reuturns an ImageIcon, if the path is found
     *
     * @param path path of the given image
     * @return Returns the image if the path is valid
     */
    private ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = GUIMaker.class.getResource(path);
        if (imgURL != null)
            return new ImageIcon(imgURL);
        else
            System.err.println("Couldn't find file: " + path);
            return null;
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

                table.setColumnSelectionInterval(column, column);
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

    public void deleteRow(int row) {
        tableModel.deleteRow(row);
    }



    /**
     * Moves the selected row up
     */
    public void moveRowUp() {
        int row = table.getSelectedRow();

        if (row > 0) {
            System.out.println("COLS: " + table.getModel().getColumnCount() + " ROW1: " + row + " ROW2: " + (row - 1));

            for (int col = 0; col < table.getModel().getColumnCount(); col++) {
                Object o1 = table.getModel().getValueAt(row, col);
                Object o2 = table.getModel().getValueAt(row - 1, col);
                System.out.println("O1: " + o1 + " O2: " + o2);
                table.getModel().setValueAt(o1, row - 1, col);
                table.getModel().setValueAt(o2, row, col);
            }
        } else
            Toolkit.getDefaultToolkit().beep();
    }

    /**
     * Moves the selected row down
     */
    public void moveRowDown() {
        int row = table.getSelectedRow();

        System.out.println("Rowcount: " + table.getModel().getRowCount() + " Row: " + row);

        if (row < table.getModel().getRowCount() - 1 && row >= 0) {

            for(int col = 0; col < table.getModel().getColumnCount(); col++) {
                Object o1 = table.getModel().getValueAt(row, col);
                Object o2 = table.getModel().getValueAt(row + 1, col);
                table.getModel().setValueAt(o1, row + 1, col);
                table.getModel().setValueAt(o2, row, col);
            }
        } else
            Toolkit.getDefaultToolkit().beep();
    }

    /**
     * Inner class for custom fillboxrenderer.
     */
    private class FillBoxRenderer extends JLabel implements ListCellRenderer{
        /**
         * Constructor.
         * Makes sure the image is aligned properly
         */
        public FillBoxRenderer() {
            setOpaque(true);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }

        /**
         *
         * @param list
         * @param value
         * @param index
         * @param isSelected
         * @param hasFocus
         * @return
         */
        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                                                      int index, boolean isSelected, boolean hasFocus)
        {
            int selectedIndex = ((Integer)value).intValue();

            if(isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            }
            else {
                setBackground(list.getBackground());
                setBackground(list.getForeground());
            }

            ImageIcon icon = fillImages[selectedIndex];
            setIcon(icon);

            return this;
        }
    }

    /**
     * Inner class for custom anchorboxrenderer.
     */
    private class AnchorBoxRenderer extends JLabel implements ListCellRenderer{
        /**
         * Constructor.
         * Makes sure the image is aligned properly
         */
        public AnchorBoxRenderer() {
            setOpaque(false);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }

        /**
         *
         * @param list
         * @param value
         * @param index
         * @param isSelected
         * @param hasFocus
         * @return
         */
        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                                                      int index, boolean isSelected, boolean hasFocus)
        {
            int selectedIndex = ((Integer)value).intValue();

            if(isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            }
            else {
                setBackground(list.getBackground());
                setBackground(list.getForeground());
            }

            ImageIcon icon = anchorImages[selectedIndex];
            setIcon(icon);

            return this;
        }
    }

    /**
     * Mouselistener for rightclicking
     */
    class PopupListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            showPopup(e);
        }
        public void mouseReleased(MouseEvent e) {
            showPopup(e);
        }

        /**
         * Shows the popupmenu at the specified point
         * @param e MouseEvent
         */
        private void showPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                mousePop.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }

    class ActionListenerPopup implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem item = (JMenuItem)e.getSource();

            if (item.getText() == Lang.getInstance().getString("properties"))
                GWindowManager.getInstance().createAndRunGPanelPreferencesDialog((Element)tableModel.getData().get(table.getSelectedRow()));
            else if (item.getText() == Lang.getInstance().getString("delete"))
                GWindowManager.getInstance().MainWindow.getPanel().deleteRow(table.getSelectedRow());
        }
    }
}
