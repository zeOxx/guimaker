package no.whg.GUIMaker;

/**
 * Created with IntelliJ IDEA.
 * Package: no.whg.GUIMaker
 * User: Inge
 * Date: 10.10.13
 * Time: 17:47
 */
public class CoreElement {

    private String varName;
    private String text;
    private int x;
    private int y;
    private int column;
    private int row;

    public CoreElement(int id) {
        varName = "var" + String.valueOf(id);
        text = "";
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
