import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

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
        queue.enqueue("item4");
        queue.enqueue("item5");
        queue.enqueue("item6");
        queue.enqueue("item7");
        queue.enqueue("item8");

        queue.enqueue("item9");
        assertEquals(9, queue.size());
    }

    @Test
    public void testBigDequeue() {
        queue.enqueue("item0");
        queue.enqueue("item1");
        queue.enqueue("item2");
        queue.enqueue("item3");
        queue.enqueue("item4");
        queue.enqueue("item5");
        queue.enqueue("item6");
        queue.enqueue("item7");
        queue.enqueue("item8");
        queue.enqueue("item9");
        assertEquals(10, queue.size());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertEquals(3, queue.size());
        queue.dequeue();
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
        queue.dequeue();
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testGetIterator() {
        assertTrue(queue.isEmpty());
        Iterator<String> it = queue.iterator();
        assertFalse(it.hasNext());
        queue.enqueue("item1");
        queue.enqueue("item2");
        queue.enqueue("item3");
        it = queue.iterator();
        String s = it.next();
        assertEquals(5, s.length());
        s = it.next();
        s = it.next();
        assertEquals(5, s.length());
        assertFalse(it.hasNext());

        try{
            s = it.next();
            assertEquals(true, false);
        }catch (Exception e){
            assertEquals(java.util.NoSuchElementException.class, e.getClass());
        }
    }

    @Test
    public void testRemoveOnIterator() {
        Iterator<String> it = queue.iterator();

        try{
            it.remove();
            assertEquals(true, false);
        }catch (Exception e){
            assertEquals(java.lang.UnsupportedOperationException.class, e.getClass());
        }
    }
}
