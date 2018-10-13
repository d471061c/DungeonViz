package com.d471061c.dungeonviz;

import com.d471061c.dungeonviz.domain.Dungeon;
import com.d471061c.dungeonviz.domain.PrimObject;
import com.d471061c.dungeonviz.domain.datastructures.PrimObjectHeap;
import com.d471061c.dungeonviz.logic.DungeonGenerator;
import java.util.Arrays;

/**
 * @author d471061c
 */
public class DungeonViz {
    
    /***
     * Generate and display the dungeon
     * @param numberOfRooms Number of rooms to generate in the dungeon
     */
    public static void generateAndDisplayDungeon(int numberOfRooms) {
        DungeonGenerator generator = new DungeonGenerator();
        Dungeon dungeon = generator.generateDungeon(numberOfRooms);
        System.out.println(dungeon);
    }

    public static void main(String[] args) {
        int rooms = 5;
        generateAndDisplayDungeon(rooms);
    }

}
