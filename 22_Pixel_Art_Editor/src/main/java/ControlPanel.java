public class ControlPanel {
    private Command up;
    private Command down;
    private Command left;
    private Command right;
    private Command select;
    private Command generateCode;

    public ControlPanel(Command up, Command down, Command left, Command right, Command select, Command generateCode) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.select = select;
        this.generateCode = generateCode;
    }

    public void moveUp() {
        up.execute();
    }

    public void moveDown() {
        down.execute();
    }

    public void moveRight() {
        right.execute();
    }

    public void moveLeft() {
        left.execute();
    }

    public void updateCellStatus() {
        select.execute();
    }

    public void generateCode() {
        generateCode.execute();
    }
}