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

import com.d471061c.dungeonviz.domain.datastructures.MinHeap;
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
public class MinHeapTest {
    
    public MinHeapTest() {
    }
    
    @Test
    public void insertionWithTwoElementsTest() {
        MinHeap testHeap = new MinHeap();
        testHeap.insert(13);
        testHeap.insert(21);
        assertEquals(testHeap.deleteMin(), 13);
        assertEquals(testHeap.deleteMin(), 21);
    }
    
    @Test
    public void ascendingInsertionTest() {
        int array[] = {1, 2, 3, 4, 5};
        MinHeap testHeap = new MinHeap();
        for (int i = 0; i < array.length; i++) {
            testHeap.insert(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            assertEquals(testHeap.deleteMin(), array[i]);
        }
    }
    
    @Test
    public void descendingInsertionTest() {
        int array[] = {5, 4, 3, 2, 1};
        MinHeap testHeap = new MinHeap();
        for (int i = 0; i < array.length; i++) {
            testHeap.insert(array[i]);
        }
        for (int i = array.length - 1; i >= 0; i--) {
            assertEquals(testHeap.deleteMin(), array[i]);
        }
    }
}
