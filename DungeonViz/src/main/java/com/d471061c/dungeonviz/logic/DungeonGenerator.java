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
import com.d471061c.dungeonviz.domain.Edge;
import com.d471061c.dungeonviz.domain.PrimObject;
import com.d471061c.dungeonviz.domain.Room;
import com.d471061c.dungeonviz.domain.datastructures.PrimObjectHeap;

/**
 * Dungeon generator
 *
 * @author d471061c
 */
public class DungeonGenerator {

    private final int INFINITY = 999999;

    private RoomFactory roomFactory;
    private DungeonVisualizer visualizer;
    
    /**
     * Dungeon Generator
     *
     * @param roomFactory Factory that provides the rooms
     * @see RoomFactory
     */
    public DungeonGenerator(RoomFactory roomFactory) {
        this.roomFactory = roomFactory;
        this.visualizer = new DungeonVisualizer();
    }

    public DungeonGenerator() {
        this(new RoomFactory());
    }


    /**
     *
     * Get minimum spanning tree with Prim's algorithm
     *
     * @param rooms Rooms which to be connected
     * @return Minimum spanning tree represented as edges
     */
    private Edge[] primAlgorithm(Room rooms[]) {
        // Generate the graph from given rooms
        // ID of each room is the index in which the room is located at.
        int rootIndex = 0;

        PrimObjectHeap heap = new PrimObjectHeap(rooms.length);
        PrimObject objects[] = new PrimObject[rooms.length];
        Room parent[] = new Room[rooms.length];
        
        // Initialize all objects
        for (int i = 0; i < rooms.length; i++) {
            parent[i] = null;
            objects[i] = new PrimObject(rooms[i], this.INFINITY, i);
        }
        objects[rootIndex].setValue(0);
        
        // Insert all prim objects to heap
        for (PrimObject object : objects) {
            heap.insert(object);
        }

        // Edges between rooms
        Edge edges[] = new Edge[rooms.length - 1];
        int edgePointer = 0;

        // Actual Prim's Algorithm
        while (!heap.isEmpty()) {
            // Delete the minimum
            PrimObject currentObject = heap.deleteMin();
            // Add edge
            if (parent[currentObject.getIndex()] != null) {
                Edge edge = new Edge(currentObject.getRoom(), parent[currentObject.getIndex()]);
                edges[edgePointer] = edge;
                edgePointer++;
            }

            // Go through all the rooms
            for (int i = 0; i < objects.length; i++) {
                // No paths to self
                if (currentObject.getIndex() != i) {
                    double distance = currentObject.getRoom().distance(objects[i].getRoom());
                    if (distance < objects[i].getValue() && heap.contains(objects[i])) {
                        parent[i] = currentObject.getRoom();
                        objects[i].setValue(distance);
                        heap.update(objects[i]);
                    }
                }
            }
        }
        
        return edges;
    }

    /**
     * Generate a dungeon with given number of rooms.
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

        // Calculate the edges between the rooms
        Edge edges[] = primAlgorithm(dungeonRooms);
        
        char[][] map = visualizer.createMap(dungeonRooms, edges);
        return new Dungeon(dungeonRooms, map);
    }

}
