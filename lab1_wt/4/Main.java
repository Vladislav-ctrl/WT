

public class Main {
    public static void main(String[] args) {
        Sequence sequence = new Sequence(getSizeArray());
        sequence.printElements();
        ManipulateWithSequence.findSimpleNumbers(sequence);
    }

    private static int getSizeArray() {
        System.out.println("Input size of array");
        return InputInteger.getInputInteger();
    }
}
