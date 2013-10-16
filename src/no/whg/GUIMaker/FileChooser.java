package no.whg.GUIMaker;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

import static no.whg.GUIMaker.MyFileManager.getInstance;

/**
 * Created with IntelliJ IDEA for ${PROJECT_NAME}
 * User: Snorre
 * Date: 10/2/13
 * Time: 4:58 PM
 */
public class FileChooser {
    JFileChooser jfc;

    /* TODO: commenting */
    public FileChooser (){
        //Create a file chooser
        jfc = new JFileChooser();
    }

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
                /* TODO: Exception handling */
                return null;
            } catch (ClassNotFoundException e) {
                /* TODO: Exception handling */
                return null;
            }
        } else {
            /* TODO: Error message */
        }
        return null;
    }

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
                /* TODO: Exception handling */
            }
        } else {
            /* TODO: Error message */
        }
    }

    public void saveGUI (ArrayList re, File temp){
        try {
            FileOutputStream fos = new FileOutputStream(temp);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(re);
            oos.close();
            fos.close();
            /* TODO: "file has been saved" dialog */
        } catch (IOException e) {
            /* TODO: Exception handling */
        }
    }
}
