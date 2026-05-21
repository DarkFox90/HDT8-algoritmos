import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class VectorHeapTest {
    private VectorHeap<Integer> heap;

    @Before
    public void setUp() {
        heap = new VectorHeap<Integer>();
    }

    @Test
    public void testRemove() {
        heap.add(10);
        heap.add(2);
        heap.add(7);
        heap.add(1);

        assertEquals(Integer.valueOf(1), heap.remove());
        assertEquals(Integer.valueOf(2), heap.remove());
        assertEquals(Integer.valueOf(7), heap.remove());
        assertEquals(Integer.valueOf(10), heap.remove());
        assertTrue(heap.isEmpty());
    }
}
