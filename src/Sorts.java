import java.util.NoSuchElementException;

public class Sorts {

    public static int[] mergeSort(int[] array) {
        int length = array.length;
        int[] helper = new int[length];
        mergeSort(array, helper, 0, length - 1);
        return array;
    }

    private static void mergeSort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(array, helper, low, middle);
            mergeSort(array, helper, middle + 1, high);
            merge(array, helper, low, middle, high);
        }
    }

    private static void merge(int[] array, int[] helper, int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }

            current++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i < remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }

    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int index = partition(array, left, right);
            quickSort(array, left, index - 1);
            quickSort(array, index + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static int binarySearch(int[] array, int value) {
        quickSort(array); // sorting the array

        int i = binarySearch(array, 0, array.length - 1, value);
        if (i == -1) {
            throw new NoSuchElementException();
        }
        return i;
    }

    private static int binarySearch(int[] array, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int middleValue = (low + high) / 2;

        if (value < array[middleValue]) {
            return binarySearch(array, low, middleValue, value);
        } else if (value > array[middleValue]) {
            return binarySearch(array, middleValue + 1, high, value);
        } else {
            return middleValue;
        }
    }
}
