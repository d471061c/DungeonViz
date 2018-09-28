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
package com.d471061c.dungeonviz.domain.datastructures;

import com.d471061c.dungeonviz.domain.PrimObject;
import java.util.Arrays;

/**
 * PrimObject version of MinHeap, used in Prim's algorithm implementation
 *
 * @see PrimObject
 * @author d471061c
 */
public class PrimObjectHeap extends MinHeap<PrimObject> {

    // When item is not in the heap
    private final int EMPTY = -1;
    
    // Locations in the heap
    private int[] locations;

    public PrimObjectHeap(int capacity) {
        super(capacity);
        initializeLocations(capacity);

    }

    public PrimObjectHeap() {
        super();
        initializeLocations(DEFAULT_CAPACITY);
    }
    
    private void initializeLocations(int capacity) {
        this.locations = new int[capacity + 1];
        for (int i = 0; i < locations.length; i++ ) {
            this.locations[i] = EMPTY;
        }
    }

    @Override
    protected void swap(int first, int second) {
        super.swap(first, second);
        try {
            this.locations[this.array[first].getIndex()] = second;
            this.locations[this.array[second].getIndex()] = first;
        } catch (Exception ex) {
            System.out.println(ex);
        }

        
    }

    @Override
    public void insert(PrimObject value) {
        super.insert(value);
         this.locations[value.getIndex()] = this.heapSize;
    }

    /**
     * *
     * Update Prim Objects location in the heap
     *
     * @param object Prim object with new value
     */
    public void update(PrimObject object) {
        int heapLocation = this.locations[object.getIndex()];
        this.decreaseKey(heapLocation, object);
    }

    /**
     * *
     * Returns true if the object is in the heap
     *
     * @param object PrimObject to check
     * @return True if object is in the heap, false if not
     */
    public boolean contains(PrimObject object) {
        return locations[object.getIndex()] != EMPTY;
    }

    @Override
    public PrimObject deleteMin() {
        PrimObject object = super.deleteMin();
        this.locations[object.getIndex()] = EMPTY;
        return object;
    }

}
