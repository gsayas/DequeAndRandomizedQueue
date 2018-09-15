import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.Random;

public class RandomizedQueue<T> implements Iterable<T> {

    T[] array;
    private int head, tail;

    public RandomizedQueue(){
        array = (T[]) new Object[1];
        head = 0;
        tail = 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return tail - head;
    }

    public void enqueue(T item) {
        if(item == null) throw new java.lang.IllegalArgumentException();

        if (size() == array.length)
            resize(2 * array.length);

        array[tail] = item;
        tail++;
    }

    private void resize(int capacity)
    {
        T[] copy = (T[]) new Object[capacity];

        for (int i = head, j= 0; i < tail; i++, j++)
            copy[j] = array[i];

        array = copy;

        resetIndices();
    }

    private void resetIndices(){
        tail -= head;
        head = 0;
    }

    public T dequeue() {
        if(isEmpty()) throw new java.util.NoSuchElementException();

        moveRandomItemToHead();
        T item = array[head];
        array[head++] = null;
        if (size() > 0 && size() == array.length/4) resize(array.length/2);
        return item;
    }

    private void moveRandomItemToHead() {
        int randomIndex = StdRandom.uniform(head, tail);
        T currentHead = array[head];
        array[head] = array[randomIndex];
        array[randomIndex] = currentHead;
    }

    public T sample() {
        if(isEmpty()) throw new java.util.NoSuchElementException();

        int randomIndex = StdRandom.uniform(head, tail);
        return array[randomIndex];
    }

    public Iterator<T> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<T> {

        private T[] iteratorArray;
        private int currentIndex;

        public RandomIterator() {
            iteratorArray = (T[]) new Object[size()];
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
        public T next() {
            if(hasNext()) {
                currentIndex++;
                T item = iteratorArray[currentIndex];
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
