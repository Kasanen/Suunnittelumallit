public class SortingAlgorithm {
    public static void main(String[] args) {
        SortingContext sortingHandler = new SortingContext(new QuickSort());

        int[] integers = { 1, 5, 4, 6, 3 };
        int placement = 1;

        long startT = System.nanoTime();
        while (placement < 4) {
            System.out.println("\n");
            switch (placement) {
                case 1:
                    startT = System.nanoTime();
                    System.out.println("Strategy case 1");
                    sortingHandler.setStrategy(new QuickSort());
                    break;
                case 2:
                    startT = System.nanoTime();
                    System.out.println("Strategy case 2");
                    sortingHandler.setStrategy(new BubbleSort());
                    break;

                case 3:
                    startT = System.nanoTime();
                    System.out.println("Strategy case 3");
                    sortingHandler.setStrategy(new CycleSort());
                    break;
                default:
                    System.out.println("Every sorting type Completed");
                    return;
            }

            boolean sortingSuccessful = sortingHandler.processSorting(integers);

            if (sortingSuccessful) {
                System.out.println("Sorting successful!");

                long duration = (System.nanoTime() - startT) / 1000000;
                System.out.println(duration + "ms");

                placement += 1;
            } else {
                System.out.println("Sorting failed!");
            }
        }

    }

}