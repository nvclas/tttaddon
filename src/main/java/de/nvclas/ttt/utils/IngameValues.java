package de.nvclas.ttt.utils;

public class IngameValues {

    private static boolean ingame;

    public static Role role;
    public static int started;

    public static boolean isIngame() {
        return ingame;
    }

    public static void setIngame(boolean ingame) {
        IngameValues.ingame = ingame;
    }

    public static void resetValues() {
        ingame = false;
        started = 0;
    }

    public static int getInnocentAmount(int started) {
        if(started == 3) return 1;
        if(started == 4 || started == 5) return 2;
        if(started == 6) return 3;
        if(started == 7 || started == 8) return 4;
        if(started == 9 || started == 10) return 5;
        if(started == 11) return 5;
        if(started == 12) return 6;
        if(started == 13) return 7;
        if(started == 14 || started == 15 || started == 16) return 8;
        if(started == 17 || started == 18) return 9;
        if(started == 19) return 10;
        if(started == 20 || started == 21 || started == 22) return 11;
        if(started == 23 || started == 24) return 12;
        return 0;
    }

    public static int getTraitorAmount(int started) {
        if(started == 2 || started == 3 || started == 4) return 1;
        if(started == 5 || started == 6 || started == 7) return 2;
        if(started == 8 || started == 9 || started == 10) return 3;
        if(started == 11 || started == 12 || started == 13 || started == 14) return 4;
        if(started == 15 || started == 16 || started == 17) return 5;
        if(started == 18 || started == 19 || started == 20) return 6;
        if(started == 21 ||started == 22 || started == 23) return 7;
        if(started == 24) return 8;
        return 0;
    }

}
