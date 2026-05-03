public class TogglePixelCommand implements Command {
    private GUI gui;
    private Cursor cursor;

    public TogglePixelCommand(GUI gui, Cursor cursor) {
        this.gui = gui;
        this.cursor = cursor;
    }

    @Override
    public void execute() {
        gui.updateCellStatus(cursor.getX(), cursor.getY(), !gui.getCellStatus(cursor.getX(), cursor.getY()));
    }
}