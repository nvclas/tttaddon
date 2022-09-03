package de.nvclas.ttt.listeners;

import de.nvclas.ttt.settings.Config;
import de.nvclas.ttt.utils.ColorUtil;
import de.nvclas.ttt.utils.IngameValues;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

public class TickHandler {
    @Subscribe
    public void onTick(TickEvent event) {
        if(Minecraft.getInstance().getConnection() == null || !IngameValues.isIngame()) return;
        for(NetworkPlayerInfo entry : Minecraft.getInstance().getConnection().getPlayerInfoMap()) {
            ScorePlayerTeam team = entry.getPlayerTeam();
            if(team == null) continue;
            //Innocent color
            if(team.getPrefix().equals(new StringTextComponent("§a")) || (team.getPrefix().getString().equals("") && team.getColor() == TextFormatting.GREEN)) {
                team.setColor(ColorUtil.fromColor(Config.innocentColor));
                team.setPrefix(new StringTextComponent("§a"));
                continue;
            }
            //Detective color
            if(team.getPrefix().equals(new StringTextComponent("§9")) || (team.getPrefix().getString().equals("") && team.getColor() == TextFormatting.BLUE)) {
                team.setColor(ColorUtil.fromColor(Config.detectiveColor));
                team.setPrefix(new StringTextComponent("§9"));
                continue;
            }
            //Traitor color
            if(team.getPrefix().equals(new StringTextComponent("§4")) || (team.getPrefix().getString().equals("") && team.getColor() == TextFormatting.DARK_RED)) {
                team.setColor(ColorUtil.fromColor(Config.traitorColor));
                team.setPrefix(new StringTextComponent("§4"));
            }

        }
    }
}
