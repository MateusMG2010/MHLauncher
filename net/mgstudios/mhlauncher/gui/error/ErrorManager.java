package net.mgstudios.mhlauncher.gui.error;

import net.mgstudios.mhlauncher.gui.Frame;
import net.mgstudios.mhlauncher.gui.components.ErrorLabel;
import net.mgstudios.mhlauncher.gui.components.LiteButton;

import javax.swing.*;
import java.awt.*;

public class ErrorManager {
    private static JDialog dialog;
    public static void MakeDialog(String TEXT) {
        if(dialog == null || !dialog.isShowing()){
            dialog = new JDialog(Frame.frame);
            ErrorLabel ERROR = new ErrorLabel(TEXT);
            LiteButton OK = new LiteButton("OK", (e) -> {
                dialog.dispose();
            });
            dialog.getContentPane().setBackground(Color.BLACK);
            dialog.getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
            dialog.setUndecorated(true);
            dialog.setVisible(true);
            dialog.setSize(400,120);
            dialog.setLocationRelativeTo(Frame.frame);
            OK.setBounds(102,75,200,35);
            OK.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
            dialog.add(ERROR);
            dialog.add(OK);
            dialog.setLayout(null);
        }
    }
}