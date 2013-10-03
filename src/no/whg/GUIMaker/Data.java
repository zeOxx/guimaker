package no.whg.GUIMaker;

/**
 * Created with IntelliJ IDEA.
 * User: Inge
 * Date: 02.10.13
 * Time: 18:47
 * Project: guimaker
 */
public class Data {

    private int x;
    private int y;
    private int column;
    private int row;

    public Data() {
        x = 0;
        y = 0;
        column = 0;
        row = 0;
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
