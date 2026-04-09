public class Hexagon extends Shape {

    public Hexagon(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Hexagon drawn. " + color.fill();
    }
}