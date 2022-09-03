package de.nvclas.ttt.utils;

import net.minecraft.util.text.TextFormatting;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ColorUtil {

    private static final Map<TextFormatting, ColorSet<Integer, Integer, Integer>> colorMap = new HashMap<>();

    static {
        colorMap.put(TextFormatting.BLACK, new ColorSet<>(0, 0, 0));
        colorMap.put(TextFormatting.DARK_BLUE, new ColorSet<>(0, 0, 170));
        colorMap.put(TextFormatting.DARK_GREEN, new ColorSet<>(0, 170, 0));
        colorMap.put(TextFormatting.DARK_AQUA, new ColorSet<>(0, 170, 170));
        colorMap.put(TextFormatting.DARK_RED, new ColorSet<>(170, 0, 0));
        colorMap.put(TextFormatting.DARK_PURPLE, new ColorSet<>(170, 0, 170));
        colorMap.put(TextFormatting.GOLD, new ColorSet<>(255, 170, 0));
        colorMap.put(TextFormatting.GRAY, new ColorSet<>(170, 170, 170));
        colorMap.put(TextFormatting.DARK_GRAY, new ColorSet<>(85, 85, 85));
        colorMap.put(TextFormatting.BLUE, new ColorSet<>(85, 85, 255));
        colorMap.put(TextFormatting.GREEN, new ColorSet<>(85, 255, 85));
        colorMap.put(TextFormatting.AQUA, new ColorSet<>(85, 255, 255));
        colorMap.put(TextFormatting.RED, new ColorSet<>(255, 85, 85));
        colorMap.put(TextFormatting.LIGHT_PURPLE, new ColorSet<>(255, 85, 255));
        colorMap.put(TextFormatting.YELLOW, new ColorSet<>(255, 255, 85));
        colorMap.put(TextFormatting.WHITE, new ColorSet<>(255, 255, 255));
    }

    private static class ColorSet<R, G, B> {
        R red;
        G green;
        B blue;

        ColorSet(R red, G green, B blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        public R getRed() {
            return red;
        }

        public G getGreen() {
            return green;
        }

        public B getBlue() {
            return blue;
        }

    }

    public static TextFormatting fromColor(Color c) {
        TreeMap<Integer, TextFormatting> closest = new TreeMap<>();
        colorMap.forEach((color, set) -> {
            int red = Math.abs(c.getRed() - set.getRed());
            int green = Math.abs(c.getGreen() - set.getGreen());
            int blue = Math.abs(c.getBlue() - set.getBlue());
            closest.put(red + green + blue, color);
        });
        return closest.firstEntry().getValue();
    }

}
