import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class DequeTest {

    private Deque<String> deque;

    @Before
    public void setUp() throws Exception {
        deque = new Deque<String>();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(deque.size(), 0);
    }

    @Test
    public void testAddFirstWhenEmpty() {
        assertTrue(deque.isEmpty());

        deque.addFirst("Item1");
        assertEquals(deque.size(), 1);
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testAddFirstWhenNotEmpty() {
        deque.addFirst("Item1");
        assertEquals(deque.size(), 1);
        assertFalse(deque.isEmpty());

        deque.addFirst("Item2");
        assertEquals(deque.size(), 2);
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testAddLastWhenEmpty() {
        assertTrue(deque.isEmpty());

        deque.addLast("Item1");
        assertEquals(deque.size(), 1);
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testAddLastWhenNotEmpty() {
        deque.addFirst("Item1");
        assertEquals(deque.size(), 1);
        assertFalse(deque.isEmpty());

        deque.addLast("Item2");
        assertEquals(deque.size(), 2);
        assertFalse(deque.isEmpty());
    }
}
