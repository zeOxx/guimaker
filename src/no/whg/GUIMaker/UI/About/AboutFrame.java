package no.whg.GUIMaker.UI.About;

import no.whg.GUIMaker.Lang;
import no.whg.GUIMaker.UI.GWindowManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/16/13
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class AboutFrame extends JFrame {
    JButton closeButton;

    public AboutFrame (String tag){
        populateAbout();
        setTitle(tag);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void populateAbout(){
        JPanel panel = createContentPane();

        add(panel);
    }

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

    private JPanel createTextPanel(){
        JPanel panel = new JPanel();

        String contents = Lang.getInstance().getString("aboutString");
        JLabel label = new JLabel(contents);
        label.setSize(50, 40);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(label);
        return panel;
    }

    private JPanel createCloseButton(){
        JPanel panel = new JPanel();

        closeButton = new JButton("Close");
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
