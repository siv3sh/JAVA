import java.util.*;

public class MaxFreq {
    static int k;

    private static void countFreq(int arr[], int n) {
        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);

        System.out.println("Frequencies of " + k + " elements:");
        int Count = 0;

        for (int i = 0; i < n && Count < k; i++) {
            if (visited[i]) {
                continue;
            }
            int count = 1;
            visited[i] = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println("Element: " + arr[i] + " Frequency: " + count);
            Count++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        
        // Validation for 'n'
        if (n <= 0) {
            System.out.println("Invalid input. Number of elements must be positive.");
            return;
        }

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        
        // Accept and validate array elements
        for (int i = 0; i < n; i++) {
            if (sc.hasNextInt()) {
                arr[i] = sc.nextInt();
            } else {
                System.out.println("Invalid input. Please enter integers only.");
                return;
            }
        }

        System.out.println("Enter the number of elements whose frequency is to be counted:");
        k = sc.nextInt();

        // Validation for 'k'
        if (k <= 0 || k > n) {
            System.out.println("Invalid input. 'k' should be a positive number and less than or equal to " + n);
            return;
        }

        countFreq(arr, n);
    }
}
