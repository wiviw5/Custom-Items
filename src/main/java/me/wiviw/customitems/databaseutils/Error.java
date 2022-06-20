package me.wiviw.customitems.databaseutils;

import me.wiviw.customitems.CustomItems;

import java.util.logging.Level;

public class Error {
    public static void execute(CustomItems plugin, Exception ex){
        plugin.getLogger().log(Level.SEVERE, "Couldn't execute MySQL statement: ", ex);
    }
    public static void close(CustomItems plugin, Exception ex){
        plugin.getLogger().log(Level.SEVERE, "Failed to close MySQL connection: ", ex);
    }
}