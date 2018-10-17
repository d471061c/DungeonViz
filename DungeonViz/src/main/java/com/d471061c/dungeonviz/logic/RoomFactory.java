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

import com.d471061c.dungeonviz.domain.Room;
import java.util.Random;

/**
 * Room factory that produces random sized rooms.
 * @author d471061c
 */
public class RoomFactory {
    
    // Maximum constants
    private final int DEFAULT_MINIMUM_WIDTH = 10;
    private final int DEFAULT_MINIMUM_HEIGHT = 10;
    private final int DEFAULT_MINIMUM_X = 0;
    private final int DEFAULT_MINIMUM_Y = 0;

    // Minimum constants
    private final int DEFAULT_MAXIMUM_WIDTH = 10;
    private final int DEFAULT_MAXIMUM_HEIGHT = 10;
    private final int DEFAULT_MAXIMUM_X = 100;
    private final int DEFAULT_MAXIMUM_Y = 100;

    // Other constants
    private final boolean DEFAULT_FIXED_SIZE = true;
    
    // Minimum
    private int minimumWidth;
    private int minimumHeight;
    private int minimumX;
    private int minimumY;

    // Maximum
    private int maximumWidth;
    private int maximumHeight;
    private int maximumX;
    private int maximumY;

    // Resizing possibility
    private boolean fixedSize;
    
    // Randomness
    private Random random;

    /***
     * Create a room factory with custom random object
     * @param random Random class
     * @see Random
     */
    public RoomFactory(Random random) {
        this.random = random;
        this.maximumX = DEFAULT_MAXIMUM_X;
        this.maximumY = DEFAULT_MAXIMUM_Y;
        this.maximumWidth = DEFAULT_MAXIMUM_WIDTH;
        this.maximumHeight = DEFAULT_MAXIMUM_HEIGHT;
        this.minimumX = DEFAULT_MINIMUM_X;
        this.minimumY = DEFAULT_MINIMUM_Y;
        this.minimumWidth = DEFAULT_MINIMUM_WIDTH;
        this.minimumHeight = DEFAULT_MINIMUM_HEIGHT;
        this.fixedSize = DEFAULT_FIXED_SIZE;
    }
    
    public RoomFactory() {
        this(new Random());
    }

    /***
     * Set maximum height
     * @param maximumHeight Value for the maximum height
     */
    public void setMaximumHeight(int maximumHeight) {
        this.maximumHeight = maximumHeight;
    }

    /***
     * Set maximum width
     * @param maximumWidth Value for the maximum width
     */
    public void setMaximumWidth(int maximumWidth) {
        this.maximumWidth = maximumWidth;
    }

    /***
     * Set minimum height
     * @param minimumHeight Value for the maximum height
     */
    public void setMinimumHeight(int minimumHeight) {
        this.minimumHeight = minimumHeight;
    }

    
    /**
     * Set minimum width
     * @param minimumWidth Value for the minimum width
     */
    public void setMinimumWidth(int minimumWidth) {
        this.minimumWidth = minimumWidth;
    }

    /***
     * Returns maximum height
     * @return Maximum height
     */
    public int getMaximumHeight() {
        return maximumHeight;
    }

    /***
     * Returns maximum width
     * @return Maximum width
     */
    public int getMaximumWidth() {
        return maximumWidth;
    }

    /***
     * Returns minimum height
     * @return Minimum height
     */
    public int getMinimumHeight() {
        return minimumHeight;
    }

    /***
     * Returns minimum width
     * @return Minimum width
     */
    public int getMinimumWidth() {
        return minimumWidth;
    }

    /***
     * Returns true if the room factory generates fixed size of rooms
     * @return True if the room factory generates fixed size of rooms, false if not
     */
    public boolean isFixedSize() {
        return fixedSize;
    }

    /**
     * Set room factory to generate fixed sized rooms
     * @param fixedSize Whether or not the room factory generates fixed sized rooms
     */
    public void setFixedSize(boolean fixedSize) {
        this.fixedSize = fixedSize;
    }

    public int getMinimumX() {
        return minimumX;
    }

    /***
     * Sets the minimum X-coordinate in which the room can be generated to
     * @param minimumX the minimum X-coordinate in which the room can be generated to
     */
    public void setMinimumX(int minimumX) {
        this.minimumX = minimumX;
    }

    public int getMinimumY() {
        return minimumY;
    }

    /***
     * Sets the minimum Y-coordinate in which the room can be generated to
     * @param minimumY the minimum Y-coordinate in which the room can be generated to
     */
    public void setMinimumY(int minimumY) {
        this.minimumY = minimumY;
    }

    public int getMaximumX() {
        return maximumX;
    }

    /***
     * Sets the maximum X-coordinate in which the room can be generated to
     * @param maximumX maximum X-coordinate in which the room can be generated to
     */
    public void setMaximumX(int maximumX) {
        this.maximumX = maximumX;
    }

    
    public int getMaximumY() {
        return maximumY;
    }

    /**
     * Sets the maximum Y-coordinate in which the room can be generated to
     * @param maximumY maximum Y-coordinate in which the room can be generated to
     */
    public void setMaximumY(int maximumY) {
        this.maximumY = maximumY;
    }
    
    /***
     * Create a random sized room at a random location.
     * @return Room
     */
    public Room produceRoom() {
        int x = minimumX + random.nextInt(maximumX);
        int y = minimumY + random.nextInt(maximumY);
        int width = minimumWidth;
        int height = minimumHeight;
        if (!fixedSize) {
            width += random.nextInt(maximumWidth);
            height += random.nextInt(maximumHeight);
        }
        return new Room(x, y, width, height);
    }

}
