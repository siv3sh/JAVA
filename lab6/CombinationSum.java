public class CombinationSum{

    private static int totalCount = 0; // Shared result

    public static void main(String[] args) throws InterruptedException {
        int[] nums = {2, 5, 3, 6};
        int targetSum = 10;

        // Number of threads
        int threadCount = 2; // Example: 2 threads
        int chunkSize = nums.length / threadCount; // Divide the array
        Thread[] threads = new Thread[threadCount];

        for (int t = 0; t < threadCount; t++) {
            final int start = t * chunkSize;
            final int end = (t == threadCount - 1) ? nums.length : (t + 1) * chunkSize;

            // Create thread to process part of the array
            threads[t] = new Thread(() -> processCombinations(nums, targetSum, start, end));
            threads[t].start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }

        // Print the total count
        System.out.println("Number of combinations: " + totalCount);
    }

    // Recursive function to find combinations
    private static void findCombinations(int[] nums, int targetSum, int start) {
        if (targetSum == 0) {
            // Valid combination found
            synchronized (CombinationSum.class) {
                totalCount++;
            }
            return;
        }

        if (targetSum < 0) {
            return; // Stop exploring this branch
        }

        // Try each number starting from 'start' to allow repetition
        for (int i = start; i < nums.length; i++) {
            // Recurse with the current element and reduce the target sum
            findCombinations(nums, targetSum - nums[i], i); // Allow repetition by passing `i`
        }
    }

    // Process part of the array
    private static void processCombinations(int[] nums, int targetSum, int start, int end) {
        for (int i = start; i < end; i++) {
            findCombinations(nums, targetSum, i); // Start the recursive exploration
        }
    }
}

 
    

