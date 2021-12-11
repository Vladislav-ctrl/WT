
public class Matrix {
    private double[][] square;
    private Sequence sequence;

    public Matrix(Sequence sequence) {
        square = new double[sequence.getSize()][sequence.getSize()];
        this.sequence = sequence;
    }

    public void fillMatrix() {
        double[] elements = sequence.getArrayNumbers();
        for (int i = 0; i < square.length; i++) {
            int temp = i;
            for (int j = 0; j < square[i].length; j++) {
                square[i][j] = elements[temp % elements.length];
                temp++;
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                System.out.print(square[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public double[][] getSquare() {
        return square;
    }

    public void setSquare(double[][] square) {
        this.square = square;
    }

    public Sequence getSequence() {
        return sequence;
    }

    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }
}
