package no.whg.GUIMaker;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Package: no.whg.GUIMaker
 * User: Inge
 * Date: 10.10.13
 * Time: 17:47
 */
public class Element implements Serializable {

    public static final long serialVersionUID = 42L;

    public static String[] types = { "JLabel", "JButton", "JTextField", "JTextArea", "JCheckBox", "JList", "JComboBox", "JSpinnerList", "JSpinnerNumber"};
    protected String type;
    protected String varName;
    protected String text;
    protected String rows;
    protected String columns;
    protected String column;
    protected String row;
    protected String fill;
    protected String anchor;

    /**
     * Vars used in dialog popups
     */
    protected int height;
    protected int width;
    protected float startValue;
    protected float minValue;
    protected float maxValue;
    protected float stepValue;
    protected boolean scroll;
    protected boolean wrap;
    protected boolean combo;
    protected String spinner;

    /**
     * Constructor
     * @param id unique identifier
     */
    public Element(int id) {
        varName = "var" + String.valueOf(id);
        type = types[0];
        text = "";
        rows = "1";
        columns = "1";
        column = "0";
        row = "0";
        fill = "0";
        anchor = "0";

        height = 1;
        width = 1;

        startValue = 1.0f;
        minValue = 1.0f;
        maxValue = 1.0f;
        stepValue = 1.0f;

        scroll = true;
        wrap = true;
        combo = true;

        spinner = "";
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public String getColumns() {
        return columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
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


    public float getStartValue() {
        return startValue;
    }

    public void setStartValue(float startValue) {
        this.startValue = startValue;
    }

    public float getMinValue() {
        return minValue;
    }

    public void setMinValue(float minValue) {
        this.minValue = minValue;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }

    public float getStepValue() {
        return stepValue;
    }

    public void setStepValue(float stepValue) {
        this.stepValue = stepValue;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isScroll() {
        return scroll;
    }

    public void setScroll(boolean scroll) {
        this.scroll = scroll;
    }

    public boolean isWrap() {
        return wrap;
    }

    public void setWrap(boolean wrap) {
        this.wrap = wrap;
    }

    public boolean isCombo() {
        return combo;
    }

    public void setCombo(boolean combo) {
        this.combo = combo;
    }

    public String getSpinner() {
        return spinner;
    }

    public void setSpinner(String spinner) {
        this.spinner = spinner;
    }

}
