public class Main {
    public static void main(String[] args) {
        double[] inputArray = InputDouble.getArrayDouble(getSizeArray());
        SortShell sortShell = new SortShell(inputArray);
        sortShell.sort();
        sortShell.printArray();
    }

    private static int getSizeArray() {
        return InputInteger.getInputInteger();
    }
}
