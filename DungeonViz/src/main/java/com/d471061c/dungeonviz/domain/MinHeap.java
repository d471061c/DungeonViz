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
 * Minimum Heap.
 * @author d471061c
 */
public class MinHeap {
    
    private final int DEFAULT_CAPACITY = 27;
    
    private int heapSize;
    private int array[];

    public MinHeap() {
        this.heapSize = 0;
        this.array = new int[DEFAULT_CAPACITY];
    }
    
    public MinHeap(int capacity) {
        this.heapSize = 0;
        this.array = new int[capacity];
    }
    
    /***
     * Build heap from given array.
     * @param array Array from which to build heap
     */
    public void buildHeap(int array[]) {
        this.heapSize = array.length;
        for (int index = this.heapSize / 2; 0 < index; index--) {
            this.heapify(index);
        }
    }
    
    /***
     * Get parent node of the node located at index.
     * @param index Node
     * @return Parent of the node located at index
     */
    private int parent(int index) {
        return index / 2;
    }
    
    /***
     * Get left child of the node located at index.
     * @param index Node
     * @return Left child of the node located at index
     */
    private int left(int index) {
        return 2 * index;
    }
    
    /***
     * Get right child of the node located at index.
     * @param index Node
     * @return Right child of the node located at index
     */
    private int right(int index) {
        return 2 * index + 1;
    }
    
    /***
     * Swap two elements in array.
     * @param first index of the first element
     * @param second index of the second element
     */
    private void swap(int first, int second) {
        int temp = this.array[first];
        this.array[first] = this.array[second];
        this.array[second] = temp;
    }
    
    /***
     * Verify and correct the heap structure of the internal array starting from the given index.
     * @param index Index to heapify from.
     */
    private void heapify(int index) {
        int leftIndex = this.left(index);
        int rightIndex = this.right(index);
        
        if (rightIndex <= this.heapSize) {
            int smallestIndex;
            if (this.array[leftIndex] > this.array[rightIndex]) {
                smallestIndex = rightIndex;
            } else {
                smallestIndex = leftIndex;
            }
            
            if (this.array[index] > this.array[smallestIndex]) {
                this.swap(index, smallestIndex);
            }
            
        } else if (leftIndex == this.heapSize && this.array[index] > this.array[leftIndex]) {
            this.swap(index, leftIndex);
        }
    }
    
    /***
     * Insert a new value to the heap.
     * @param value Value to be added
     */
    public void insert(int value) {
        this.heapSize++;
        int index = this.heapSize;
        
        while(index > 1 && this.array[this.parent(index)] > value) {
            this.array[index] = this.array[this.parent(index)];
            index = this.parent(index);
        }
        
        this.array[index] = value;
    }
    
    /***
     * Decrease the value of the node at index by replacing its value with new value.
     * @param index Location of the node.
     * @param newValue value that is smaller than the node's existing value.
     */
    private void decreaseKey(int index, int newValue) {
        if (newValue < this.array[index]) {
            this.array[index] = newValue;
            this.heapify(index);
        }
    }
    
    /***
     * Increase the value of the node at index by replacing its value with new value.
     * @param index Location of the node.
     * @param newValue Value that is bigger than the node's existing value.
     */
    private void increaseKey(int index, int newValue) {
        if (newValue > this.array[index]) {
            this.array[index] = newValue;
            while (index > 1 && this.array[this.parent(index)] < this.array[index]) {
                this.swap(index, this.parent(index));
                index = this.parent(index);
            }
        }
    }
    
    /***
     * Delete and return the minimum value from the heap.
     * @return Minimum value
     */
    public int deleteMin() {
        int minimum = this.array[1];
        this.array[1] = this.array[this.heapSize];
        this.heapSize--;
        this.heapify(1);
        return minimum;
    }
}
