import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);

        Random randomNumber = new Random();
        int computerNumber = randomNumber.nextInt(100);

        boolean itsNumber = false;
        int high = 0;
        int low = 0;
        int attempt = 0;

        while(!itsNumber) {
            System.out.println("Guess the number [1-100]: ");
            String playerInput = scanner.next();


            boolean isValid = true;

            for (int i = 0; i < playerInput.length(); i++) {
                if(playerInput.charAt(i) < 48 || playerInput.charAt(i) > 57) {
                    isValid = false;
                    System.out.println("Please write only number between 0 and 100!");
                    System.out.println();
                    break;
                }
            }

            if (isValid) {
                int playerNumber = Integer.parseInt(playerInput);
                attempt++;

                if(playerNumber == computerNumber) {
                    System.out.println("You guess it !");
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

        System.out.printf("You guess a number on %d attempt%n", attempt);
        if (high > 0) {
            System.out.printf("You have %d result then is higher of computer number%n", high);
        }
        if ( low > 0) {
            System.out.printf("You have %d result then is lower of computer number%n", low);
        }
    }
}
