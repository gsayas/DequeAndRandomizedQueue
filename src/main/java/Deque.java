public class Deque<T> {

    private class Node {
        T item;
        Node next;
        Node previous;
    }

    private Node first;
    private Node last;
    private int size;

    public Deque(){
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        Node oldFirst = first;

        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.previous = null;

        if(isEmpty()) {
            last = first;
        }else{
            oldFirst.previous = first;
        }

        size++;
    }

    public void addLast(T item) {
        if(isEmpty()){
            addFirst(item);
        }else{
            addLastWhenNotEmpty(item);
        }
    }

    private void addLastWhenNotEmpty(T item){
        Node oldLast = last;

        last = new Node();
        last.item = item;
        last.previous = oldLast;
        last.next = null;

        oldLast.next = last;

        size++;
    }


    public T removeFirst() {
        if(isEmpty()){
            throw new java.util.NoSuchElementException();
        }else{
            Node currentFirst = first;
            first = currentFirst.next;

            if(size() > 1){
                first.previous = null;
            }

            size--;
            return currentFirst.item;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
