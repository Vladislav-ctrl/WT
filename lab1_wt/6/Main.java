public class Main {
    public static void main(String[] args) {
        int countElements = getCountElements();
        Sequence sequence = new Sequence(countElements);
        Matrix matrix = new Matrix(sequence);
        matrix.fillMatrix();
        matrix.printMatrix();
    }

    private static int getCountElements() {
        System.out.println("Input the order of the square matrix");
        return InputInteger.getInputInteger();
    }
}
