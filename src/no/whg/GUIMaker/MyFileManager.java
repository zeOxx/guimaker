package no.whg.GUIMaker;

import no.whg.GUIMaker.UI.GWindowManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

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

    private Vector<Element> rowList = new Vector<Element>();
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
    public Vector<Element> getRowList(){
        return this.rowList;
    }

    /**
     * Overwrites the Arraylist rowList with new data
     *
     * @param arg The ArrayList with which to replace rowList
     */
    private void setRowList(Vector<Element> arg){
        this.rowList = arg;
    }

    /**
     * Inserts an object into the Arraylist rowList
     *
     * @param arg The the object to be inserted into rowList
     */
    public void addObjectToRowList(Element arg){
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
        this.rowList = new Vector<Element>();
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
    public void saveGUI (boolean saveAs, Vector<Element> data){
        if (saveAs){
            fc.saveGUI(data);
        } else {
            if (lastFile == null){
                fc.saveGUI(data);
            } else {
                fc.saveGUI(data, lastFile);
            }
        }
    }

    /**
     * Sets up a new, blank UI table
     */
    public void newGUI(){
        lastFile = null;
        clearRowList();
    }

    public void writeJava(String java_first){
        fc.writeJava(java_first);
    }

    /*public String loadGeneratorStrings(String path){
        String generatorString;
        try {
            generatorString = fc.loadGeneratorStrings(path);
        } catch (FileNotFoundException e){
            System.out.println("FileNotFoundException: " + e.getMessage());
            generatorString = null;
        }
        return generatorString;
    }*/
}
