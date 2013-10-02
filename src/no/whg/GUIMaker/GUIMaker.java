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

    public static void main (String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createUI();
            }
        });
    }

    static void createUI (){

    }
//
    public boolean loadGUI (File f){
        Object object = null;
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.rowList = (ArrayList<RowElement>)ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
        return true;
    }

    public boolean saveGUI (File f){
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(rowList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public void previewGUI (){
        //previewWindow = new previewWindow; previewWindow.run; or something
    }

    public void saveSource (){

    }


}
