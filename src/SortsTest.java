import org.junit.Test;

import java.util.Arrays;

public class SortsTest {

    @Test
    public void mergeSort() {
        int[] array = new int[] {50, 30, 20, 10, 80, 40};
//        int[] mergeSortResult = Sorts.mergeSort(array);
        int[] quickSortResult = Sorts.quickSort(array);
        int[] newArray = Arrays.copyOf(array, array.length);
        Arrays.stream(newArray).forEach(e -> System.out.print(e + " "));
        System.out.println();
//        Arrays.stream(mergeSortResult).forEach(e -> System.out.print(e + " "));
        System.out.println();
        Arrays.stream(quickSortResult).forEach(e -> System.out.print(e + " "));
        System.out.println();
        System.out.println(Sorts.binarySearch(array, 40));
        System.out.println(Sorts.binarySearch(array, 50));
    }
}