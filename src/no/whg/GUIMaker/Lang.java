package no.whg.GUIMaker;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Locale;
import java.util.Observable;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * Package: no.whg.GUIMaker
 * User: Inge
 * Date: 15.10.13
 * Time: 18:19
 */

public class Lang extends Observable {
    /**
     * This class is a singleton, meaning there can only be one instance of this class.
     * Call Language.getInstance() to use it.
     */
    private static Lang instance = null;
    private Locale currentLocale;
    private ResourceBundle language;

    /**
     * Default constructor.
     * The default language is english(US).
     */
    protected Lang() {
        currentLocale = new Locale("en", "US");
        getBundle();
    }

    /**
     * Singleton
     *
     * @return Returns the one instance of the class
     */
    public static Lang getInstance() {
        if (instance == null)
            instance = new Lang();

        return instance;
    }

    /**
     * Creates a ResourceBundle based on currentLocale
     */
    private void getBundle() {
        language = ResourceBundle.getBundle("no.whg.GUIMaker.res.strings", currentLocale);
    }

    /**
     * Returns a given string in the correct language
     *
     * @param value String wanted
     * @return The correct String based on currentLocale
     */
    public String getString(String value) {
        return language.getString(value);
    }

    /**
     * Allows the user to change the language in runtime
     *
     * @param language The language
     * @param country The country of the program's language
     */
    public void changeLanguage(String language, String country) {
        currentLocale = new Locale(language, country);
        getBundle();
    }

    /**
     * Gets the current locale
     *
     * @return currentLocale
     */
    public Locale getCurrentLocale(){
        return currentLocale;
    }

    /**
     * Sets the current locale
     *
     * @param l the new locale
     */
    public void setCurrentLocale(Locale l){
        if (l != this.currentLocale){
            this.currentLocale = l;
            getBundle();
            setChanged();
            notifyObservers();
            System.out.println("set");
        }
    }
}
