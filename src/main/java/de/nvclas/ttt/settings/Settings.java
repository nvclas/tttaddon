package de.nvclas.ttt.settings;

import de.nvclas.ttt.main.Main;
import net.labymod.gui.elements.ColorPicker;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ColorPickerCheckBoxBulkElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Material;
import net.labymod.utils.ModColor;

import java.util.List;

public class Settings {

    public static void fillSettings(List<SettingsElement> list) {
        //Better Texts
        BooleanElement betterTexts = new BooleanElement("Bessere Texte", new ControlElement.IconData(Material.SIGN), bool -> {
            Config.enableBetterTexts = bool;
            Main.getAddon().getConfig().addProperty("enableBetterTexts", bool);
        }, Config.enableBetterTexts);

        //Role colors
        ColorPickerCheckBoxBulkElement roleColor = new ColorPickerCheckBoxBulkElement("Rollen");
        //Traitor
        ColorPicker traitorPicker = new ColorPicker("Traitor", Config.traitorColor,
                () -> { /* Default Color */
                    Config.traitorColor = ModColor.DARK_RED.getColor();
                    Main.getAddon().getConfig().addProperty("traitorColor", ModColor.DARK_RED.getColor().getRGB());
                    return ModColor.DARK_RED.getColor();
                }, 0, 0, 0, 0);
        traitorPicker.setHasDefault(true);
        traitorPicker.setUpdateListener(traitor -> {
            if(traitor == null) return;
            Config.traitorColor = traitor;
            Main.getAddon().getConfig().addProperty("traitorColor", traitor.getRGB());
        });
        //Detective
        ColorPicker detectivePicker = new ColorPicker("Detective", Config.detectiveColor,
                () -> {  /* Default Color */
                    Config.detectiveColor = ModColor.BLUE.getColor();
                    Main.getAddon().getConfig().addProperty("detectiveColor", ModColor.BLUE.getColor().getRGB());
                    return ModColor.BLUE.getColor();
                }, 0, 0, 0, 0);
        detectivePicker.setHasDefault(true);
        detectivePicker.setUpdateListener(detective -> {
            if(detective == null) return;
            Config.detectiveColor = detective;
            Main.getAddon().getConfig().addProperty("detectiveColor", detective.getRGB());
        });
        //Innocent
        ColorPicker innocentPicker = new ColorPicker("Innocent", Config.innocentColor,
                () -> {  /* Default Color */
                    Config.innocentColor = ModColor.GREEN.getColor();
                    Main.getAddon().getConfig().addProperty("innocentColor", ModColor.GREEN.getColor().getRGB());
                    return ModColor.GREEN.getColor();
                }, 0, 0, 0, 0);
        innocentPicker.setHasDefault(true);
        innocentPicker.setUpdateListener(innocent -> {
            if(innocent == null) return;
            Config.innocentColor = innocent;
            Main.getAddon().getConfig().addProperty("innocentColor", innocent.getRGB());
        });

        //Chestplate color
        ColorPickerCheckBoxBulkElement chestplateColor = new ColorPickerCheckBoxBulkElement("Chestplates");
        //Innocent chestplate
        ColorPicker innocentChestPicker = new ColorPicker("Innocent chestplate", Config.innocentChestplateColor,
                () -> {  /* Default Color */
                    Config.innocentChestplateColor = ModColor.DARK_GRAY.getColor();
                    Main.getAddon().getConfig().addProperty("innocentChestplateColor", ModColor.DARK_GRAY.getColor().getRGB());
                    return ModColor.DARK_GRAY.getColor();
                }, 0, 0, 0, 0);
        innocentChestPicker.setHasDefault(true);
        innocentChestPicker.setHasAdvanced(true);
        innocentChestPicker.setUpdateListener(innocentChest -> {
            if(innocentChest == null) return;
            Config.innocentChestplateColor = innocentChest;
            Main.getAddon().getConfig().addProperty("innocentChestplateColor", innocentChest.getRGB());
        });

        roleColor.addColorPicker(traitorPicker);
        roleColor.addColorPicker(detectivePicker);
        roleColor.addColorPicker(innocentPicker);
        chestplateColor.addColorPicker(innocentChestPicker);

        list.add(betterTexts);
        list.add(roleColor);
        list.add(chestplateColor);
    }

}
