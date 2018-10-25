/*
 * The MIT License
 *
 * Copyright 2018 d471061c.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.d471061c.dungeonviz.utils;

import com.d471061c.dungeonviz.exception.InvalidArgumentException;

/**
 * Command line parser
 * @author d471061c
 */
public class CommandLineParser {
    // Default settings of the parser
    private final int DEFAULT_ROOMS = 5;
    private final int DEFAULT_ROOM_WIDTH = 20;
    private final int DEFAULT_ROOM_HEIGHT = 20;
    
    private final int DEFAULT_SPREAD_X = 50;
    private final int DEFAULT_SPREAD_Y = 50;
    private final boolean DEFAULT_FIXED_SIZE = true;
    
    // Rooms and their sizes
    private int rooms;
    private int width;
    private int height;
    
    // Spread of the rooms
    private int spreadX;
    private int spreadY;
    
    // Whether or not every room is the same size
    private boolean fixedSize;
    
    public CommandLineParser() {
        this.rooms = DEFAULT_ROOMS;
        this.width = DEFAULT_ROOM_WIDTH;
        this.height = DEFAULT_ROOM_HEIGHT;
        this.spreadX = DEFAULT_SPREAD_X;
        this.spreadY = DEFAULT_SPREAD_Y;
        this.fixedSize = DEFAULT_FIXED_SIZE;
    }
    
    public void parse(String args[]) throws InvalidArgumentException {
        for (int i = 0; i < args.length; i++) {
            if (i + 1 < args.length) {
                if (args[i].equalsIgnoreCase("-rooms") || args[i].equalsIgnoreCase("-r")) {
                    try {
                        this.rooms = Integer.parseInt(args[i + 1]);
                        if (this.rooms < 0) {
                            throw new InvalidArgumentException("[!] Amount of rooms must be positive");
                        }
                    } catch (NumberFormatException ex) {
                        throw new InvalidArgumentException("[!] Rooms must be an integer");
                    }
                    
                } else if (args[i].equalsIgnoreCase("-roomwidth") || args[i].equalsIgnoreCase("-rw")) {
                    try {
                        this.width = Integer.parseInt(args[i + 1]);
                        if (this.width < 0) {
                            throw new InvalidArgumentException("[!] Room width must be positive");
                        }
                    } catch (NumberFormatException ex) {
                        throw new InvalidArgumentException("[!] Room width must be an integer");
                    }
                    
                } else if (args[i].equalsIgnoreCase("-roomheight") || args[i].equalsIgnoreCase("-rh")) {
                    try {
                        this.height = Integer.parseInt(args[i + 1]);
                        if (this.height < 0) {
                            throw new InvalidArgumentException("[!] Room height must be positive");
                        }
                    } catch (NumberFormatException ex) {
                        throw new InvalidArgumentException("[!] Room height must be an integer");
                    }
                    
                } else if (args[i].equalsIgnoreCase("-spreadX") || args[i].equalsIgnoreCase("-sx")) {
                    try {
                        this.spreadX = Integer.parseInt(args[i + 1]);
                        if (this.spreadX < 0) {
                            throw new InvalidArgumentException("[!] Spread in X direction must be positive");
                        }
                        
                    } catch (NumberFormatException ex) {
                        throw new InvalidArgumentException("[!] Spread X must be an integer");
                    }
                    
                } else if (args[i].equalsIgnoreCase("-spreadY") || args[i].equalsIgnoreCase("-sy")) {
                    try {
                        this.spreadY = Integer.parseInt(args[i + 1]);
                        if (this.spreadY < 0) {
                            throw new InvalidArgumentException("[!] Spread in Y direction must be positive");
                        }
                        
                    } catch (NumberFormatException ex) {
                        throw new InvalidArgumentException("[!] Spread Y must be an integer");
                    }
                    
                } else if (args[i].equalsIgnoreCase("-fixedSize") || args[i].equalsIgnoreCase("-fs")) {
                    try {
                        this.fixedSize = Boolean.parseBoolean(args[i + 1]);
                    } catch (NumberFormatException ex) {
                        throw new InvalidArgumentException("[!] FixedSize must be a boolean");
                    }
                    
                }
            }
        }
    }

    public int getRooms() {
        return rooms;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /***
     * Return the maximum X-coordinate the can be place into.
     * @return Spread in X direction.
     */
    public int getSpreadX() {
        return spreadX;
    }

    /**
     * Return the maximum Y-coordinate the room can be placed into.
     * @return Spread in Y direction.
     */
    public int getSpreadY() {
        return spreadY;
    }

    /***
     * Returns true if the size of the rooms is fixed
     * @return True if the size of the rooms is fixed, false if not
     */
    public boolean isFixedSize() {
        return fixedSize;
    }

    public void displayInfo() {
        System.out.println("DungeonViz, beta version");
        System.out.println("   -r, --rooms       amount of rooms, default = " + DEFAULT_ROOMS);
        System.out.println("   -rw, --roomwidth  width of rooms, default = " + DEFAULT_ROOM_WIDTH);
        System.out.println("   -rh, --roomheight height of rooms, default = " + DEFAULT_ROOM_HEIGHT);
        System.out.println("   -sx, --spreadX    spread in x direction of rooms, default = " + DEFAULT_SPREAD_X);
        System.out.println("   -sy, --spreadY    spread in y direction of rooms, default = " + DEFAULT_SPREAD_Y);
        System.out.println("   -fs, --fixedSize  whether or not the size of the rooms are fixed, default = " + DEFAULT_FIXED_SIZE);
    }
    
    
    
}
