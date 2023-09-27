package net.mgstudios.mhlauncher;

import net.mgstudios.mhlauncher.gui.Frame;
import net.mgstudios.mhlauncher.lang.LanguageManager;

public class Main {
    public static final String APPLICATION_VERSION = "1.1";
    public static void main(String[] args) {
        System.out.println("===MHLAUNCHER===");
        System.out.println("By @MateusMG2010");
        System.out.printf("Version: %s\n", APPLICATION_VERSION);
        new LanguageManager().Init();
        new Frame();
    }
}