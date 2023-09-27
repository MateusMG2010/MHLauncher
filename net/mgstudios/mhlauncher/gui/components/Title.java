package net.mgstudios.mhlauncher.gui.components;

import javax.swing.*;
import java.awt.*;

public class Title extends JLabel {
    public Title(String TEXT){
        super(TEXT);
        this.setForeground(Color.WHITE);
        this.setFont(new Font(Font.SERIF, Font.PLAIN, 33));
    }
}