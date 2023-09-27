package net.mgstudios.mhlauncher.Extra;

import java.io.IOException;

public class Command {
    public static void RunCommand(String[] COMMAND){
        try {
            Runtime.getRuntime().exec(COMMAND);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}