package com.georlegacy.general.minelator;

import com.georlegacy.general.minelator.listeners.PlayerChatListener;
import com.gtranslate.Language;
import com.gtranslate.Translator;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MineLator extends JavaPlugin {

    Translator translator;
    Language language;

    @Override
    public void onEnable() {
        translator = Translator.getInstance();
        language = Language.getInstance();

        PluginManager pm = this.getServer().getPluginManager();

        pm.registerEvents(new PlayerChatListener(this), this);
    }

    @Override
    public void onDisable() {

    }

}
