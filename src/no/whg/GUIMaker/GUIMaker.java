package no.whg.GUIMaker;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 9/24/13
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class GUIMaker {
    public ArrayList rowList = new ArrayList<RowElement>();
    protected FileChooser fc = new FileChooser();

    public static void main (String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createUI();
            }
        });
    }

    static void createUI (){

    }

    public void loadGUI (){
        rowList = fc.loadGUI();
    }

    public void saveGUI (){
        fc.saveGUI(rowList);
    }

    public void previewGUI (){

    }

    public void saveSource (){

    }
}
