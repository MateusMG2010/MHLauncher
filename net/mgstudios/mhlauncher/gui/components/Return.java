package net.mgstudios.mhlauncher.gui.components;

import javax.swing.*;
import java.awt.*;
import net.mgstudios.mhlauncher.gui.Frame;
import net.mgstudios.mhlauncher.gui.menus.List;

public class Return extends JButton {
    public Return(List TO_RETURN) {
        super("<");
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
        this.setFocusable(false);
        this.setBounds(5,5,55,55);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.addActionListener((e) -> {
            Frame.Load(TO_RETURN);
        });
    }
}