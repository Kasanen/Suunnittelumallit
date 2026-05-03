public class Cursor {
    private int x;
    private int y;

    public Cursor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        if (y > 0) {
            y--;
        }
    }

    public void moveDown() {
        if (y < 7) {
            y++;
        }
    }

    public void moveLeft() {
        if (x > 0) {
            x--;
        }
    }

    public void moveRight() {
        if (x < 7) {
            x++;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}