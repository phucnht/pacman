package com.ezneuron.pezman.utils;

/**
 * Created by batty on 6/1/2016.
 */
public class Constants {
    // Taille de scene
    public static final float VIEWPORT_WIDTH = 19.0f;
    public static final float VIEWPORT_HEIGHT = 23.0f;

    // Game Controller
    public static final float PPM = 16f;

    public static final short NOTHING_BIT = 0;
    public static final short WALL_BIT = 1;
    public static final short PLAYER_BIT = 1 << 1;
    public static final short PILL_BIT = 1 << 2;
    public static final short GHOST_BIT = 1 << 3;
    public static final short GATE_BIT = 1 << 4;
    public static final short LIGHT_BIT = 1 << 5;

    // Pezman
    public static final int IDLE = 0;
    public static final int IDLE_UP = 0;
    public static final int IDLE_DOWN = 1;
    public static final int IDLE_LEFT = 2;
    public static final int IDLE_RIGHT = 3;

    public static final int MOVE_UP = 4;
    public static final int MOVE_DOWN = 5;
    public static final int MOVE_LEFT = 6;
    public static final int MOVE_RIGHT = 7;
    public static final int DIE = 8;

    // Ghost
}
