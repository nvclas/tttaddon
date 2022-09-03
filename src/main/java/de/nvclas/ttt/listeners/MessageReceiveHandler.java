package de.nvclas.ttt.listeners;

import de.nvclas.ttt.utils.IngameValues;
import de.nvclas.ttt.utils.Role;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.chat.MessageReceiveEvent;

public class MessageReceiveHandler {
    @Subscribe
    public void onMessageReceive(MessageReceiveEvent event) {
        String msg = event.getComponent().getString();
        if(msg.startsWith("[TTT] Du bist ein")) {
            IngameValues.role = Role.valueOf(msg.split(" ")[4].toUpperCase());
            IngameValues.setIngame(true);
            return;
        }
        if(msg.startsWith("[TTT] Diese Runde startete mit")) {
            IngameValues.started = Integer.parseInt(msg.split(" ")[5].split("/")[0]);
            return;
        }
        if(msg.startsWith("-= Statistiken dieser Runde =-")) {
            IngameValues.resetValues();
        }
    }
}
