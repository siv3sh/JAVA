import java.util.Scanner;

public class AlphabetWarGame {
    private int w, p, b, s;
    private int m, q, d, z;

    public AlphabetWarGame() {
        this.w = 4;
        this.p = 3;
        this.b = 2;
        this.s = 1;
        this.m = 4;
        this.q = 3;
        this.d= 2;
        this.z = 1;
    }
    public void playGame(String input) {
        int leftStrength = 0;
        int rightStrength = 0;
        for (char c : input.toCharArray()) {
            switch (c) {
                case 'm': leftStrength += m; 
                break;
                case 'q': leftStrength += q; 
                break;
                case 'd': leftStrength += d; 
                break;
                case 'z': leftStrength += z; 
                break;
                case 'w': rightStrength += w; 
                break;
                case 'p': rightStrength += p; 
                break;
                case 'b': rightStrength += b; 
                break;
                case 's': rightStrength += s; 
                break;
            }
        }
        if (leftStrength == 0 && rightStrength == 0) {
            System.out.println("Let's play again! No valid letters found.");
            return;
        }
        Winner(leftStrength, rightStrength);
    }

    public void playGame(String leftSide, String rightSide) {
        int leftStrength = calculateLeftStrength(leftSide);
        int rightStrength = calculateRightStrength(rightSide);
        Winner(leftStrength, rightStrength);
    }

    private int calculateLeftStrength(String leftSide) {
        int strength = 0;
        for (char c : leftSide.toCharArray()) {
            switch (c) {
                case 'm': strength += m; 
                break;
                case 'q': strength += q; 
                break;
                case 'd': strength += d; 
                break;
                case 'z': strength += z; 
                break;
            }
        }
        return strength;
    }

    private int calculateRightStrength(String rightSide) {
        int strength = 0;
        for (char c : rightSide.toCharArray()) {
            switch (c) {
                case 'w': strength += w; 
                break;
                case 'p': strength += p; 
                break;
                case 'b': strength += b; 
                break;
                case 's': strength += s; 
                break;
            }
        }
        return strength;
    }

    private void Winner(int leftStrength, int rightStrength) {
        if (leftStrength > rightStrength) {
            System.out.println("Left side wins");
        } else if (rightStrength > leftStrength) {
            System.out.println("Right side wins" );
        } else {
            System.out.println("It's a tie! Both sides have equal strength.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlphabetWarGame game = new AlphabetWarGame();
        
        // Keep playing until valid input
        while (true) {
            System.out.println("Enter a string for Alphabet War Game:");
            String input = scanner.nextLine().toLowerCase();
            game.playGame(input);
        }
    }
}