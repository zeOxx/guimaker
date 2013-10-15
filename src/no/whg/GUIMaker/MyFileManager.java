package no.whg.GUIMaker;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/15/13
 * Time: 7:16 PM
 */
public class MyFileManager {
    // This class is a singleton, meaning there can only be one instance of this class.
    // Call Language.getInstance() to use it.
    private static MyFileManager instance = null;

    private ArrayList rowList = new ArrayList<RowElement>();
    protected FileChooser fc = new FileChooser();

    /**
     * Default constructor.
     * Exists only to defeat instantiation.
     */
    protected MyFileManager() {
        // Exists only to defeat instantiation.
    }

    /**
     * Singleton
     *
     * @return Returns the one instance of the class
     */
    public static MyFileManager getInstance() {
        if(instance == null) {
            instance = new MyFileManager();
        }
        return instance;
    }

    /**
     * Fetches the list of rows.
     *
     * @return Returns the ArrayList rowList
     */
    public ArrayList getRowList(){
        return this.rowList;
    }

    /**
     * Overwrites the Arraylist rowList with new data
     *
     * @param arg The ArrayList with which to replace rowList
     */
    private void setRowList(ArrayList arg){
        this.rowList = arg;
    }

    /**
     * Inserts an object into the Arraylist rowList
     *
     * @param arg The the object to be inserted into rowList
     */
    public void addObjectToRowList(RowElement arg){
        this.rowList.add(arg);
    }

    /**
     * Removes an item from the Arraylist rowList at a given index
     *
     * @param arg The index to remove from rowList
     */
    public void removeIndexFromRowList(int arg){
        this.rowList.remove(arg);
    }

    /**
     * Removes an object from the Arraylist rowList
     *
     * @param arg The object to remove from rowList
     */
    public void removeObjectFromRowList(RowElement arg){
        this.rowList.remove(arg);
    }

    /**
     * Opens the dialog for loading configurations
     */
    public void loadGUI (){
        setRowList(fc.loadGUI());
    }

    /**
     * Opens the dialog for saving configurations
     */
    public void saveGUI (){
        fc.saveGUI(getRowList());
    }
}
