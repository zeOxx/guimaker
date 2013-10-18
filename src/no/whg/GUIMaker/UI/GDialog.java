package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.Element;
import no.whg.GUIMaker.Lang;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: snorre and Inge
 * Date: 10/17/13
 * Time: 6:07 PM
 */
public class GDialog extends JOptionPane {
    Element element;

    /**
     * Constructor for GDialog
     *
     * @param e An Element for future reference
     */
    public GDialog(Element e){
        this.element = e;
    }

    /**
     * Shows input dialog
     *
     * @param parent The parent JFrame this dialog belongs to
     */
    public void showInputDialog(GFrame parent){
        String [] possibilities = element.types;
        String current = element.getType();

        /**
         * JTextField
         */
        if (current.equals(possibilities[2])) {
            JTextField rows = new JTextField();
            rows.setText(element.getRows());
            JTextField width = new JTextField();
            width.setText(String.valueOf(element.getWidth()));
            JTextField height = new JTextField();
            height.setText(String.valueOf(element.getHeight()));

            final JComponent[] inputs = new JComponent[] {
                    new JLabel(Lang.getInstance().getString("rows")), rows,
                    new JLabel(Lang.getInstance().getString("width")), width,
                    new JLabel(Lang.getInstance().getString("height")), height
            };

            showMessageDialog(null, inputs, current + " dialog", JOptionPane.PLAIN_MESSAGE);

            element.setRows(rows.getText());
            element.setWidth(Integer.parseInt(width.getText()));
            element.setHeight(Integer.parseInt(height.getText()));
        }
        /**
         * JTextArea
         */
        else if (current.equals(possibilities[3])) {
            JTextField columns = new JTextField();
            columns.setText(element.getColumns());
            JTextField rows = new JTextField();
            rows.setText(element.getRows());
            JTextField width = new JTextField();
            width.setText(String.valueOf(element.getWidth()));
            JTextField height = new JTextField();
            height.setText(String.valueOf(element.getHeight()));
            JCheckBox scroll = new JCheckBox();
            scroll.setSelected(element.isScroll());
            JCheckBox wrap = new JCheckBox();
            wrap.setSelected(element.isWrap());

            final JComponent[] inputs = new JComponent[] {
                    new JLabel(Lang.getInstance().getString("columns")), columns,
                    new JLabel(Lang.getInstance().getString("rows")), rows,
                    new JLabel(Lang.getInstance().getString("width")), width,
                    new JLabel(Lang.getInstance().getString("height")), height,
                    new JLabel(Lang.getInstance().getString("dialogScrollPane")), scroll,
                    new JLabel(Lang.getInstance().getString("dialogWordWrap")), wrap
            };

            showMessageDialog(null, inputs, current + " dialog", JOptionPane.PLAIN_MESSAGE);

            element.setColumns(columns.getText());
            element.setRows(rows.getText());
            element.setWidth(Integer.parseInt(width.getText()));
            element.setHeight(Integer.parseInt(height.getText()));
            element.setScroll(scroll.isSelected());
            element.setWrap(wrap.isSelected());
        }
        /**
         * JList
         */
        else if (current.equals(possibilities[5])) {
            JTextField width = new JTextField();
            width.setText(String.valueOf(element.getWidth()));
            JTextField height = new JTextField();
            height.setText(String.valueOf(element.getHeight()));
            JCheckBox scroll = new JCheckBox();
            scroll.setSelected(element.isScroll());
            JCheckBox combo = new JCheckBox();
            combo.setSelected(element.isCombo());

            final JComponent[] inputs = new JComponent[] {
                    new JLabel(Lang.getInstance().getString("width")), width,
                    new JLabel(Lang.getInstance().getString("height")), height,
                    new JLabel(Lang.getInstance().getString("dialogScrollPane")), scroll,
                    new JLabel(Lang.getInstance().getString("dialogCombo")), combo
            };

            showMessageDialog(null, inputs, current + " dialog", JOptionPane.PLAIN_MESSAGE);

            element.setWidth(Integer.parseInt(width.getText()));
            element.setHeight(Integer.parseInt(height.getText()));
            element.setScroll(scroll.isSelected());
            element.setCombo(combo.isSelected());
        }
        /**
         * JComboBox
         */
        else if (current.equals(possibilities[6])) {
            JTextField width = new JTextField();
            width.setText(String.valueOf(element.getWidth()));
            JTextField height = new JTextField();
            height.setText(String.valueOf(element.getHeight()));
            JCheckBox combo = new JCheckBox();
            combo.setSelected(element.isCombo());

            final JComponent[] inputs = new JComponent[] {
                    new JLabel(Lang.getInstance().getString("width")), width,
                    new JLabel(Lang.getInstance().getString("height")), height,
                    new JLabel(Lang.getInstance().getString("dialogCombo")), combo
            };

            showMessageDialog(null, inputs, current + " dialog", JOptionPane.PLAIN_MESSAGE);

            element.setWidth(Integer.parseInt(width.getText()));
            element.setHeight(Integer.parseInt(height.getText()));
            element.setCombo(combo.isSelected());
        }
        /**
         * JSpinnerList
         */
        else if (current.equals(possibilities[7])) {
            JTextField spinnerList = new JTextField();
            spinnerList.setText(element.getSpinner());

            final JComponent[] inputs = new JComponent[] {
                    new JLabel(Lang.getInstance().getString("dialogSpinner")), spinnerList
            };

            showMessageDialog(null, inputs, current + " dialog", JOptionPane.PLAIN_MESSAGE);

            element.setSpinner(spinnerList.getText());
        }
        /**
         * JSpinnerNumber
         */
        else if (current.equals(possibilities[8])) {
            JTextField startValue = new JTextField();
            startValue.setText(String.valueOf(element.getStartValue()));
            JTextField minValue = new JTextField();
            minValue.setText(String.valueOf(element.getMinValue()));
            JTextField maxValue = new JTextField();
            maxValue.setText(String.valueOf(element.getMaxValue()));
            JTextField stepValue = new JTextField();
            stepValue.setText(String.valueOf(element.getStepValue()));

            final JComponent[] inputs = new JComponent[] {
                    new JLabel(Lang.getInstance().getString("dialogStartValue")), startValue,
                    new JLabel(Lang.getInstance().getString("dialogMinValue")), minValue,
                    new JLabel(Lang.getInstance().getString("dialogMaxValue")), maxValue,
                    new JLabel(Lang.getInstance().getString("dialogStepValue")), stepValue
            };

            showMessageDialog(null, inputs, current + " dialog", JOptionPane.PLAIN_MESSAGE);

            element.setStartValue(Float.parseFloat(startValue.getText()));
            element.setMinValue(Float.parseFloat(minValue.getText()));
            element.setMaxValue(Float.parseFloat(maxValue.getText()));
            element.setStepValue(Float.parseFloat(stepValue.getText()));
        }

        GWindowManager.getInstance().MainWindow.getPanel().changeElementInTable(element);
    }
}
