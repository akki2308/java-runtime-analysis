import java.util.Arrays;
        import java.util.Random;

public class Sorting_Comparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; // Dataset sizes
        Random rand = new Random();

        for (int size : sizes) {
            int[] dataset = generateDataset(size);

            // Copy datasets to ensure fair comparison
            int[] bubbleData = Arrays.copyOf(dataset, dataset.length);
            int[] mergeData = Arrays.copyOf(dataset, dataset.length);
            int[] quickData = Arrays.copyOf(dataset, dataset.length);

            System.out.println("Dataset Size: " + size);

            // Bubble Sort
            if (size <= 10000) { // Bubble Sort is impractical for large N
                long start = System.nanoTime();
                bubbleSort(bubbleData);
                long end = System.nanoTime();
                System.out.println("Bubble Sort Time: " + (end - start) / 1_000_000.0 + " ms");
            } else {
                System.out.println("Bubble Sort: Unfeasible for large N");
            }

            // Merge Sort
            long start = System.nanoTime();
            mergeSort(mergeData, 0, mergeData.length - 1);
            long end = System.nanoTime();
            System.out.println("Merge Sort Time: " + (end - start) / 1_000_000.0 + " ms");

            // Quick Sort
            start = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            end = System.nanoTime();
            System.out.println("Quick Sort Time: " + (end - start) / 1_000_000.0 + " ms");

            System.out.println("--------------------------------");
        }
    }

    // Generate random dataset
    private static int[] generateDataset(int size) {
        int[] dataset = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            dataset[i] = rand.nextInt(size * 10); // Random values
        }
        return dataset;
    }

    // Bubble Sort (O(N²))
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: Stop if already sorted
        }
    }

    // Merge Sort (O(N log N))
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort (O(N log N))
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
