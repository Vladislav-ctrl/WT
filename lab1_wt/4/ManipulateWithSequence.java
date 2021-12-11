

public class ManipulateWithSequence {
    private ManipulateWithSequence() {
    }

    public static void findSimpleNumbers(Sequence sequence) {
        int[] arraySequence = sequence.getArray();
        System.out.print("Simple Numbers: ");
        for (int i = 0; i < sequence.getArray().length; i++) {
            if (arraySequence[i] == 0 || arraySequence[i] == 1) {
                continue;
            } else if (arraySequence[i] == 2) {
                System.out.print(arraySequence[i] + " ");
            } else {
                boolean isSimple = true;
                for (int j = 2; j < arraySequence[i] - 1; j++) {
                    if (arraySequence[i] % j == 0) {
                        isSimple = false;
                        break;
                    }
                }
                if (isSimple) {
                    System.out.print(arraySequence[i] + "(index = " + i + ") ");
                }
            }
        }
    }
}
