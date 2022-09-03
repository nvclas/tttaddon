package de.nvclas.ttt.listeners;

import de.nvclas.ttt.main.Main;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.network.server.LoginServerEvent;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;

public class LoginServerHandler {
    @Subscribe
    public void onServerLogin(LoginServerEvent event) {
        if(Minecraft.getInstance().world == null || Minecraft.getInstance().player == null) return;
        if(event.getServerData().getIp().contains("gomme")) {
            if(!Minecraft.getInstance().world.getScoreboard().getObjectiveNames().contains("Freunde§7:")) {
                LabyMod.getInstance().displayMessageInChat(Main.PREFIX + "§cYour §clanguage §cis §cnot §cset §cto §cGerman. §cThis §caddon §cmay §cnot §cwork §cproperly");
            }
            //special welcome message for TTT clans
            if(Minecraft.getInstance().player.getDisplayName().getString().contains("[Tokyo]"))
                LabyMod.getInstance().displayMessageInChat(Main.PREFIX + "§aWillkommen §e" + LabyMod.getInstance().getPlayerName());
            else if(Minecraft.getInstance().player.getDisplayName().getString().contains("[xTTT]"))
                LabyMod.getInstance().displayMessageInChat(Main.PREFIX + "§aWillkommen §5" + LabyMod.getInstance().getPlayerName());
            else if(Minecraft.getInstance().player.getDisplayName().getString().contains("[EMP]"))
                LabyMod.getInstance().displayMessageInChat(Main.PREFIX + "§aWillkommen §2" + LabyMod.getInstance().getPlayerName());
            else if(Minecraft.getInstance().player.getDisplayName().getString().contains("[Nano]"))
                LabyMod.getInstance().displayMessageInChat(Main.PREFIX + "§aWillkommen §9" + LabyMod.getInstance().getPlayerName());
            else if(Minecraft.getInstance().player.getDisplayName().getString().contains("[TTTSt]"))
                LabyMod.getInstance().displayMessageInChat(Main.PREFIX + "§aWillkommen §3" + LabyMod.getInstance().getPlayerName());
            else if(Minecraft.getInstance().player.getDisplayName().getString().contains("[RMY]"))
                LabyMod.getInstance().displayMessageInChat(Main.PREFIX + "§aWillkommen §d" + LabyMod.getInstance().getPlayerName());
            else if(Minecraft.getInstance().player.getDisplayName().getString().contains("[close]"))
                LabyMod.getInstance().displayMessageInChat(Main.PREFIX + "§aWillkommen §b" + LabyMod.getInstance().getPlayerName());
            else LabyMod.getInstance().displayMessageInChat(Main.PREFIX + "§aWillkommen §f" + LabyMod.getInstance().getPlayerName());

        }
    }
}
