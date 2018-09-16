import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] array;
    private int head, tail;

    public RandomizedQueue(){
        array = (Item[]) new Object[1];
        head = 0;
        tail = 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return tail - head;
    }

    public void enqueue(Item item) {
        if(item == null) throw new java.lang.IllegalArgumentException();

        if (size() == array.length) {
            resize(2 * array.length);
        }else if(tail >= array.length){
            resize(2 * size());
        }

        array[tail] = item;
        tail++;
    }

    private void resize(int capacity)
    {
        Item[] copy = (Item[]) new Object[capacity];

        for (int i = head, j= 0; i < tail; i++, j++)
            copy[j] = array[i];

        array = copy;

        resetIndices();
    }

    private void resetIndices(){
        tail -= head;
        head = 0;
    }

    public Item dequeue() {
        if(isEmpty()) throw new java.util.NoSuchElementException();

        moveRandomItemToHead();
        Item item = array[head];
        array[head] = null;
        head++;
        if(size()==0) resetIndices();
        if (size() > 0 && size() == array.length/4) resize(array.length/2);
        return item;
    }

    private void moveRandomItemToHead() {
        int randomIndex = StdRandom.uniform(head, tail);
        Item currentHead = array[head];
        array[head] = array[randomIndex];
        array[randomIndex] = currentHead;
    }

    public Item sample() {
        if(isEmpty()) throw new java.util.NoSuchElementException();

        int randomIndex = StdRandom.uniform(head, tail);
        return array[randomIndex];
    }

    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {

        private Item[] iteratorArray;
        private int currentIndex;

        public RandomIterator() {
            iteratorArray = (Item[]) new Object[size()];
            currentIndex = -1;

            for (int i = head, j = 0; i < tail; i++, j++)
                iteratorArray[j] = array[i];

            StdRandom.shuffle(iteratorArray);
        }

        @Override
        public boolean hasNext() {
            return !isEmpty() && currentIndex + 1 < iteratorArray.length;
        }

        @Override
        public Item next() {
            if(hasNext()) {
                currentIndex++;
                Item item = iteratorArray[currentIndex];
                return item;
            }else{
                throw new java.util.NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
}
