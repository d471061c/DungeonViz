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
package com.d471061c.dungeonviz.domain;

/**
 * Dungeon that contains rooms and possibly the path to the rooms.
 * @author d471061c
 */
public class Dungeon {
    
    private final Room[] rooms;
    private final char map[][];

    /***
     * Representation of a dungeon.
     * @param rooms Rooms of the dungeon
     * @param map Character map of the dungeon
     */
    public Dungeon(Room[] rooms, char[][] map) {
        this.rooms = rooms;
        this.map = map;
    }

    /***
     * Returns a copy of the dungeon's map
     * @return Character map of the dungeon
     */
    public char[][] getMap() {
        return map.clone();
    }

    /**
     * Get a copy of the rooms within the dungeon
     * @return An array of dungeon rooms.
     */
    public Room[] getRooms() {
        return rooms.clone();
    }

    @Override
    public String toString() {
        String mapString = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                mapString += map[i][j];
            }
            mapString += "\n";
        }
        return mapString;
    }
    
}
