public class Sequence {
    private int size;
    private int[] array;

    public Sequence(int n) {
        size = n;
        array = new int[size];
        installArray();
    }

    private void installArray() {
        for (int i = 0; i < size; i++) {
            int temp = (int) (Math.random() * 100) + 1;
            array[i] = temp;
        }
    }

    public void printElements() {
        System.out.print("Elements of array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}
