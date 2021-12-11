import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

public class Expression {
    public static void main(String[] args) {
        double numberX = InputDouble.getInputDouble("X");
        double numberY = InputDouble.getInputDouble("Y");
        System.out.println(new Expression().calculate(numberX, numberY));
    }

    private double calculate(double numberX, double numberY) {
        double top = pow(sin(numberX + numberY), 2) + 1;
        double downTop = 2 * numberX;
        double downDown = (pow(numberX, 2) * pow(numberY, 2)) + 1;
        double down = abs(numberX - (downTop / downDown)) + 2;
        return (top / down) + numberX;
    }
}
