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
package com.d471061c.dungeonviz.logic;

import com.d471061c.dungeonviz.domain.Dungeon;
import com.d471061c.dungeonviz.domain.Room;

/**
 * Dungeon generator
 * 
 * @author d471061c
 */
public class DungeonGenerator {

    public final static char WALL = '#';
    public final static char EMPTY = '.';
    public final static char NOTHING = '-';
    
    private RoomFactory roomFactory;

    /**
     * Dungeon Generator
     * @param roomFactory Factory that provides the rooms
     * @see RoomFactory
     */
    public DungeonGenerator(RoomFactory roomFactory) {
        this.roomFactory = roomFactory;
    }

    public DungeonGenerator() {
        this(new RoomFactory());
    }

    /**
     * Draw given room into the character map.
     *
     * @param room Room to be drawn
     * @param map Character map to be drawn into
     */
    private void drawRoom(Room room, char[][] map) {
        // Generate upper and lower wall
        for (int i = 0; i < room.getWidth(); i++) {
            map[room.getY()][room.getX() + i] = WALL;
            map[room.getY() + room.getHeight() - 1][room.getX() + i] = WALL;
        }

        // Generate left and right wall
        for (int i = 0; i < room.getHeight(); i++) {
            map[room.getY() + i][room.getX()] = WALL;
            map[room.getY() + i][room.getX() + room.getWidth() - 1] = WALL;
        }

        // Generate the blank area within the room
        for (int i = 0; i < room.getWidth() - 2; i++) {
            for (int j = 0; j < room.getHeight() - 2; j++) {
                map[room.getY() + j + 1][room.getX() + i + 1] = EMPTY;
            }
        }
    }

    /**
     * Offset all rooms by given x and y offsets.
     *
     * @param rooms Array of rooms.
     * @param offsetX how much x will be offset
     * @param offsetY how much y will be offset
     */
    private void offsetRooms(Room rooms[], int offsetX, int offsetY) {
        for (Room room : rooms) {
            room.setX(room.getX() + offsetX);
            room.setY(room.getY() + offsetY);
        }
    }

    /**
     * Generate a character map from given dungeon rooms.
     *
     * @param dungeonRooms Array containing dungeon rooms
     * @return Character map containing rooms
     */
    private char[][] createMap(Room dungeonRooms[]) {
        if (dungeonRooms.length == 0) return new char[0][0];
        
        int minimumX = dungeonRooms[0].getX();
        int minimumY = dungeonRooms[0].getY();
        for (Room room : dungeonRooms) {
            if (minimumX > room.getX()) {
                minimumX = room.getX();
            }
            if (minimumY > room.getY()) {
                minimumY = room.getY();
            }
        }

        this.offsetRooms(dungeonRooms, -minimumX, -minimumY);
        
        int maximumX = 0;
        int maximumY = 0;
        for (Room room : dungeonRooms) {
            if (maximumY < room.getHeight() + room.getY()) {
                maximumY = room.getHeight() + room.getY();
            }
            if (maximumX < room.getWidth() + room.getX()) {
                maximumX = room.getWidth() + room.getX();
            }
        }
        
        char map[][] = new char[maximumY][maximumX];
        for (int i = 0; i < maximumY; i++) {
            for (int j = 0; j < maximumX; j++) {
                map[i][j] = NOTHING;
            }
        }

        for (Room room : dungeonRooms) {
            this.drawRoom(room, map);
        }

        return map;
    }

    /**
     * Generate a dungeon.
     * 
     * @param rooms Amount of rooms
     * @return Generated dungeon
     */
    public Dungeon generateDungeon(int rooms) {
        Room dungeonRooms[] = new Room[rooms];
        
        for (int i = 0; i < rooms; i++) {
            Room room = this.roomFactory.produceRoom();
            dungeonRooms[i] = room;
        }

        char[][] map = createMap(dungeonRooms);
        return new Dungeon(dungeonRooms, map);
    }

}
