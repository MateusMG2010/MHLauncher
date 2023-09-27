package net.mgstudios.mhlauncher.game;

import net.mgstudios.mhlauncher.Extra.Command;
import net.mgstudios.mhlauncher.gui.error.ErrorManager;
import net.mgstudios.mhlauncher.lang.Text;

import java.io.File;
public class GameLauncher {
    private static final String GAME_PATH = "Game";
    private static final String WADS_PATH = "%s\\Wads\\".formatted(GAME_PATH);
    private static final File GAME_FOLDER = new File(GAME_PATH);
    private static final File FD1 = new File("%s\\FD1\\FiveNightsAtFreddys.wad".formatted(WADS_PATH));
    private static final File FD1_PK3 = new File("%s\\FD1\\FNAF.pk3".formatted(WADS_PATH));
    private static final File JF = new File("%s\\Font\\JF.pk3".formatted(WADS_PATH));
    private static final File CONFIG = new File("%s\\gzdoom.ini".formatted(GAME_PATH));
    private boolean CheckAll(){
        return FD1.exists() && FD1_PK3.exists() && JF.exists() && CONFIG.exists();
    }
    public void SINGLEPLAYER() {
        if(GAME_FOLDER.exists()){
            if(CheckAll()){
                Command.RunCommand(new String[]{"cmd.exe","/c","cd Game && start gzdoom.exe +sv_cheats 1 +map shelter"});
                System.exit(0);
            }
            else {
                ErrorManager.MakeDialog(Text.getText("gui.error.files"));
            }
        }
        else {
            ErrorManager.MakeDialog(Text.getText("gui.error.directory"));
        }
    }
    public void HOST(String p_number, String map){
        if(GAME_FOLDER.exists()){
            if(CheckAll()){
                Command.RunCommand(new String[]{"cmd.exe","/c","cd Game && start gzdoom.exe -host %s +map %s +sv_cheats 1".formatted(p_number, map)});
                System.exit(0);
            }
            else {
                ErrorManager.MakeDialog(Text.getText("gui.error.files"));
            }
        }
        else {
            ErrorManager.MakeDialog(Text.getText("gui.error.directory"));
        }
    }
    public void JOIN(String HOST_IP) {
        if(GAME_FOLDER.exists()){
            if(CheckAll()){
                Command.RunCommand(new String[]{"cmd.exe","/c","cd Game && start gzdoom.exe -join %s -skill 4".formatted(HOST_IP)});
                System.exit(0);
            }
            else {
                ErrorManager.MakeDialog(Text.getText("gui.error.files"));
            }
        }
        else {
            ErrorManager.MakeDialog(Text.getText("gui.error.directory"));
        }
    }
}