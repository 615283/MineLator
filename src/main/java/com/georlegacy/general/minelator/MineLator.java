package com.georlegacy.general.minelator;

import com.georlegacy.general.minelator.listeners.PlayerChatListener;
import com.georlegacy.general.minelator.util.MessageUtil;
import com.rmtheis.yandtran.TranslateUtils;
import com.rmtheis.yandtran.language.Language;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MineLator extends JavaPlugin {
    private MessageUtil messageUtil;

    public MessageUtil getMessageUtil() {
        return messageUtil;
    }

    @Override
    public void onEnable() {

        System.out.println(TranslateUtils.translate("KEY", "I think that we really ought to use french more often", Language.ENGLISH, Language.FRENCH));

        this.messageUtil = new MessageUtil(this);

        PluginManager pm = this.getServer().getPluginManager();

        pm.registerEvents(new PlayerChatListener(this), this);

    }

    @Override
    public void onDisable() {

    }

}
