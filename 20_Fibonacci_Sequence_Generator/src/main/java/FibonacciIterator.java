import java.util.Iterator;
import java.util.NoSuchElementException;

public class FibonacciIterator implements Iterator<Integer> {
    private final Node start;
    private Node current;
    private boolean firstPass;

    public FibonacciIterator(FibonacciSequence ring) {
        this.start = ring.getHead();
        this.current = start;
        this.firstPass = true;
    }

    @Override
    public boolean hasNext() {
        return current != null && (firstPass || current != start);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        int data = current.getData();
        current = current.getNext();
        firstPass = false;
        return data;
    }
}