package me.wiviw.customitems;

import me.wiviw.customitems.commands.BufferCommand;
import org.bukkit.plugin.java.JavaPlugin;

import static me.wiviw.customitems.enums.GeneralCommandEnums.*;

public final class CustomItems extends JavaPlugin {

    private static CustomItems instance;

    @Override
    public void onEnable() {
        instance = this;
        registerCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerCommands() {
        getCommand(CMD_BUFFER.getCommandName()).setExecutor(new BufferCommand());
        getCommand(CMD_BUFFER.getCommandName()).setPermission(CMD_BUFFER.getPermission());
    }

    public static CustomItems getInstance() {
        return instance;
    }
}
