package de.nvclas.ttt.utils;

import de.nvclas.ttt.settings.Config;

import java.awt.*;

public enum Role {
    INNOCENT("Innocent"),
    TRAITOR("Traitor"),
    DETECTIVE("Detective");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        if(this == Role.INNOCENT) return Config.innocentColor;
        if(this == Role.TRAITOR) return Config.traitorColor;
        return Config.detectiveColor;
    }

}
