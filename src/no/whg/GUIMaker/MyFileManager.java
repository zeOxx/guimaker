package no.whg.GUIMaker;

import java.io.File;
import java.io.PrintWriter;
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
    private File lastFile = null;

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
     * Getter for lastFile
     *
     * @return lastFile
     */
    public File getLastFile(){
        return lastFile;
    }

    /**
     * Setter for lastFile
     * @param f The file to set
     */
    public void setLastFile(File f){
        this.lastFile = f;
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
     * Clears the ArrayList rowList
     */
    private void clearRowList(){
        this.rowList = new ArrayList<RowElement>();
    }

    /**
     * Opens the dialog for loading configurations
     */
    public void loadGUI (){
        setRowList(fc.loadGUI());
    }

    /**
     * Saves files using FileChooser
     *
     * @param saveAs Whether the dialog should be opened
     */
    public void saveGUI (boolean saveAs){
        if (saveAs){
            fc.saveGUI(getRowList());
        } else {
            if (lastFile == null){
                fc.saveGUI(getRowList());
            } else {
                fc.saveGUI(getRowList(), lastFile);
            }
        }
    }

    /**
     * Sets up a new, blank UI table
     */
    public void newGUI(){
        lastFile = null;
        /* TODO: reset table */
        clearRowList();
    }

    public void writeJava(String java){
        //PrintWriter out = new PrintWriter("filename.txt");
    }
}
