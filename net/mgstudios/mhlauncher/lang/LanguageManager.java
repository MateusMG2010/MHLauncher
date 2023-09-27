package net.mgstudios.mhlauncher.lang;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.mgstudios.mhlauncher.Extra.Resource;
import net.mgstudios.mhlauncher.gui.Frame;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

public class LanguageManager {
    static final Properties properties = new Properties();
    private static final Gson gson = new Gson();
    private static JsonObject obj;
    public void Init(){
        switch (System.getProperty("user.language")) {
            case "en" -> {
                English();
            }
            case "pt" -> {
                Portuguese();
            }
            case "es" -> {
                Spanish();
            }
        }
    }
    private static void English(){
        try {
            obj = gson.fromJson(new BufferedReader(new InputStreamReader(Resource.getResource("assets/mhlauncher/lang/en_us.json"))),JsonObject.class);
            SetProperties();
        }
        catch (NullPointerException e){
            JOptionPane.showMessageDialog(Frame.frame, "English Lang File Not Found!\nForcing Quit.","LANG ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void Portuguese(){
        try {
            obj = gson.fromJson(new BufferedReader(new InputStreamReader(Resource.getResource("assets/mhlauncher/lang/pt_br.json"))),JsonObject.class);
            SetProperties();
        }
        catch (NullPointerException e){
            JOptionPane.showMessageDialog(Frame.frame, "Portuguese Lang File Not Found!\nForcing Quit.","LANG ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void Spanish(){
        try {
            obj = gson.fromJson(new BufferedReader(new InputStreamReader(Resource.getResource("assets/mhlauncher/lang/spanish.json"))),JsonObject.class);
            SetProperties();
        }
        catch (NullPointerException e){
            JOptionPane.showMessageDialog(Frame.frame, "Spanish Lang File Not Found!\nForcing Quit.","LANG ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void RegistryProperty(String PROPERTY){
        try {
            properties.setProperty(PROPERTY, obj.get(PROPERTY).getAsString());
        }
        catch (NullPointerException e){
            JOptionPane.showMessageDialog(Frame.frame, "Property: %s Not Found!\nForcing Quit".formatted(PROPERTY),"PROPERTY ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void SetProperties(){
        RegistryProperty("gui.main.singleplayer");
        RegistryProperty("gui.main.multiplayer");
        RegistryProperty("gui.multiplayer.join");
        RegistryProperty("gui.multiplayer.host");
        RegistryProperty("gui.host.start");
        RegistryProperty("gui.join.start");
        RegistryProperty("gui.error.engine");
        RegistryProperty("gui.error.directory");
        RegistryProperty("gui.error.files");
        RegistryProperty("gui.error.ip");
        RegistryProperty("gui.maps.shelter");
        RegistryProperty("gui.maps.night");
        RegistryProperty("gui.popup.copy");
        RegistryProperty("gui.popup.paste");
    }
}