package me.wiviw.customitems.utilities;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPermissions {

    public static boolean OPCommandOverride = true; // Global Override for OP Permissions to execute plugin commands regardless of permissions

    public static boolean commandPermissionsAndChecks(CommandSender sender, boolean needsPlayer, String Permission, boolean SendErrorMessages) {
        // If the command requires a player, and the sender is not an instance of a player, deny.
        if (needsPlayer) {
            if (!(sender instanceof Player)) {
                if (SendErrorMessages){
                    sender.sendMessage(ChatColor.RED + "[CI] Console Cannot run this command.");
                }
                return false;
            }
        }
        // If OP Override is on and player has op, allow command to pass through
        if (OPCommandOverride) {
            if (!sender.isOp()) {
                if (SendErrorMessages){
                    sender.sendMessage(ChatColor.RED + "[CI] You are lacking permissions to run this command.");
                }
                return false;
            }
            return true;
        }
        // Check if player doesn't have permission
        if (!sender.hasPermission(Permission)){
            if (SendErrorMessages){
                sender.sendMessage(ChatColor.RED + "[CI] You are lacking permissions to run this command.");
            }
        }
        return sender.hasPermission(Permission);
    }
}
