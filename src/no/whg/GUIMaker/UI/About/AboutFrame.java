package no.whg.GUIMaker.UI.About;

import no.whg.GUIMaker.Lang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/16/13
 * Time: 5:33 PM
 */
public class AboutFrame extends JFrame {
    JButton closeButton;
    String tag;

    /**
     * Constructor for AboutFrame
     *
     * @param tag The title of this window.
     */
    public AboutFrame (String tag){
        populateAbout();
        this.tag = tag;
        setTitle(tag);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * Adds content to AboutFrame
     */
    private void populateAbout(){
        JPanel panel = createContentPane();

        add(panel);
    }

    /**
     * Creates content pane for AboutFrame
     *
     * @return The content panel
     */
    private JPanel createContentPane(){
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setOpaque(true);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel label = createTextPanel();
        JPanel button = createCloseButton();

        panel.add(label, BorderLayout.CENTER);
        panel.add(button, BorderLayout.PAGE_END);

        return panel;
    }

    /**
     * Creates the text panel for the content pane
     *
     * @return The text panel
     */
    private JPanel createTextPanel(){
        JPanel panel = new JPanel();

        String contents = Lang.getInstance().getString("aboutString");
        JLabel label = new JLabel(contents);
        label.setSize(50, 40);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(label);
        return panel;
    }

    /**
     * Creates the close button for the content pane
     *
     * @return The close button
     */
    private JPanel createCloseButton(){
        JPanel panel = new JPanel();

        closeButton = new JButton(Lang.getInstance().getString("close"));
        closeButton.setMaximumSize(closeButton.getPreferredSize());

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setVisible(false); //you can't see me!
                dispose(); //Destroy the JFrame object
            }

        });

        panel.add(closeButton);

        return panel;
    }


}
