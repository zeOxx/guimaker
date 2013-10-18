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
    private String block_first = "";
    private String block_last = "";
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
        /* TODO: Assemble the start of the file here. */
        for (int i = 0; i < elements.size(); i++){
            boolean elementLoaded = false;
            temp = "";
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
                theFile = theFile + temp;
            }
        }
        /* TODO: Assemble the end of the file here */
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

    private String getGridbagConstraintsAnchor(int derp) {
        switch (derp) {
            case 0:
                return "CENTER";
            case 1:
                return "EAST";
            case 2:
                return "NORTH";
            case 3:
                return "NORTHEAST";
            case 4:
                return "NORTHWEST";
            case 5:
                return "SOUTH";
            case 6:
                return "SOUTHEAST";
            case 7:
                return "SOUTHWEST";
            case 8:
                return "WEST";
            default:
                return "CETNER";
        }
    }

    private String getGridbagConstrainsFill(int derp) {
        switch (derp) {
            case 0:
                return "NONE";
            case 1:
                return "BOTH";
            case 2:
                return "VERTICAL";
            case 3:
                return "HORIZONTAL";
            default:
                return "NONE";
        }
    }
}