package net.mgstudios.mhlauncher.Extra;

import net.mgstudios.mhlauncher.Main;
import net.mgstudios.mhlauncher.gui.Frame;

import javax.swing.*;
import java.io.InputStream;
import java.net.URL;

public class Resource {
    public static URL getURL(String ADDRESS) {
        try {
            return Main.class.getClassLoader().getResource(ADDRESS);
        }
        catch (NullPointerException e){
            Frame.frame.setVisible(false);
            JOptionPane.showMessageDialog(Frame.frame, "Resource: %s".formatted(ADDRESS), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        return null;
    }
    public static InputStream getResource(String ADDRESS) {
        return Main.class.getClassLoader().getResourceAsStream(ADDRESS);
    }
}