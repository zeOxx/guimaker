package no.whg.GUIMaker;

import javax.swing.JLabel;

/**
 * Created with IntelliJ IDEA.
 * Package: no.whg.GUIMaker
 * User: Inge
 * Date: 24.09.13
 * Time: 19:15
 */
public class Label extends JLabel {

    /**
     * Variables
     */
    private String varName;
    private String text;
    private int anchor;

    private Data data;

    /**
     *
     * @param id
     */
    public Label(int id) {
        varName = "var" + String.valueOf(id);
        text = "";
        anchor = CENTER;

        data = new Data();
    }

    /**
     *
     * @return
     */
    public String getVarName() {
        return varName;
    }

    /**
     *
     * @param varName
     */
    public void setVarName(String varName) {
        this.varName = varName;
    }

    /**
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     */
    public int getAnchor() {
        return anchor;
    }

    /**
     *
     * @param anchor
     */
    public void setAnchor(int anchor) {
        this.anchor = anchor;
    }
}
