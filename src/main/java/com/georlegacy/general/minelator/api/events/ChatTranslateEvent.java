package com.georlegacy.general.minelator.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Date;
import java.util.Set;

/**
 * The primary event for MineLator. Is called whenever a message sent in any language other than the base language is sent to the chat. Primary usage for API.
 *
 * @see Event
 *
 * @author James Conway (615283)
 * @since 1.0
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
    public Player getSender() {
        return sender;
    }

    /**
     * The message sent by the player <b>before</b> translation.
     *
     * @return The String containing the message content.
     *
     * @see #getSender()
     */
    public String getOriginalMessage() {
        return originalMessage;
    }

    /**
     * The message sent by the player <b>after</b> translation.
     *
     * @return The String containing the message content.
     *
     * @see #getSender()
     * @see #getOriginalMessage()
     */
    public String getTranslatedMessage() {
        return translatedMessage;
    }

    /**
     * The {@link com.gtranslate.Language} code for the original language prior to the translation.
     *
     * @return The String language code.
     *
     * @see com.gtranslate.Language
     */
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    /**
     * The timestamp for the sending of the original message.
     *
     * @return Timestamp formatted as a String with {@link java.text.SimpleDateFormat}.
     *
     * @see java.text.SimpleDateFormat#format(Date)
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * The players who received the message sent by the sender.
     *
     * @return {@link Set} of {@link Player}s.
     */
    public Set<Player> getRecipients() {
        return recipients;
    }

    /**
     * Bukkit {@link HandlerList}
     */
    public static final HandlerList handlers = new HandlerList();


    /**
     * superclass @Override method
     *
     * @return {@link java.util.List} of EventHandlers
     */
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
