import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random randomNumber = new Random();
        int computerNumber = randomNumber.nextInt(100);

        boolean itsNumber = false;
        int high = 0;
        int low = 0;
        int attempt = 5;
        boolean itGuess = false;

        while (attempt != 0) {

            if (itGuess) {
                break;
            }

            for (int i = 1; i <= attempt; i++) {

                String playerInput = "";

                if (!itGuess) {
                    System.out.printf("You have %d attempts%n", attempt);
                    System.out.println("Guess the number [1-100]: ");
                    playerInput = scanner.next();
                } else {
                    break;
                }

                boolean isValid = true;

                for (int j = 0; j < playerInput.length(); j++) {
                    if (playerInput.charAt(j) < 48 || playerInput.charAt(j) > 57) {
                        isValid = false;
                        System.out.println("Please write only number between 0 and 100!");
                        System.out.println();
                        break;
                    }
                }

                if (isValid) {
                    int playerNumber = Integer.parseInt(playerInput);
                    attempt--;

                    if (playerNumber == computerNumber) {
                        System.out.println("You guess it !");
                        itGuess = true;
                        break;
                    } else if (playerNumber > computerNumber) {
                        System.out.println("Too High");
                        high++;
                    } else if (playerNumber < computerNumber) {
                        System.out.println("Too Low");
                        low++;
                    }
                }
            }
        }


        if (itGuess) {
            System.out.printf("You guess a number on %d attempt%n", attempt);
            if (high > 0) {
                System.out.printf("You have %d result then is higher of computer number%n", high);
            }
            if (low > 0) {
                System.out.printf("You have %d result then is lower of computer number%n", low);
            }
        } else {
            System.out.println();
            System.out.println("You lose !");
            System.out.println();
            if (high > 0) {
                System.out.printf("You have %d result then is higher of the computer number%n", high);
            }
            if (low > 0) {
                System.out.printf("You have %d result then is lower of the computer number%n", low);
            }
        }
    }
}
