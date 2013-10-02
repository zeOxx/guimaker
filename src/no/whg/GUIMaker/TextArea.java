package no.whg.GUIMaker;

import javax.swing.JTextArea;

/**
 * Created with IntelliJ IDEA.
 * Package: no.whg.GUIMaker
 * User: Inge
 * Date: 24.09.13
 * Time: 19:26
 */
public class TextArea extends JTextArea {

    /**
     * Variables
     */
    private String varName;
    private String text;

    private Data data;

    /**
     *
     * @param id
     */
    public TextArea(int id) {
        varName = "var" + String.valueOf(id);
        text = "";

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
}
