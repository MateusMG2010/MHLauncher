package net.mgstudios.mhlauncher.gui.menus;

import net.mgstudios.mhlauncher.Extra.Resource;
import net.mgstudios.mhlauncher.gui.components.Exit;
import net.mgstudios.mhlauncher.gui.components.LiteButton;
import net.mgstudios.mhlauncher.gui.components.LitePanel;
import net.mgstudios.mhlauncher.gui.components.Return;
import net.mgstudios.mhlauncher.gui.components.conf.TextFieldLimit;
import net.mgstudios.mhlauncher.gui.error.ErrorManager;
import net.mgstudios.mhlauncher.game.GameLauncher;
import net.mgstudios.mhlauncher.lang.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Join extends LitePanel implements ActionListener {
    private static final JLabel BACKGROUND = new JLabel();
    private final LiteButton JOIN = new LiteButton(Text.getText("gui.join.start"), this);
    private static final JTextField IP = new JTextField();
    private static final JPopupMenu rightClickMenu = new JPopupMenu();
    private static final JMenuItem copy = new JMenuItem(Text.getText("gui.popup.copy"));
    private static final JMenuItem paste = new JMenuItem(Text.getText("gui.popup.paste"));
    public Join(){
        //BACKGROUND SETTINGS
        this.add(BACKGROUND);
        BACKGROUND.setIcon(new ImageIcon(Resource.getURL("assets/mhlauncher/chica.jpg")));
        BACKGROUND.setBounds(0,0,475,700);
        BACKGROUND.add(new Return(List.Multiplayer));
        BACKGROUND.add(new Exit());
        BACKGROUND.add(IP);
        BACKGROUND.add(JOIN);
        //

        IP.setDocument(new TextFieldLimit(20));
        IP.setFont(new Font(Font.SERIF, Font.PLAIN, 19));
        IP.setBounds(5,665,200,30);
        IP.setBackground(Color.BLACK);
        IP.setForeground(Color.WHITE);
        IP.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char character = e.getKeyChar();
                if(character==KeyEvent.VK_ENTER){
                    PrepareJoin();
                }
                else if (((e.getKeyChar() < '0') || (character > '9')) && (character != '\b') && (character != '.') && (character != ':')) {
                    e.consume();
                }
            }
        });
        IP.setComponentPopupMenu(rightClickMenu);

        //Right Click Menu Definition
        rightClickMenu.add(paste);
        rightClickMenu.add(copy);

        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        paste.addActionListener(e -> IP.paste());
        paste.setBackground(Color.BLACK);
        paste.setForeground(Color.WHITE);

        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        copy.addActionListener(e -> IP.copy());
        copy.setBackground(Color.BLACK);
        copy.setForeground(Color.WHITE);
        //

        IP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON3){
                    Join.IP.setInheritsPopupMenu(true);
                }
            }
        });
        JOIN.setBounds(210, 665, 120,30);
    }
    private void PrepareJoin(){
        if(IP.getText().equals("2010")){
            new GameLauncher().JOIN("localhost");
        }
        else if(IP.getText().isEmpty()){
            ErrorManager.MakeDialog(Text.getText("gui.error.ip"));
        }
        else {
            new GameLauncher().JOIN(IP.getText());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==JOIN){
            PrepareJoin();
        }
    }
}