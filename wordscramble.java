import java.util.Random;
import java.util.Scanner;

public class WordScramble {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "banana", "orange", "computer", "book"}; // List of words

        while (true) {
            // Randomly select a word
            Random random = new Random();
            String targetWord = words[random.nextInt(words.length)];

            // Scramble the word
            String scrambledWord = scrambleWord(targetWord);

            // Display the scrambled word after user confirms playing again
            System.out.println("\nWord Scramble!");
            System.out.println("Are you ready to guess? (y/n)");
            String confirm = scanner.nextLine().toLowerCase();

            if (confirm.equals("y")) {
                System.out.println("Scrambled word: " + scrambledWord);

                System.out.print("Guess the word: ");
                String guess = scanner.nextLine();

                if (guess.equalsIgnoreCase(targetWord)) {
                    System.out.println("Congratulations! You guessed the word correctly.");
                } else {
                    System.out.println("Sorry, incorrect guess. The word was: " + targetWord);
                }
            } else {
                System.out.println("Exiting game...");
                continue; // Skip to the next iteration without asking for guess
            }

            System.out.println("\nDo you want to:");
            System.out.println("1. Play again");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                continue;
            } else if (choice == 2) {
                System.out.println("Exiting game...");
                scanner.close();
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static String scrambleWord(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int randomIndex = new Random().nextInt(chars.length);
            char temp = chars[i];
            chars[i] = chars[randomIndex];
            chars[randomIndex] = temp;
        }
        return new String(chars);
    }
}
