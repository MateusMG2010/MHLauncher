package net.mgstudios.mhlauncher.gui.components;

import javax.swing.*;
import java.awt.*;

public class ErrorLabel extends JLabel {
    public ErrorLabel(String ERROR_TEXT){
        super(ERROR_TEXT);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.RED);
        this.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
        this.setBounds(0,20,400,30);
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}