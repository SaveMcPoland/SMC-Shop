package pl.savemc.shop.utils;

import org.bukkit.ChatColor;

import java.util.List;

public class ChatUtils {

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('$', text);
    }

    public static List<String> color(List<String> text) {
        int index = 0;

        for (String s : text) {
            text.set(index, ChatColor.translateAlternateColorCodes('$', s));
            index++;
        }

        return text;
    }
}
