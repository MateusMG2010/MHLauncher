package net.mgstudios.mhlauncher.gui.components;

import java.awt.*;

public class Exit extends LiteButton {
    public Exit(){
        super("X", null);
        this.setBounds(415, 5, 55, 55);
        this.addActionListener((e) -> {
            System.exit(0);
        });
        this.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
    }
}