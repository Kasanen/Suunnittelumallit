public class GenerateCodeCommand implements Command {
    private Cursor cursor;
    private GUI gui;

    public GenerateCodeCommand(Cursor cursor, GUI gui) {
        this.cursor = cursor;
        this.gui = gui;
    }

    @Override
    public void execute() {
        StringBuilder output = new StringBuilder();

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                output.append(gui.getCellStatus(x, y) ? "1" : "0");
            }
            output.append("\n");
        }

        System.out.println(output);
    }
    
}