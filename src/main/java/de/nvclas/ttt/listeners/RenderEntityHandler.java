package de.nvclas.ttt.listeners;

import de.nvclas.ttt.settings.Config;
import de.nvclas.ttt.utils.IngameValues;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.renderer.RenderEntityEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.text.StringTextComponent;

public class RenderEntityHandler {
    @Subscribe
    public void onRenderEntity(RenderEntityEvent event) {
        if(!IngameValues.isIngame()) return;
        if(event.getEntity() instanceof PlayerEntity) {
            if(Minecraft.getInstance().world == null) return;
            PlayerEntity player = (PlayerEntity) event.getEntity();
            ScorePlayerTeam team = Minecraft.getInstance().world.getScoreboard().getPlayersTeam(player.getScoreboardName());
            if(team == null) return;
            //Innocent chestplate
            if(team.getPrefix().equals(new StringTextComponent("§a"))) {
                ((DyeableArmorItem) player.inventory.armorItemInSlot(2).getItem()).setColor(player.inventory.armorItemInSlot(2), Config.innocentChestplateColor.getRGB());
                return;
            }
            //Detective chestplate
            if(team.getPrefix().equals(new StringTextComponent("§9"))) {
                ((DyeableArmorItem) player.inventory.armorItemInSlot(2).getItem()).setColor(player.inventory.armorItemInSlot(2), Config.detectiveColor.getRGB());
                return;
            }
            //Traitor chestplate
            if(team.getPrefix().equals(new StringTextComponent("§4"))) {
                ((DyeableArmorItem) player.inventory.armorItemInSlot(2).getItem()).setColor(player.inventory.armorItemInSlot(2), Config.traitorColor.getRGB());
            }
        }
    }
}
