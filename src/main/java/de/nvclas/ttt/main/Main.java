package de.nvclas.ttt.main;

import de.nvclas.ttt.listeners.*;
import de.nvclas.ttt.settings.Config;
import de.nvclas.ttt.settings.Settings;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.ModColor;

import java.awt.*;
import java.util.List;

public class Main extends LabyModAddon {

    private static Main addon;

    public static final String PREFIX = "§8[§4TTT§7-§fAddon§8] ";

    @Override
    public void onEnable() {
        addon = this;

        api.getEventService().registerListener(new LoginServerHandler());
        api.getEventService().registerListener(new MessageModifyHandler());
        api.getEventService().registerListener(new MessageReceiveHandler());
        api.getEventService().registerListener(new RenderEntityHandler());
        api.getEventService().registerListener(new TickHandler());
        api.getEventService().registerListener(new ServerSwitchHandler());
    }

    @Override
    public void loadConfig() {
        Config.enableBetterTexts = getConfig().has("enableBetterTexts") ? getConfig().get("enableBetterTexts").getAsBoolean() : false;
        Config.traitorColor = getConfig().has("traitorColor") ? new Color(getConfig().get("traitorColor").getAsInt()) : ModColor.DARK_RED.getColor();
        Config.detectiveColor = getConfig().has("detectiveColor") ? new Color(getConfig().get("detectiveColor").getAsInt()) : ModColor.BLUE.getColor();
        Config.innocentColor = getConfig().has("innocentColor") ? new Color(getConfig().get("innocentColor").getAsInt()) : ModColor.GREEN.getColor();
        Config.innocentChestplateColor = getConfig().has("innocentChestplateColor") ? new Color(getConfig().get("innocentChestplateColor").getAsInt()) : ModColor.DARK_GRAY.getColor();
    }

    @Override
    protected void fillSettings(List<SettingsElement> list) {
        Settings.fillSettings(list);
    }

    public static Main getAddon() {
        return addon;
    }

}