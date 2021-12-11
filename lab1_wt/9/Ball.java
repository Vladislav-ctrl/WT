import java.awt.Color;

public class Ball {
    private double width;
    private Color color;

    public Ball(double width, Color color) {
        this.width = width;
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "width=" + width +
                ", color=" + color +
                '}';
    }
}
