package com.georlegacy.general.minelator.util;

import com.georlegacy.general.minelator.MineLator;
import org.bukkit.entity.Player;

public class MessageUtil {
    private final MineLator ml;
    public MessageUtil(MineLator ml) {
        this.ml = ml;
    }

    public void sendToPermissionHolders(String permission, String message) {
        for (Player p : ml.getServer().getOnlinePlayers()) {
            if (p.hasPermission(permission)) {
                p.sendMessage(ColorUtil.color(message));
            }
        }
    }

}
