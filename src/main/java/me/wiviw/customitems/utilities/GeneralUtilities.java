package me.wiviw.customitems.utilities;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneralUtilities {

    // TODO Remove. (Only kept for checking back on code mistakes and other notes in this class.

    private static final Pattern regularCodesPattern = Pattern.compile("\\\\&[k-rK-R]", Pattern.CASE_INSENSITIVE);
    private static final Pattern hexPattern = Pattern.compile("\\\\&#[a-fA-F0-9]{6}", Pattern.CASE_INSENSITIVE);
    private static final String formatString = "§§§";

    // Takes in a string supplied from the user, returns it formatted correctly with color codes shown as \&#000000 (\& is the starter match, with a hex code following)
    public static TextComponent formatString(String str) {
        //Initializing both matchers, just to check first if any strings that match exist, if none, then return the same string we got in.
        Matcher regularCodesMatcher = regularCodesPattern.matcher(str);
        Matcher hexMatcher = regularCodesPattern.matcher(str);
        /*
        if (!regularCodesMatcher.find() && !hexMatcher.find()){
            return Component.text(str);
        }

         */
        //First we go through and check for regular codes and replace with format char and code it belongs to
        while (regularCodesMatcher.find()) {
            String color = str.substring(regularCodesMatcher.start(), regularCodesMatcher.end());
            str = str.replace(color, "§" + str.charAt(regularCodesMatcher.end()-1));
            regularCodesMatcher = regularCodesPattern.matcher(str);
        }
        //Second we go through hex colors.
        List<TextColor> colorList = new ArrayList<>();
        while (hexMatcher.find()) {

            String color = str.substring(hexMatcher.start(), hexMatcher.end());
            str = str.replace(color, formatString);
            colorList.add(TextColor.fromHexString(color.substring(2)));
            hexMatcher = hexPattern.matcher(str);
        }
        String[] sections = str.split(formatString);
        TextComponent.Builder finalComponent = Component.empty().toBuilder();
        for (int x = 1; x < sections.length; x++) {
            System.out.println("finalcomp: " + finalComponent + " :");
            System.out.println("sections: " + sections[x] + " :");
            System.out.println("colorlist: " + colorList.get(x - 1) + " :");
            finalComponent.append(Component.text(sections[x], colorList.get(x - 1)));
        }
        return finalComponent.build();
    }

}
