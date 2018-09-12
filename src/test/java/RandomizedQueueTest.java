import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
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
    public void testsize() {
        assertEquals(0, queue.size());
    }

    @Test
    public void testEnqueueWhenEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue("item1");
        assertEquals(1, queue.size());
    }
}
