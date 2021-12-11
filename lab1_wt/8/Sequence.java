import java.util.List;

public class Sequence {
    private List<Double> numbers;
    private int size;

    public Sequence(int size) {
        this.size = size;
        numbers = installList();
    }

    private List<Double> installList() {
        return InputDouble.getHighestList(size);
    }

    public List<Double> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Double> numbers) {
        this.numbers = numbers;
    }
}
