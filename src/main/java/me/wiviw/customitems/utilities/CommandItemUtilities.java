package me.wiviw.customitems.utilities;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandItemUtilities {

    // Makes sure that the Item you are holding exists.
    public static boolean doesHeldItemExist(Player player, boolean SendErrorMessages) {
        if (player.getInventory().getItemInMainHand().getType() == Material.AIR) {
            if (SendErrorMessages) {
                player.sendMessage(ChatColor.RED + "[CI] You must be holding something.");
            }
            return false;
        }
        return true;
    }


    // TODO Likely Need to fix this, but That's a problem once I get into buffer commands for real.
    // Returns a String array minus the first argsToIgnore number. So If you wanted to ignore the first 2 args of the array, you'd <getArgsOtherwiseFromList(args, 2)>
    public static String[] ignoreXArgsFromArgs(String[] args, int argsToIgnore){
        ArrayList<String> newList = new ArrayList<>();
        for (int x = argsToIgnore; x < args.length; x++){
            newList.add(args[x]);
        }
        return (String[]) newList.toArray();
    }
}
