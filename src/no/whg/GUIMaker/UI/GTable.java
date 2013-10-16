package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.Lang;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class GTable extends JTable {

    String[] titles;

    public GTable() {
        populateTitles();
    }

    /**
     * Populates the title array. Repopulate if language is changed
     */
    private void populateTitles() {
        titles = new String[]   {Lang.getInstance().getString("type"), Lang.getInstance().getString("variable"), Lang.getInstance().getString("text"),
                                Lang.getInstance().getString("row"), Lang.getInstance().getString("column"), Lang.getInstance().getString("rows"),
                                Lang.getInstance().getString("columns"), Lang.getInstance().getString("fill"), Lang.getInstance().getString("anchor")};
    }

    public void addItem() {
        
    }
}
