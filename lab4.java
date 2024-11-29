import java.util.*;

abstract class Robber {
  
    abstract int RowHouses(int[] amounts);
    abstract int RoundHouses(int[] amounts);
    abstract int SquareHouse(int[] amounts);
    abstract int MultiHouseBuilding(int[]... amounts);

    public static void MachineLearning() {
System.out.println("I love MachineLearning");
    
    }

    public static void RobbingClass() {

        System.out.println("MScAI&ML");
 }}



 class JAVAProfessionalRobber extends Robber {
    
int RowHouses(int[] amounts) {
    int oddSum = 0, evenSum = 0;
        
    for (int i = 0; i < amounts.length; i++) {

      if (i % 2 == 0) {
      evenSum += amounts[i];

    }  else {

        oddSum += amounts[i];

            } }
    
        return Math.max(oddSum, evenSum);
    }

int RoundHouses(int[] amounts) {
        
        if (amounts.length == 1) return amounts[0];
        return Math.max(calculateMax(amounts, 0, amounts.length - 2),
                        calculateMax(amounts, 1, amounts.length - 1));
    }

    private static int calculateMax(int[] amounts, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + amounts[i]);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }


 int SquareHouse(int[] amounts) {
        return RowHouses(amounts);
    }

   
int MultiHouseBuilding(int[]... amounts) {
        int totalMax = 0;
        for (int[] houseType : amounts) {
            totalMax += RowHouses(houseType);
        }
        return totalMax;
    }

    public static void RowHouse() {
        int[] amount = {1, 2, 3, 0};
        int oddSum = 0, evenSum = 0;
        for (int i = 0; i < amount.length; i++) {
            if (i % 2 == 0) {
                evenSum += amount[i];
            } else {
                oddSum += amount[i];
            }
        }
        System.out.println(Math.max(oddSum, evenSum));
        System.out.println("RowHouse");
    }

    public static void RoundHouse() {
        int[] amount = {1, 2, 3, 4};
        int case1 = calculateMax(amount, 0, amount.length - 2);
        int case2 = calculateMax(amount, 1, amount.length - 1);
        int result = Math.max(case1, case2);
        System.out.println(result);
        System.out.println("RoundHouse");
    }

    public static void SquareHouse() {
        int[] amount = {5, 10, 2, 7};
        int oddSum = 0, evenSum = 0;
        for (int i = 0; i < amount.length; i++) {
            if (i % 2 == 0) {
                evenSum += amount[i];
            } else {
                oddSum += amount[i];
            }
        }
        System.out.println(Math.max(oddSum, evenSum));
        System.out.println("SquareHouse");
    }

    public static void MuliHouseBuilding() {
        System.out.println("MultiHouseBuilding");
    }
}

public class lab4 {
public static void main(String[] args) {
    int n = 0;
      Scanner sc = new Scanner(System.in);

     while (true) {
        System.out.println("1. RowHouse");
     System.out.println("2. RoundHouse");
     System.out.println("3. SquareHouse");
     System.out.println("4. MultiHouseBuilding");
    System.out.println("5. Exit");
    System.out.print("Enter Your Choice: ");
        n = sc.nextInt();

     if (n == 1) {
            JAVAProfessionalRobber.RowHouse();

            } else if (n == 2) {
                JAVAProfessionalRobber.RoundHouse();

            } else if (n == 3) {
                JAVAProfessionalRobber.SquareHouse();

            } else if (n == 4) {
                JAVAProfessionalRobber.MuliHouseBuilding();

            } else if (n == 5) {
                System.out.println("Exiting...");

                break;
            } else {

                System.out.println("Invalid Choice! Please try again.");
            }
        }

        sc.close();}}
