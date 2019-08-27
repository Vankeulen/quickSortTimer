import java.util.Arrays;

public class QuickSort_Times {

    public static void main(String[] arg) {
        int[] arr = generateRandomArray(0, 100, 10);
        int[] ar1 = arr;


        printQuickSort(arr, false);
        printQuickSort(ar1, true);
    } //main

    private static void printQuickSort(int[] arr, boolean mot) {
        int left = 0;
        int right = arr.length - 1;
        System.out.println("Array length: " + arr.length);
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        long timeTook = 0;
        if (!mot) {
//            medianOfThree(arr, left, right);
            timeTook = quickSortTime(arr, left, right, false);
        } else {
            timeTook = quickSortTime(arr, left, right, true);
        }
        System.out.println("Sorted array:   " + Arrays.toString(arr));
        System.out.println("Time: " + timeTook + " nanoseconds\n");
    }

    private static long quickSortTime(int[] arr, int left, int right, boolean mot) {
        long first;
        if (!mot) {
            first = System.nanoTime();
            quickSort(arr, left, right);
        } else {
            first = System.nanoTime();
            medianOfThree(arr, left, right);
            quickSort(arr, left, right);
        }
        long last = System.nanoTime();
        return last - first;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);

            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private static int partition(int arr[], int left, int right) {
        int pivot = arr[right];
        int i = (left - 1);

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;

//                swap(arr, arr[i], arr[j]);
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = swapTemp;

        return i + 1;
    }

    private static int[] generateRandomArray(int min, int max, int listSize) {
        int[] arr = new int[listSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max) + min;
        }
        return arr;
    }

    // Get the median of three of the array, changing the array as you do.
    // arr = Data Structure (List)
    // left = Left most index into list to find MOT on.
    // right = Right most index into list to find MOT on
    private static int medianOfThree(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[right] < arr[left]) {
            swap(arr, left, right);
        }
        if (arr[mid] < arr[left]) {
            swap(arr, mid, left);
        }
        if (arr[right] < arr[mid]) {
            swap(arr, right, mid);
        }
        return mid;
    }

    // Generic Swap for manipulating list data.
    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

    }
}