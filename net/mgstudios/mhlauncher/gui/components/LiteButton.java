package net.mgstudios.mhlauncher.gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LiteButton extends JButton {
    public LiteButton(String TEXT, ActionListener listener) {
        super(TEXT);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setFocusable(false);
        this.addActionListener(listener);
    }
}