package net.mgstudios.mhlauncher.gui.menus;

import net.mgstudios.mhlauncher.gui.Frame;
import net.mgstudios.mhlauncher.Extra.Resource;
import net.mgstudios.mhlauncher.gui.components.*;
import net.mgstudios.mhlauncher.game.GameLauncher;
import net.mgstudios.mhlauncher.lang.Text;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends LitePanel implements ActionListener {
    private static final JLabel BACKGROUND = new JLabel();
    public static final ImageIcon ICON = new ImageIcon(Resource.getURL("assets/mhlauncher/background.png"));
    LiteButton SINGLEPLAYER = new LiteButton(Text.getText("gui.main.singleplayer"), this);
    LiteButton MULTIPLAYER = new LiteButton(Text.getText("gui.main.multiplayer"), this);
    Exit EXIT = new Exit();
    Title TITLE = new Title("MHLauncher");
    public MainPanel() {
        //Background Definition
        BACKGROUND.setIcon(ICON);
        BACKGROUND.add(SINGLEPLAYER);
        BACKGROUND.add(MULTIPLAYER);
        BACKGROUND.add(TITLE);
        BACKGROUND.add(EXIT);
        this.add(BACKGROUND);
        //
        BACKGROUND.setBounds(0,0,475,700);
        SINGLEPLAYER.setBounds(5,665,120,30);
        MULTIPLAYER.setBounds(130, 665, 120,30);
        TITLE.setBounds(5,10,200,35);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==SINGLEPLAYER){
            new GameLauncher().SINGLEPLAYER();
        }
        if(e.getSource()==MULTIPLAYER){
            Frame.Load(List.Multiplayer);
        }
    }
}