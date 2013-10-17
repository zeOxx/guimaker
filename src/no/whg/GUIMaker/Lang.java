package no.whg.GUIMaker;

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
     * This class extends Observable.
     * Use of setCurrentLocale() may be observed by a class that implements Observer.
     */
    private static Lang instance = null;
    private Locale currentLocale;
    private ResourceBundle language;

    /**
     * Default constructor.
     * The default language is english(US).
     *
     * TODO: Remember the user's choice of language.
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
     * Gets the current locale
     *
     * @return currentLocale
     */
    public Locale getCurrentLocale(){
        return currentLocale;
    }

    /**
     * Sets the current locale, and informs observers of the change.
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
