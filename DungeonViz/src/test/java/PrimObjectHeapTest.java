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

}
