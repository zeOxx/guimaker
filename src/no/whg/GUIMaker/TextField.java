package no.whg.GUIMaker;

import javax.swing.JTextField;

/**
 * Created with IntelliJ IDEA.
 * Package: no.whg.GUIMaker
 * User: Inge
 * Date: 24.09.13
 * Time: 19:26
 */
public class TextField extends JTextField {

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
    public TextField(int id) {
        varName = "var" + String.valueOf(id);
        text = "";
        anchor = CENTER;

        x = 0;
        y = 0;
        column = 0;
        row = 0;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
