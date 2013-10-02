package no.whg.GUIMaker;

import javax.swing.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA for ${PROJECT_NAME}.
 * User: snorre
 * Date: 9/24/13
 * Time: 5:56 PM
 */
public class GUIMaker {
    private ArrayList rowList = new ArrayList<RowElement>();
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
        setRowList(fc.loadGUI());
    }

    public void saveGUI (){
        fc.saveGUI(getRowList());
    }

    public void previewGUI (){

    }

    public void saveSource (){

    }

    public ArrayList getRowList(){
        return this.rowList;
    }

    private void setRowList(ArrayList arg){
        this.rowList = arg;
    }

    public void addToRowList(RowElement arg){
        this.rowList.add(arg);
    }

    public void removeIndexFromRowList(int arg){
        this.rowList.remove(arg);
    }

    public void removeObjectFromRowList(RowElement arg){
        this.rowList.remove(arg);
    }
}
