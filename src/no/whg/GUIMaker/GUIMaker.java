package no.whg.GUIMaker;

import no.whg.GUIMaker.UI.GFrame;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA for ${PROJECT_NAME}.
 * User: snorre
 * Date: 9/24/13
 * Time: 5:56 PM
 */
public class GUIMaker extends JFrame {
    private ArrayList rowList = new ArrayList<RowElement>();
    protected FileChooser fc = new FileChooser();
    static GFrame guim;

    public static void main (String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createUI();
            }
        });
    }

    static void createUI (){
        guim = new GFrame();
        guim.setVisible(true);
    }

    public ArrayList getRowList(){
        return this.rowList;
    }

    private void setRowList(ArrayList arg){
        this.rowList = arg;
    }

    public void addObjectToRowList(RowElement arg){
        this.rowList.add(arg);
    }

    public void removeIndexFromRowList(int arg){
        this.rowList.remove(arg);
    }

    public void removeObjectFromRowList(RowElement arg){
        this.rowList.remove(arg);
    }
}
