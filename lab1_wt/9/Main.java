import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Ball ball1 = new Ball(10, Color.BLACK);
        Ball ball2 = new Ball(5.5, Color.BLUE);
        Ball ball3 = new Ball(7.6, Color.RED);
        Ball ball4 = new Ball(3, Color.BLUE);
        Ball ball5 = new Ball(6.85, Color.YELLOW);
        Ball ball6 = new Ball(8.3, Color.GREEN);
        Basket basket = new Basket();
        basket.addBall(ball1);
        basket.addBall(ball2);
        basket.addBall(ball3);
        basket.addBall(ball4);
        basket.addBall(ball5);
        basket.addBall(ball6);
        System.out.println(basket.calcWidthBalls());
        System.out.println(basket.calcCountBlueBalls());
    }
}
