package me.wiviw.customitems.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static me.wiviw.customitems.enums.CommandEnums.*;
import static me.wiviw.customitems.utilities.CommandUtilities.checkSender;

public class BufferCommand implements TabExecutor {

    private final String[] commandModifiers = {"new", "list", "add", "edit", "show", "listwords", "listchars", "listchildren", "test"};
    // TODO Implement JSON loading for this stuff.
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // Check permissions on command
        if (!checkSender(sender, command.getPermission(), false)) {
            return false;
        }
        Player p = (Player) sender;
        // Check for First arguments (command modifiers).
        if (args.length < 1) {
            p.sendMessage(BUFFER_ERROR_INVALID_PARAMETERS.getMessage());
            for (String i : commandModifiers){
                p.sendMessage(Component.text(i).color(TextColor.fromHexString("#ffffff")));
            }
            return false;
        }
        // Check for Buffer name.
        if (args.length < 2) {
            p.sendMessage(GENERAL_ERROR_INVALID_PARAMETER_BUFFER.getMessage());
            return false;
        }
        switch (args[0]) {
            case "new" -> notImplemented(p);
            case "list" -> notImplemented(p);
            case "add" -> notImplemented(p);
            case "edit" -> notImplemented(p);
            case "show" -> notImplemented(p);
            case "listwords" -> notImplemented(p);
            case "listchars" -> notImplemented(p);
            case "listchildren" -> notImplemented(p);
            case "test" -> notImplemented(p);
            default -> p.sendMessage(BUFFER_ERROR_INVALID_PARAMETERS.getMessage()); // TODO Change into proper error for command specific missing parameters/invalid
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!checkSender(sender, command.getPermission(), false)) {
            return null;
        }
        if (args.length > 1) {
            return null;
        } else {
            return List.of(commandModifiers);
        }
    }

    public static void notImplemented(Player p) {
        p.sendMessage(GENERAL_ERROR_NOT_IMPLEMENTED.getMessage());
    }

    /*
    public static void newBufferCMD(String bufferName, String[] args) {
        TextComponent.Builder bufferComponent = Component.empty().toBuilder();
        for (int x = 1; x < args.length; x++) {
            bufferComponent.append(Component.text(args[x] + " "));
        }
        newBuffer(bufferName, bufferComponent.build());
    }

    public static void addBufferCMD(String bufferName, String[] args) {
        /*
        for (int x = 1; x < args.length; x++){
            bufferComponent.append(Component.text(args[x] + " "));
        }

    }

    public static void editBufferCMD(String bufferName, String[] args) {
    }

    public static void showBufferCMD(String bufferName, Player p) {
        Component buffer = getBuffer(bufferName);
        p.sendMessage(buffer);
    }

    public static void listWordsBufferCMD(String bufferName, Player p) {
        /*
        TextComponent.Builder listWordsBuilder = Component.empty().toBuilder();
        String[] strings = ((TextComponent) bufferComponent.build().compact()).content().split(" ");
        for (String string : strings){
            listWordsBuilder.append(Component.text(string));
        }
        p.sendMessage(listWordsBuilder.build());

    }

    public static void listCharsBufferCMD(String bufferName, Player p) {
        /*
        TextComponent.Builder listBuilder = Component.empty().toBuilder();
        TextComponent compactedComponent = (TextComponent) bufferComponent.build().compact();
        for (char c : compactedComponent.content().toCharArray()){
            listBuilder.append(Component.text(c));
        }
        p.sendMessage(listBuilder.build());

    }

    public static void listChildrenBufferCMD(String bufferName, Player p) {
        /*
        String[] stringsTwo = ((TextComponent) bufferComponent.build().compact()).content().split(" ");
        for (int x = 0; x < bufferComponent.build().children().toArray().length; x++){
            p.sendMessage(stringsTwo[x]);
        }

    }

    public static void testCMD(String bufferName) {
        MiniMessage mm = MiniMessage.miniMessage();
        TextComponent.Builder bufferComponent = Component.empty().toBuilder();
        bufferComponent.append(Component.text("Testing123 ").color(TextColor.fromHexString("#e87196")));
        bufferComponent.append(Component.text("321Test").color(TextColor.fromHexString("#d7ccc9")));
        bufferComponent.append(mm.deserialize(" <rainbow>Rainbow</rainbow> "));
        bufferComponent.append(Component.text("#testingmoment").color(TextColor.fromHexString("#000000")));
        newBuffer(bufferName, bufferComponent.build());
    }
    */
}
