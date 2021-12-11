
public class Graphic {
    private Graphic() {
    }

    public static boolean checkPoint(Point point) {
        if (point.getX() > 6 || point.getX() < -6 || point.getY() > 5 || point.getY() < -3) {
            return false;
        } else if (point.getX() >= -4 && point.getX() <= 4) {
            return true;
        } else if (point.getY() <= 0) {
            return true;
        }
        return false;
    }
}
