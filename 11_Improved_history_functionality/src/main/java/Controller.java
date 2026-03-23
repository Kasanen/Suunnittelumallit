import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> redoHistory; // Redo history

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
        gui.updateGui();
        gui.updateStats();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public List<IMemento> getHistory() {
        return history;
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
        gui.updateGui();
        gui.updateStats();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");

            redoHistory.add(model.createMemento());

            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);

            gui.updateGui();
            gui.updateStats();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Redo memento found in history");

            history.add(model.createMemento());

            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(nextState);

            gui.updateGui();
            gui.updateStats();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
        redoHistory.clear();
    }

    public void restoreFromMemento(IMemento memento) {
        history.add(model.createMemento());
        model.restoreState(memento);
        gui.updateGui();
        gui.updateStats();
    }

}
