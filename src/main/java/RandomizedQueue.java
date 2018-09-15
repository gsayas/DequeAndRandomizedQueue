import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<T> {

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

        if (size() == array.length) resize(2 * array.length);
        array[tail] = item;
        tail++;
    }

    private void resize(int capacity)
    {
        T[] copy = (T[]) new Object[capacity];



        try {
            for (int i = head; i < tail; i++)
                copy[tail - i - 1] = array[i];
        }catch (Exception e){
            System.out.println("tail-head-i:" + tail +"-"+head+"-");
        }
        array = copy;

        if( isShrinking(capacity) ) {
            resetIndices();
        }
    }

    private boolean isShrinking(int capacity) {
        return capacity < array.length;
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
        System.out.println("Index:" + randomIndex);
        System.out.println("lenght:" + array.length);
        System.out.println("tail:" + tail);
        return array[randomIndex];
    }
}
