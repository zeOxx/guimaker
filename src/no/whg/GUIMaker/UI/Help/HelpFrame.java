package no.whg.GUIMaker.UI.Help;

/*
 * Copyright (c) Ian F. Darwin, http://www.darwinsys.com/, 1996-2002.
 * All rights reserved. Software written by Ian F. Darwin and others.
 * $Id: LICENSE,v 1.8 2004/02/09 03:33:38 ian Exp $
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS''
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * Java, the Duke mascot, and all variants of Sun's Java "steaming coffee
 * cup" logo are trademarks of Sun Microsystems. Sun's, and James Gosling's,
 * pioneering role in inventing and promulgating (and standardizing) the Java
 * language and environment is gratefully acknowledged.
 *
 * The pioneering role of Dennis Ritchie and Bjarne Stroustrup, of AT&T, for
 * inventing predecessor languages C and C++ is also gratefully acknowledged.
 */

import no.whg.GUIMaker.GUIMaker;
import no.whg.GUIMaker.Lang;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/17/13
 * Time: 1:24 PM
 *
 * The vast majority of this class was taken from http://www.java2s.com/Code/Java/Swing-JFC/SimpleHelpFramebasedonJFCJEditorPane.htm
 * Copyright (c) Ian F. Darwin, http://www.darwinsys.com/, 1996-2002.
 * Some modifications have been made so it will fit into GUIMaker, but they are minor. This window will not dynamically react to locale change.
 * For more info, see the comment at the top of this class.
 */
public class HelpFrame extends JFrame implements HyperlinkListener {
    /** The contentpane */
    protected Container cp;
    String helpIndexFileName;

    /** The editorpane */
    JEditorPane help;

    /*
     * Construct a Help object. Just construct a JEditorPane with a URL, and it
     * does all the help from there.
     */
    public HelpFrame(String windowName/*, String helpIndexFileName*/) {
        super(Lang.getInstance().getString(windowName));



        cp = getContentPane();
        getAccessibleContext().setAccessibleName(windowName + " Help Window");
        getAccessibleContext().setAccessibleDescription(
                "A window for viewing the help for " + windowName
                        + ", which is somewhat hyperlinked.");
        helpIndexFileName = "res/help/index.html";
        try {
            //URL url = new File(helpIndexFileName).toURL();
            URL url = GUIMaker.class.getResource(helpIndexFileName);
            // Only create the window once.
            if (help == null) {
                setLocationRelativeTo(null);
                System.out.println("Creat-ing help window for " + url);
                help = new JEditorPane(url);
                // System.out.println("Done!");
                help.setEditable(false);
                help.addHyperlinkListener(this);
                JScrollPane scroller = new JScrollPane();
                /*scroller.setBorder(BorderFactory.createTitledBorder(windowName
                        + " Help"));*/
                scroller.getViewport().add(help);
                cp.add(BorderLayout.CENTER, scroller);
                addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        HelpFrame.this.setVisible(false);
                        HelpFrame.this.dispose();
                    }
                });
                setSize(700, 600);
            } else {
                System.out.println("Re-using help window!");
            }
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }

    /**
     * Notification of a change relative to a hyperlink. From:
     * java.swing.event.HyperlinkListener
     */
    public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            URL target = e.getURL();
            // System.out.println("linkto: " + target);

            // Get the help panel's cursor and the wait cursor
            Cursor oldCursor = help.getCursor();
            Cursor waitCursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
            help.setCursor(waitCursor);

            // Now arrange for the page to get loaded asynchronously,
            // and the cursor to be set back to what it was.
            SwingUtilities.invokeLater(new PageLoader(target, oldCursor));
        }
    }

    /**
     * Inner class that loads a URL synchronously into the help panel. Loads it
     * later than the request so that a cursor change can be done at the very
     * end.
     *
     * @author BORROWED FROM SUN'S SWING DEMO, UNTIL JAVAHELP AVAILABLE
     */
    class PageLoader implements Runnable {
        URL url;

        Cursor cursor;

        PageLoader(URL u, Cursor c) {
            url = u;
            cursor = c;
        }

        public void run() {
            // System.out.println("PageLoader: u=" + url);
            if (url == null) {
                // restore the original cursor
                help.setCursor(cursor);

                // PENDING(prinz) remove this hack when
                // automatic validation is activated.
                Container parent = help.getParent();
                parent.repaint();
            } else {
                Document doc = help.getDocument();
                try {
                    help.setPage(url);
                } catch (Exception ioe) {
                    help.setDocument(doc);
                    getToolkit().beep();
                } finally {
                    // schedule the cursor to revert after
                    // the paint has happended.
                    url = null;
                    SwingUtilities.invokeLater(this);
                }
            }
        }
    }
}