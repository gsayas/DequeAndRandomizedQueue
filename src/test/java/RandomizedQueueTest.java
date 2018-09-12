import org.junit.Before;
import org.junit.Test;

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
}
