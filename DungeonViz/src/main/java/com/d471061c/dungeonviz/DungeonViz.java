package com.d471061c.dungeonviz;

import com.d471061c.dungeonviz.domain.Dungeon;
import com.d471061c.dungeonviz.domain.Edge;
import com.d471061c.dungeonviz.domain.PrimObject;
import com.d471061c.dungeonviz.domain.Room;
import com.d471061c.dungeonviz.domain.datastructures.MinHeap;
import com.d471061c.dungeonviz.domain.datastructures.PrimObjectHeap;
import com.d471061c.dungeonviz.logic.DungeonGenerator;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
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
        System.out.format("Generating dungeon with %d rooms.\n", rooms);
        generateAndDisplayDungeon(rooms);
    }

}
