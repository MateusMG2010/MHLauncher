package net.mgstudios.mhlauncher.gui.menus;

import net.mgstudios.mhlauncher.Extra.Resource;
import net.mgstudios.mhlauncher.gui.Frame;
import net.mgstudios.mhlauncher.gui.components.*;
import net.mgstudios.mhlauncher.lang.Text;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Multiplayer extends LitePanel implements ActionListener {
    private final LiteButton HOST = new LiteButton(Text.getText("gui.multiplayer.host"), this);
    private final LiteButton JOIN = new LiteButton(Text.getText("gui.multiplayer.join"), this);
    public Multiplayer(){
        //BACKGROUND SETTINGS
        JLabel BACKGROUND = new JLabel();
        BACKGROUND.setIcon(new ImageIcon(Resource.getURL("assets/mhlauncher/bonnie.jpg")));
        BACKGROUND.add(new Return(List.MainPanel));
        BACKGROUND.add(new Exit());
        BACKGROUND.add(HOST);
        BACKGROUND.add(JOIN);
        BACKGROUND.setBounds(0,0,475,700);
        //
        HOST.setBounds(5,665,120,30);
        JOIN.setBounds(130, 665, 120,30);
        this.add(BACKGROUND);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==HOST){
            Frame.Load(List.Host);
        }
        if(e.getSource()==JOIN){
            Frame.Load(List.Join);
        }
    }
}