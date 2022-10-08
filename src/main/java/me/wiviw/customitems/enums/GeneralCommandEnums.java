package me.wiviw.customitems.enums;

public enum GeneralCommandEnums {

    CMD_BUFFER("cibuffer", "customitems.commands.cibuffer");


    private final String permission;
    private final String commandName;

    GeneralCommandEnums(String commandName, String permission) {
        this.permission = permission;
        this.commandName = commandName;
    }

    public String getPermission() {
        return permission;
    }

    public String getCommandName() {
        return commandName;
    }
}
