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

import com.d471061c.dungeonviz.domain.PrimObject;
import com.d471061c.dungeonviz.domain.datastructures.PrimObjectHeap;
import java.util.Arrays;
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
public class PrimObjectHeapTest {

    public PrimObject createPrimObject(double value, int index) {
        return new PrimObject(null, value, index);
    }

    /***
     * Checks whether or not the heap objects are in the given order inside the heap.
     * @param solution List containing indexes of the heap
     * @param heap Heap to check from
     * @return True if in order, false if not
     */
    public boolean verifyHeapArray(int solution[], PrimObjectHeap heap) {
        Comparable objects[] = heap.getArray();
        for (int i = 0; i < solution.length; i++) {
            if (solution[i] == 0 && objects[i] == null) continue;
            if (solution[i] != ((PrimObject)objects[i]).getValue()) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Verify the locations in the heap
     * @param solution Solution of what the heap locations should be 
     * @param heap Heap from which to check locations
     * @return True if all are in order, false if not
     */
    public boolean verifyHeapLocations(int solution[], PrimObjectHeap heap) {
        int locations[] = heap.getHeapLocations();
        for (int i = 0; i < solution.length; i++) {
            if (locations[i] != solution[i]) return false;
        }
        return true;
    }
    
    @Test
    public void ascendingOrderTest() {
        PrimObjectHeap heap = new PrimObjectHeap(100);
        for (int i = 0; i < 100; i++) {
            heap.insert(createPrimObject(i * 2.0, i));
        }

        for (int i = 0; i < 100; i++) {
            assertEquals(heap.deleteMin().getValue(), i * 2.0, 1);
        }
    }

    @Test
    public void descendingOrderTest() {
        PrimObjectHeap heap = new PrimObjectHeap(100);
        for (int i = 99; i >= 0; i--) {
            heap.insert(createPrimObject(i * 2.0, i));
        }

        for (int i = 0; i < 100; i++) {
            assertEquals(heap.deleteMin().getValue(), i * 2.0, 1);
        }
    }

    @Test
    public void heapContainTest() {
        PrimObjectHeap heap = new PrimObjectHeap(20);
        PrimObject obj = createPrimObject(0.2, 0);
        assertFalse("Object in heap when it is not supposed to be in", heap.contains(obj));
        heap.insert(obj);
        assertTrue("Object not in heap after insertion", heap.contains(obj));
        heap.deleteMin();
        assertFalse("Object still in heap after removal", heap.contains(obj));
    }

    @Test
    public void updateTest() {
        PrimObjectHeap heap = new PrimObjectHeap(3);
        PrimObject obj = createPrimObject(1, 0);
        PrimObject obj2 = createPrimObject(2, 1);
        heap.insert(obj);
        heap.insert(obj2);
        obj2.setValue(0);
        heap.update(obj2);
        assertEquals(heap.deleteMin().getValue(), 0, 0.1);
        assertEquals(heap.deleteMin().getValue(), 1, 0.1);
    }
    
    @Test
    public void strictOverallTest() {
        // Solutions
        int solution0[] = {0, 0,  0,  0,  0,  0 };
        int solution1[] = {0, 10, 0,  0,  0,  0 };
        int solution2[] = {0, 7, 10,  0,  0,  0 };
        int solution3[] = {0, 7, 10, 11,  0,  0 };
        int solution4[] = {0, 7, 10, 11,  26, 0 };
        int solution5[] = {0, 5, 7,  11,  26, 10};
        
        int heapSolution0[] = {-1, -1, -1, -1, -1, -1};
        int heapSolution1[] = {-1,  1, -1, -1, -1, -1};
        int heapSolution2[] = {-1,  2,  1, -1, -1, -1};
        int heapSolution3[] = {-1,  2,  1,  3, -1, -1};
        int heapSolution4[] = {-1,  2,  1,  3,  4, -1};
        int heapSolution5[] = {-1,  5,  2,  3,  4,  1};
        
        int deleteSolution1[] = {-1,  2,  1,  3,  4, -1};
        int deleteSolution2[] = {-1,  1, -1,  3,  2, -1};
        int deleteSolution3[] = {-1, -1, -1,  1,  2, -1};
        int deleteSolution4[] = {-1,  -1, -1, 1, -1, -1};
        int deleteSolution5[] = {-1, -1, -1, -1, -1, -1};
        
        // Objects
        PrimObject obj1 = createPrimObject(10, 1);
        PrimObject obj2 = createPrimObject(7 , 2);
        PrimObject obj3 = createPrimObject(11, 3);
        PrimObject obj4 = createPrimObject(26, 4);
        PrimObject obj5 = createPrimObject(5 , 5);
        
        // Test
        PrimObjectHeap heap = new PrimObjectHeap(5);
        assertTrue(verifyHeapArray(solution0, heap));
        assertTrue(verifyHeapLocations(heapSolution0, heap));
        
        heap.insert(obj1);
        assertTrue(verifyHeapArray(solution1, heap));
        assertTrue(verifyHeapLocations(heapSolution1, heap));
        
        heap.insert(obj2);
        assertTrue(verifyHeapArray(solution2, heap));
        assertTrue(verifyHeapLocations(heapSolution2, heap));
        
        heap.insert(obj3);
        assertTrue(verifyHeapArray(solution3, heap));
        assertTrue(verifyHeapLocations(heapSolution3, heap));
        
        heap.insert(obj4);
        assertTrue(verifyHeapArray(solution4, heap));
        assertTrue(verifyHeapLocations(heapSolution4, heap));
        
        heap.insert(obj5);
        assertTrue(verifyHeapArray(solution5, heap));
        assertTrue(verifyHeapLocations(heapSolution5, heap));
        
        
        // Verify that all objects can be found from their correct positions
        int heapLocation1 = heap.getHeapLocations()[obj1.getIndex()];
        assertTrue(heap.getArray()[heapLocation1].equals(obj1));
        
        int heapLocation2 = heap.getHeapLocations()[obj2.getIndex()];
        assertTrue(heap.getArray()[heapLocation2].equals(obj2));
        
        int heapLocation3 = heap.getHeapLocations()[obj3.getIndex()];
        assertTrue(heap.getArray()[heapLocation3].equals(obj3));
        
        int heapLocation4 = heap.getHeapLocations()[obj4.getIndex()];
        assertTrue(heap.getArray()[heapLocation4].equals(obj4));
        
        int heapLocation5 = heap.getHeapLocations()[obj5.getIndex()];
        assertTrue(heap.getArray()[heapLocation5].equals(obj5));
        
        // Deletion test
        /*
        PrimObject deleted = heap.deleteMin();
        assertTrue(verifyHeapLocations(deleteSolution1, heap));
        assertFalse(heap.contains(deleted));
        
        deleted = heap.deleteMin();
        assertTrue(verifyHeapLocations(deleteSolution2, heap));
        assertFalse(heap.contains(deleted));
        
        deleted = heap.deleteMin();
        assertTrue(verifyHeapLocations(deleteSolution3, heap));
        assertFalse(heap.contains(deleted));
        
        deleted = heap.deleteMin();
        assertTrue(verifyHeapLocations(deleteSolution4, heap));
        assertFalse(heap.contains(deleted));
        
        deleted = heap.deleteMin();
        assertTrue(verifyHeapLocations(deleteSolution5, heap));
        assertFalse(heap.contains(deleted));
        */
    }
}
