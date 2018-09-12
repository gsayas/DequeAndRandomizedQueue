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
        assertEquals(0, deque.size());
    }

    @Test
    public void testAddFirstWhenEmpty() {
        assertTrue(deque.isEmpty());

        deque.addFirst("Item1");
        assertEquals(1, deque.size());
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testAddFirstWhenNotEmpty() {
        deque.addFirst("Item1");
        assertEquals(1, deque.size());
        assertFalse(deque.isEmpty());

        deque.addFirst("Item2");
        assertEquals(2, deque.size());
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testAddLastWhenEmpty() {
        assertTrue(deque.isEmpty());

        deque.addLast("Item1");
        assertEquals(1, deque.size());
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testAddLastWhenNotEmpty() {
        deque.addFirst("Item1");
        assertEquals(1, deque.size());
        assertFalse(deque.isEmpty());

        deque.addLast("Item2");
        assertEquals(2, deque.size());
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testRemoveFirstWhenEmpty() {
        try{
            deque.removeFirst();
        }catch (Exception ex){
            assertEquals(java.util.NoSuchElementException.class, ex.getClass());
        }
    }

    @Test
    public void testRemoveFirstWhenNotEmpty() {
        deque.addLast("item2");
        deque.addFirst("item1");
        assertEquals(2, deque.size());
        String s = deque.removeFirst();
        assertEquals("item1", s);
        assertEquals(1, deque.size());
    }

    @Test
    public void testRemoveLastWhenEmpty() {
        try{
            deque.removeLast();
        }catch (Exception ex){
            assertEquals(java.util.NoSuchElementException.class, ex.getClass());
        }
    }

    @Test
    public void testRemoveLastWhenNotEmpty() {
        deque.addFirst("item1");
        deque.addLast("item2");
        assertEquals(2, deque.size());
        String s = deque.removeLast();
        assertEquals("item2", s);
        assertEquals(1, deque.size());
    }
}
