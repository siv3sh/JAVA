import java.util.*;

public class ShareTrader {
    public static int maxProfit(int[] prices) {
        int firstBuy = 0;     
        int firstSell = 0;   
        int secondBuy = 0;    
        int secondSell = 0;   
        
        for (int price : prices) {
            if (firstBuy == 0) {
                firstBuy = -price;
            } else {
                if (-price > firstBuy) {
                    firstBuy = -price;
                }
            }

            if (firstBuy < 0) { 
                int profit = firstBuy + price; 
                if (profit > firstSell) {
                    firstSell = profit; 
                }
            }

            if (firstSell > 0) { 
                if (secondBuy == 0) {
                    secondBuy = firstSell - price; 
                } else {
                    if (firstSell - price > secondBuy) {
                        secondBuy = firstSell - price;
                    }
                }
            }

            if (secondBuy < 0) { 
                int profit = secondBuy + price; 
                if (profit > secondSell) {
                    secondSell = profit; 
                }
            }
        }
        return secondSell;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        
        // Validate input for the number of elements
        int n;
        if (sc.hasNextInt()) {
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Invalid input. The number of elements must be positive.");
                return;
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
            return;
        }

        int[] prices = new int[n]; 
        System.out.println("Enter the stock prices:");

        // Accept and validate stock prices
        for (int i = 0; i < n; i++) {
            if (sc.hasNextInt()) {
                prices[i] = sc.nextInt();
                // Check for negative stock prices
                if (prices[i] < 0) {
                    System.out.println("Invalid input. Stock prices cannot be negative.");
                    return;
                }
            } else {
                System.out.println("Invalid input. Please enter integers only.");
                return;
            }
        }

        // Calculate and display the maximum profit
        System.out.println("Maximum profit: " + maxProfit(prices)); 
    }
}
