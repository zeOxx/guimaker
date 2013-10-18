package no.whg.GUIMaker;

import java.io.*;
import javax.swing.filechooser.FileFilter;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.filechooser.*;

import static no.whg.GUIMaker.MyFileManager.getInstance;

/**
 * Created with IntelliJ IDEA for guimaker
 * User: Snorre
 * Date: 10/2/13
 * Time: 4:58 PM
 */
public class FileChooser {
    /**
     * Constructor for FileChooser
     */
    public FileChooser (){

    }

    /**
     * Opens a window where the user may load an ArrayList from file, and loads the selected file into an Arraylist
     *
     * TODO: Confirmation dialog
     *
     * @return An ArrayList, unless there is a failure, which will return null
     */
    public Vector<Element> loadGUI (){
        JFileChooser jfc = new JFileChooser();
        int returnVal = jfc.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();

            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Vector<Element> re = (Vector<Element>)ois.readObject();
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
     * @param data The Vector to save
     */
    public void saveGUI (Vector<Element> data){
        JFileChooser jfc = new JFileChooser();
        FileFilter type1 = new ExtensionFilter("GUI source", ".guim");
        jfc.setFileFilter(type1);
        jfc.addChoosableFileFilter(type1);

        int returnVal = jfc.showSaveDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            String name = file.getName();
            name = name.replace(".guim", "");

            int index = file.getName().indexOf(".");

            try {
                String ext = file.getName().substring(index);
                if (!ext.equals(".guim")) {
                    File dir = file.getParentFile();
                    file = new File(dir, file.getName() + ".guim");
                }
            } catch (StringIndexOutOfBoundsException e) {
                File dir = file.getParentFile();
                file = new File(dir, file.getName() + ".guim");
            }

            try {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(data);
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
     * @param data The ArrayList to save
     * @param lastFile The previously used location
     */
    public void saveGUI (Vector<Element> data, File lastFile){
        try {
            FileOutputStream fos = new FileOutputStream(lastFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.close();
            fos.close();
            /* TODO: "file has been saved" dialog */
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }

    public void writeJava(String java){
        JFileChooser chooser = new JFileChooser();
        FileFilter type1 = new ExtensionFilter("Java source", ".java");
        chooser.setFileFilter(type1);
        chooser.addChoosableFileFilter(type1);
        int returnVal = chooser.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String name = file.getName();
            name = name.replace(".java","");
            java = java.replace("MyGUI",name);

            int index = file.getName().indexOf(".");
            try {
                String ext = file.getName().substring(index);
                if (!ext.equals(".java")){
                    File dir = file.getParentFile();
                    file = new File(dir, file.getName()+".java");
                }
            } catch (StringIndexOutOfBoundsException e){
                File dir = file.getParentFile();
                file = new File(dir, file.getName()+".java");
            }

            try {
                Writer output;
                output = new BufferedWriter(new FileWriter(file));
                output.write(java);
                output.close();
                /* TODO: "file has been saved" dialog */
            } catch (IOException e) {
                System.out.println("IOException: " + e);
            }
        } else {
            System.out.println("Invalid option.");
        }
    }
}


