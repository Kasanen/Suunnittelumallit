import java.util.Iterator;

public class FibonacciSequence implements Iterable<Integer>, Sequence {
    private Node head;
    private Node prev;
    private Node tail;

    public FibonacciSequence() {
        this.head = null;
        this.prev = null;
        this.tail = null;
    }

    public void add() {
        int nextValue;

        if(head == null) {
            nextValue = 0;
        } else if (tail == head) {
            nextValue = 1;
        } else {
            nextValue = tail.getData() + tail.getPrev().getData();
        }

        Node newNode = new Node(nextValue);
        
        if (head == null) {
            // first element
            head = newNode;
            tail = newNode;
            prev = null;
            tail.setNext(head);
            head.setPrev(tail);
        } else {
            prev = tail;
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
            tail.setNext(head);
            head.setPrev(tail);
        }
    }

    public Integer getPrevious() {
        return (prev != null) ? prev.getData() : null;
    }

    public Node getHead() {
        return head;
    }

    public Node getPrev() {
        return prev;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(this);
    }
}
