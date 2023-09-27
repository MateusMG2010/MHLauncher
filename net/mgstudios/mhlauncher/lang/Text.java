package net.mgstudios.mhlauncher.lang;

import net.mgstudios.mhlauncher.gui.Frame;

import javax.swing.*;
import java.util.Properties;

public class Text {
    private static final Properties properties = LanguageManager.properties;
    public static String getText(String PROPERTY_NAME) {
        String result = properties.getProperty(PROPERTY_NAME);
        if (result != null) {
            return result;
        }
        JOptionPane.showMessageDialog(Frame.frame, "Property: %s Not Found!\nForcing Quit.".formatted(PROPERTY_NAME), "PROPERTY ERROR", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
        return "12";
    }
}