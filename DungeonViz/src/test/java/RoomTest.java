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

import com.d471061c.dungeonviz.domain.Room;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author d471061c
 */
public class RoomTest {
    
    public RoomTest() {
    }

    @Test
    public void horizontalCollisionTest() {
        Room first = new Room(0, 0, 10, 10);
        Room second = new Room(5, 0, 10, 10);
        assertTrue("Rooms did not collide horizontally", first.collides(second));
        assertTrue("Rooms did not collide horizontally", second.collides(first));
    }
    
    @Test
    public void verticalCollisionTest() {
        Room first = new Room(0, 0, 10, 10);
        Room second = new Room(0, 5, 10, 10);
        assertTrue("Rooms did not collide vertically", first.collides(second));
        assertTrue("Rooms did not collide vertically", second.collides(first));
    }
    
    @Test
    public void diagonalCollisionTest() {
        Room first = new Room(0, 0, 10, 10);
        Room second = new Room(5, 5, 10, 10);
        assertTrue("Rooms did not collide diagonally", first.collides(second));
        assertTrue("Rooms did not collide diagonally", second.collides(first));
    }
    
    @Test
    public void noCollisionVerticallyTest() {
        Room first = new Room(0, 0, 10, 10);
        Room second = new Room(11, 0, 10, 10);
        assertTrue("Rooms did collide vertically", !first.collides(second));
        assertTrue("Rooms did collide vertically", !second.collides(first));
    }
    
    @Test
    public void noCollisionHorizontallyTest() {
        Room first = new Room(0, 0, 10, 10);
        Room second = new Room(0, 11, 10, 10);
        assertTrue("Rooms did collide horizontally", !first.collides(second));
        assertTrue("Rooms did collide horizontally", !second.collides(first));
    }
    
    @Test
    public void noCollisionDiagonallyTest() {
        Room first = new Room(0, 0, 10, 10);
        Room second = new Room(11, 11, 10, 10);
        assertTrue("Rooms did collide diagonally", !first.collides(second));
        assertTrue("Rooms did collide diagonally", !second.collides(first));
    }
    
    @Test
    public void verticalDistanceTest() {
        Room first = new Room(0, 0, 10, 10);
        Room second = new Room(10, 0, 10, 10);
        assertEquals(first.distance(second), 10.0, 1);
        assertEquals(second.distance(first), 10.0, 1);
    }
    
    @Test
    public void horizontalDistanceTest() {
        Room first = new Room(0, 0, 10, 10);
        Room second = new Room(0, 10, 10, 10);
        assertEquals(first.distance(second), 10.0, 1);
        assertEquals(second.distance(first), 10.0, 1);
    }
    
    @Test
    public void diagonalDistanceTest() {
        Room first = new Room(0, 0, 10, 10);
        Room second = new Room(3, 4, 10, 10);
        assertEquals(first.distance(second), 5.0, 1);
        assertEquals(second.distance(first), 5.0, 1);
    }
}
