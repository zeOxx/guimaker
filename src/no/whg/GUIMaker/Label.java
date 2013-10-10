package no.whg.GUIMaker;

import javax.swing.JLabel;

/**
 * Created with IntelliJ IDEA.
 * Package: no.whg.GUIMaker
 * User: Inge
 * Date: 24.09.13
 * Time: 19:15
 */
public class Label extends CoreElement {

    /**
     * Variables
     */
    private int anchor;

    /**
     *
     * @param id
     */
    public Label(int id) {
        super(id);
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
