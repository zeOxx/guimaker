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

    private int x;
    private int y;
    private int column;
    private int row;

    /**
     *
     * @param id
     */
    public Label(int id) {
        varName = "var" + String.valueOf(id);
        text = "";
        anchor = CENTER;

        x = 0;
        y = 0;
        column = 0;
        row = 0;
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

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return
     */
    public int getColumn() {
        return column;
    }

    /**
     *
     * @param column
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     *
     * @return
     */
    public int getRow() {
        return row;
    }

    /**
     *
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }
}
