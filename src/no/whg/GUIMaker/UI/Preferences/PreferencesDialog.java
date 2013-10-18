package no.whg.GUIMaker.UI.Preferences;

import no.whg.GUIMaker.Lang;
import no.whg.GUIMaker.UI.GFrame;

import javax.swing.*;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA for guimaker
 * User: Snorre
 * Date: 10/16/13
 * Time: 9:43 PM
 */
public class PreferencesDialog extends JOptionPane {
    Locale currentLocale;

    /**
     * Constructor for PreferencesDialog
     *
     * @param cl the current locale
     */
    public PreferencesDialog(Locale cl){
        currentLocale = cl;
    }

    /**
     * Shows an input dialog that lets the user change locale
     *
     * @param parent The parent this dialog belongs to
     */
    public void showInputDialog(GFrame parent){
        String temp = currentLocale.getCountry();
        if (temp.equals("US")){
            temp = Lang.getInstance().getString("en_US");
        } else if (temp.equals("NO")){
            temp = Lang.getInstance().getString("nb_NO");
        } else { return; }

        Object[] possibilities = {Lang.getInstance().getString("en_US"), Lang.getInstance().getString("nb_NO")};
        String s = (String)super.showInputDialog(
                parent,
                Lang.getInstance().getString("language") + ":\n",
                Lang.getInstance().getString("titlepreferences"),
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                temp);
        //If a string was returned, say so.
        if ((s != null) && (s.length() > 0)) {
            Locale l;
            if (s.equals(Lang.getInstance().getString("en_US"))){
                l = new Locale("en", "US");
                Lang.getInstance().setCurrentLocale(l);
            } else if (s.equals(Lang.getInstance().getString("nb_NO"))){
                l = new Locale ("nb", "NO");
                Lang.getInstance().setCurrentLocale(l);
            }
        }
        //If you're here, the return value was null/empty.
    }
}
