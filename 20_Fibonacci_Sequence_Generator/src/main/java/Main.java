import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        int amount = 0;

        // Scanner sc = new Scanner(System.in);

        // Sequence ring = new FibonacciSequence();
        // ring.add(17);
        // ring.add(3);
        // ring.add(-2);
        // ring.add(0);
        // ring.add(50);

        // Iterator iterator = ring.iterator();

        // while (iterator.hasNext()) {
        // System.out.println("In turn: " + iterator.next());
        // // 'Enter' continues, 'q' stops
        // String s = sc.nextLine();
        // if (s.equals("q")) {
        // break;
        // }
        // }

        FibonacciSequence fib = new FibonacciSequence();

        Iterator iterator = fib.iterator();

        while (amount <= 10) {
            fib.add();
            amount++;
        }

        if (fib.getHead() != null) {
            for (Integer value : fib) {
                System.out.println(value);
            }
        }
    }
}
