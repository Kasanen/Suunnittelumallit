public class Memento implements IMemento {
    private final int[] options;
    private final boolean isSelected;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public String toString() {
        return "options=[" + options[0] + "," + options[1] + "," + options[2] + "], selected=" + isSelected;
    }
}