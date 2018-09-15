import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RandomizedQueueTest {

    private RandomizedQueue<String> queue;

    @Before
    public void setUp() throws Exception {
        queue = new RandomizedQueue<String>();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, queue.size());
    }

    @Test
    public void testEnqueueWhenEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue("item1");
        assertEquals(1, queue.size());
    }

    @Test
    public void testEnqueueWhenNotEmpty() {
        queue.enqueue("item1");
        assertFalse(queue.isEmpty());

        queue.enqueue("item2");
        assertEquals(2, queue.size());

        queue.enqueue("item3");
        assertEquals(3, queue.size());
    }

    @Test
    public void testDequeueWhenEmpty() {
        assertTrue(queue.isEmpty());

        try {
            String s = queue.dequeue();
            assertEquals(true, false);
        } catch (Exception e) {
            assertEquals(java.util.NoSuchElementException.class, e.getClass());
        }

    }

    @Test
    public void testSampleWhenEmpty() {
        assertTrue(queue.isEmpty());

        try {
            String s = queue.sample();
            assertEquals(true, false);
        } catch (Exception e) {
            assertEquals(java.util.NoSuchElementException.class, e.getClass());
        }

    }

    @Test
    public void testSampleWhenNotEmpty() {
        queue.enqueue("item1");
        assertFalse(queue.isEmpty());

        queue.enqueue("item2");
        assertEquals(2, queue.size());

        String s = queue.sample();
        assertEquals(5, s.length());
        //assertEquals("item1", s);
    }

    @Test
    public void testDequeueWhenNotEmpty() {
        queue.enqueue("item1");
        assertFalse(queue.isEmpty());

        queue.enqueue("item2");
        assertEquals(2, queue.size());

        String s = queue.dequeue();
        assertEquals(1, queue.size());
        //assertEquals("item1", s);
    }

    @Test
    public void testBigEnqueue() {
        queue.enqueue("item1");
        assertFalse(queue.isEmpty());

        queue.enqueue("item2");
        assertEquals(2, queue.size());

        queue.enqueue("item3");
        assertEquals(3, queue.size());

        queue.enqueue("item4");
        assertEquals(4, queue.size());

        queue.enqueue("item5");
        assertEquals(5, queue.size());

        queue.enqueue("item6");
        assertEquals(6, queue.size());

        queue.enqueue("item7");
        assertEquals(7, queue.size());

        queue.enqueue("item8");
        assertEquals(8, queue.size());

        queue.enqueue("item9");
        assertEquals(9, queue.size());
    }
}
