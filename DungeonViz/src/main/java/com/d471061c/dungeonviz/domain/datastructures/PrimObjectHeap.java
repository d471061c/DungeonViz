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
        int temp = this.locations[second];
        this.locations[second] = this.locations[first];
        this.locations[first] = temp;
        
    }

    @Override
    public void insert(PrimObject value) {
        this.heapSize++;
        int index = this.heapSize;
        this.locations[value.getIndex()] = heapSize;
        
        while(index > 1 && this.array[this.parent(index)].compareTo(value) > 0) {
            // Keep track of the locations here
            int temp = this.locations[parent(index)];
            this.locations[parent(index)] = this.locations[index];
            this.locations[index] = temp;
            
            // Go up
            this.array[index] = this.array[this.parent(index)];
            index = this.parent(index);
        }
        
        this.array[index] = value;
        this.locations[value.getIndex()] = index;
    }

    /**
     *
     * Update Prim Objects location in the heap
     *
     * @param object Prim object with new value
     */
    public void update(PrimObject object) {
        int heapLocation = this.locations[object.getIndex()];
        this.decreaseKey(heapLocation, object);
    }

    /**
     *
     * Returns true if the object is in the heap
     *
     * @param object PrimObject to check
     * @return True if object is in the heap, false if not
     */
    public boolean contains(PrimObject object) {
        return locations[object.getIndex()] != EMPTY;
    }

    /***
     * Returns copy of the internal array used in heap
     * @return Heap array
     */
    public Comparable[] getArray() {
        return array.clone();
    }
    
    /***
     * Returns array containing locations of the prim objects
     * @return Array containing locations of the prim objects
     */
    public int[] getHeapLocations() {
        return locations.clone();
    }

    @Override
    public PrimObject deleteMin() {
        PrimObject minimum = (PrimObject)this.array[1];
        
        // Add bottom to top
        this.array[1] = this.array[this.heapSize];
        this.array[this.heapSize] = null;
        this.locations[1] = this.locations[this.heapSize];
        
        // Remove from track
        this.locations[minimum.getIndex()] = EMPTY;
        this.heapSize--;
        
        // Fix minheap
        this.heapify(1);
        
        return minimum;
    }

}
