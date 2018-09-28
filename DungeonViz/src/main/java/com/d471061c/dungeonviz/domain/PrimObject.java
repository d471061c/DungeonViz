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
 * This class is used as a part for the prim's algorithm
 * @author d471061c
 */
public class PrimObject implements Comparable {
    
    // Values of prim object
    private Room room;
    private double value;
    
    // ID of the PrimObject, location in array
    private int index;
    
    public PrimObject(Room room, double value, int index) {
        this.room = room;
        this.value = value;
        this.index = index;
    }

    public Room getRoom() {
        return room;
    }

    public int getIndex() {
        return index;
    }
    
    public double getValue() {
        return value;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    @Override
    public int compareTo(Object t) {
        if (t instanceof PrimObject) {
            PrimObject other = (PrimObject) t;
            if (other.value > this.value) {
                return -1;
            }  else if (other.value < this.value) {
                return 1;
            } else {
                return 0;
            }
        }
        
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof PrimObject) {
            PrimObject obj = (PrimObject) o;
            return obj.index == this.index && obj.value == this.value;
        }
        return false; 
    }

    
    
    @Override
    public String toString() {
        return "(Id: " + this.index + ", value: " + this.value + ")" ;
    }
    
    
}