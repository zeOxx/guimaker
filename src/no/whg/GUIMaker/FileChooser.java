package no.whg.GUIMaker;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

import static no.whg.GUIMaker.MyFileManager.getInstance;

/**
 * Created with IntelliJ IDEA for guimaker
 * User: Snorre
 * Date: 10/2/13
 * Time: 4:58 PM
 */
public class FileChooser {
    JFileChooser jfc;

    /**
     * Constructor for FileChooser
     */
    public FileChooser (){
        //Create a file chooser
        jfc = new JFileChooser();
    }

    /**
     * Opens a window where the user may load an ArrayList from file, and loads the selected file into an Arraylist
     *
     * TODO: Confirmation dialog
     *
     * @return An ArrayList, unless there is a failure, which will return null
     */
    public ArrayList loadGUI (){
        int returnVal = jfc.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();

            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ArrayList re = (ArrayList<RowElement>)ois.readObject();
                ois.close();
                fis.close();
                return re;
            } catch (IOException e) {
                System.out.println("IOException: " + e);
                return null;
            } catch (ClassNotFoundException e) {
                System.out.println("ClassNotFoundException: " + e);
                return null;
            }
        } else {
            System.out.println("Invalid option.");
        }
        return null;
    }

    /**
     * Opens a window where the user may save an ArrayList to file
     *
     * TODO: Confirmation dialog
     *
     * @param re The ArrayList to save
     */
    public void saveGUI (ArrayList re){
        int returnVal = jfc.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            try {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(re);
                oos.close();
                fos.close();
                getInstance().setLastFile(file);
                /* TODO: "file has been saved" dialog */
            } catch (IOException e) {
                System.out.println("IOException: " + e);
            }
        } else {
            System.out.println("Invalid option.");
        }
    }

    /**
     * Saves an ArrayList to file at a previously used location
     *
     * TODO: Confirmation dialog
     *
     * @param re The ArrayList to save
     * @param lastFile The previously used location
     */
    public void saveGUI (ArrayList re, File lastFile){
        try {
            FileOutputStream fos = new FileOutputStream(lastFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(re);
            oos.close();
            fos.close();
            /* TODO: "file has been saved" dialog */
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }
}
