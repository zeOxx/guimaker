package no.whg.GUIMaker.UI;

import no.whg.GUIMaker.Element;
import no.whg.GUIMaker.Lang;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/17/13
 * Time: 6:07 PM
 */
public class GDialog extends JOptionPane {
    Element element;

    public GDialog(Element e){
        this.element = e;
    }

    public void showInputDialog(GFrame parent){
        String [] possibilities = element.types;
        String current = element.getType();

        String s = (String)super.showInputDialog(
                parent,
                Lang.getInstance().getString("type") + ":\n",
                Lang.getInstance().getString("titlepreferences"),
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                current);
        //If a string was returned, say so.
        if ((s != null) && (s.length() > 0)) {
            if (!s.equals(current)){
                for (int i = 0; i < possibilities.length; i++){
                    System.out.println(i);
                    if (s.equals(possibilities[i])){
                        System.out.println("Breaking at " + i);
                        break;
                    }
                }
            } else {
                System.out.println("User chose " + s + ", but that was already selected");
            }
        }
        //If you're here, the return value was null/empty.
        System.out.println("Return value was null/empty");
    }
}
