package pl.savemc.shop.utils;

import net.md_5.bungee.api.ChatColor;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChatUtils {

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static List<String> color(List<String> text) {
        List<String> colored = new ArrayList<>();

        for (String s : text) {
            colored.add(color(s));
        }

        return colored;
    }

    public static String gradient(String content, Color... colors){
        StringBuilder result = new StringBuilder();

        double divisions = colors.length - 1.0D;
        double divider = content.length() / divisions;

        int first = 0;

        for (int index = 0; index < divisions; index++){
            int second = (int) (divider * (index + 1));

            String substring = content.substring(first, second);
            first = second;

            result.append(gradientTwoColors(substring, colors[index], colors[index + 1]));
        }

        return result.toString();
    }

    private static String gradientTwoColors(String content, Color color, Color color2) {

        int length = content.length();
        StringBuilder result = new StringBuilder();

        if (length == 1) {
            result.append(ChatColor.of(color)).append(content);
            return result.toString();
        }

        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        int r2 = color2.getRed();
        int g2 = color2.getGreen();
        int b2 = color2.getBlue();

        int redDivider = getDivider(r, r2, length);
        int greenDivider = getDivider(g, g2, length);
        int blueDivider = getDivider(b, b2, length);

        int index = 0;

        for (char c : content.toCharArray()) {
            result.append(net.md_5.bungee.api.ChatColor.of(new Color(
                    r - index * redDivider,
                    g - index * greenDivider,
                    b - index * blueDivider
            ))).append(c);

            index ++;
        }
        return result.toString();
    }

    private static int getDivider(int color1Strength, int color2Strength, int length) {
        return (color1Strength - color2Strength) / (length - 1);
    }

}
