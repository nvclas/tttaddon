package de.nvclas.ttt.listeners;

import de.nvclas.ttt.utils.IngameValues;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.network.server.ServerSwitchEvent;

public class ServerSwitchHandler {
    @Subscribe
    public void onServerSwitch(ServerSwitchEvent event) {
        if(IngameValues.isIngame()) IngameValues.resetValues();
    }
}
