package com.georlegacy.general.minelator.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Set;

/**
 * The primary event for MineLator. Is called whenever a message sent in any language other than the base language is sent to the chat. Primary usage for API.
 *
 * @see Event
 */
public class ChatTranslateEvent extends Event {

    private Player sender;
    private String originalMessage;
    private String translatedMessage;
    private String originalLanguage;
    private String timeStamp;
    private Set<Player> recipients;

    /**
     * Class constructor for the {@link Event} to be called by the {@link org.bukkit.Bukkit} {@link org.bukkit.plugin.PluginManager}.
     *
     * @param sender The sender of the original chat message.
     * @param originalMessage The content of the message before it is translated by the {@link com.gtranslate.Translator} instance.
     * @param translatedMessage The content of the message after it has been translated by the {@link com.gtranslate.Translator} instance.
     * @param originalLanguage The {@link com.gtranslate.Language} code given to the language of the message content before translation.
     * @param timeStamp The {@link java.text.SimpleDateFormat} timestamp for the sending of the message.
     * @param recipients The {@link Set} of recipients of the message.
     */
    public ChatTranslateEvent(Player sender, String originalMessage, String translatedMessage, String originalLanguage, String timeStamp, Set<Player> recipients) {
        this.sender = sender;
        this.originalMessage = originalMessage;
        this.translatedMessage = translatedMessage;
        this.originalLanguage = originalLanguage;
        this.timeStamp = timeStamp;
        this.recipients = recipients;
    }

    /**
     * The sender of the original chat message.
     *
     * @return The Player who sent the original chat message.
     */
    public Player getPlayer() {
        return sender;
    }

    /**
     * The message sent by the player <b>before</b> translation.
     *
     * @return The String containing the message content.
     *
     * @see #getPlayer()
     */
    public String getOriginalMessage() {
        return originalMessage;
    }

    public String getTranslatedMessage() {
        return translatedMessage;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public Set<Player> getRecipients() {
        return recipients;
    }


    public static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
