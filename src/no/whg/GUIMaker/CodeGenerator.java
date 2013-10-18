package no.whg.GUIMaker;

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

    private String java_first = "import javax.swing.*;\nimport java.awt.*;\n\npublic class MyGUI extends JFrame {\n\n    public static void main(String[] args){\n        SwingUtilities.invokeLater(new Runnable() {\n            public void run() {SwingUtilities.invokeLater(new Runnable() {\n                @Override\n                public void run() {\n                    MyGUI GUI = new MyGUI(\"MyGUI\");\n                    GUI.setVisible(true);\n                }\n            });\n            }\n        });\n    }\n\n    public MyGUI(String title){\n        setTitle(title);\n        setSize(700, 400);\n        setLocationRelativeTo(null);\n        setDefaultCloseOperation(EXIT_ON_CLOSE);\n        createGUI();\n    }\n\n    private void createGUI(){\n" +
            "    GridBagLayout layout = new GridBagLayout ();\n" +
            "    GridBagConstraints gbc = new GridBagConstraints();\n" +
            "    setLayout (layout);\n";
    private String java_second = "    }\n}";

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
        String partOne = java_first;
        String partTwo = java_second;

        String temp;

        for (int i = 0; i < v.size(); i++){
            boolean elementLoaded = false;
            temp = "";
            Element e = (Element) v.get(i);
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
                partOne = partOne + temp;
            }
        }

        partOne = partOne + partTwo;
        MyFileManager.getInstance().writeJava(partOne);
    }

    /**
     * Sends an Element object to be assembled
     *
     * @param e The Element that needs assembling
     * @param j The type of Element
     * @return A String containg the assembled Element
     */
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

    /**
     * Assembles constraints from an Element
     *
     * @param e The Element
     * @return String containing Java code
     */
    private String assembleConstraints(Element e){
        String retString = "gbc.gridx = " + e.getRow() + ";\n" +
                "gbc.gridy = " + e.getColumn() + ";\n" +
                "gbc.gridwidth = " + e.getRows() + ";\n" +
                "gbc.gridheight = " + e.getColumns() + ";\n" +
                "gbc.anchor = java.awt.GridBagConstraints." + getGridBagConstraintsAnchor(e.getAnchor()) + ";\n" +
                "gbc.fill = java.awt.GridBagConstraints." + getGridBagConstraintsFill(e.getFill()) + ";\n";
        return retString;
    }

    /**
     * Assmbles Java code from an Element
     *
     * @param e The Element
     * @return String containing Java code
     */
    private String assembleJLabel(Element e){
        String retString = "JLabel " + e.getVarName() + " = new JLabel(" + '"' + '"' + ");\n" +
               assembleConstraints(e) +
               "layout.setConstraints(" + e.getVarName() + ", gbc);\n" +
               "add(" + e.getVarName() +");\n";
        return retString;
    }

    /**
     * Assmbles Java code from an Element
     *
     * @param e The Element
     * @return String containing Java code
     */
    private String assembleJButton(Element e){
        String retString = "JButton " + e.getVarName() + " = new JButton(" + '"' + '"' + ");\n" +
                assembleConstraints(e) +
                "layout.setConstraints(" + e.getVarName() + ", gbc);\n" +
                "add(" + e.getVarName() +");\n";
        return retString;
    }

    /**
     * Assmbles Java code from an Element
     *
     * @param e The Element
     * @return String containing Java code
     */
    private String assembleJTextField(Element e){
        String retString = "JTextField " + e.getVarName() + " = new JTextField(" + '"' + '"' + ");\n" +
                assembleConstraints(e) +
                "layout.setConstraints(" + e.getVarName() + ", gbc);\n" +
                "add(" + e.getVarName() +");\n";
        return retString;
    }

    /**
     * Assmbles Java code from an Element
     *
     * @param e The Element
     * @return String containing Java code
     */
    private String assembleJTextArea(Element e){
        String retString = "JTextArea " + e.getVarName() + " = new JTextArea(" + '"' + '"' + ");\n" +
                assembleConstraints(e) +
                "JScrollPane " + e.getVarName() + "ScrollPane = new JScrollPane(" + e.getVarName() + ");\n" +
                "layout.setConstraints(" + e.getVarName() + "ScrollPane , gbc);\n" +
                "add(" + e.getVarName() +"ScrollPane);\n" +
                e.getVarName() + ".setLineWrap(true);\n" +
                e.getVarName() + ".setWrapStyleWord(true)\n";
        return retString;
    }

    /**
     * Assmbles Java code from an Element
     *
     * @param e The Element
     * @return String containing Java code
     */
    private String assembleJCheckBox(Element e){
        String retString = "JCheckBox " + e.getVarName() + " = new JCheckBox(" + '"' + '"' + ");\n" +
                assembleConstraints(e) +
                "layout.setConstraints(" + e.getVarName() + ", gbc);\n" +
                "add(" + e.getVarName() +");\n";
        return retString;
    }

    /**
     * Assmbles Java code from an Element
     *
     * @param e The Element
     * @return String containing Java code
     */
    private String assembleJList(Element e){
        String retString = "JList " + e.getVarName() + " = new JList(" + '"' + '"' + ");\n" +
                assembleConstraints(e) +
                "JScrollPane " + e.getVarName() + "ScrollPane = new JScrollPane(" + e.getVarName() + ");\n" +
                "layout.setConstraints(" + e.getVarName() + "ScrollPane, gbc);\n" +
                "add(" + e.getVarName() +"ScrollPane);\n";
        return retString;
    }

    /**
     * Assmbles Java code from an Element
     *
     * @param e The Element
     * @return String containing Java code
     */
    private String assembleJComboBox(Element e){
        String retString = "String " + e.getVarName() + "Data = " + '"' + '"' + ";\n" +
                "DefaultComboBoxModel " + e.getVarName() + "Model = new DefaultComboBoxModel (" + e.getVarName() +"Data.split (\"[\\\\p{Punct}\\\\s]+\"));\n" +
                "JList " + e.getVarName() + " = new JList(" + e.getVarName() + "Model);\n" +
                assembleConstraints(e) +
                "layout.setConstraints(" + e.getVarName() + ", gbc);\n" +
                "add(" + e.getVarName() +");\n";
        return retString;
    }

    /**
     * Assmbles Java code from an Element
     *
     * @param e The Element
     * @return String containing Java code
     */
    private String assembleJSpinnerList(Element e){
        String retString = "String " + e.getVarName() + "Data = " + '"' + '"' + ";\n" +
                "SpinnerListModel " + e.getVarName() + "Model = new SpinnerListModel(" + e.getVarName() + "Data.split (\"[\\\\p{Punct}\\\\s]+\"));\n" +
                "JSpinner " + e.getVarName() + " = new JSpinner(" + e.getVarName() + "Model);\n" +
                assembleConstraints(e) +
                "layout.setConstraints(" + e.getVarName() + ", gbc);\n" +
                "add(" + e.getVarName() +");\n";
        return retString;
    }

    /**
     * Assmbles Java code from an Element
     *
     * @param e The Element
     * @return String containing Java code
     */
    private String assembleJSpinnerNumber(Element e){
        String retString = "JSpinner " + e.getVarName() + " = new JSpinner(new SpinnerNumberModel(1.0, 1.0, 5.0, 1.0));\n" +
            assembleConstraints(e) +
            "layout.setConstraints(" + e.getVarName() + ", gbc);\n" +
            "add(" + e.getVarName() +");\n";
        return retString;
    }

    private String getGridBagConstraintsAnchor(String derp) {
        switch (derp.charAt(0)) {
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
                return "CENTER";
        }
    }

    private String getGridBagConstraintsFill(String derp) {
        switch (derp.charAt(0)) {
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