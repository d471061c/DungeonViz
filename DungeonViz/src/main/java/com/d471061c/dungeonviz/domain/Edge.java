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
 * A connection between two rooms.
 * @author d471061c
 */
public class Edge {
    
    private final Room first;
    private final Room second;

    /**
     * Create Edge between two rooms
     * @param first First Room
     * @param second Second Room
     */
    public Edge(Room first, Room second) {
        this.first = first;
        this.second = second;
    }
    
    /***
     * Returns the distance between two rooms
     * @return The distance between two rooms
     */
    public double distance() {
        return first.distance(second);
    }

    /**
     * Returns the first room
     * @return First room
     */
    public Room getFirst() {
        return first;
    }

    /**
     * Returns the second room
     * @return Second room
     */
    public Room getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "[" + first + ", " + second + ", distance: " + first.distance(second) + "]"; 
    }
    
    
}
