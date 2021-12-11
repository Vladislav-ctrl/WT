import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Ball> balls;

    public Basket(List<Ball> balls) {
        this.balls = balls;
    }

    public Basket() {
        balls = new ArrayList<>();
    }

    public void addBall(Ball ball) {
        balls.add(ball);
    }

    public double calcWidthBalls() {
        double commonWidth = 0;
        for (int i = 0; i < balls.size(); i++) {
            commonWidth += balls.get(i).getWidth();
        }
        return commonWidth;
    }

    public int calcCountBlueBalls() {
        int count = 0;
        for (int i = 0; i < balls.size(); i++) {
            if (balls.get(i).getColor().equals(Color.BLUE)) {
                count++;
            }
        }
        return count;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    @Override
    public String toString() {
        return balls.toString();
    }
}
