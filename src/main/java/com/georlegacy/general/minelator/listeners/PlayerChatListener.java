package com.georlegacy.general.minelator.listeners;

import com.georlegacy.general.minelator.MineLator;
import com.georlegacy.general.minelator.api.events.ChatTranslateEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {
    private final MineLator ml;
    public PlayerChatListener(MineLator ml) {
        this.ml = ml;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        ml.getServer().getPluginManager().callEvent(new ChatTranslateEvent());
    }

}
