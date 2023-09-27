package net.mgstudios.mhlauncher.gui;

import net.mgstudios.mhlauncher.Extra.Resource;
import net.mgstudios.mhlauncher.gui.menus.*;
import net.mgstudios.mhlauncher.gui.menus.List;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private static final MainPanel mainPanel = new MainPanel();
    private static final Multiplayer multiplayer = new Multiplayer();
    private static final Host host = new Host();
    private static final Join join = new Join();
    private static final JLabel BACKGROUND = new JLabel();
    public static JFrame frame;
    public Frame(){
        frame = this;
        this.setUndecorated(true);
        this.setSize(475,700);
        this.add(BACKGROUND);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(Resource.getURL("assets/mhlauncher/icon.png")));
        BACKGROUND.setBounds(0,0,475,700);
        BACKGROUND.setIcon(new ImageIcon(Resource.getURL("assets/mhlauncher/intro/INTRO_0.png")));
        sleep(750);
        BACKGROUND.setIcon(new ImageIcon(Resource.getURL("assets/mhlauncher/intro/INTRO_1.png")));
        sleep(2250);
        Load(List.MainPanel);
    }
    private static void sleep(int TIME){
        try {
            Thread.sleep(TIME);
        }
        catch (InterruptedException e){
            System.out.println("Ignored!");
        }
    }
    private static void refresh(){
        SwingUtilities.updateComponentTreeUI(frame);
    }
    public static void Load(List MENU){
        switch (MENU){
            case MainPanel -> {
                frame.setContentPane(mainPanel);
                refresh();
            }
            case Multiplayer -> {
                frame.setContentPane(multiplayer);
                refresh();
            }
            case Host -> {
                frame.setContentPane(host);
                refresh();
            }
            case Join -> {
                frame.setContentPane(join);
                refresh();
            }
        }
    }
}