package me.wiviw.customitems.enums;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;

public enum CommandEnums {

    GENERAL_ERROR_UNKNOWN(Component.text("[CI] An unknown/unnamed error has occurred, please report this.").color(TextColor.fromHexString("#ff0b0b"))),
    GENERAL_ERROR_INVALID_PARAMETER_BUFFER(Component.text("[CI] You must have a proper buffer selected.").color(TextColor.fromHexString("#ff0b0b"))),
    BUFFER_ERROR_INVALID_PARAMETERS(Component.text("[CI] Invalid Parameter, please select following list:").color(TextColor.fromHexString("#ff0b0b"))),

    GENERAL_ERROR_NOT_IMPLEMENTED(Component.text("[CI] This has not yet been implemented.").color(TextColor.fromHexString("#ff0b0b")));

    private final TextComponent message;


    CommandEnums(TextComponent message) {
        this.message = message;
    }

    public TextComponent getMessage() {
        return message;
    }
}
