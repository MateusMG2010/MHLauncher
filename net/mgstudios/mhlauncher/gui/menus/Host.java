package net.mgstudios.mhlauncher.gui.menus;

import net.mgstudios.mhlauncher.Extra.Resource;
import net.mgstudios.mhlauncher.gui.components.Exit;
import net.mgstudios.mhlauncher.gui.components.LiteButton;
import net.mgstudios.mhlauncher.gui.components.LitePanel;
import net.mgstudios.mhlauncher.gui.components.Return;
import net.mgstudios.mhlauncher.game.GameLauncher;
import net.mgstudios.mhlauncher.lang.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Host extends LitePanel implements ActionListener {
    private static final JLabel BACKGROUND = new JLabel();
    private final JSpinner player_spinner = new JSpinner();
    private final JComboBox<String> maps = new JComboBox<>();
    private final LiteButton HOST = new LiteButton(Text.getText("gui.host.start"), this);
    public Host(){
        //BACKGROUND SETTINGS
        BACKGROUND.setIcon(new ImageIcon(Resource.getURL("assets/mhlauncher/foxy.jpg")));
        BACKGROUND.setBounds(0,0,475,700);
        BACKGROUND.add(new Return(List.Multiplayer));
        BACKGROUND.add(new Exit());
        BACKGROUND.add(player_spinner);
        BACKGROUND.add(HOST);
        BACKGROUND.add(maps);
        this.add(BACKGROUND);
        //
        //Player Spinner Defines
        player_spinner.setBounds(5,665,120,30);
        player_spinner.setModel(new SpinnerNumberModel(2,2,8,1));
        JTextField player_field = ((JSpinner.DefaultEditor) player_spinner.getEditor()).getTextField();
        player_field.setEditable(false);
        player_field.setBackground(Color.BLACK);
        player_field.setForeground(Color.WHITE);
        player_field.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
        //
        maps.setBackground(Color.BLACK);
        maps.setForeground(Color.WHITE);
        maps.setFocusable(false);
        maps.setBounds(130, 665, 120,30);
        maps.addItem(Text.getText("gui.maps.shelter"));
        maps.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        maps.setSelectedIndex(0);
        for(int i = 1; i <= 6; i++) {
            maps.addItem(Text.getText("gui.maps.night").formatted(i));
        }
        HOST.setBounds(255,665,120,30);
        HOST.setFont(new Font(Font.SERIF, Font.PLAIN, 22));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == HOST) {
            String map_code = switch (maps.getSelectedIndex()) {
                case 0: {
                    yield "shelter";
                }
                case 1: {
                    yield "e1m2";
                }
                case 2: {
                    yield "e1m3";
                }
                case 3: {
                    yield "e1m4";
                }
                case 4: {
                    yield "e1m5";
                }
                case 5: {
                    yield "e1m6";
                }
                case 6: {
                    yield "e1m7";
                }
                default: {
                    throw new IllegalStateException("Unexpected value: " + maps.getSelectedIndex());
                }
            };
            new GameLauncher().HOST(player_spinner.getValue().toString(), map_code);
        }
    }
}