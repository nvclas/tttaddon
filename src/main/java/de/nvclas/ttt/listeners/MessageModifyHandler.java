package de.nvclas.ttt.listeners;

import de.nvclas.ttt.main.Main;
import de.nvclas.ttt.settings.Config;
import de.nvclas.ttt.utils.ColorUtil;
import de.nvclas.ttt.utils.IngameValues;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.chat.MessageModifyEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.StringTextComponent;

import java.util.Arrays;
import java.util.List;

public class MessageModifyHandler {
    @Subscribe
    public void onMessageModify(MessageModifyEvent event) {
        if(Minecraft.getInstance().player == null) return;
        String msg = event.getComponent().getString();
        if(Config.enableBetterTexts) {
            if(msg.startsWith("[TTT]")) {
                if(msg.contains("Du kannst dieses Item erst nach Ende der Schutzzeit aufnehmen")) {
                    event.setComponent(null);
                    Minecraft.getInstance().player.playSound(new SoundEvent(new ResourceLocation("block.chest.locked")), 1f, 4f);
                    return;
                }
                if(msg.contains("Die Runde beginnt!")) {
                    event.setComponent(new StringTextComponent("§f[§4TTT§f] §eDie Runde beginnt!"));
                    Minecraft.getInstance().player.playSound(new SoundEvent(new ResourceLocation("block.note_block.pling")), 1f, 4f);
                    return;
                }
                if(deletedMessages.stream().anyMatch(msg::contains)) {
                    event.setComponent(null);
                    return;
                }
                if(msg.contains("Diese Runde startete mit")) {
                    event.setComponent(new StringTextComponent("§f[§4TTT§f] §eSpieler§7: §b" + IngameValues.started + " §7- §4" + IngameValues.getTraitorAmount(IngameValues.started)));
                    return;
                }
                if(msg.contains("Du bist ein")) {
                    String role = msg.split(" ")[4];
                    event.setComponent(new StringTextComponent("§f[§4TTT§f] §eDeine Rolle§7: " + ColorUtil.fromColor(IngameValues.role.getColor()) + role));
                    return;
                }
                if(msg.contains("wurde von einem Random-Tester überprüft")) {
                    event.setComponent(new StringTextComponent("§f[§4TTT§f] §a" + msg.split(" ")[1] + " §ewurde geprüft"));
                    return;
                }
                if(msg.contains("wurde von einem Random-Tester enttarnt")) {
                    event.setComponent(new StringTextComponent("§f[§4TTT§f] §4" + msg.split(" ")[1] + " §ewurde enttarnt"));
                    return;
                }
                if(msg.contains("Der Random-Tester von dem Spieler")) {
                    String traitor = msg.split(" ")[11].replace("!", "");
                    String detective = msg.split(" ")[6];
                    event.setComponent(new StringTextComponent("§f[§4TTT§f] §4" + traitor + " §cwird in §e15 Sekunden §cvon §9" + detective + " §centtarnt"));
                }
                if(msg.contains("hat einen Random-Tester auf dich angesetzt")) {
                    String detective = msg.split(" ")[3];
                    event.setComponent(new StringTextComponent("§f[§4TTT§f] §9" + detective + " §centtarnt dich in §e40 Sekunden"));
                }
            }
            if(msg.startsWith("Der Server ist voll.")) {
                event.setComponent(new StringTextComponent(Main.PREFIX + "§cServer voll"));
            }
        }
    }

    final List<String> deletedMessages = Arrays.asList(
            "Finde und eliminiere durch Beobachten alle Traitor",
            "Töte unauffällig alle Innocents und Detectives",
            "Nutze @t, um mit deinen Traitor-Kollegen zu kommunizieren",
            "Nutze @d, um mit deinem Detective-Kollegen zu kommunizieren",
            "Grundloses Töten von Spielern ist verboten",
            "Öffne den Shop mit /shop"
    );

}
