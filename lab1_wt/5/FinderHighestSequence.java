

import java.util.Arrays;

public class FinderHighestSequence {
    public static int find(int[] array) {
        int[] tempArray = new int[array.length];
        Arrays.fill(tempArray, 1);
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j] && tempArray[i] <= tempArray[j]) {
                    tempArray[i] = tempArray[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i] >= max) {
                max = tempArray[i];
            }
        }
        return array.length - max;
    }
}
