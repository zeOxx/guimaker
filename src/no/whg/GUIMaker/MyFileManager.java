package no.whg.GUIMaker;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyFileManager {
    private static MyFileManager instance = null;
    private ArrayList rowList = new ArrayList<RowElement>();
    protected FileChooser fc = new FileChooser();

    protected MyFileManager() {
        // Exists only to defeat instantiation.
    }

    public static MyFileManager getInstance() {
        if(instance == null) {
            instance = new MyFileManager();
        }
        return instance;
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

    public void loadGUI (){
        setRowList(fc.loadGUI());
    }

    public void saveGUI (){
        fc.saveGUI(getRowList());
    }
}
