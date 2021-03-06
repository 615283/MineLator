package com.georlegacy.general.minelator.listeners;

import com.georlegacy.general.minelator.MineLator;
import com.georlegacy.general.minelator.api.events.ChatTranslateEvent;
import com.rmtheis.yandtran.TranslateUtils;
import com.rmtheis.yandtran.language.Language;
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
        Language originalLanguage;
        String timeStamp;
        Set<Player> recipients;

        sender = e.getPlayer();
        originalMessage = e.getMessage();
        timeStamp = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss zzz").format(new Date());
        recipients = e.getRecipients();
        originalLanguage = Language.fromString(TranslateUtils.detect("APIKEY", originalMessage));
        translatedMessage = TranslateUtils.translate("APIKEY", originalMessage, originalLanguage, Language.ENGLISH);

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

        ml.getMessageUtil().sendToPermissionHolders("minelator.monitor", String.format("&7[TRANSLATED] &8(%s) &r%s: &f%s", originalLanguage.toString(), sender.getDisplayName(), translatedMessage));

    }

}
