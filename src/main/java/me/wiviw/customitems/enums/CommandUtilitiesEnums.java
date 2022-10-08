package me.wiviw.customitems.enums;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.ChatColor;

public enum CommandUtilitiesEnums {
    ERROR_PLAYER_NEEDED(Component.text("[CI] You must be a player to run this command.").color(TextColor.fromHexString("#ff0b0b"))),
    ERROR_LACKING_PERMISSIONS(Component.text("[CI] You are lacking permissions to run this command.").color(TextColor.fromHexString("#ff0b0b")));

    private final TextComponent message;


    CommandUtilitiesEnums(TextComponent message) {
        this.message = message;
    }

    public TextComponent getMessage() {
        return message;
    }

}
