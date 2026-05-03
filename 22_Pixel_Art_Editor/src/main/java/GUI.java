import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GUI extends Application {

    private static final int ROWS = 8;
    private static final int COLS = 8;
    private static final int CELL_SIZE = 70;
    private static final int PADDING = 10;

    private final Rectangle[][] cells = new Rectangle[COLS][ROWS];
    private final boolean[][] cellStatus = new boolean[COLS][ROWS];

    private int lastCursorX = -1;
    private int lastCursorY = -1;

    @Override
    public void start(Stage primaryStage) {
        Cursor cursor = new Cursor(0, 0);

        Command up = new MoveCursorUpCommand(cursor);
        Command down = new MoveCursorDownCommand(cursor);
        Command left = new MoveCursorLeftCommand(cursor);
        Command right = new MoveCursorRightCommand(cursor);
        Command space = new TogglePixelCommand(this, cursor);
        Command generate = new GenerateCodeCommand(cursor, this);

        ControlPanel controlPanel = new ControlPanel(up, down, left, right, space, generate);

        // Grid system
        GridPane grid = new GridPane();
        grid.setHgap(4);
        grid.setVgap(4);
        grid.setStyle(
                "-fx-background-color: #717171;" +
                        "-fx-padding: " + PADDING + ";");

        for (int y = 0; y < ROWS; y++) {
            for (int x = 0; x < COLS; x++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);

                cells[x][y] = cell;
                cell.setFill(Color.web("#000000"));
                grid.add(cell, x, y);
            }
        }

        Button toggleButton = new Button("Generate Code");
        toggleButton.setMaxWidth(Double.MAX_VALUE);
        toggleButton.setFocusTraversable(false);
        toggleButton.setOnAction(e -> controlPanel.generateCode());

        VBox root = new VBox(10, grid, toggleButton);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: " + PADDING + ";");

        // Set up the scene
        int windowSize = COLS * CELL_SIZE + (COLS - 1) * 4 + PADDING * 2;
        Scene scene = new Scene(root, windowSize, windowSize + 60);

        updateCursorMarker(cursor);

        // Event handlers
        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.DOWN) {
                controlPanel.moveDown();
                updateCursorMarker(cursor);
                System.out.println("DOWN pressed");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.UP) {
                controlPanel.moveUp();
                updateCursorMarker(cursor);
                System.out.println("UP pressed");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.LEFT) {
                controlPanel.moveLeft();
                updateCursorMarker(cursor);
                System.out.println("LEFT pressed");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.RIGHT) {
                controlPanel.moveRight();
                updateCursorMarker(cursor);
                System.out.println("RIGHT pressed");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.SPACE) {
                controlPanel.updateCellStatus();
                System.out.println("Space pressed");
            }
        });

        primaryStage.setTitle("Pixel Art Editor");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void updateCellStatus(int x, int y, boolean status) {
        cellStatus[x][y] = status;
        cells[x][y].setFill(status ? Color.web("#ffffff") : Color.web("#000000"));
    }

    public boolean getCellStatus(int x, int y) {
        return cellStatus[x][y];
    }

    private void updateCursorMarker(Cursor cursor) {
        // Remove old marker
        if (lastCursorX >= 0 && lastCursorY >= 0) {
            Rectangle oldCell = cells[lastCursorX][lastCursorY];
            oldCell.setStroke(Color.TRANSPARENT);
            oldCell.setStrokeWidth(0);
        }

        // Add new marker
        int x = cursor.getX();
        int y = cursor.getY();
        Rectangle current = cells[x][y];
        current.setStroke(Color.web("#f6f669")); 
        current.setStrokeWidth(3);

        lastCursorX = x;
        lastCursorY = y;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
