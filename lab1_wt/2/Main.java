

public class Main {
    public static void main(String[] args) {
        Main check = new Main();
        System.out.println(Graphic.checkPoint(check.installPoint()));
    }

    private Point installPoint() {
        Point point = new Point();
        point.setX(installOneCoordinate("X"));
        point.setY(installOneCoordinate("Y"));
        return point;
    }

    private double installOneCoordinate(String str) {
        return InputDouble.getInputDouble(str);
    }
}
