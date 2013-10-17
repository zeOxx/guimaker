package no.whg.GUIMaker.UI.Help;

import no.whg.GUIMaker.Lang;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/17/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelpFrame extends JFrame implements Observer {
    String title;

    public HelpFrame(String t){
        populateHelp();
        this.title = t;
        setTitle(Lang.getInstance().getString(t));
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        observe(Lang.getInstance());
    }

    public void populateHelp(){
        //
    }

    /**
     * Starts observing an Observable
     *
     * @param o The Observable to observe
     */
    public void observe(Observable o) {
        o.addObserver(this);
    }

    /**
     * Called when notified by the observable. Updates content to reflect the change
     *
     * @param o The Observable being observed
     * @param arg The argument passed to the observer
     */
    @Override
    public void update(Observable o, Object arg) {
        this.setTitle(Lang.getInstance().getString(title));
    }
}
