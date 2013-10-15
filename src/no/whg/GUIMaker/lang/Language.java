package no.whg.GUIMaker.lang;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * Package: no.whg.GUIMaker.lang
 * User: Inge
 * Date: 15.10.13
 * Time: 18:19
 */

public class Language {
    // This class is a singleton, meaning there can only be one instance of this class.
    // Call Language.getInstance() to use it.
    private static Language instance = null;
    private Locale currentLocale;
    private ResourceBundle messages;

    /**
     * Default constructor.
     * The default language is english(US).
     */
    protected Language() {
       currentLocale = new Locale("en", "US");
        getBundle();
    }

    /**
     * Singleton
     *
     * @return Returns the one instance of the class
     */
    public static Language getInstance() {
        if (instance == null)
            instance = new Language();

        return instance;
    }

    /**
     * Creates a ResourceBundle based on currentLocale
     */
    private void getBundle() {
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    /**
     * Returns a given string in the correct language
     *
     * @param value String wanted
     * @return The correct String based on currentLocale
     */
    public String getString(String value) {
        return messages.getString(value);
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
}
