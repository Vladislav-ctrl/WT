
public class Sequence {
    private double[] arrayNumbers;
    private int size;

    public Sequence(int size) {
        this.size = size;
        arrayNumbers = installElements();
    }

    private double[] installElements() {
        return InputDouble.getArrayDouble(size);
    }

    public double[] getArrayNumbers() {
        return arrayNumbers;
    }

    public void setArrayNumbers(double[] arrayNumbers) {
        this.arrayNumbers = arrayNumbers;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
