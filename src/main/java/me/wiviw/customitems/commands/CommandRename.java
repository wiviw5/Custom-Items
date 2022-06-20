package me.wiviw.customitems.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static me.wiviw.customitems.CustomItems.pluginname;
import static me.wiviw.customitems.utilities.CommandItemUtilities.doesHeldItemExist;
import static me.wiviw.customitems.utilities.CommandPermissions.commandPermissionsAndChecks;
import static me.wiviw.customitems.utilities.GeneralUtilities.formatString;

public class CommandRename implements TabExecutor {

    // TODO Implement with Buffers instead of in command.

    String renamePermission = pluginname + ".commands.rename";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (commandPermissionsAndChecks(sender,true, renamePermission, true)){
            Player p = (Player) sender;
            if (doesHeldItemExist(p, true)){
                StringBuilder name = new StringBuilder();
                for (String arg : args) {
                    name.append(arg).append(" ");
                }
                TextComponent finalizedName = formatString(name.toString().trim());
                p.getInventory().setItemInMainHand(renameItemStack(p.getInventory().getItemInMainHand(), finalizedName));
                return true;
            }
        }
        return false;
    }

    public ItemStack renameItemStack(ItemStack itemStack, TextComponent name){
        ItemMeta ItemMeta = itemStack.getItemMeta();
        ItemMeta.displayName(name);
        itemStack.setItemMeta(ItemMeta);
        return itemStack;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return new ArrayList<>(); // We don't want to have anything returned after this command.
    }
}
