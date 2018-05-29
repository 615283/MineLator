package com.georlegacy.general.minelator.listeners;

import com.georlegacy.general.minelator.MineLator;
import com.georlegacy.general.minelator.api.events.ChatTranslateEvent;
import com.gtranslate.Language;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class PlayerChatListener implements Listener {
    private final MineLator ml;
    public PlayerChatListener(MineLator ml) {
        this.ml = ml;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player sender;
        String originalMessage;
        String translatedMessage;
        String originalLanguage;
        String timeStamp;
        Set<Player> recipients;

        sender = e.getPlayer();
        originalMessage = e.getMessage();
        timeStamp = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss zzz").format(new Date());
        recipients = e.getRecipients();
        originalLanguage = ml.getTranslator().detect(originalMessage);
        translatedMessage = ml.getTranslator().translate(originalLanguage, originalLanguage, Language.ENGLISH);

        ml.getServer().getPluginManager().callEvent(
                new ChatTranslateEvent(
                        sender,
                        originalMessage,
                        translatedMessage,
                        originalLanguage,
                        timeStamp,
                        recipients
                )
        );
    }

}
