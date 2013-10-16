package no.whg.GUIMaker.UI.About;

import no.whg.GUIMaker.Lang;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/16/13
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class AboutFrame extends JFrame {
    public AboutFrame (String tag){
        populateAbout();
        setTitle(tag);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void populateAbout(){
        String contents = Lang.getInstance().getString("aboutString");
        JPanel panel = new JPanel(new BorderLayout(10,10));
        JLabel label = new JLabel(contents);
        JButton button = new JButton("Close");
        button.setMaximumSize(button.getPreferredSize());

        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        //panel.add(button);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panel);
        //
        // pack();
    }
}
