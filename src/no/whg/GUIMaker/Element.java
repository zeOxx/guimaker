package no.whg.GUIMaker;

/**
 * Created with IntelliJ IDEA.
 * Package: no.whg.GUIMaker
 * User: Inge
 * Date: 10.10.13
 * Time: 17:47
 */
public class Element {

    public static String[] types = { "JLabel", "JButton", "JTextField", "JTextArea", "JCheckBox", "JList", "JComboBox", "JSpinnerList", "JSpinnerNumber"};
    protected String type;
    protected String varName;
    protected String text;
    protected String x;
    protected String y;
    protected String column;
    protected String row;
    protected String fill;
    protected String anchor;

    public Element(int id) {
        varName = "var" + String.valueOf(id);
        type = types[0];
        text = "";
        x = "0";
        y = "0";
        column = "0";
        row = "0";
        fill = "0";
        anchor = "0";
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public String getAnchor() {
        return anchor;
    }

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }
}
