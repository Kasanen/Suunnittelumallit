public class SortingContext {
    
    private SortingStrategy sortingStrategy;

    public SortingContext(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setStrategy(SortingStrategy sortingStrategy) {
        //System.out.println("Setting strategy: " + sortingStrategy);
        this.sortingStrategy = sortingStrategy;
    }

    public boolean processSorting(int list[]){
        return sortingStrategy.processSorting(list);
    }
}
