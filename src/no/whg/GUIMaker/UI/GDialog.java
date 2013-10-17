package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.Element;
import no.whg.GUIMaker.Lang;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/17/13
 * Time: 6:07 PM
 */
public class GDialog extends JOptionPane {
    Element element;

    public GDialog(Element e){
        this.element = e;
    }

    public void showInputDialog(GFrame parent){
        String [] possibilities = element.types;
        String current = element.getType();

/*        String s = (String)super.showInputDialog(
                parent,
                Lang.getInstance().getString("type") + ":\n",
                Lang.getInstance().getString("titlepreferences"),
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                current);
        //If a string was returned, say so.
        if ((s != null) && (s.length() > 0)) {
            if (!s.equals(current)){
                for (int i = 0; i < possibilities.length; i++){
                    System.out.println(i);
                    if (s.equals(possibilities[i])){
                        System.out.println("Breaking at " + i);
                        break;
                    }
                }
            } else {
                System.out.println("User chose " + s + ", but that was already selected");
            }
        }
        //If you're here, the return value was null/empty.
        System.out.println("Return value was null/empty");*/

        if (current.equals(possibilities[2])) {
            JTextField rows = new JTextField();
            JTextField width = new JTextField();
            JTextField height = new JTextField();

            final JComponent[] inputs = new JComponent[] {
                    new JLabel(Lang.getInstance().getString("rows")), rows,
                    new JLabel(Lang.getInstance().getString("width")), width,
                    new JLabel(Lang.getInstance().getString("height")), height
            };

            showMessageDialog(null, inputs, current + " dialog", JOptionPane.PLAIN_MESSAGE);
        } else if (current.equals(possibilities[3])) {
            JTextField columns = new JTextField();
            JTextField rows = new JTextField();
            JTextField width = new JTextField();
            JTextField height = new JTextField();
            JCheckBox scroll = new JCheckBox();
            JCheckBox wrap = new JCheckBox();

            final JComponent[] inputs = new JComponent[] {
                    new JLabel(Lang.getInstance().getString("columns")), columns,
                    new JLabel(Lang.getInstance().getString("rows")), rows,
                    new JLabel(Lang.getInstance().getString("width")), width,
                    new JLabel(Lang.getInstance().getString("height")), height,
                    new JLabel(Lang.getInstance().getString("dialogScrollPane")), scroll,
                    new JLabel(Lang.getInstance().getString("dialogWordWrap")), wrap
            };

            showMessageDialog(null, inputs, current + " dialog", JOptionPane.PLAIN_MESSAGE);
        } else if (current.equals(possibilities[5])) {
            JTextField width = new JTextField();
            JTextField height = new JTextField();
            JCheckBox scroll = new JCheckBox();
            JCheckBox combo = new JCheckBox();

            final JComponent[] inputs = new JComponent[] {
                    new JLabel(Lang.getInstance().getString("width")), width,
                    new JLabel(Lang.getInstance().getString("height")), height,
                    new JLabel(Lang.getInstance().getString("dialogScrollPane")), scroll,
                    new JLabel(Lang.getInstance().getString("dialogCombo")), combo
            };

            showMessageDialog(null, inputs, current + " dialog", JOptionPane.PLAIN_MESSAGE);
        } else if (current.equals(possibilities[6])) {
            JTextField width = new JTextField();
            JTextField height = new JTextField();
            JCheckBox combo = new JCheckBox();

            final JComponent[] inputs = new JComponent[] {
                    new JLabel(Lang.getInstance().getString("width")), width,
                    new JLabel(Lang.getInstance().getString("height")), height,
                    new JLabel(Lang.getInstance().getString("dialogCombo")), combo
            };

            showMessageDialog(null, inputs, current + " dialog", JOptionPane.PLAIN_MESSAGE);
        } else if (current.equals(possibilities[7])) {
            JTextField spinnerList = new JTextField();

            final JComponent[] inputs = new JComponent[] {
                    new JLabel(Lang.getInstance().getString("dialogSpinner")), spinnerList
            };

            showMessageDialog(null, inputs, current + " dialog", JOptionPane.PLAIN_MESSAGE);
        } else if (current.equals(possibilities[8])) {
            JTextField startValue = new JTextField();
            JTextField minValue = new JTextField();
            JTextField maxValue = new JTextField();
            JTextField stepValue = new JTextField();

            final JComponent[] inputs = new JComponent[] {
                    new JLabel(Lang.getInstance().getString("dialogStartValue")), startValue,
                    new JLabel(Lang.getInstance().getString("dialogMinValue")), minValue,
                    new JLabel(Lang.getInstance().getString("dialogMaxValue")), maxValue,
                    new JLabel(Lang.getInstance().getString("dialogStepValue")), stepValue
            };

            showMessageDialog(null, inputs, current + " dialog", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
