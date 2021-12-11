public class SortShell {
    private double[] array;

    public SortShell(double[] array) {
        this.array = array;
    }

    public void sort() {
        int i = 0;
        while (i < array.length - 1) {
            boolean isBack = false;
            if (array[i] > array[i + 1]) {
                double temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                if (i > 0) {
                    isBack = true;
                    i--;
                }
            }
            if (!isBack) {
                i++;
            }
        }
    }

    public void printArray() {
        System.out.print("Elements of array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }

    public double[] getArray() {
        return array;
    }

    public void setArray(double[] array) {
        this.array = array;
    }
}
