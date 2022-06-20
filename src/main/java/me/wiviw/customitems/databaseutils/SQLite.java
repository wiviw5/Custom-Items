package me.wiviw.customitems.databaseutils;

import me.wiviw.customitems.CustomItems;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

public class SQLite extends Database {
    // Commented out these lines below, no clue what they do.
    //String bufferDataBaseName;

    public SQLite(CustomItems instance) {
        super(instance);
        // Commented out these lines below, no clue what they do. TODO Find out what this is meant to do.
        //bufferDataBaseName = plugin.getConfig().getString("SQLite.Filename", table); // Set the table name here e.g. player_kills
    }


    // TODO Make this into a method and make those into the "db:" portion, one for buffer and one for inv.
    public String SQLiteCreateTable = "CREATE TABLE IF NOT EXISTS " + table + " (" + // make sure to put your table name in here too.
            "`player` varchar(32) NOT NULL," + // This creates the different columns you will save data too. varchar(32) Is a string, int = integer
            "`kills` int(11) NOT NULL," +
            "`total` int(11) NOT NULL," +
            "PRIMARY KEY (`player`)" +  // This is creating 3 columns Player, Kills, Total. Primary key is what you are going to use as your indexer. Here we want to use player so
            ");"; // we can search by player, and get kills and total. If you somehow were searching kills it would provide total and player.

    // TODO Remove the instant executeUpdate, we will be doing that in plugin like said above.
    public void load(String DBName) {
        connection = getSQLConnection(DBName);
        try {
            Statement s = connection.createStatement();
            s.executeUpdate(SQLiteCreateTable);
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        initialize(DBName);
    }

    // Creating the DB, getting the initial connection and making sure it's available to the rest of the plugin.
    public Connection getSQLConnection(String DBName) {
        File dataFolder = new File(plugin.getDataFolder(), DBName + ".db");
        if (!dataFolder.exists()) {
            try {
                dataFolder.createNewFile();
            } catch (IOException e) {
                plugin.getLogger().log(Level.SEVERE, "File write error: " + DBName + ".db");
            }
        }
        try {
            if (connection != null && !connection.isClosed()) {
                return connection;
            }
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dataFolder);
            return connection;
        } catch (SQLException ex) {
            plugin.getLogger().log(Level.SEVERE, "SQLite exception on initialize", ex);
        } catch (ClassNotFoundException ex) {
            plugin.getLogger().log(Level.SEVERE, "You need the SQLite JBDC library. Google it. Put it in /lib folder.");
        }
        return null;
    }
}