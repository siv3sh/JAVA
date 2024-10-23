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
        int n = sc.nextInt();
        int[] prices = new int[n]; 
        System.out.println("Enter the stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt(); 
        }
        System.out.println("Maximum profit: " + maxProfit(prices)); 
    }
}
