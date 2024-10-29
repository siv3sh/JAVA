import java.util.Scanner;

public class Alpha {
    // Strength points for each letter
    private final int w = 4, p = 3, b = 2, s = 1;
    private final int m = 4, q = 3, d = 2, z = 1;

    public void playGame(String input) {
        int leftStrength = 0, rightStrength = 0;

        for (char c : input.toCharArray()) {
            switch (c) {
                case 'm': leftStrength += m; break;
                case 'q': leftStrength += q; break;
                case 'd': leftStrength += d; break;
                case 'z': leftStrength += z; break;
                case 'w': rightStrength += w; break;
                case 'p': rightStrength += p; break;
                case 'b': rightStrength += b; break;
                case 's': rightStrength += s; break;
            }
        }

        // Print result based on strength
        if (leftStrength == 0 && rightStrength == 0) {
            System.out.println("Let's play again! No valid letters found.");
        } else if (leftStrength > rightStrength) {
            System.out.println("Left side wins");
        } else if (rightStrength > leftStrength) {
            System.out.println("Right side wins");
        } else {
            System.out.println("It's a tie! Both sides have equal strength.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlphabetWarGame game = new AlphabetWarGame();

        // Loop for continuous gameplay
        while (true) {
            System.out.println("Enter a string for Alphabet War Game:");
            String input = scanner.nextLine().toLowerCase();
            game.playGame(input);
        }
    }
}
