import java.util.Arrays;
        import java.util.Random;

public class Search_Comparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};  // Dataset sizes
        Random rand = new Random();

        for (int size : sizes) {
            int[] dataset = generateDataset(size);
            int target = dataset[rand.nextInt(size)];  // Pick a random element as target

            // Measure Linear Search Time
            long startTime = System.nanoTime();
            linearSearch(dataset, target);
            long endTime = System.nanoTime();
            long linearTime = endTime - startTime;

            // Measure Binary Search Time (Sorting + Searching)
            Arrays.sort(dataset);  // Sorting required for Binary Search
            startTime = System.nanoTime();
            binarySearch(dataset, target);
            endTime = System.nanoTime();
            long binaryTime = endTime - startTime;

            // Print Results
            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearTime / 1_000_000.0 + " ms");
            System.out.println("Binary Search Time: " + binaryTime / 1_000_000.0 + " ms");
            System.out.println("---------------------------");
        }
    }

    // Generate random dataset
    private static int[] generateDataset(int size) {
        int[] dataset = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            dataset[i] = rand.nextInt(size * 10);  // Random values within a range
        }
        return dataset;
    }

    // Linear Search implementation
    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  // Return index if found
            }
        }
        return -1;  // Not found
    }

    // Binary Search implementation
    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;  // Not found
    }
}
