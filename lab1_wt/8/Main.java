public class Main {
    public static void main(String[] args) {
        System.out.println("Input numbers for first sequence");
        Sequence sequenceOne = new Sequence(getListSize());
        System.out.println("Input numbers for second sequence");
        Sequence sequenceTwo = new Sequence(getListSize());
        HandlerSequences handlerSequences = new HandlerSequences(sequenceOne, sequenceTwo);
        handlerSequences.elementToSeqA();
        System.out.println(handlerSequences.getSequenceA().getNumbers());
    }

    public static int getListSize() {
        return InputInteger.getInputInteger();
    }
}
