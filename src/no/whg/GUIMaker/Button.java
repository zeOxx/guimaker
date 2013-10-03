package no.whg.GUIMaker;

import javax.swing.JButton;

/**
 * Created with IntelliJ IDEA.
 * Package: no.whg.GUIMaker
 * User: Inge
 * Date: 24.09.13
 * Time: 19:38
 */
public class Button extends JButton {

    /**
     * Variables
     */
    private String varName;
    private String text;
    private int anchor;

    public Data data;

    /**
     *
     * @param id
     */
    public Button(int id) {
        varName = "var" + String.valueOf(id);
        text = "";
        anchor = CENTER;

        data = new Data();
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAnchor() {
        return anchor;
    }

    public void setAnchor(int anchor) {
        this.anchor = anchor;
    }
}