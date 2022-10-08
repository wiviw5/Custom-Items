package me.wiviw.customitems.utilities;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.wiviw.customitems.enums.CommandUtilitiesEnums.*;

public class CommandUtilities {

    /**
     * Checks for permissions & if the command needs a player.
     *
     * @param sender      User checked against for permissions & to send errors too
     * @param permission  Permission string command is associated with
     * @param needsPlayer If a Player is needed for the command
     * @return true if the sender has permission or is OP, otherwise returns false if the user is lacking permissions or is not a player and a player is needed.
     */
    public static boolean checkSender(CommandSender sender, String permission, boolean needsPlayer) {
        // If a player is needed & sender is not a player, then send error message & return false.
        if (needsPlayer && !(sender instanceof Player)) {
            sender.sendMessage(ERROR_PLAYER_NEEDED.getMessage());
            return false;
        }
        // If the sender does not have the permission, then send error message & return false.
        if (!sender.hasPermission(permission)) {
            sender.sendMessage(ERROR_LACKING_PERMISSIONS.getMessage());
            return false;
        }
        // OP override & Final permission check returns true if either is met.
        return sender.hasPermission(permission) || sender.isOp();
    }
}
