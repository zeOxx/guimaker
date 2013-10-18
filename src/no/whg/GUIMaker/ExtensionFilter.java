package no.whg.GUIMaker;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * Created with IntelliJ IDEA.
 * User: snorre
 * Date: 10/18/13
 * Time: 1:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class ExtensionFilter extends FileFilter {
    private String extensions[];

    private String description;

    public ExtensionFilter(String description, String extension) {
        this(description, new String[] { extension });
    }

    public ExtensionFilter(String description, String extensions[]) {
        this.description = description;
        this.extensions = (String[]) extensions.clone();
    }

    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        int count = extensions.length;
        String path = file.getAbsolutePath();
        for (int i = 0; i < count; i++) {
            String ext = extensions[i];
            if (path.endsWith(ext)
                    && (path.charAt(path.length() - ext.length()) == '.')) {
                return true;
            }
        }
        return false;
    }

    public String getDescription() {
        return (description == null ? extensions[0] : description);
    }
}