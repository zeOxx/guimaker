package no.whg.GUIMaker;

import javax.swing.JButton;

/**
 * Created with IntelliJ IDEA.
 * Package: no.whg.GUIMaker
 * User: Inge
 * Date: 24.09.13
 * Time: 19:38
 */

public class Button extends CoreElement {

    /**
     * Variables
     */
    private int anchor;

    /**
     *
     * @param id
     */
    public Button(int id) {
        super(id);
    }

    public int getAnchor() {
        return anchor;
    }

    public void setAnchor(int anchor) {
        this.anchor = anchor;
    }
}
