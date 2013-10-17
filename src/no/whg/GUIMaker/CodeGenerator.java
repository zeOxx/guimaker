package no.whg.GUIMaker;

import java.io.File;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/17/13
 * Time: 6:34 PM
 */
public class CodeGenerator {
    // This class is a singleton, meaning there can only be one instance of this class.
    // Call GWindowManager.getInstance() to use it.
    private static CodeGenerator instance = null;
    /**
     * Default constructor.
     * Exists only to defeat instantiation.
     */
    protected CodeGenerator(){
        // Exists only to defeat instantiation
    }
    /**
     * Singleton
     *
     * @return Returns the one instance of the class
     */
    public static CodeGenerator getInstance() {
        if(instance == null) {
            instance = new CodeGenerator();
        }
        return instance;
    }

    public void assembleAndPrintFile(Vector v){
        String theFile = "";
        String temp;
        Vector<Element> elements = v;
        for (int i = 0; i < elements.size(); i++){
            boolean elementLoaded = false;
            Element e = elements.get(i);
            String type = e.type;
            int j;
            for (j = 0; j < (e.types.length) && (!elementLoaded); j++){
                if (type.equals(e.type)){
                    elementLoaded = true;
                    temp = assembleElement(e, j);
                    break;
                }
            }
            if (elementLoaded){
                // Do something to string temp
            }
        }
        MyFileManager.getInstance().writeJava(theFile);
    }

    private String assembleElement(Element e, int j){
        String el;
        switch (j){
            case 0:
                el = assembleJLabel(e);
                break;
            case 1:
                el = assembleJButton(e);
                break;
            case 2:
                el = assembleJTextField(e);
                break;
            case 3:
                el = assembleJTextArea(e);
                break;
            case 4:
                el = assembleJCheckBox(e);
                break;
            case 5:
                el = assembleJList(e);
                break;
            case 6:
                el = assembleJComboBox(e);
                break;
            case 7:
                el = assembleJSpinnerList(e);
                break;
            case 8:
                el = assembleJSpinnerNumber(e);
                break;
            default:
                System.out.println("Oh shit");
                return null;
        }
        return el;
    }

    private String assembleJLabel(Element e){
        return "";
    }

    private String assembleJButton(Element e){
        return "";
    }

    private String assembleJTextField(Element e){
        return "";
    }

    private String assembleJTextArea(Element e){
        return "";
    }

    private String assembleJCheckBox(Element e){
        return "";
    }

    private String assembleJList(Element e){
        return "";
    }

    private String assembleJComboBox(Element e){
        return "";
    }

    private String assembleJSpinnerList(Element e){
        return "";
    }

    private String assembleJSpinnerNumber(Element e){
        return "";
    }
}