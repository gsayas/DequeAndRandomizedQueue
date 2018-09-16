import edu.princeton.cs.algs4.StdIn;
import java.util.NoSuchElementException;

public class Permutation {
    public static void main(String[] args){

        RandomizedQueue<String> queue = new RandomizedQueue<>();
        int K = (int) Integer.parseInt(args[0]);

        try {
            do{
                queue.enqueue(StdIn.readString());
            }while(true);
        }
        catch (NoSuchElementException e) {

            for(int i=0; i<K; i++){
                System.out.println(queue.dequeue());
            }
        }

    }
}
