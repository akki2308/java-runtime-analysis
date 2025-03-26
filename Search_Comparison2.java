import java.util.*;

public class Search_Comparison2 {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000}; // Dataset sizes
        Random rand = new Random();

        for (int size : sizes) {
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            // Populate datasets with random values
            for (int i = 0; i < size; i++) {
                int value = rand.nextInt(size * 10); // Random unique values
                array[i] = value;
                hashSet.add(value);
                treeSet.add(value);
            }

            // Pick a random target value to search
            int target = array[rand.nextInt(size)];

            System.out.println("Dataset Size: " + size);

            // Array Search (Linear Search - O(N))
            long start = System.nanoTime();
            boolean foundInArray = linearSearch(array, target);
            long end = System.nanoTime();
            System.out.println("Array Search Time: " + (end - start) / 1_000_000.0 + " ms");

            // HashSet Search (O(1))
            start = System.nanoTime();
            boolean foundInHashSet = hashSet.contains(target);
            end = System.nanoTime();
            System.out.println("HashSet Search Time: " + (end - start) / 1_000_000.0 + " ms");

            // TreeSet Search (O(log N))
            start = System.nanoTime();
            boolean foundInTreeSet = treeSet.contains(target);
            end = System.nanoTime();
            System.out.println("TreeSet Search Time: " + (end - start) / 1_000_000.0 + " ms");

            System.out.println("--------------------------------");
        }
    }

    // Linear search for array (O(N))
    private static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }
}
