package me.wiviw.customitems.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static me.wiviw.customitems.CustomItems.pluginname;
import static me.wiviw.customitems.utilities.CommandPermissions.commandPermissionsAndChecks;
import static me.wiviw.customitems.utilities.BufferUtilities.*;

public class CommandBuffer implements TabExecutor {

    // TODO Finish SQL first, then move onto the Utilities, then finish this and after move onto other commands.

    private final String bufferPermission = pluginname + ".commands.buffer";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (commandPermissionsAndChecks(sender,true, bufferPermission, true)){
            if (!(args.length>2)){

            }
            //MiniMessage mm = MiniMessage.miniMessage();
            Player p = (Player) sender;
            switch (args[0]){
                case "new":
                    newBufferCMD("FutureProof", args);
                    break;
                case "add":
                    addBufferCMD("FutureProof", args);
                    break;
                case "edit":
                    editBufferCMD("FutureProof", args);
                    break;
                case "show":
                    showBufferCMD("FutureProof", p);
                    break;
                case "listwords":
                    listWordsBufferCMD("FutureProof", p);
                    break;
                case "listchars":
                    listCharsBufferCMD("FutureProof", p);
                    break;
                case "listchildren":
                    listChildrenBufferCMD("FutureProof", p);
                    break;
                case "test":
                    testCMD("FutureProof");
                    break;
                default:
                    p.sendMessage(Component.text("Nope!").color(TextColor.fromHexString("#ff0b0b")));
            }
            return true;
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> tabComplete = new ArrayList<>();
        if (args.length<=0){
            return tabComplete;
        }else{
            tabComplete.add("new");
            tabComplete.add("add");
            tabComplete.add("edit");
            tabComplete.add("show");
            tabComplete.add("listwords");
            tabComplete.add("listchars");
            tabComplete.add("listchildren");
            tabComplete.add("test");
            tabComplete.removeIf(tabs -> !tabs.startsWith(args[0]));
            return tabComplete;
        }
    }

    public static void newBufferCMD(String bufferName, String[] args){
        TextComponent.Builder bufferComponent = Component.empty().toBuilder();
        for (int x = 1; x < args.length; x++){
            bufferComponent.append(Component.text(args[x] + " "));
        }
        newBuffer(bufferName, bufferComponent.build());
    }

    public static void addBufferCMD(String bufferName, String[] args){
        /*
        for (int x = 1; x < args.length; x++){
            bufferComponent.append(Component.text(args[x] + " "));
        }
         */
    }

    public static void editBufferCMD(String bufferName, String[] args){
    }

    public static void showBufferCMD(String bufferName, Player p){
        Component buffer = getBuffer(bufferName);
        p.sendMessage(buffer);
    }

    public static void listWordsBufferCMD(String bufferName, Player p){
        /*
        TextComponent.Builder listWordsBuilder = Component.empty().toBuilder();
        String[] strings = ((TextComponent) bufferComponent.build().compact()).content().split(" ");
        for (String string : strings){
            listWordsBuilder.append(Component.text(string));
        }
        p.sendMessage(listWordsBuilder.build());
         */
    }

    public static void listCharsBufferCMD(String bufferName, Player p){
        /*
        TextComponent.Builder listBuilder = Component.empty().toBuilder();
        TextComponent compactedComponent = (TextComponent) bufferComponent.build().compact();
        for (char c : compactedComponent.content().toCharArray()){
            listBuilder.append(Component.text(c));
        }
        p.sendMessage(listBuilder.build());
         */
    }

    public static void listChildrenBufferCMD(String bufferName, Player p){
        /*
        String[] stringsTwo = ((TextComponent) bufferComponent.build().compact()).content().split(" ");
        for (int x = 0; x < bufferComponent.build().children().toArray().length; x++){
            p.sendMessage(stringsTwo[x]);
        }
         */
    }

    public static void testCMD(String bufferName){
        MiniMessage mm = MiniMessage.miniMessage();
        TextComponent.Builder bufferComponent = Component.empty().toBuilder();
        bufferComponent.append(Component.text("Testing123 ").color(TextColor.fromHexString("#e87196")));
        bufferComponent.append(Component.text("321Test").color(TextColor.fromHexString("#d7ccc9")));
        bufferComponent.append(mm.deserialize(" <rainbow>Rainbow</rainbow> "));
        bufferComponent.append(Component.text("#testingmoment").color(TextColor.fromHexString("#000000")));
        newBuffer(bufferName, bufferComponent.build());
    }
}
