package me.wiviw.customitems;

import me.wiviw.customitems.commands.CommandBuffer;
import me.wiviw.customitems.commands.CommandRename;
import me.wiviw.customitems.commands.CommandReturnText;
import me.wiviw.customitems.databaseutils.Database;
import me.wiviw.customitems.databaseutils.SQLite;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomItems extends JavaPlugin {

    public static String pluginname = "customitems";
    private Database bufferDB;
    private Database invDB;

    @Override
    public void onEnable() {
        this.bufferDB = new SQLite(this);
        this.bufferDB.load("bufferDB");
        this.invDB = new SQLite(this);
        this.invDB.load("invDB");
        registerCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerCommands() {
        getCommand("cirename").setExecutor(new CommandRename());
        getCommand("cireturntext").setExecutor(new CommandReturnText());
        getCommand("cibuffer").setExecutor(new CommandBuffer());
    }

    public Database getBufferDataBase() {
        return this.bufferDB;
    }

    public Database getINVDataBase() {
        return this.invDB;
    }
}
