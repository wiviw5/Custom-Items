package me.wiviw.customitems.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static me.wiviw.customitems.utilities.CommandPermissions.commandPermissionsAndChecks;
import static me.wiviw.customitems.utilities.GeneralUtilities.formatString;
import static me.wiviw.customitems.CustomItems.pluginname;

public class CommandReturnText implements TabExecutor {

    // TODO Reformat with buffer format, & align with previous associated code standards for said buffer.

    ChatColor pink = ChatColor.of("#1b1b1b");

    private final String returntextPermission = pluginname + ".commands.returntext";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (commandPermissionsAndChecks(sender,true, returntextPermission, true)){
            Player p = (Player) sender;
            StringBuilder sentMessage = new StringBuilder();
            for (String arg : args) {
                sentMessage.append(arg).append(" ");
            }
            p.sendMessage(formatString(sentMessage.toString().trim()));
            return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return new ArrayList<>(); // We don't want to have anything returned after this command.
    }
}
