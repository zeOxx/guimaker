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
    private String java_second = "    }\n\n    private JLabel createJLabel(String value){\n        JLabel label = new JLabel(value);\n        return label;\n    }\n\n    private JButton createJButton(String value){\n        JButton button = new JButton(value);\n        return button;\n    }\n\n    private JTextField createJTextField(int value){\n        JTextField text = new JTextField(value);\n        return text;\n    }\n\n    private JTextArea createJTextArea(int valueR, int valueC){\n        JTextArea text = new JTextArea(valueR, valueC);\n        return text;\n    }\n\n    private JCheckBox createJCheckBox(String value){\n        JCheckBox box = new JCheckBox(value);\n        return box;\n    }\n\n    private JList createJList(Object [] values){\n        JList list = new JList(values);\n        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);\n        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);\n        list.setVisibleRowCount(-1);\n        return list;\n    }\n\n    private JComboBox createJComboBox(String [] values){\n        JComboBox combo = new JComboBox(values);\n        combo.setSelectedIndex(0);\n        return combo;\n    }\n\n    private JSpinner createJSpinnerList(String [] values){\n        SpinnerListModel spinModel = new SpinnerListModel(values);\n        JSpinner spin = new JSpinner(spinModel);\n        return spin;\n    }\n\n    private JSpinner createJSpinnerNumber(int value, int span){\n        // needs to add SpinnerNumberModel\n        SpinnerModel spinModel = new SpinnerNumberModel(value,          //initial value\n                                                    value - span,   //min value\n                                                    value + span,   //max value\n                                                    1);             //step\n        JSpinner spin = new JSpinner(spinModel);\n        return spin;\n    }\n}";

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
                            "gbc.anchor = " + getGridBagConstraintsAnchor(e.getAnchor()) + ";\n" +
                            "gbc.fill = " + getGridBagConstraintsFill(e.getFill()) + ";\n";
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
                "add(" + e.getVarName() +");\n" +
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
        return "";
    }

    /**
     * Assmbles Java code from an Element
     *
     * @param e The Element
     * @return String containing Java code
     */
    private String assembleJList(Element e){
        return "";
    }

    /**
     * Assmbles Java code from an Element
     *
     * @param e The Element
     * @return String containing Java code
     */
    private String assembleJComboBox(Element e){
        return "";
    }

    /**
     * Assmbles Java code from an Element
     *
     * @param e The Element
     * @return String containing Java code
     */
    private String assembleJSpinnerList(Element e){
        return "";
    }

    /**
     * Assmbles Java code from an Element
     *
     * @param e The Element
     * @return String containing Java code
     */
    private String assembleJSpinnerNumber(Element e){
        return "";
    }
}